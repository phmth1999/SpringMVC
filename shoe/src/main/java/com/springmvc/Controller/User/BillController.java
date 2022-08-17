package com.springmvc.Controller.User;

import java.io.File;
import java.io.FileOutputStream;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.springmvc.Dto.CartDto;
import com.springmvc.Entity.Bill;
import com.springmvc.Entity.User;
import com.springmvc.Security.CustomSuccesHandler;
import com.springmvc.Service.User.BillServiceImpl;
import com.springmvc.Service.User.CartServiceImpl;
import com.springmvc.Service.User.UserServiceImpl;
import com.springmvc.Utils.MD5;
import com.springmvc.Utils.RandomChars;
import com.springmvc.Utils.SendEmail;
import com.springmvc.Utils.VerSign;
import com.springmvc.Utils.coppyAndDelete;


@Controller
public class BillController {
	CustomSuccesHandler email;
	@Autowired
	private BillServiceImpl billServiceImpl;
	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private CartServiceImpl cartService;

	Locale lc = new Locale("vi", "VN");
	NumberFormat numf = NumberFormat.getCurrencyInstance(lc);

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView CheckOut() throws Exception {
		ModelAndView mav = null;
		try {
			if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails) {
				mav = new ModelAndView("user/bill/checkout");
				Bill b = new Bill();
				b.setUser(CustomSuccesHandler.getPrincipal().getEmail());
				b.setFullname(CustomSuccesHandler.getPrincipal().getFullName());
				mav.addObject("bill", b);
				return mav;
			} else {
				mav = new ModelAndView("user/account/login");
				mav.addObject("user", new User());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String CheckOutBill(HttpServletRequest request, HttpSession session, @ModelAttribute("bill") Bill bill)
			throws Exception {
		String mav = "";
		try {
			@SuppressWarnings("unchecked")
			HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>) session.getAttribute("Cart");
			int quanty = cartService.TotalQuanty(cart);
			double total = cartService.TotalPrice(cart);

			session.setAttribute("hoadon", bill);
			session.setAttribute("TotalQuantyCart", quanty);
			session.setAttribute("TotalPriceCart", total);

			String dirFile = request.getServletContext().getRealPath("HoaDon");
			File fileDir = new File(dirFile);
			String dir = fileDir+"";
			session.setAttribute("fileDir", dir);
			if (!fileDir.exists()) {
				fileDir.mkdir();
			}

			String hoadon = fileDir + "/HoaDon.pdf";
			session.setAttribute("hd", hoadon);

			// tao file pdf hoa don
			Document document = new Document();
			try {
				PdfWriter.getInstance(document, new FileOutputStream(new File(hoadon)));
				// open
				document.open();

				Paragraph p = new Paragraph();
				p.add("BILLS");
				p.setAlignment(Element.ALIGN_CENTER);
				document.add(p);

				document.add(new Paragraph("FullName: " + bill.getFullname()));
				document.add(new Paragraph("Address: " + bill.getAddress()));
				document.add(new Paragraph("Phone: " + bill.getPhone()));
				document.add(new Paragraph("Date: " + java.time.LocalDate.now()));

				PdfPTable t = new PdfPTable(3);
				t.setSpacingBefore(25);
				t.setSpacingAfter(25);

				PdfPCell c1 = new PdfPCell(new Phrase("Quantity"));
				t.addCell(c1);
				PdfPCell c2 = new PdfPCell(new Phrase("Name"));
				t.addCell(c2);
				PdfPCell c3 = new PdfPCell(new Phrase("Price"));
				t.addCell(c3);

				for (Map.Entry<Integer, CartDto> itemCart : cart.entrySet()) {
					t.addCell("" + itemCart.getValue().getQuanty());
					t.addCell("" + itemCart.getValue().getProduct().getName());
					t.addCell("" + numf.format(itemCart.getValue().getTotalPrice()));
				}
				document.add(t);

				Paragraph tong = new Paragraph();
				tong.add("Toatal: " + numf.format(total));
				tong.setAlignment(Element.ALIGN_RIGHT);
				document.add(tong);

				document.add(new Paragraph(" "));

				Paragraph n = new Paragraph();
				n.add("Day...Month...Year");
				n.add("                                                                                                ");
				n.add("Day...Month...Year");
				document.add(n);

				Paragraph m = new Paragraph();
				m.add("          Buyer");
				m.add("                                                                                                ");
				m.add("                     Seller");
				document.add(m);

				// close
				document.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// gui mail dinh kem file pdf
			String hashHD = MD5.getMD5File(new File(hoadon));
			session.setAttribute("hashHD", hashHD);
			String content ="- Code hash md5 file HoaDon.pdf: " + hashHD +"\n"+"\n"+"- Link download Sign: " +"https://drive.google.com/drive/u/1/folders/18ECHJCudAoWvNIrO4Mh0NzKaUCoEs8zL";
			SendEmail.Send(bill.getUser(), "Bills", content, hoadon);
			mav = "redirect:sign";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/sign", method = RequestMethod.GET)
	public String sign(HttpSession session) throws Exception{
		String mav = "";
		try {
			session.setAttribute("sign", "sign");
			mav = "user/bill/checksign";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/sign", method = RequestMethod.POST)
	public String sign1(@RequestParam("sign") String sign, Model model,
			HttpSession session) throws Exception {
		String mav = "";
		try {
			@SuppressWarnings("unchecked")
			HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>) session.getAttribute("Cart");
			Bill b = (Bill) session.getAttribute("hoadon");
			int quanty = (int) session.getAttribute("TotalQuantyCart");
			double total = (double) session.getAttribute("TotalPriceCart");
			String hd = (String) session.getAttribute("hd");
			String fileDir = (String) session.getAttribute("fileDir");
			String hashHD = (String) session.getAttribute("hashHD");
			String key = userServiceImpl.getDataUserById(CustomSuccesHandler.getPrincipal().getId()).getPublickey();
			if (VerSign.VerSignByHash(sign, hashHD, key) == true || VerSign.VerSignByFile(sign, hd, key) == true) {
				b.setSign(sign);
				b.setData(hashHD);
				billServiceImpl.addBill(b, quanty, total);
				billServiceImpl.addBillDetail(b.getId(), cart);
				
				billServiceImpl.editBill(b.getId(), fileDir+"/HoaDon-"+b.getId()+".pdf");
				coppyAndDelete.coppyAndDeleteFile(hd, fileDir+"/HoaDon-"+b.getId()+".pdf");

				session.removeAttribute("Cart");
				session.removeAttribute("TotalQuantyCart");
				session.removeAttribute("TotalPriceCart");
				session.removeAttribute("hashHD");
				session.removeAttribute("hd");
				session.removeAttribute("fileDir");
				mav = "redirect:history";
			} else {
				model.addAttribute("erro", "Chữ ký sai");
				mav = "user/bill/checksign";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
		
	}
	@RequestMapping(value = "/update-publickey", method = RequestMethod.GET)
	public String updatePublickey()throws Exception {
		String mav = "";
		try {
			mav = "user/account/updatepublickey";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping(value = "/update-publickey", method = RequestMethod.POST)
	public String updatePublickey1(@RequestParam("key") String key, Model model,
			HttpSession session) throws Exception {
		String mav = "";
		try {
			User user = userServiceImpl.getDataUserById(CustomSuccesHandler.getPrincipal().getId());
					String maxn = RandomChars.generateRandomChars();
					session.setAttribute("maxn", maxn);
					session.setAttribute("key", key);
					String n = null;
					SendEmail.Send(user.getUsername(), "website", "Mã xác nhận: "+maxn, n);
					mav = "redirect:/xacnhan-publickey";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
		
	}
	// Chuyen qua trang xac nhan ma
		@RequestMapping(value = "/xacnhan-publickey", method = RequestMethod.GET)
		public String maxacnhan() throws Exception{
			String mav = "";
			try {
				mav = "user/bill/xacnhan";
			} catch (Exception e) {
				e.printStackTrace();
			}
			return mav;
		}
		@RequestMapping(value = "/xacnhan-publickey", method = RequestMethod.POST)
		public String xulymaxacnhan(HttpSession session, @RequestParam("maxacnhan") String maxacnhan, Model model) throws Exception {
			String page = "";
			try {
				String maxn = (String) session.getAttribute("maxn");
				String key = (String) session.getAttribute("key");
				if (maxn.equals(maxacnhan)) {
					userServiceImpl.addPublicKey(key, CustomSuccesHandler.getPrincipal().getId());
					session.removeAttribute("maxn");
					session.removeAttribute("key");
					if(session.getAttribute("sign")!=null){
						page = "redirect:/sign";
						session.removeAttribute("sign");
					}else{
						page = "redirect:/profile";
					}
				} else {
					model.addAttribute("erro", "Mã xác nhận sai");
					page = "user/bill/xacnhan";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return page;
		}
}
