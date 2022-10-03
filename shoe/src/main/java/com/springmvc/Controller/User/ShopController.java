package com.springmvc.Controller.User;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Entity.Product;
import com.springmvc.Service.Impl.BrandServiceImpl;
import com.springmvc.Service.Impl.CategoryServiceImpl;
import com.springmvc.Service.Impl.ProductServiceImpl;

@Controller
public class ShopController {
	final static Logger logger = Logger.getLogger(ShopController.class);
	@Autowired
	private CategoryServiceImpl categoryService;
	
	@Autowired
	private BrandServiceImpl brandService;
	
	@Autowired
	private ProductServiceImpl productService;

	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public ModelAndView shop(HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView mav = null;
		try {
			session.removeAttribute("sortSession");
			int pageNum = 1;
			if(request.getParameter("page")!=null){
			pageNum = Integer.parseInt(request.getParameter("page").toString());
			}
			String sortName = "low-high";
			Sort sort =  new Sort(Sort.Direction.ASC, "price");
			if(request.getParameter("sort")!=null){
				sortName = request.getParameter("sort").toString();
				if(sortName.equals("low-high")){
					sort = new Sort(Sort.Direction.ASC, "price");
				}else if(sortName.equals("high-low")){
					sort = new Sort(Sort.Direction.DESC, "price");
				}else if(sortName.equals("a-z")){
					sort = new Sort(Sort.Direction.ASC, "name");
				}else if(sortName.equals("z-a")){
					sort = new Sort(Sort.Direction.DESC, "name");
				}
			}
			session.setAttribute("sortSession", sortName);
			Pageable pageable = new PageRequest((pageNum - 1), 9, sort);
			Page<Product> page = productService.getAllProduct(pageable);
			List<Product> listPageProducts = page.getContent();
			mav = new ModelAndView("user/product/shop");
			mav.addObject("currentPage", pageNum);
			mav.addObject("previous", pageNum-1);
			mav.addObject("next", pageNum+1);
			mav.addObject("totalPages", page.getTotalPages());
		    mav.addObject("totalItems", page.getTotalElements());
		    mav.addObject("listPageProducts", listPageProducts);
			mav.addObject("listAllCategory", categoryService.getAllCategory());
			mav.addObject("listAllBrand", brandService.getAllBrand());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	public ModelAndView category(HttpSession session,HttpServletRequest request, @PathVariable String id) throws Exception {
		ModelAndView mav = null;
		try {
			session.removeAttribute("sortSession");
			int i=Integer.parseInt(id);
			int pageNum = 1;
			if(request.getParameter("page")!=null){
			pageNum = Integer.parseInt(request.getParameter("page").toString());
			}
			String sortName = "low-high";
			Sort sort =  new Sort(Sort.Direction.ASC, "price");
			if(request.getParameter("sort")!=null){
				sortName = request.getParameter("sort").toString();
				if(sortName.equals("low-high")){
					sort = new Sort(Sort.Direction.ASC, "price");
				}else if(sortName.equals("high-low")){
					sort = new Sort(Sort.Direction.DESC, "price");
				}else if(sortName.equals("a-z")){
					sort = new Sort(Sort.Direction.ASC, "name");
				}else if(sortName.equals("z-a")){
					sort = new Sort(Sort.Direction.DESC, "name");
				}
			}
			session.setAttribute("sortSession", sortName);
			Pageable pageable = new PageRequest((pageNum - 1), 9, sort);
			Page<Product> page = productService.getAllProductByIdCategory(i, pageable);
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
			mav.addObject("listAllCategory", categoryService.getAllCategory());
			mav.addObject("listAllBrand", brandService.getAllBrand());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
	@RequestMapping(value = "/brand/{id}", method = RequestMethod.GET)
	public ModelAndView brand(HttpSession session,HttpServletRequest request, @PathVariable String id) throws Exception {
		ModelAndView mav = null;
		try {
			session.removeAttribute("sortSession");
			int i=Integer.parseInt(id);
			int pageNum = 1;
			if(request.getParameter("page")!=null){
				pageNum = Integer.parseInt(request.getParameter("page").toString());
			}
			String sortName = "low-high";
			Sort sort =  new Sort(Sort.Direction.ASC, "price");
			if(request.getParameter("sort")!=null){
				sortName = request.getParameter("sort").toString();
				if(sortName.equals("low-high")){
					sort = new Sort(Sort.Direction.ASC, "price");
				}else if(sortName.equals("high-low")){
					sort = new Sort(Sort.Direction.DESC, "price");
				}else if(sortName.equals("a-z")){
					sort = new Sort(Sort.Direction.ASC, "name");
				}else if(sortName.equals("z-a")){
					sort = new Sort(Sort.Direction.DESC, "name");
				}
			}
			session.setAttribute("sortSession", sortName);
			Pageable pageable = new PageRequest((pageNum - 1), 9, sort);
			Page<Product> page = productService.getAllProductByIdBrand(i, pageable);
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
			mav.addObject("listAllCategory", categoryService.getAllCategory());
			mav.addObject("listAllBrand", brandService.getAllBrand());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public List<Product> search(HttpServletRequest request) throws Exception {
		List<Product> listSearch = null;
		try {
			listSearch = productService.getProductBySearch(request.getParameter("term"));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listSearch;
	}
}
