package com.springmvc.Controller.User;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public ModelAndView blog(HttpServletRequest request)throws Exception {
		ModelAndView mav = null;
		try {
			mav = new ModelAndView("user/blog/blog");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping(value = "/blog-detail", method = RequestMethod.GET)
	public ModelAndView blogDetail(HttpServletRequest request)throws Exception {
		ModelAndView mav = null;
		try {
			mav = new ModelAndView("user/blog/blog_detail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
