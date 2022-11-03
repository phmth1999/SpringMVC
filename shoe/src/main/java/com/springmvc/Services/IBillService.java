package com.springmvc.Services;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springmvc.Dto.BillDetailDto;
import com.springmvc.Dto.BillDto;
import com.springmvc.Dto.CartDto;

public interface IBillService {
	Page<BillDto> getAllBill(Pageable pageable) throws Exception;
	void addBill(BillDto bill, int quanty, double total) throws Exception;
	void addBillDetail(int idBill, HashMap<Integer, CartDto> cart) throws Exception;
	void editBill(int id, String file) throws Exception;
	Page<BillDto> getAllBillByIdUserLogin(int id, Pageable pageable) throws Exception;
	List<BillDetailDto> getBillDetailByIdUserLogin(int id) throws Exception;
}
