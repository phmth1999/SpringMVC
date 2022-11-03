package com.springmvc.Services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.Converter.CategoryConverter;
import com.springmvc.Dto.CategoryDto;
import com.springmvc.Entity.CategoryEntity;
import com.springmvc.Repositories.ICategoryRepository;
import com.springmvc.Services.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {
	final static Logger logger = Logger.getLogger(CategoryServiceImpl.class);
	@Autowired
	private ICategoryRepository categoryRepository;

	public List<CategoryDto> getAllCategory() throws Exception {
		List<CategoryDto> listCategoryDto = new ArrayList<CategoryDto>();
		try {
			List<CategoryEntity> listCategoryEntity = categoryRepository.findAll();
			for (CategoryEntity categoryEntity : listCategoryEntity) {
				CategoryDto categoryDto = CategoryConverter.toDto(categoryEntity);
				listCategoryDto.add(categoryDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listCategoryDto;
	}
}
