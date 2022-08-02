package com.springmvc.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springmvc.Dto.ProductJoinCategory;
import com.springmvc.Entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("SELECT p FROM Product p where p.id_category=?1")
	List<Product> getDataProductByIdCategory(int id);
	
	@Query("SELECT new com.springmvc.Dto.ProductJoinCategory(p.id,p.name,p.price,p.img,p.quantity,c.name) FROM Product p,Category c WHERE p.id_category=c.id ORDER BY p.id DESC")
	List<ProductJoinCategory> findAllProductJoinCategorySortDESC();
	
}
