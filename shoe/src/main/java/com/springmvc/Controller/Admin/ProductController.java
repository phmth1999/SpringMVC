package com.springmvc.Controller.Admin;

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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Dto.ProductJoinCategoryAndBrandDto;
import com.springmvc.Services.IProductService;
import com.springmvc.Utils.FileUploadUtil;

@Controller("AdminProduct")
public class ProductController {
	
	final static Logger logger = Logger.getLogger(ProductController.class);
	
	@Autowired
	private IProductService productService; 
	
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
	
	@GetMapping("/quan-tri/product")
	public ModelAndView ListProduct(HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			int pageNum = 1;
			Sort sort =  new Sort(Sort.Direction.DESC, "id");
			Pageable pageable = new PageRequest((checkPage(request, pageNum) - 1), 6, sort);
			Page<ProductJoinCategoryAndBrandDto> page = productService.getAllProductJoinCategoryAndBrand(pageable);
			List<ProductJoinCategoryAndBrandDto> listPageProducts = page.getContent();
			mav = new ModelAndView("admin/product/list");
			mav.addObject("currentPage", checkPage(request, pageNum));
			mav.addObject("previous", checkPage(request, pageNum)-1);
			mav.addObject("next", checkPage(request, pageNum)+1);
			mav.addObject("totalPages", page.getTotalPages());
		    mav.addObject("totalItems", page.getTotalElements());
			mav.addObject("listPageProducts", listPageProducts);
			
			session.setAttribute("pageSessionProductAdmin", checkPage(request, pageNum));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
	@GetMapping("/quan-tri/product/edit/{id}")
	public ModelAndView getEditProduct(@PathVariable String id, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			mav = new ModelAndView("admin/product/edit");
			int idProduct = Integer.parseInt(id);
			ProductJoinCategoryAndBrandDto product = productService.getProductJoinCategoryAndBrand(idProduct);
			mav.addObject("product", product);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
	
	@GetMapping("/quan-tri/product/delete/{id}")
	public ModelAndView DeleteProduct(@PathVariable String id, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			mav = new ModelAndView("redirect:/quan-tri/product");
			int idProduct = Integer.parseInt(id);
			productService.deleteProduct(idProduct);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
	
	@PostMapping("/quan-tri/product/edit")
	public ModelAndView postEditProduct(@ModelAttribute("product") ProductJoinCategoryAndBrandDto product,HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			int page = Integer.parseInt(session.getAttribute("pageSessionProductAdmin").toString());
			session.removeAttribute("pageSessionProductAdmin");
			mav = new ModelAndView("redirect:/quan-tri/product?page="+page);
			productService.editProductJoinCategoryAndBrand(product);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
	
	@GetMapping("/quan-tri/product/add")
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
	
	@PostMapping("/quan-tri/product/add")
	public ModelAndView postAddProduct(@RequestParam("image") MultipartFile image, @ModelAttribute("product") ProductJoinCategoryAndBrandDto product,HttpServletRequest request) throws Exception {
		ModelAndView mav = null;
		
		try {
			mav = new ModelAndView("admin/product/add");
			String fileName = StringUtils.cleanPath(image.getOriginalFilename());
			String uploadDir = "uploads/";
			FileUploadUtil.saveFile(uploadDir, fileName, image);
			
			product.setImg(image.getOriginalFilename());
			productService.addProductJoinCategoryAndBrand(product);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
}
