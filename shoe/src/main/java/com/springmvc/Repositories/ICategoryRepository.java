package com.springmvc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.Entity.CategoryEntity;
@Repository
public interface ICategoryRepository extends JpaRepository<CategoryEntity, Integer> {

}
