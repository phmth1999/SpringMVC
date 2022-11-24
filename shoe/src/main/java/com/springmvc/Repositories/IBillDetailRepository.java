package com.springmvc.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springmvc.Dto.BillDetailJoinProductDto;
import com.springmvc.Entity.BillDetailEntity;
@Repository
public interface IBillDetailRepository extends JpaRepository<BillDetailEntity, Integer> {
	@Query("SELECT new com.springmvc.Dto.BillDetailJoinProductDto(b.id_bill,p.img,p.name,p.price,b.quanty,b.total) FROM BillDetailEntity b,ProductEntity p WHERE b.id_product=p.id and b.id_bill=?1 ORDER BY p.id DESC")
	List<BillDetailJoinProductDto> findAllBillDetailByIdUserLogin(int id);

}
