package com.springmvc.Converter;

import com.springmvc.Dto.BrandDto;
import com.springmvc.Entity.BrandEntity;

public class BrandConverter {
	public static BrandDto toDto(BrandEntity brandEntity) {
		BrandDto brandDto = new BrandDto();
		brandDto.setId(brandEntity.getId());
		brandDto.setName(brandEntity.getName());
		return brandDto;
	}

	public static BrandEntity toEntity(BrandDto brandDto) {
		BrandEntity brandEntity = new BrandEntity();
		brandEntity.setName(brandDto.getName());
		return brandEntity;
	}
}
