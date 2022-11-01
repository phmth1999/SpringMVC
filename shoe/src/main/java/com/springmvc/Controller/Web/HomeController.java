package com.springmvc.Controller.Web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Service.ProductService;
import com.springmvc.Service.SlideService;

@Controller
public class HomeController {
	
	final static Logger logger = Logger.getLogger(HomeController.class);
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private SlideService slideService;

	@GetMapping({ "/", "/trang-chu" })
	public ModelAndView Index(HttpServletRequest request, HttpSession httpSession) throws Exception {
		ModelAndView mav = null;
		try {
			mav = new ModelAndView("web/index");
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
