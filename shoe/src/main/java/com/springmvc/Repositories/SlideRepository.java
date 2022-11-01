package com.springmvc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.Entity.SlideEntity;
@Repository
public interface SlideRepository extends JpaRepository<SlideEntity, Integer> {

}
