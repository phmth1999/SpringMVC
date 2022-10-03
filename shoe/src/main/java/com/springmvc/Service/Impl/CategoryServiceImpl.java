package com.springmvc.Service.Impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.Dao.CategoryRepository;
import com.springmvc.Entity.Category;
import com.springmvc.Service.CategoryService;
/**
 * @author PhamMinhThien
 * @since 2022
 **/
@Service
public class CategoryServiceImpl implements CategoryService{
	final static Logger logger = Logger.getLogger(CategoryServiceImpl.class);
	@Autowired
	private CategoryRepository categoryRepository;
	
	/**
	 * getAllDataCategory
	 * @return List<Category> listCategory
	 * @throws Exception
	 **/
	public List<Category> getAllCategory() throws Exception {
		List<Category> listCategory = null;
		try {
			listCategory = categoryRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listCategory;
	}
}
