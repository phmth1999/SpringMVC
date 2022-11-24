package com.springmvc.Controller.Admin;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("AdminHome")
public class HomeController {
	
	final static Logger logger = Logger.getLogger(HomeController.class);
	
	@GetMapping({ "/quan-tri/", "/quan-tri/trang-chu" })
	public ModelAndView Index() throws Exception{
		ModelAndView mav = new ModelAndView();
		try {
			mav = new ModelAndView("admin/home");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
}
