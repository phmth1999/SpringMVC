package com.springmvc.Service;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springmvc.Dto.CartDto;
import com.springmvc.Entity.Bill;
import com.springmvc.Entity.BillDetail;

public interface BillService {
	public Page<Bill> getAllBill(Pageable pageable) throws Exception;
	public void addBill(Bill bill, int quanty, double total) throws Exception;
	public void addBillDetail(int idBill, HashMap<Integer, CartDto> cart) throws Exception;
	public void editBill(int id, String file) throws Exception;
	public Page<Bill> getAllBillByIdUserLogin(int id, Pageable pageable) throws Exception;
	public List<BillDetail> getBillDetailByIdUserLogin(int id) throws Exception;
}
