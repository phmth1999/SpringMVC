package com.springmvc.Service.Impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springmvc.Dto.ProductJoinCategoryAndBrandDto;
import com.springmvc.Entity.ProductEntity;
import com.springmvc.Repositories.ProductRepository;
import com.springmvc.Service.ProductService;
import com.springmvc.Utils.Convert;
@Service
public class ProductServiceImpl implements ProductService{
	final static Logger logger = Logger.getLogger(ProductServiceImpl.class);
	@Autowired
	private ProductRepository productRepository;
	
	public Page<ProductJoinCategoryAndBrandDto> getAllProductJoinCategoryAndBrand(Pageable pageable) throws Exception {
		Page<ProductJoinCategoryAndBrandDto> listProductJoinCategoryDto = null;
		try {
			listProductJoinCategoryDto = productRepository.findAllProductJoinCategoryAndBrand(pageable);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listProductJoinCategoryDto;
	}
	public ProductJoinCategoryAndBrandDto getProductJoinCategoryAndBrand(int id) throws Exception {
		ProductJoinCategoryAndBrandDto listProductJoinCategoryDto = null;
		try {
			listProductJoinCategoryDto = productRepository.findProductJoinCategoryAndBrand(id);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listProductJoinCategoryDto;
	}
	public List<ProductEntity> getProductBySearch(String keyword) throws Exception{
		List<ProductEntity> listsearch = null;
		try {
//			listsearch = productRepository.getProductBySearch(keyword);
			listsearch = productRepository.findByNameStartingWith(keyword);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listsearch;
	}
	public ProductEntity getProductById(int id) throws Exception{
		ProductEntity product = null;
		try {
			product = productRepository.findOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return product;
	}
	public Page<ProductEntity> getAllProduct(Pageable pageable) throws Exception {
		Page<ProductEntity> listProduct = null;
		try {
			listProduct = productRepository.findAll(pageable);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listProduct;
	}
	public Page<ProductEntity> getAllProductByIdCategory(int id, Pageable pageable) throws Exception {
		Page<ProductEntity> listProduct = null;
		try {
			listProduct = productRepository.getPageProductByIdCategory(id, pageable);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listProduct;
	}
	public Page<ProductEntity> getAllProductByIdBrand(int id, Pageable pageable) throws Exception{
		Page<ProductEntity> listProduct = null;
		try {
			listProduct = productRepository.getPageProductByIdBrand(id, pageable);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listProduct;
	}
	public void editProductJoinCategoryAndBrand(ProductJoinCategoryAndBrandDto product) throws Exception{
		try {
			ProductEntity listProduct = productRepository.findOne(product.getId());
			listProduct.setName(product.getName());
			listProduct.setId_category(Convert.convertCategoryToInt(product.getNameCategory()));
			listProduct.setId_brand(Convert.convertBrandToInt(product.getNameBrand()));
			listProduct.setImg(product.getImg());
			listProduct.setPrice(product.getPrice());
			listProduct.setQuantity(product.getQuantity());
			productRepository.save(listProduct);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
	public void addProductJoinCategoryAndBrand(ProductJoinCategoryAndBrandDto product) throws Exception{
		try {
			ProductEntity listProduct = new ProductEntity();
			listProduct.setName(product.getName());
			listProduct.setId_category(Convert.convertCategoryToInt(product.getNameCategory()));
			listProduct.setId_brand(Convert.convertBrandToInt(product.getNameBrand()));
			listProduct.setImg(product.getImg());
			listProduct.setPrice(product.getPrice());
			listProduct.setQuantity(product.getQuantity());
			productRepository.save(listProduct);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
	public void deleteProduct(int id) throws Exception{
		try {
			ProductEntity product = productRepository.findOne(id);
			productRepository.delete(product);;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
}