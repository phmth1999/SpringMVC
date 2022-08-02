package com.springmvc.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public ModelAndView product(@PathVariable String id) {
		ModelAndView mav = new ModelAndView("user/product/product");
		return mav;
	}

}
