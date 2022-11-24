package com.springmvc.Controller.Web;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Dto.ProductDto;
import com.springmvc.Services.IBrandService;
import com.springmvc.Services.ICategoryService;
import com.springmvc.Services.IProductService;

@Controller("WebProduct")
public class ProductController {
	
	final static Logger logger = Logger.getLogger(ProductController.class);
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private IBrandService brandService;
	
	
	@GetMapping("/product/{id}")
	public ModelAndView product(@PathVariable String id, HttpSession session) throws Exception{
		ModelAndView mav = null;
		try {
			ProductDto product = productService.getProductById(Integer.parseInt(id));
			mav = new ModelAndView("web/product/product");
			mav.addObject("listAllCategory", categoryService.getAllCategory());
			mav.addObject("listAllBrand", brandService.getAllBrand());
			mav.addObject("product", product);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}

}
