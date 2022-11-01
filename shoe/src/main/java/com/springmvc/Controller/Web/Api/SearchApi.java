package com.springmvc.Controller.Web.Api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.Controller.Web.UserController;
import com.springmvc.Entity.ProductEntity;
import com.springmvc.Service.ProductService;

@Controller
public class SearchApi {
	final static Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private ProductService productService;
	
	@GetMapping("/search")
	@ResponseBody
	public List<ProductEntity> search(HttpServletRequest request, @RequestParam("term") String term) throws Exception {
		List<ProductEntity> listSearch = null;
		try {
			listSearch = productService.getProductBySearch(term);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listSearch;
	}
}
