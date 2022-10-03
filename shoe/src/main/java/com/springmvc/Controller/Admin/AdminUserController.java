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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Entity.User;
import com.springmvc.Service.Impl.UserServiceImpl;

@Controller
public class AdminUserController {
	final static Logger logger = Logger.getLogger(AdminUserController.class);
	@Autowired
	private UserServiceImpl userServiceImpl; 
	
	@RequestMapping(value = "/quan-tri/user", method = RequestMethod.GET)
	public ModelAndView ListUser(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			int pageNum = 1;
			if(request.getParameter("page")!=null){
			pageNum = Integer.parseInt(request.getParameter("page").toString());
			}
			Sort sort =  new Sort(Sort.Direction.ASC, "id");;
			Pageable pageable = new PageRequest((pageNum - 1), 6, sort);
			Page<User> page = userServiceImpl.getAllAccount(pageable);
			List<User> listPageUsers = page.getContent();
			mav = new ModelAndView("admin/account/list");
			mav.addObject("currentPage", pageNum);
			mav.addObject("previous", pageNum-1);
			mav.addObject("next", pageNum+1);
			mav.addObject("totalPages", page.getTotalPages());
		    mav.addObject("totalItems", page.getTotalElements());
		    mav.addObject("listPageUsers", listPageUsers);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
	@RequestMapping(value = "/quan-tri/user/lock", method = RequestMethod.GET)
	public ModelAndView blockUser(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			int id = Integer.parseInt(request.getParameter("idUser").toString());
			userServiceImpl.blockUser(id);
			int pageNum = 1;
			if(request.getParameter("page")!=null){
			pageNum = Integer.parseInt(request.getParameter("page").toString());
			}
			Sort sort =  new Sort(Sort.Direction.ASC, "id");;
			Pageable pageable = new PageRequest((pageNum - 1), 6, sort);
			Page<User> page = userServiceImpl.getAllAccount(pageable);
			List<User> listPageUsers = page.getContent();
			mav = new ModelAndView("redirect:" + request.getHeader("Referer"));
			mav.addObject("currentPage", pageNum);
			mav.addObject("previous", pageNum-1);
			mav.addObject("next", pageNum+1);
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
