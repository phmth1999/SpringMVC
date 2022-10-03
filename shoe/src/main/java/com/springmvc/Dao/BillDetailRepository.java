package com.springmvc.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springmvc.Entity.BillDetail;
/**
 * @author PhamMinhThien
 * @since 2022
 **/
@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, Integer> {
	@Query("SELECT new com.springmvc.Dto.BillDetailJoinProductDto(b.id_bill,p.img,p.name,p.price,b.quanty,b.total) FROM BillDetail b,Product p WHERE b.id_product=p.id and b.id_bill=?1 ORDER BY p.id DESC")
	List<BillDetail> findAllBillDetailByIdUserLogin(int id);

}
