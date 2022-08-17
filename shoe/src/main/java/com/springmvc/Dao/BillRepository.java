package com.springmvc.Dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springmvc.Entity.Bill;
/**
 * @author PhamMinhThien
 * @since 2022
 **/
@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
	@Query("SELECT b FROM Bill b ORDER BY b.id DESC")
	Page<Bill>findAllDataBillSortDESC(Pageable pageable);
	
	@Query("SELECT b FROM Bill b WHERE b.id_user=?1 ORDER BY b.id DESC")
	Page<Bill> findAllByIdUserLogin(int id, Pageable pageable);
}
