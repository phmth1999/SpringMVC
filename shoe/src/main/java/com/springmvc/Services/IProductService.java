package com.springmvc.Services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springmvc.Dto.ProductDto;
import com.springmvc.Dto.ProductJoinCategoryAndBrandDto;

public interface IProductService {
	Page<ProductJoinCategoryAndBrandDto> getAllProductJoinCategoryAndBrand(Pageable pageable) throws Exception;
	List<ProductDto> getProductBySearch(String keyword) throws Exception;
	ProductDto getProductById(int id) throws Exception;
	Page<ProductDto> getAllProduct(Pageable pageable) throws Exception;
	Page<ProductDto> getAllProductByIdCategory(int id, Pageable pageable) throws Exception;
	Page<ProductDto> getAllProductByIdBrand(int id, Pageable pageable) throws Exception;
	void editProductJoinCategoryAndBrand(ProductJoinCategoryAndBrandDto product) throws Exception;
	ProductJoinCategoryAndBrandDto getProductJoinCategoryAndBrand(int id) throws Exception;
	void addProductJoinCategoryAndBrand(ProductJoinCategoryAndBrandDto product) throws Exception;
	void deleteProduct(int id) throws Exception;
}
