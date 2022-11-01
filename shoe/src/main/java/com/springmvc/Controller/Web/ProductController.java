package com.springmvc.Controller.Web;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Entity.ProductEntity;
import com.springmvc.Service.BrandService;
import com.springmvc.Service.CategoryService;
import com.springmvc.Service.ProductService;

@Controller
public class ProductController {
	
	final static Logger logger = Logger.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private BrandService brandService;
	
	
	@GetMapping("/product/{id}")
	public ModelAndView product(@PathVariable String id, HttpSession session) throws Exception{
		ModelAndView mav = null;
		try {
			ProductEntity product = productService.getProductById(Integer.parseInt(id));
			mav = new ModelAndView("web/product/product");
			mav.addObject("listAllCategory", categoryService.getAllCategory());
			mav.addObject("listAllBrand", brandService.getAllBrand());
			mav.addObject("product", product);
			int quanty = 1;
			if(session.getAttribute("quanty")!=null){
				quanty = Integer.parseInt(session.getAttribute("quanty").toString());
				session.removeAttribute("quanty");
			}
			mav.addObject("quanty", quanty);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}

}
