package com.springmvc.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springmvc.Dao.BillDetailRepository;
import com.springmvc.Dao.BillRepository;
import com.springmvc.Dao.ProductRepository;
import com.springmvc.Dto.CartDto;
import com.springmvc.Entity.Bill;
import com.springmvc.Entity.BillDetail;
import com.springmvc.Entity.Product;
import com.springmvc.Security.CustomSuccesHandler;
import com.springmvc.Service.BillService;
@Service
public class BillServiceImpl implements BillService{
	final static Logger logger = Logger.getLogger(BillServiceImpl.class);
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private BillDetailRepository billDetailRepository;

	public Page<Bill> getAllBill(Pageable pageable) throws Exception {
		Page<Bill> listBill = null;
		try {
			listBill = billRepository.findAll(pageable);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listBill;
	}

	public void addBill(Bill bill, int quanty, double total) throws Exception {
		try {
			int id_user = CustomSuccesHandler.getPrincipal().getId();
			bill.setId_user(id_user);
			bill.setQuanty(quanty);
			bill.setTotal(total);
			billRepository.save(bill);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		
	}

	public void addBillDetail(int idBill, HashMap<Integer, CartDto> cart) throws Exception {
		try {
			for (Map.Entry<Integer, CartDto> itemCart : cart.entrySet()) {
				BillDetail billDetail = new BillDetail();
				billDetail.setId_bill(idBill);
				billDetail.setId_product(itemCart.getValue().getProduct().getId());
				billDetail.setQuanty(itemCart.getValue().getQuanty());
				billDetail.setTotal(itemCart.getValue().getTotalPrice());
				billDetailRepository.save(billDetail);
				
				Product product = new Product();
				product = productRepository.findOne(itemCart.getValue().getProduct().getId());
				product.setQuantity(product.getQuantity() - itemCart.getValue().getQuanty());
				product.setQuantity_sold(product.getQuantity_sold() + itemCart.getValue().getQuanty());
				productRepository.save(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
	public void editBill(int id, String file) throws Exception{
		Bill bill = new Bill();
		try {
			bill = billRepository.findOne(id);
			bill.setFile(file);
			billRepository.save(bill);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
	public Page<Bill> getAllBillByIdUserLogin(int id, Pageable pageable) throws Exception{
		Page<Bill> listBill = null;
		try {
			listBill = billRepository.findAllBillByIdUserLogin(id, pageable);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listBill;
	}
	public List<BillDetail> getBillDetailByIdUserLogin(int id) throws Exception{
		List<BillDetail> listBillDetail = null;
		try {
			listBillDetail = billDetailRepository.findAllBillDetailByIdUserLogin(id);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listBillDetail;
	}
}
