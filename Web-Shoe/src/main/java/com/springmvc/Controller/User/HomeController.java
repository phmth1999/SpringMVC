package com.springmvc.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Service.User.HomeServiceImpl;

@Controller
public class HomeController {
	@Autowired
	private HomeServiceImpl homeService;

	@RequestMapping(value = { "/", "/trang-chu" }, method = RequestMethod.GET)
	public ModelAndView Index() {
		ModelAndView mav = new ModelAndView("user/index");
		mav.addObject("listAllSlide", homeService.getAllDataSlide());
		mav.addObject("listProductCategoryMen", homeService.getDataProductByIdCategory(1));
		mav.addObject("listProductCategoryWomen", homeService.getDataProductByIdCategory(2));
		return mav;
	}

	

}
