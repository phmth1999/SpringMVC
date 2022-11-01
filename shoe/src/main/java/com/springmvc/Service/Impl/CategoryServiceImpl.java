package com.springmvc.Service.Impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.Entity.CategoryEntity;
import com.springmvc.Repositories.CategoryRepository;
import com.springmvc.Service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
	final static Logger logger = Logger.getLogger(CategoryServiceImpl.class);
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<CategoryEntity> getAllCategory() throws Exception {
		List<CategoryEntity> listCategory = null;
		try {
			listCategory = categoryRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listCategory;
	}
}
