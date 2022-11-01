package com.springmvc.Controller.Web;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
	
	final static Logger logger = Logger.getLogger(BlogController.class);
	
	@GetMapping("/blog")
	public ModelAndView blog(HttpServletRequest request)throws Exception {
		ModelAndView mav = null;
		try {
			mav = new ModelAndView("web/blog/blog");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
	@GetMapping("/blog-detail")
	public ModelAndView blogDetail(HttpServletRequest request)throws Exception {
		ModelAndView mav = null;
		try {
			mav = new ModelAndView("web/blog/blog_detail");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
}
