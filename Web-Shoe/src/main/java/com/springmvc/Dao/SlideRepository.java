package com.springmvc.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.Entity.Slide;
@Repository
public interface SlideRepository extends JpaRepository<Slide, Integer> {

}
