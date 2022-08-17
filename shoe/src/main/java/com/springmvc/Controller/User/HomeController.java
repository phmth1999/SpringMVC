package com.springmvc.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
	public ModelAndView Index() throws Exception {
		ModelAndView mav = null;
		try {
			mav = new ModelAndView("user/index");
			mav.addObject("listAllSlide", homeService.getAllDataSlide());
			mav.addObject("listProductCategoryMen", homeService.getPageProductByIdCategory(1, new PageRequest(0, 6)).getContent());
			mav.addObject("listProductCategoryWomen", homeService.getPageProductByIdCategory(2, new PageRequest(0, 6)).getContent());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	

}
