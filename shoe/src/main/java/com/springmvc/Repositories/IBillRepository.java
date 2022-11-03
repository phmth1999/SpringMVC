package com.springmvc.Repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springmvc.Entity.BillEntity;
@Repository
public interface IBillRepository extends JpaRepository<BillEntity, Integer> {
	
	@Query("SELECT b FROM BillEntity b WHERE b.id_user=?1")
	Page<BillEntity> findAllBillByIdUserLogin(int id, Pageable pageable);
}
