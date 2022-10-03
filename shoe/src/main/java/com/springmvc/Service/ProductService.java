package com.springmvc.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springmvc.Dto.ProductJoinCategoryAndBrandDto;
import com.springmvc.Entity.Product;

public interface ProductService {
	public Page<ProductJoinCategoryAndBrandDto> getAllProductJoinCategoryAndBrand(Pageable pageable) throws Exception;
	public List<Product> getProductBySearch(String keyword) throws Exception;
	public Product getProductById(int id) throws Exception;
	public Page<Product> getAllProduct(Pageable pageable) throws Exception;
	public Page<Product> getAllProductByIdCategory(int id, Pageable pageable) throws Exception;
	public Page<Product> getAllProductByIdBrand(int id, Pageable pageable) throws Exception;
	public void editProductJoinCategoryAndBrand(ProductJoinCategoryAndBrandDto product) throws Exception;
	public ProductJoinCategoryAndBrandDto getProductJoinCategoryAndBrand(int id) throws Exception;
	public void addProductJoinCategoryAndBrand(ProductJoinCategoryAndBrandDto product) throws Exception;
	public void deleteProduct(int id) throws Exception;
}
