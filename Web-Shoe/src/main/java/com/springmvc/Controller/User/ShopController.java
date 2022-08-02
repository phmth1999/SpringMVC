package com.springmvc.Controller.User;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
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
	public ModelAndView shop(HttpServletRequest request) {
		List<Product> listProduct = homeService.getAllDataProduct();
		PagedListHolder<Product> pagedListHolder = new PagedListHolder<Product>(listProduct);
		int page = ServletRequestUtils.getIntParameter(request, "page", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(6);
		ModelAndView mav = new ModelAndView("user/product/shop");
		mav.addObject("pagedListHolder", pagedListHolder);
		mav.addObject("listAllCategory", homeService.getAllDataCategory());
		return mav;
	}
	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	public ModelAndView category(HttpServletRequest request, @PathVariable String id) {
		int i=Integer.parseInt(id);
		List<Product> listProduct = homeService.getDataProductByIdCategory(i);
		PagedListHolder<Product> pagedListHolder = new PagedListHolder<Product>(listProduct);
		int page = ServletRequestUtils.getIntParameter(request, "page", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(6);
		ModelAndView mav = new ModelAndView("user/product/category");
		mav.addObject("pagedListHolder", pagedListHolder);
		mav.addObject("id", i);
		mav.addObject("listAllCategory", homeService.getAllDataCategory());
		return mav;
	}
}
