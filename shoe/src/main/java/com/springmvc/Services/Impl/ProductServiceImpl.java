package com.springmvc.Services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springmvc.Converter.ProductConverter;
import com.springmvc.Dto.ProductDto;
import com.springmvc.Dto.ProductJoinCategoryAndBrandDto;
import com.springmvc.Entity.ProductEntity;
import com.springmvc.Repositories.IProductRepository;
import com.springmvc.Services.IProductService;
import com.springmvc.Utils.Convert;
@Service
public class ProductServiceImpl implements IProductService{
	final static Logger logger = Logger.getLogger(ProductServiceImpl.class);
	@Autowired
	private IProductRepository productRepository;
	
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
	public List<ProductDto> getProductBySearch(String keyword) throws Exception{
		List<ProductDto> listSearchDto = new ArrayList<ProductDto>();
		try {
			List<ProductEntity> listSearchEntity = productRepository.findByNameStartingWith(keyword);
			for (ProductEntity productEntity : listSearchEntity) {
				ProductDto productDto = ProductConverter.toDto(productEntity);
				listSearchDto.add(productDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listSearchDto;
	}
	public ProductDto getProductById(int id) throws Exception{
		ProductDto productDto = null;
		try {
			ProductEntity productEntity = productRepository.findOne(id);
			productDto = ProductConverter.toDto(productEntity);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return productDto;
	}
	public Page<ProductDto> getAllProduct(Pageable pageable) throws Exception {
		Page<ProductDto> listProductDto = null;
		try {
			Page<ProductEntity> listProductEntity = productRepository.findAll(pageable);
			listProductDto = listProductEntity.map(new Converter<ProductEntity, ProductDto>() {
				@Override
				public ProductDto convert(ProductEntity productEntity) {
					ProductDto productDto = ProductConverter.toDto(productEntity);
					return productDto;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listProductDto;
	}
	public Page<ProductDto> getAllProductByIdCategory(int id, Pageable pageable) throws Exception {
		Page<ProductDto> listProductDto = null;
		try {
			Page<ProductEntity> listProductEntity = productRepository.getPageProductByIdCategory(id, pageable);
			listProductDto = listProductEntity.map(new Converter<ProductEntity, ProductDto>() {
				@Override
				public ProductDto convert(ProductEntity productEntity) {
					ProductDto productDto = ProductConverter.toDto(productEntity);
					return productDto;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listProductDto;
	}
	public Page<ProductDto> getAllProductByIdBrand(int id, Pageable pageable) throws Exception{
		Page<ProductDto> listProductDto = null;
		try {
			Page<ProductEntity> listProductEntity = productRepository.getPageProductByIdBrand(id, pageable);
			listProductDto = listProductEntity.map(new Converter<ProductEntity, ProductDto>() {
				@Override
				public ProductDto convert(ProductEntity productEntity) {
					ProductDto productDto = ProductConverter.toDto(productEntity);
					return productDto;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listProductDto;
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