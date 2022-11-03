package com.springmvc.Controller.Web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Dto.BillDetailDto;
import com.springmvc.Dto.BillDto;
import com.springmvc.Dto.UserDto;
import com.springmvc.Security.CustomSuccesHandler;
import com.springmvc.Services.IBillService;
import com.springmvc.Services.IUserService;
import com.springmvc.Utils.RandomChars;
import com.springmvc.Utils.SendEmail;
@Controller
public class UserController {
	final static Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IBillService billService;

	@GetMapping("/dang-nhap")
	public ModelAndView login() throws Exception{
		ModelAndView mav = null;
		try {
			mav = new ModelAndView("web/account/login");
			mav.addObject("user", new UserDto());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}

	@GetMapping("/dang-xuat")
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
			logger.error(e);
		}
		return mav;
	}

	@GetMapping("/accessDenied")
	public ModelAndView accessDenied() throws Exception {
		ModelAndView mav = null;
		try {
			mav = new ModelAndView("redirect:/dang-nhap?accessDenied");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}

	@GetMapping("/dang-ky")
	public ModelAndView Register()throws Exception {
		ModelAndView mav = null;
		try {
			mav = new ModelAndView("web/account/register");
			mav.addObject("user", new UserDto());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}

	@PostMapping("/dang-ky")
	public ModelAndView CreateAcc(@ModelAttribute("user") UserDto user, HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView mav = null;
		try {
			mav = new ModelAndView("redirect:/xac-nhan");
			String maxn = RandomChars.generateRandomChars();
			session.setAttribute("maxn", maxn);
			String n = null;
			SendEmail.Send(user.getUsername(), "website", "Ma xac nhan: "+maxn, n);
			session.setAttribute("tk", user);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
	
	@GetMapping("/xac-nhan")
	public String maxacnhan() throws Exception{
		String mav = "";
		try {
			mav = "web/account/xacnhan";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}

	@PostMapping("/xac-nhan")
	public String xulymaxacnhan(HttpSession session, @RequestParam("maxacnhan") String maxacnhan, Model model) throws Exception {
		String page = "";
		try {
			String maxn = (String) session.getAttribute("maxn");
			UserDto tk = (UserDto) session.getAttribute("tk");
			if (maxn.equals(maxacnhan)) {
				userService.addAccount(tk);
				page = "redirect:/dang-nhap";
			} else {
				model.addAttribute("erro", "Ma xac nhan sai");
				page = "web/account/xacnhan";
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return page;
	}

	@GetMapping("/profile")
	public ModelAndView profile(@ModelAttribute("user") UserDto user) throws Exception {
		ModelAndView mav = null;
		try {
			if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails) {
				mav = new ModelAndView("web/account/profile");
				mav.addObject("user", userService.getAccountById(CustomSuccesHandler.getPrincipal().getId()));
			}else{
				mav = new ModelAndView("redirect:/dang-nhap");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
	
	@PostMapping("/profile")
	public ModelAndView editProfile(@ModelAttribute("user") UserDto user) throws Exception {
		ModelAndView mav = null;
		try {
			userService.editProfile(user, CustomSuccesHandler.getPrincipal().getId());
			mav = new ModelAndView("redirect:/profile");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
	
	@GetMapping("/history")
	public ModelAndView history(@ModelAttribute("bill") BillDto bill,HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView mav = null;
		try {
			int pageNum = 1;
			if(request.getParameter("page")!=null){
			pageNum = Integer.parseInt(request.getParameter("page").toString());
			}
			Sort sort =  new Sort(Sort.Direction.DESC, "id");
			Pageable pageable = new PageRequest((pageNum - 1), 6, sort);
			if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails) {
				mav = new ModelAndView("web/account/history");
				Page<BillDto> page = billService.getAllBillByIdUserLogin(CustomSuccesHandler.getPrincipal().getId(), pageable);
				List<BillDto> listPageBills = page.getContent();
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
			logger.error(e);
		}
		return mav;
	}
	@GetMapping("/history-detail")
	public ModelAndView historyDetal(@ModelAttribute("billDetail") BillDetailDto billDetail, HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView mav = null;
		try {
			int idBill = Integer.parseInt(request.getParameter("idBill").toString());
				if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails) {
				request.setAttribute("page", Integer.parseInt(session.getAttribute("page").toString()));
				session.removeAttribute("page");
				mav = new ModelAndView("web/account/history-detail");
				mav.addObject("billDetail", billService.getBillDetailByIdUserLogin(idBill));
			}else{
				mav = new ModelAndView("redirect:/dang-nhap");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
}
