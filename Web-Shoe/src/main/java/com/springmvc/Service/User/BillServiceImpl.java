package com.springmvc.Service.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.Dao.BillDetailRepository;
import com.springmvc.Dao.BillRepository;
import com.springmvc.Dto.CartDto;
import com.springmvc.Entity.Bill;
import com.springmvc.Entity.BillDetail;
import com.springmvc.Security.CustomSuccesHandler;

@Service
public class BillServiceImpl {
	@Autowired
	private BillRepository billRepository;
	@Autowired
	private BillDetailRepository billDetailRepository;

	public List<Bill> getAllDataBillSortDESC() {
		return billRepository.findAllDataBillSortDESC();
	}

	public List<BillDetail> getAllDataBillDetail() {
		return billDetailRepository.findAll();
	}

	public void addBill(Bill bill, int quanty, double total) {
		int id_user = CustomSuccesHandler.getPrincipal().getId();
		bill.setId_user(id_user);;
		bill.setQuanty(quanty);
		bill.setTotal(total);
		billRepository.save(bill);
	}

	public void addBillDetail(int idBill, HashMap<Integer, CartDto> cart) {
		for (Map.Entry<Integer, CartDto> itemCart : cart.entrySet()) {
			BillDetail billDetail = new BillDetail();
			billDetail.setId_bill(idBill);
			billDetail.setId_product(itemCart.getValue().getProduct().getId());
			billDetail.setQuanty(itemCart.getValue().getQuanty());
			billDetail.setTotal(itemCart.getValue().getTotalPrice());
			billDetailRepository.save(billDetail);
		}
	}
}
