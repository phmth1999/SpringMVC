package com.springmvc.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.Entity.BillDetail;
@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, Integer> {

}
