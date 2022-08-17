package com.springmvc.Controller.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Dto.ProductJoinCategoryDto;
import com.springmvc.Service.User.ProductServiceImpl;

@Controller
public class AdminProductController {
	@Autowired
	private ProductServiceImpl productServiceImpl; 
	
	@RequestMapping(value = "/quan-tri/product", method = RequestMethod.GET)
	public ModelAndView ListProduct(HttpServletRequest request) throws Exception {
		int pageNum = 1;
		if(request.getParameter("page")!=null){
		pageNum = Integer.parseInt(request.getParameter("page").toString());
		}
		Pageable pageable = new PageRequest((pageNum - 1), 6);
		Page<ProductJoinCategoryDto> page = productServiceImpl.getDataProductJoinCategorySortDESC(pageable);
		List<ProductJoinCategoryDto> listPageProducts = page.getContent();
		ModelAndView mav = new ModelAndView("admin/product/list");
		mav.addObject("currentPage", pageNum);
		mav.addObject("previous", pageNum-1);
		mav.addObject("next", pageNum+1);
		mav.addObject("totalPages", page.getTotalPages());
	    mav.addObject("totalItems", page.getTotalElements());
		mav.addObject("listPageProducts", listPageProducts);
		return mav;
	}
}
