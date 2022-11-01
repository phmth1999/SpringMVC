package com.springmvc.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springmvc.Dto.ProductJoinCategoryAndBrandDto;
import com.springmvc.Entity.ProductEntity;

public interface ProductService {
	public Page<ProductJoinCategoryAndBrandDto> getAllProductJoinCategoryAndBrand(Pageable pageable) throws Exception;
	public List<ProductEntity> getProductBySearch(String keyword) throws Exception;
	public ProductEntity getProductById(int id) throws Exception;
	public Page<ProductEntity> getAllProduct(Pageable pageable) throws Exception;
	public Page<ProductEntity> getAllProductByIdCategory(int id, Pageable pageable) throws Exception;
	public Page<ProductEntity> getAllProductByIdBrand(int id, Pageable pageable) throws Exception;
	public void editProductJoinCategoryAndBrand(ProductJoinCategoryAndBrandDto product) throws Exception;
	public ProductJoinCategoryAndBrandDto getProductJoinCategoryAndBrand(int id) throws Exception;
	public void addProductJoinCategoryAndBrand(ProductJoinCategoryAndBrandDto product) throws Exception;
	public void deleteProduct(int id) throws Exception;
}
