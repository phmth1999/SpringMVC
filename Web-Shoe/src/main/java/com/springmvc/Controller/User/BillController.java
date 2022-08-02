package com.springmvc.Controller.User;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.text.NumberFormat;
import java.util.Base64;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

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
import com.springmvc.config.SendEmail;

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
	public ModelAndView CheckOut() {
		if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails) {
			ModelAndView mav = new ModelAndView("user/bill/checkout");
			Bill b = new Bill();
			b.setUser(CustomSuccesHandler.getPrincipal().getEmail());
			b.setFullname(CustomSuccesHandler.getPrincipal().getFullName());
			mav.addObject("bill", b);
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("user/account/login");
			mav.addObject("user", new User());
			return mav;
		}
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String CheckOutBill(HttpServletRequest request, HttpSession session, @ModelAttribute("bill") Bill bill)
			throws Exception {

		@SuppressWarnings("unchecked")
		HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>) session.getAttribute("Cart");
		int quanty = cartService.TotalQuanty(cart);
		double total = cartService.TotalPrice(cart);

		session.setAttribute("hoadon", bill);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", quanty);
		session.setAttribute("TotalPriceCart", total);

		String dirFile = request.getServletContext().getRealPath("HoaDon");
		System.out.println(dirFile);
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
		String hashHD = getMD5File(new File(hoadon));
		session.setAttribute("hashHD", hashHD);
		String content ="- Code hash md5 file HoaDon.pdf: " + hashHD +"\n"+"\n"+"- Link download Sign: " +"https://drive.google.com/drive/u/1/folders/18ECHJCudAoWvNIrO4Mh0NzKaUCoEs8zL";
		SendEmail.Send(bill.getUser(), "Bills", content, hoadon);
		return "redirect:sign";
	}

	@RequestMapping(value = "/sign", method = RequestMethod.GET)
	public String sign() {
		return "user/bill/checksign";
	}
	public static void main(String[] args) throws IOException {
		String current = new java.io.File( "." ).getCanonicalPath();
        System.out.println("Current dir:"+current);
	}

	@RequestMapping(value = "/sign", method = RequestMethod.POST)
	public String sign1(@RequestParam("sign") String sign, Model model,
			HttpSession session) throws Exception {
		@SuppressWarnings("unchecked")
		HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>) session.getAttribute("Cart");
		int quanty = cartService.TotalQuanty(cart);
		double total = cartService.TotalPrice(cart);
		Bill b = (Bill) session.getAttribute("hoadon");
		String hd = (String) session.getAttribute("hd");
		String fileDir = (String) session.getAttribute("fileDir");
		String hashHD = (String) session.getAttribute("hashHD");
		String key = userServiceImpl.getDataUserById(CustomSuccesHandler.getPrincipal().getId()).getPublickey();
		if(key!=null){
		if (VerSignByHash(sign, hashHD, key) == true || VerSignByFile(sign, hd, key) == true) {
			b.setSign(sign);
			b.setData(hashHD);
			billServiceImpl.addBill(b, quanty, total);
			billServiceImpl.addBillDetail(b.getId(), cart);
			
			coppyAndDeleteFile(hd, fileDir+"/HoaDon-"+b.getId()+".pdf");
			b.setFile(fileDir+"/HoaDon-"+b.getId()+".pdf");

			session.removeAttribute("Cart");
			session.removeAttribute("TotalQuantyCart");
			session.removeAttribute("TotalPriceCart");
			session.removeAttribute("hashHD");
			session.removeAttribute("hd");
			session.removeAttribute("fileDir");
			return "redirect:trang-chu";
		} else {
			model.addAttribute("erro", "Chữ ký không chính xác");
			return "user/bill/checksign";
		}
		}else{
			model.addAttribute("erro", "Hệ thống chưa có publicKey của bạn");
			return "user/bill/checksign";
		}
	}
	@RequestMapping(value = "/update-publickey", method = RequestMethod.GET)
	public String updatePublickey() {
		return "user/bill/updatepublickey";
	}
	@RequestMapping(value = "/update-publickey", method = RequestMethod.POST)
	public String updatePublickey1(@RequestParam("key") String key, Model model,
			HttpSession session) throws Exception {
		User user = userServiceImpl.getDataUserById(CustomSuccesHandler.getPrincipal().getId());
		if(user.getPublickey()==null){
			userServiceImpl.addPublicKey(key, CustomSuccesHandler.getPrincipal().getId());
			return "redirect:/sign";
		}else{
			String maxn = generateRandomChars();
			session.setAttribute("maxn", maxn);
			// Gui ma xac nhan cho email
			String n = null;
			SendEmail.Send(user.getUsername(), "website", "Mã xác nhận: "+maxn, n);
			session.setAttribute("key", key);
			return "redirect:/xacnhan";
		}
		
	}
	// Chuyen qua trang xac nhan ma
		@RequestMapping(value = "/xacnhan", method = RequestMethod.GET)
		public String maxacnhan() {
			return "user/bill/xacnhan";
		}
		@RequestMapping(value = "/xacnhan", method = RequestMethod.POST)
		public String xulymaxacnhan(HttpSession session, @RequestParam("maxacnhan") String maxacnhan, Model model) {
			String page = "";
			String maxn = (String) session.getAttribute("maxn");
			String key = (String) session.getAttribute("key");
			if (maxn.equals(maxacnhan)) {
				userServiceImpl.addPublicKey(key, CustomSuccesHandler.getPrincipal().getId());
				session.removeAttribute("maxn");
				session.removeAttribute("key");
				page = "redirect:/sign";
			} else {
				model.addAttribute("erro", "Mã xác nhận không chính xác");
				page = "user/bill/xacnhan";
			}
			return page;
		}
	// Tao ma xac nhan email
		private String generateRandomChars() {
			String srcChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234556789";
			int length = 5;
			StringBuilder sb = new StringBuilder();
			Random random = new Random();
			for (int i = 0; i < length; i++) {
				sb.append(srcChars.charAt(random.nextInt(srcChars.length())));
			}
			return sb.toString();
		}
	private static PublicKey readPublicKey(String key) throws Exception {
		byte[] b = Base64.getDecoder().decode(key);

		X509EncodedKeySpec spec = new X509EncodedKeySpec(b);
		KeyFactory factory = KeyFactory.getInstance("RSA");
		PublicKey pubKey = factory.generatePublic(spec);
		return pubKey;
	}

	public static boolean VerSignByHash(String sign, String data, String PublicKey) throws Exception {
		PublicKey pubKey = readPublicKey(PublicKey);

		byte[] signToVer = Base64.getDecoder().decode(sign);

		Signature rsa = Signature.getInstance("SHA256withRSA");
		rsa.initVerify(pubKey);

		byte[] input = data.getBytes();
			rsa.update(input);

		boolean verfile = rsa.verify(signToVer);
		return verfile;
	}
	public static boolean VerSignByFile(String sign, String data, String PublicKey) throws Exception {
		PublicKey pubKey = readPublicKey(PublicKey);
		
		byte[] signToVer = Base64.getDecoder().decode(sign);
		
		Signature rsa = Signature.getInstance("SHA256withRSA");
		rsa.initVerify(pubKey);
		
		FileInputStream datafis = new FileInputStream(new File(data));
		BufferedInputStream bis = new BufferedInputStream(datafis);
		byte[] input = new byte[1024];
		int len;
		while ((len = bis.read(input)) != -1) {
			rsa.update(input, 0, len);
		};
		bis.close();
		
		boolean verfile = rsa.verify(signToVer);
		return verfile;
	}
	public static String getMD5File(File file) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			FileInputStream fis = new FileInputStream(file);
			byte[] dataBytes = new byte[1024];
			int nread = 0;
			while ((nread = fis.read(dataBytes)) != -1) {
				md.update(dataBytes, 0, nread);
			}
			byte[] byteData = md.digest();
			fis.close();
			return convertByteToHex(byteData);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static String convertByteToHex(byte[] data) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			sb.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}
	public static void coppyAndDeleteFile(String from, String to){
		InputStream inStream = null;
		OutputStream outStream = null;

		try {

			File afile = new File(from);
			File bfile = new File(to);

			inStream = new FileInputStream(afile);
			outStream = new FileOutputStream(bfile);

			byte[] buffer = new byte[1024];

			int length;
			// copy the file content in bytes
			while ((length = inStream.read(buffer)) > 0) {

				outStream.write(buffer, 0, length);

			}
			inStream.close();
			outStream.close();

			// delete the original file
			afile.delete();


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
