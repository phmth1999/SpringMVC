package com.springmvc.Converter;

import com.springmvc.Dto.ProductDto;
import com.springmvc.Entity.ProductEntity;

public class ProductConverter {
	public static ProductDto toDto(ProductEntity productEntity) {
		ProductDto productDto = new ProductDto();
		productDto.setId(productEntity.getId());
		productDto.setId_category(productEntity.getId_category());
		productDto.setId_brand(productEntity.getId_brand());
		productDto.setName(productEntity.getName());
		productDto.setImg(productEntity.getImg());
		productDto.setPrice(productEntity.getPrice());
		productDto.setQuantity(productEntity.getQuantity());
		productDto.setQuantity_sold(productEntity.getQuantity_sold());
		return productDto;
	}

	public static ProductEntity toEntity(ProductDto productDto) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setId_category(productDto.getId_category());
		productEntity.setId_brand(productDto.getId_brand());
		productEntity.setName(productDto.getName());
		productEntity.setImg(productDto.getImg());
		productEntity.setPrice(productDto.getPrice());
		productEntity.setQuantity(productDto.getQuantity());
		productEntity.setQuantity_sold(productDto.getQuantity_sold());
		return productEntity;
	}
}
