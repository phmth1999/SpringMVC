package com.springmvc.Controller.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Dto.ProductJoinCategory;
import com.springmvc.Service.User.ProductServiceImpl;

@Controller
public class AdminProductController {
	@Autowired
	private ProductServiceImpl productServiceImpl; 
	
	@RequestMapping(value = "/quan-tri/product", method = RequestMethod.GET)
	public ModelAndView ListProduct(HttpServletRequest request) {
		List<ProductJoinCategory> listProduct = productServiceImpl.getDataProductJoinCategorySortDESC();
		PagedListHolder<ProductJoinCategory> pagedListHolder = new PagedListHolder<ProductJoinCategory>(listProduct);
		int page = ServletRequestUtils.getIntParameter(request, "page", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(6);
		ModelAndView mav = new ModelAndView("admin/product/list");
		mav.addObject("pagedListHolder", pagedListHolder);
		return mav;
	}
}
