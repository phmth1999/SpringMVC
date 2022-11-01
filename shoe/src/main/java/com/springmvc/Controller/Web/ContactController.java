package com.springmvc.Controller.Web;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {
	
	final static Logger logger = Logger.getLogger(ContactController.class);
	
	@GetMapping("/contact")
	public ModelAndView contact(HttpServletRequest request)throws Exception {
		ModelAndView mav = null;
		try {
			mav = new ModelAndView("web/contact/contact");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
}
