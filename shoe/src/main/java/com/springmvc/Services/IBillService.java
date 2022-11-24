package com.springmvc.Services;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springmvc.Dto.BillDetailJoinProductDto;
import com.springmvc.Dto.BillDto;
import com.springmvc.Dto.CartDto;

public interface IBillService {
	Page<BillDto> getAllBill(Pageable pageable) throws Exception;
	int addBill(BillDto bill, int quanty, double total) throws Exception;
	void addBillDetail(int idBill, HashMap<Integer, CartDto> cart) throws Exception;
	void editBill(int id, BillDto bill) throws Exception;
	Page<BillDto> getAllBillByIdUserLogin(int id, Pageable pageable) throws Exception;
	List<BillDetailJoinProductDto> getBillDetailByIdUserLogin(int id) throws Exception;
	BillDto findOne(int id) throws Exception;
}
