package com.springmvc.Controller.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
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
	public ModelAndView ListUser(HttpServletRequest request) {
		List<User> listUser = userServiceImpl.getAllDataUserSortDESC();
		PagedListHolder<User> pagedListHolder = new PagedListHolder<User>(listUser);
		int page = ServletRequestUtils.getIntParameter(request, "page", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(6);
		ModelAndView mav = new ModelAndView("admin/account/list");
		mav.addObject("pagedListHolder", pagedListHolder);
		return mav;
	}
}
