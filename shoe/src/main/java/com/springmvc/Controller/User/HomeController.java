package com.springmvc.Controller.User;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Service.Impl.ProductServiceImpl;
import com.springmvc.Service.Impl.SlideServiceImpl;

@Controller
public class HomeController {
	final static Logger logger = Logger.getLogger(HomeController.class);
	@Autowired
	private ProductServiceImpl productService;
	
	@Autowired
	private SlideServiceImpl slideService;

	@RequestMapping(value = { "/", "/trang-chu" }, method = RequestMethod.GET)
	public ModelAndView Index() throws Exception {
		ModelAndView mav = null;
		try {
			mav = new ModelAndView("user/index");
			mav.addObject("listAllSlide", slideService.getAllSlide());
			mav.addObject("listProductCategoryMen", productService.getAllProductByIdCategory(1, new PageRequest(0, 6)).getContent());
			mav.addObject("listProductCategoryWomen", productService.getAllProductByIdCategory(2, new PageRequest(0, 6)).getContent());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}

	

}
