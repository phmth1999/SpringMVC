package com.springmvc.Controller.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Dto.UserDto;
import com.springmvc.Services.IUserService;

@Controller
public class AdminUserController {
	
	final static Logger logger = Logger.getLogger(AdminUserController.class);
	
	@Autowired
	private IUserService userService; 
	
	private int checkPage(HttpServletRequest request, int pageNum) throws Exception{
		try {
			if (request.getParameter("page") != null) {
				pageNum = Integer.parseInt(request.getParameter("page").toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return pageNum;
	}
	
	@GetMapping("/quan-tri/user")
	public ModelAndView ListUser(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			int pageNum = 1;
			Sort sort =  new Sort(Sort.Direction.ASC, "id");
			Pageable pageable = new PageRequest((checkPage(request, pageNum) - 1), 6, sort);
			Page<UserDto> page = userService.getAllAccount(pageable);
			List<UserDto> listPageUsers = page.getContent();
			mav = new ModelAndView("admin/account/list");
			mav.addObject("currentPage", checkPage(request, pageNum));
			mav.addObject("previous", checkPage(request, pageNum)-1);
			mav.addObject("next", checkPage(request, pageNum)+1);
			mav.addObject("totalPages", page.getTotalPages());
		    mav.addObject("totalItems", page.getTotalElements());
		    mav.addObject("listPageUsers", listPageUsers);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
	@GetMapping("/quan-tri/user/lock")
	public ModelAndView blockUser(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			int id = Integer.parseInt(request.getParameter("idUser").toString());
			userService.blockUser(id);
			int pageNum = 1;
			Sort sort =  new Sort(Sort.Direction.ASC, "id");;
			Pageable pageable = new PageRequest((checkPage(request, pageNum) - 1), 6, sort);
			Page<UserDto> page = userService.getAllAccount(pageable);
			List<UserDto> listPageUsers = page.getContent();
			mav = new ModelAndView("redirect:" + request.getHeader("Referer"));
			mav.addObject("currentPage", checkPage(request, pageNum));
			mav.addObject("previous", checkPage(request, pageNum)-1);
			mav.addObject("next", checkPage(request, pageNum)+1);
			mav.addObject("totalPages", page.getTotalPages());
		    mav.addObject("totalItems", page.getTotalElements());
		    mav.addObject("listPageUsers", listPageUsers);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
}
