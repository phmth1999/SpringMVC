package com.springmvc.Controller.Web;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Dto.BillDto;
import com.springmvc.Dto.CartDto;
import com.springmvc.Security.CustomSuccesHandler;
import com.springmvc.Services.IBillService;
import com.springmvc.Services.ICartService;
import com.springmvc.Utils.GenerateBill;
import com.springmvc.Utils.MD5;
import com.springmvc.Utils.SendEmail;
import com.springmvc.Utils.coppyAndDelete;


@Controller("WebBill")
public class BillController {
	final static Logger logger = Logger.getLogger(BillController.class);
	
	CustomSuccesHandler email;
	
	@Autowired
	private IBillService billService;
	
	@Autowired
	private ICartService cartService;

	@GetMapping("/checkout")
	public ModelAndView CheckOut(HttpSession session) throws Exception {
		ModelAndView mav = null;
		try {
			if(!session.getAttribute("Cart").toString().equals("{}") || session.getAttribute("Cart")!=null){
				mav = new ModelAndView("web/bill/checkout");
				BillDto b = new BillDto();
				b.setEmail(CustomSuccesHandler.getPrincipal().getEmail());
				b.setFullname(CustomSuccesHandler.getPrincipal().getFullName());
				mav.addObject("bill", b);
			}else{
				mav = new ModelAndView("redirect:/shop");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}

	@PostMapping("/checkout")
	public String CheckOutBill(HttpServletRequest request, HttpSession session, @ModelAttribute("bill") BillDto bill) throws Exception {
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

			String hoadonFile = fileDir + "/HoaDon.pdf";
			session.setAttribute("hdFile", hoadonFile);
			
			// tao file pdf hoa don
			GenerateBill.generate(bill, hoadonFile, cart, total);

			String hashHD = MD5.getMD5File(new File(hoadonFile));
			session.setAttribute("hashHD", hashHD);
			String content ="- Code hash md5 file HoaDon.pdf: " + hashHD +"\n"+"\n"+"- Link download Sign: " +"https://drive.google.com/drive/u/1/folders/18ECHJCudAoWvNIrO4Mh0NzKaUCoEs8zL";
			//gui mail hoa don
			SendEmail.Send(bill.getEmail(), "Bills", content, hoadonFile);
			
			mav = "redirect:/sign";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}

	@GetMapping("/sign")
	public String sign(HttpSession session) throws Exception{
		String mav = "";
		try {
			if(!session.getAttribute("Cart").toString().equals("{}") || session.getAttribute("Cart")!=null){
				if(session.getAttribute("hoadon")!=null){
					session.setAttribute("sign", "sign");
					mav = "web/bill/checksign";
				}else{
					mav = "redirect:/checkout";
				}
			}else{
				mav = "redirect:/shop";
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}

	@PostMapping("/sign")
	public String sign1(@RequestParam("sign") String sign, @RequestParam("pubkey") String pubkey, Model model, HttpSession session) throws Exception {
		String mav = "";
		try {
			@SuppressWarnings("unchecked")
			HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>) session.getAttribute("Cart");
			BillDto billDto = (BillDto) session.getAttribute("hoadon");
			int quanty = (int) session.getAttribute("TotalQuantyCart");
			double total = (double) session.getAttribute("TotalPriceCart");
			String hdFile = (String) session.getAttribute("hdFile");
			String fileDir = (String) session.getAttribute("fileDir");
			String hashHD = (String) session.getAttribute("hashHD");
			
			billDto.setSign(sign);
			billDto.setPubkey(pubkey);
			billDto.setData(hashHD);
			billDto.setStatus("Đang chờ xét duyệt");
			int idBill = billService.addBill(billDto, quanty, total);
			billService.addBillDetail(idBill, cart);
				
			billDto.setFile(fileDir+"/HoaDon-"+idBill+".pdf");
			billService.editBill(idBill, billDto);
			coppyAndDelete.coppyAndDeleteFile(hdFile, fileDir+"/HoaDon-"+idBill+".pdf");

			session.removeAttribute("Cart");
			session.removeAttribute("TotalQuantyCart");
			session.removeAttribute("TotalPriceCart");
			session.removeAttribute("hashHD");
			session.removeAttribute("hd");
			session.removeAttribute("fileDir");
			mav = "redirect:/history";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
}
