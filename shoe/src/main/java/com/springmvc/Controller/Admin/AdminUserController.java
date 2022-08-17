package com.springmvc.Controller.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Entity.User;
import com.springmvc.Service.User.UserServiceImpl;

@Controller
public class AdminUserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl; 
	
	@RequestMapping(value = "/quan-tri/user", method = RequestMethod.GET)
	public ModelAndView ListUser(HttpServletRequest request) throws Exception {
		int pageNum = 1;
		if(request.getParameter("page")!=null){
		pageNum = Integer.parseInt(request.getParameter("page").toString());
		}
		Pageable pageable = new PageRequest((pageNum - 1), 6);
		Page<User> page = userServiceImpl.getAllDataUserSortDESC(pageable);
		List<User> listPageUsers = page.getContent();
		ModelAndView mav = new ModelAndView("admin/account/list");
		mav.addObject("currentPage", pageNum);
		mav.addObject("previous", pageNum-1);
		mav.addObject("next", pageNum+1);
		mav.addObject("totalPages", page.getTotalPages());
	    mav.addObject("totalItems", page.getTotalElements());
	    mav.addObject("listPageUsers", listPageUsers);
		return mav;
	}
}
