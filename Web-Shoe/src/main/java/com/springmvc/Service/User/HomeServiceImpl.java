package com.springmvc.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.Dao.CategoryRepository;
import com.springmvc.Dao.ProductRepository;
import com.springmvc.Dao.SlideRepository;
import com.springmvc.Entity.Category;
import com.springmvc.Entity.Product;
import com.springmvc.Entity.Slide;

@Service
public class HomeServiceImpl {
	@Autowired
	private SlideRepository slideRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	public List<Slide> getAllDataSlide() {
		return slideRepository.findAll();
	}

	public List<Category> getAllDataCategory() {
		return categoryRepository.findAll();
	}

	public List<Product> getAllDataProduct() {
		return productRepository.findAll();
	}
	public List<Product> getDataProductByIdCategory(int id) {
		return productRepository.getDataProductByIdCategory(id);

	}

}
