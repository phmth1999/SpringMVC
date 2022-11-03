package com.springmvc.Services;

import java.util.List;

import com.springmvc.Dto.CategoryDto;

public interface ICategoryService {
	List<CategoryDto> getAllCategory() throws Exception;
}
