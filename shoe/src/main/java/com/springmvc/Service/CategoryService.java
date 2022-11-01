package com.springmvc.Service;

import java.util.List;

import com.springmvc.Entity.CategoryEntity;

public interface CategoryService {
	public List<CategoryEntity> getAllCategory() throws Exception;
}
