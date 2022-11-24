package com.springmvc.Controller.Web;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Dto.ProductDto;
import com.springmvc.Services.IBrandService;
import com.springmvc.Services.ICategoryService;
import com.springmvc.Services.IProductService;

@Controller("WebShop")
public class ShopController {
	
	final static Logger logger = Logger.getLogger(ShopController.class);
	
	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private IBrandService brandService;

	@Autowired
	private IProductService productService;

	private String checkSortName(HttpServletRequest request, String sortName) throws Exception{
		try {
			if (request.getParameter("sort") != null) {
				sortName = request.getParameter("sort").toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return sortName;
	}

	private Sort checkSort(HttpServletRequest request, String sortName, Sort sort) throws Exception {
		try {
			if (request.getParameter("sort") != null) {
				sortName = checkSortName(request, sortName);
				if (sortName.equals("low-high")) {
					sort = new Sort(Sort.Direction.ASC, "price");
				} else if (sortName.equals("high-low")) {
					sort = new Sort(Sort.Direction.DESC, "price");
				} else if (sortName.equals("a-z")) {
					sort = new Sort(Sort.Direction.ASC, "name");
				} else if (sortName.equals("z-a")) {
					sort = new Sort(Sort.Direction.DESC, "name");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return sort;
	}
	private int checkPage(HttpServletRequest request, int pageNum) throws Exception{
		try {
			if (request.getParameter("page") != null) {
				pageNum = Integer.parseInt(request.getParameter("page").toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return pageNum;
	}

	@GetMapping("/shop")
	public ModelAndView shop(HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView mav = null;
		try {
			session.removeAttribute("sortSession");
			int pageNum = 1;
			String sortName = "low-high";
			Sort sort = new Sort(Sort.Direction.ASC, "price");
			session.setAttribute("sortSession", checkSortName(request, sortName));
			Pageable pageable = new PageRequest((checkPage(request, pageNum) - 1), 9, checkSort(request, sortName, sort));
			Page<ProductDto> page = productService.getAllProduct(pageable);
			List<ProductDto> listPageProducts = page.getContent();
			mav = new ModelAndView("web/product/shop");
			mav.addObject("currentPage", checkPage(request, pageNum));
			mav.addObject("previous", checkPage(request, pageNum) - 1);
			mav.addObject("next", checkPage(request, pageNum) + 1);
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

	@GetMapping("/category/{id}")
	public ModelAndView category(HttpSession session, HttpServletRequest request, @PathVariable String id) throws Exception {
		ModelAndView mav = null;
		try {
			session.removeAttribute("sortSession");
			int i = Integer.parseInt(id);
			int pageNum = 1;
			String sortName = "low-high";
			Sort sort = new Sort(Sort.Direction.ASC, "price");
			session.setAttribute("sortSession", checkSortName(request, sortName));
			Pageable pageable = new PageRequest((checkPage(request, pageNum) - 1), 9, checkSort(request, sortName, sort));
			Page<ProductDto> page = productService.getAllProductByIdCategory(i, pageable);
			List<ProductDto> listProductByCategory = page.getContent();
			mav = new ModelAndView("web/product/shop");
			mav.addObject("currentPage", checkPage(request, pageNum));
			mav.addObject("previous", checkPage(request, pageNum) - 1);
			mav.addObject("next", checkPage(request, pageNum) + 1);
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

	@GetMapping("/brand/{id}")
	public ModelAndView brand(HttpSession session, HttpServletRequest request, @PathVariable String id) throws Exception {
		ModelAndView mav = null;
		try {
			session.removeAttribute("sortSession");
			int i = Integer.parseInt(id);
			int pageNum = 1;
			String sortName = "low-high";
			Sort sort = new Sort(Sort.Direction.ASC, "price");
			session.setAttribute("sortSession", checkSortName(request, sortName));
			Pageable pageable = new PageRequest((checkPage(request, pageNum) - 1), 9, checkSort(request, sortName, sort));
			Page<ProductDto> page = productService.getAllProductByIdBrand(i, pageable);
			List<ProductDto> listProductByBrand = page.getContent();
			mav = new ModelAndView("web/product/shop");
			mav.addObject("currentPage", checkPage(request, pageNum));
			mav.addObject("previous", checkPage(request, pageNum) - 1);
			mav.addObject("next", checkPage(request, pageNum) + 1);
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
}
