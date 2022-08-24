package com.springmvc.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springmvc.Dto.ProductJoinCategoryDto;
import com.springmvc.Entity.Product;
/**
 * @author PhamMinhThien
 * @since 2022
 **/
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("SELECT p FROM Product p where p.id_category=?1")
	List<Product> getDataProductByIdCategory(int id);
	
	@Query("SELECT p FROM Product p where p.id_category=?1 ORDER BY p.id DESC")
	Page<Product> getPageProductByIdCategory(int id, Pageable pageable);
	
	@Query("SELECT new com.springmvc.Dto.ProductJoinCategoryDto(p.id,p.name,p.price,p.img,p.quantity,c.name) FROM Product p,Category c WHERE p.id_category=c.id ORDER BY p.id DESC")
	Page<ProductJoinCategoryDto> findAllProductJoinCategorySortDESC(Pageable pageable);

	@Query("SELECT p FROM Product p where p.id_brand=?1 ORDER BY p.id DESC")
	Page<Product> getPageProductByIdBrand(int id, Pageable pageable);
	
}
