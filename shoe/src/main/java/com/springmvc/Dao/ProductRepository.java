package com.springmvc.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springmvc.Dto.ProductJoinCategoryAndBrandDto;
import com.springmvc.Entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("SELECT p FROM Product p where p.id_category=?1")
	List<Product> getDataProductByIdCategory(int id);
	
	@Query("SELECT new com.springmvc.Dto.ProductJoinCategoryAndBrandDto(p.id,p.name,p.price,p.img,p.quantity,c.name,b.name) FROM Product p,Category c,Brand b WHERE p.id_category=c.id and p.id_brand=b.id")
	Page<ProductJoinCategoryAndBrandDto> findAllProductJoinCategoryAndBrand(Pageable pageable);
	
	@Query("SELECT new com.springmvc.Dto.ProductJoinCategoryAndBrandDto(p.id,p.name,p.price,p.img,p.quantity,c.name,b.name) FROM Product p,Category c,Brand b WHERE p.id_category=c.id and p.id_brand=b.id and p.id=?1")
	ProductJoinCategoryAndBrandDto findProductJoinCategoryAndBrand(int id);

	@Query("SELECT p FROM Product p where p.id_category=?1")
	Page<Product> getPageProductByIdCategory(int id, Pageable pageable);
	
	@Query("SELECT p FROM Product p where p.id_brand=?1")
	Page<Product> getPageProductByIdBrand(int id, Pageable pageable);
	
	@Query("SELECT p FROM Product p where p.name like :keyword%")
	public List<Product> getProductBySearch(@Param("keyword") String keyword);
	
}
