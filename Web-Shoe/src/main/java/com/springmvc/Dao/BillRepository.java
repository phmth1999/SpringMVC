package com.springmvc.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springmvc.Entity.Bill;
@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
	@Query("SELECT b FROM Bill b ORDER BY b.id DESC")
	List<Bill>findAllDataBillSortDESC();
}
