package com.springmvc.Controller.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Dto.ProductJoinCategoryAndBrandDto;
import com.springmvc.Service.Impl.ProductServiceImpl;

@Controller
public class AdminProductController {
	final static Logger logger = Logger.getLogger(AdminProductController.class);
	@Autowired
	private ProductServiceImpl productServiceImpl; 
	
	@RequestMapping(value = "/quan-tri/product", method = RequestMethod.GET)
	public ModelAndView ListProduct(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			int pageNum = 1;
			if(request.getParameter("page")!=null){
			pageNum = Integer.parseInt(request.getParameter("page").toString());
			}
			Sort sort =  new Sort(Sort.Direction.DESC, "id");
			Pageable pageable = new PageRequest((pageNum - 1), 6, sort);
			Page<ProductJoinCategoryAndBrandDto> page = productServiceImpl.getAllProductJoinCategoryAndBrand(pageable);
			List<ProductJoinCategoryAndBrandDto> listPageProducts = page.getContent();
			mav = new ModelAndView("admin/product/list");
			mav.addObject("currentPage", pageNum);
			mav.addObject("previous", pageNum-1);
			mav.addObject("next", pageNum+1);
			mav.addObject("totalPages", page.getTotalPages());
		    mav.addObject("totalItems", page.getTotalElements());
			mav.addObject("listPageProducts", listPageProducts);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
	@RequestMapping(value = "/quan-tri/product/edit", method = RequestMethod.GET)
	public ModelAndView getEditProduct(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			mav = new ModelAndView("admin/product/edit");
			int id = Integer.parseInt(request.getParameter("idProduct").toString());
			ProductJoinCategoryAndBrandDto product = productServiceImpl.getProductJoinCategoryAndBrand(id);
			mav.addObject("product", product);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
	@RequestMapping(value = "/quan-tri/product/delete", method = RequestMethod.GET)
	public ModelAndView DeleteProduct(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			mav = new ModelAndView("redirect:/quan-tri/product");
			int id = Integer.parseInt(request.getParameter("idProduct").toString());
			productServiceImpl.deleteProduct(id);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
	@RequestMapping(value = "/quan-tri/product/edit", method = RequestMethod.POST)
	public ModelAndView postEditProduct(@ModelAttribute("product") ProductJoinCategoryAndBrandDto product,HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			mav = new ModelAndView("redirect:/quan-tri/product");
			productServiceImpl.editProductJoinCategoryAndBrand(product);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
	@RequestMapping(value = "/quan-tri/product/add", method = RequestMethod.GET)
	public ModelAndView getAddProduct(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			mav = new ModelAndView("admin/product/add");
			ProductJoinCategoryAndBrandDto product = new ProductJoinCategoryAndBrandDto();
			mav.addObject("product", product);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
	@RequestMapping(value = "/quan-tri/product/add", method = RequestMethod.POST)
	public ModelAndView postAddProduct(@ModelAttribute("product") ProductJoinCategoryAndBrandDto product,HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			mav = new ModelAndView("redirect:/quan-tri/product");
			productServiceImpl.addProductJoinCategoryAndBrand(product);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
}
