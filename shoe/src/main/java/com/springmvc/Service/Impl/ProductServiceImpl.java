package com.springmvc.Service.Impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springmvc.Dao.ProductRepository;
import com.springmvc.Dto.ProductJoinCategoryAndBrandDto;
import com.springmvc.Entity.Product;
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
	public List<Product> getProductBySearch(String keyword) throws Exception{
		List<Product> listsearch = null;
		try {
			listsearch = productRepository.getProductBySearch(keyword);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listsearch;
	}
	public Product getProductById(int id) throws Exception{
		Product product = null;
		try {
			product = productRepository.findOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return product;
	}
	public Page<Product> getAllProduct(Pageable pageable) throws Exception {
		Page<Product> listProduct = null;
		try {
			listProduct = productRepository.findAll(pageable);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listProduct;
	}
	public Page<Product> getAllProductByIdCategory(int id, Pageable pageable) throws Exception {
		Page<Product> listProduct = null;
		try {
			listProduct = productRepository.getPageProductByIdCategory(id, pageable);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listProduct;
	}
	public Page<Product> getAllProductByIdBrand(int id, Pageable pageable) throws Exception{
		Page<Product> listProduct = null;
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
			Product listProduct = productRepository.findOne(product.getId());
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
			Product listProduct = new Product();
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
			Product product = productRepository.findOne(id);
			productRepository.delete(product);;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
}