package com.springmvc.Controller.User;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {
	final static Logger logger = Logger.getLogger(ContactController.class);
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView contact(HttpServletRequest request)throws Exception {
		ModelAndView mav = null;
		try {
			mav = new ModelAndView("user/contact/contact");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
}
