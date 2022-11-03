package com.springmvc.Repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springmvc.Dto.ProductJoinCategoryAndBrandDto;
import com.springmvc.Entity.ProductEntity;
@Repository
public interface IProductRepository extends JpaRepository<ProductEntity, Integer> {
	@Query("SELECT p FROM ProductEntity p where p.id_category=?1")
	List<ProductEntity> getDataProductByIdCategory(int id);
	
	@Query("SELECT new com.springmvc.Dto.ProductJoinCategoryAndBrandDto(p.id,p.name,p.price,p.img,p.quantity,c.name,b.name) FROM ProductEntity p,CategoryEntity c,BrandEntity b WHERE p.id_category=c.id and p.id_brand=b.id")
	Page<ProductJoinCategoryAndBrandDto> findAllProductJoinCategoryAndBrand(Pageable pageable);
	
	@Query("SELECT new com.springmvc.Dto.ProductJoinCategoryAndBrandDto(p.id,p.name,p.price,p.img,p.quantity,c.name,b.name) FROM ProductEntity p,CategoryEntity c,BrandEntity b WHERE p.id_category=c.id and p.id_brand=b.id and p.id=?1")
	ProductJoinCategoryAndBrandDto findProductJoinCategoryAndBrand(int id);

	@Query("SELECT p FROM ProductEntity p where p.id_category=?1")
	Page<ProductEntity> getPageProductByIdCategory(int id, Pageable pageable);
	
	@Query("SELECT p FROM ProductEntity p where p.id_brand=?1")
	Page<ProductEntity> getPageProductByIdBrand(int id, Pageable pageable);
	
//	@Query("SELECT p FROM Product p where p.name like :keyword%")
//	public List<Product> getProductBySearch(@Param("keyword") String keyword);

	List<ProductEntity> findByNameStartingWith(String keyword);
	
}
