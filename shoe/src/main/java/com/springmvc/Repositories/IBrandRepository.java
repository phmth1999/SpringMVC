package com.springmvc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.Entity.BrandEntity;
@Repository
public interface IBrandRepository extends JpaRepository<BrandEntity, Integer> {

}
