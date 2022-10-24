package com.springmvc.Controller.Web;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
	
	final static Logger logger = Logger.getLogger(BlogController.class);
	
	@RequestMapping(value = "/blog", method = RequestMethod.GET)
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
	@RequestMapping(value = "/blog-detail", method = RequestMethod.GET)
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
