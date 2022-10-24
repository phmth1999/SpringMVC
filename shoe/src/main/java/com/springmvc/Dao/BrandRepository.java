package com.springmvc.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.Entity.Brand;
@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
