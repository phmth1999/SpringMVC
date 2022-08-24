package com.springmvc.Controller.User;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Entity.Product;
import com.springmvc.Service.User.HomeServiceImpl;

@Controller
public class ShopController {
	@Autowired
	private HomeServiceImpl homeService;

	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public ModelAndView shop(HttpServletRequest request) throws Exception {
		ModelAndView mav = null;
		try {
			int pageNum = 1;
			if(request.getParameter("page")!=null){
			pageNum = Integer.parseInt(request.getParameter("page").toString());
			}
			Pageable pageable = new PageRequest((pageNum - 1), 12);
			Page<Product> page = homeService.getAllDataProduct(pageable);
			List<Product> listPageProducts = page.getContent();
			mav = new ModelAndView("user/product/shop");
			mav.addObject("currentPage", pageNum);
			mav.addObject("previous", pageNum-1);
			mav.addObject("next", pageNum+1);
			mav.addObject("totalPages", page.getTotalPages());
		    mav.addObject("totalItems", page.getTotalElements());
		    mav.addObject("listPageProducts", listPageProducts);
			mav.addObject("listAllCategory", homeService.getAllDataCategory());
			mav.addObject("listAllBrand", homeService.getAllDataBrand());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	public ModelAndView category(HttpServletRequest request, @PathVariable String id) throws Exception {
		ModelAndView mav = null;
		try {
			int i=Integer.parseInt(id);
			int pageNum = 1;
			if(request.getParameter("page")!=null){
			pageNum = Integer.parseInt(request.getParameter("page").toString());
			}
			Pageable pageable = new PageRequest((pageNum - 1), 12);
			Page<Product> page = homeService.getPageProductByIdCategory(i, pageable);
			List<Product> listProductByCategory = page.getContent();
			mav = new ModelAndView("user/product/shop");
			mav.addObject("currentPage", pageNum);
			mav.addObject("previous", pageNum-1);
			mav.addObject("next", pageNum+1);
			mav.addObject("totalPages", page.getTotalPages());
		    mav.addObject("totalItems", page.getTotalElements());
			mav.addObject("listPageProducts", listProductByCategory);
			mav.addObject("categoryORbrand", "category");
			mav.addObject("id", i);
			mav.addObject("listAllCategory", homeService.getAllDataCategory());
			mav.addObject("listAllBrand", homeService.getAllDataBrand());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping(value = "/brand/{id}", method = RequestMethod.GET)
	public ModelAndView brand(HttpServletRequest request, @PathVariable String id) throws Exception {
		ModelAndView mav = null;
		try {
			int i=Integer.parseInt(id);
			int pageNum = 1;
			if(request.getParameter("page")!=null){
				pageNum = Integer.parseInt(request.getParameter("page").toString());
			}
			Pageable pageable = new PageRequest((pageNum - 1), 12);
			Page<Product> page = homeService.getPageProductByIdBrand(i, pageable);
			List<Product> listProductByBrand = page.getContent();
			mav = new ModelAndView("user/product/shop");
			mav.addObject("currentPage", pageNum);
			mav.addObject("previous", pageNum-1);
			mav.addObject("next", pageNum+1);
			mav.addObject("totalPages", page.getTotalPages());
			mav.addObject("totalItems", page.getTotalElements());
			mav.addObject("listPageProducts", listProductByBrand);
			mav.addObject("categoryORbrand", "brand");
			mav.addObject("id", i);
			mav.addObject("listAllCategory", homeService.getAllDataCategory());
			mav.addObject("listAllBrand", homeService.getAllDataBrand());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
