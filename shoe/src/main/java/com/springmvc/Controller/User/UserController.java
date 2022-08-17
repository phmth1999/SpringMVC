package com.springmvc.Controller.User;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Entity.Bill;
import com.springmvc.Entity.BillDetail;
import com.springmvc.Entity.User;
import com.springmvc.Security.CustomSuccesHandler;
import com.springmvc.Service.User.BillServiceImpl;
import com.springmvc.Service.User.UserServiceImpl;
import com.springmvc.Utils.SendEmail;

@Controller
public class UserController {
	@SuppressWarnings("unused")
	private static final Logger Log = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private BillServiceImpl billService;

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView login() throws Exception{
		ModelAndView mav = null;
		try {
			mav = new ModelAndView("user/account/login");
			mav.addObject("user", new User());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		try {
			mav = new ModelAndView("redirect:/trang-chu");
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth != null) {
				new SecurityContextLogoutHandler().logout(request, response, auth);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() throws Exception {
		ModelAndView mav = null;
		try {
			mav = new ModelAndView("redirect:/dang-nhap?accessDenied");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView Register()throws Exception {
		ModelAndView mav = null;
		try {
			mav = new ModelAndView("user/account/register");
			mav.addObject("user", new User());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public ModelAndView CreateAcc(@ModelAttribute("user") User user, HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView mav = null;
		try {
			mav = new ModelAndView("redirect:/xac-nhan");
			String maxn = generateRandomChars();
			session.setAttribute("maxn", maxn);
			String n = null;
			SendEmail.Send(user.getUsername(), "website", "Ma xac nhan: "+maxn, n);
			session.setAttribute("tk", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	// Chuyen qua trang xac nhan ma
	@RequestMapping(value = "/xac-nhan", method = RequestMethod.GET)
	public String maxacnhan() throws Exception{
		String mav = "";
		try {
			mav = "user/account/xacnhan";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	// Xu ly xac nhan ma de dang ky
	@RequestMapping(value = "/xac-nhan", method = RequestMethod.POST)
	public String xulymaxacnhan(HttpSession session, @RequestParam("maxacnhan") String maxacnhan, Model model) throws Exception {
		String page = "";
		try {
			String maxn = (String) session.getAttribute("maxn");
			User tk = (User) session.getAttribute("tk");
			if (maxn.equals(maxacnhan)) {
				userService.addAccount(tk);
				page = "redirect:/dang-nhap";
			} else {
				model.addAttribute("erro", "Ma xac nhan sai");
				page = "user/account/xacnhan";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}

	// Tao ma xac nhan email
	private String generateRandomChars()throws Exception {
		String srcChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234556789";
		int length = 5;
		StringBuilder sb = null;
		try {
			sb = new StringBuilder();
			Random random = new Random();
			for (int i = 0; i < length; i++) {
				sb.append(srcChars.charAt(random.nextInt(srcChars.length())));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	@RequestMapping(value = "/checkUsername", method = RequestMethod.POST)
	public @ResponseBody String checkUsername(HttpServletRequest req, @ModelAttribute("user") User user) throws Exception {
		String userName = "";
		try {
			userName = userService.findOneByUsername(user.getUsername());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userName;
	}
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView profile(@ModelAttribute("user") User user) throws Exception {
		ModelAndView mav = null;
		try {
//			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//			if (!auth.getName().equals("anonymousUser")) {
			if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails) {
				mav = new ModelAndView("user/account/profile");
				mav.addObject("user", userService.getDataUserById(CustomSuccesHandler.getPrincipal().getId()));
			}else{
				mav = new ModelAndView("redirect:/dang-nhap");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping(value = "/history", method = RequestMethod.GET)
	public ModelAndView history(@ModelAttribute("bill") Bill bill,HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView mav = null;
		try {
			int pageNum = 1;
			if(request.getParameter("page")!=null){
			pageNum = Integer.parseInt(request.getParameter("page").toString());
			}
			Pageable pageable = new PageRequest((pageNum - 1), 6);
//			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//			if (!auth.getName().equals("anonymousUser")) {
			if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails) {
				mav = new ModelAndView("user/account/history");
				Page<Bill> page = billService.getBillByIdUserLogin(CustomSuccesHandler.getPrincipal().getId(), pageable);
				List<Bill> listPageBills = page.getContent();
				session.setAttribute("page", pageNum);
				mav.addObject("currentPage", pageNum);
				mav.addObject("previous", pageNum-1);
				mav.addObject("next", pageNum+1);
				mav.addObject("totalPages", page.getTotalPages());
			    mav.addObject("totalItems", page.getTotalElements());
				mav.addObject("bill", listPageBills);
			}else{
				mav = new ModelAndView("redirect:/dang-nhap");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping(value = "/history-detail", method = RequestMethod.GET)
	public ModelAndView historyDetal(@ModelAttribute("billDetail") BillDetail billDetail, HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView mav = null;
		try {
			int idBill = Integer.parseInt(request.getParameter("idBill").toString());
//			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//			if (!auth.getName().equals("anonymousUser")) {
				if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails) {
				request.setAttribute("page", Integer.parseInt(session.getAttribute("page").toString()));
				session.removeAttribute("page");
				mav = new ModelAndView("user/account/history-detail");
				mav.addObject("billDetail", billService.getBillDetailByIdUserLogin(idBill));
			}else{
				mav = new ModelAndView("redirect:/dang-nhap");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
