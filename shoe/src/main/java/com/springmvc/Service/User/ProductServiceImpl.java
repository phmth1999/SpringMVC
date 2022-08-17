package com.springmvc.Service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springmvc.Dao.ProductRepository;
import com.springmvc.Dto.ProductJoinCategoryDto;
/**
 * @author PhamMinhThien
 * @since 2022
 **/
@Service
public class ProductServiceImpl {
	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * getDataProductJoinCategorySortDESC
	 * @return List<ProductJoinCategoryDto> listProductJoinCategoryDto
	 * @throws Exception
	 **/
	public Page<ProductJoinCategoryDto> getDataProductJoinCategorySortDESC(Pageable pageable) throws Exception {
		Page<ProductJoinCategoryDto> listProductJoinCategoryDto = null;
		try {
			listProductJoinCategoryDto = productRepository.findAllProductJoinCategorySortDESC(pageable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listProductJoinCategoryDto;
	}
}
