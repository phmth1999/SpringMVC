package com.springmvc.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springmvc.Dao.CategoryRepository;
import com.springmvc.Dao.ProductRepository;
import com.springmvc.Dao.SlideRepository;
import com.springmvc.Entity.Category;
import com.springmvc.Entity.Product;
import com.springmvc.Entity.Slide;
/**
 * @author PhamMinhThien
 * @since 2022
 **/
@Service
public class HomeServiceImpl {
	@Autowired
	private SlideRepository slideRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	/**
	 * getAllDataSlide
	 * @return List<Slide> listSile
	 * @throws Exception
	 **/
	public List<Slide> getAllDataSlide() throws Exception {
		List<Slide> listSile = null;
		try {
			listSile = slideRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listSile;
	}

	/**
	 * getAllDataCategory
	 * @return List<Category> listCategory
	 * @throws Exception
	 **/
	public List<Category> getAllDataCategory() throws Exception {
		List<Category> listCategory = null;
		try {
			listCategory = categoryRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listCategory;
	}

	/**
	 * getAllDataProduct
	 * @return List<Product> listProduct
	 * @throws Exception
	 **/
	public Page<Product> getAllDataProduct(Pageable pageable) throws Exception {
		Page<Product> listProduct = null;
		try {
			listProduct = productRepository.findAll(pageable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listProduct;
	}
	/**
	 * getPageProductByIdCategory
	 * @param int id
	 * @param Pageable pageable
	 * @return Page<Product> listProduct
	 * @throws Exception
	 **/
	public Page<Product> getPageProductByIdCategory(int id, Pageable pageable) throws Exception {
		Page<Product> listProduct = null;
		try {
			listProduct = productRepository.getPageProductByIdCategory(id, pageable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listProduct;
	}
}
