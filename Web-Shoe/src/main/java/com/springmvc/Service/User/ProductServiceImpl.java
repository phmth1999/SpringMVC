package com.springmvc.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.Dao.ProductRepository;
import com.springmvc.Dto.ProductJoinCategory;

@Service
public class ProductServiceImpl {
	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductJoinCategory> getDataProductJoinCategorySortDESC() {
		return productRepository.findAllProductJoinCategorySortDESC();
	}
}
