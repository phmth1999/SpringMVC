package com.springmvc.Converter;

import com.springmvc.Dto.CategoryDto;
import com.springmvc.Entity.CategoryEntity;

public class CategoryConverter {
	public static CategoryDto toDto(CategoryEntity categoryEntity) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(categoryEntity.getId());
		categoryDto.setName(categoryEntity.getName());
		return categoryDto;
	}

	public static CategoryEntity toEntity(CategoryDto categoryDto) {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setName(categoryDto.getName());
		return categoryEntity;
	}
}
