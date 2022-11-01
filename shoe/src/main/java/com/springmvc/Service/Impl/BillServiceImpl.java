package com.springmvc.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springmvc.Dto.CartDto;
import com.springmvc.Entity.BillEntity;
import com.springmvc.Entity.BillDetailEntity;
import com.springmvc.Entity.ProductEntity;
import com.springmvc.Repositories.BillDetailRepository;
import com.springmvc.Repositories.BillRepository;
import com.springmvc.Repositories.ProductRepository;
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

	public Page<BillEntity> getAllBill(Pageable pageable) throws Exception {
		Page<BillEntity> listBill = null;
		try {
			listBill = billRepository.findAll(pageable);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listBill;
	}

	public void addBill(BillEntity bill, int quanty, double total) throws Exception {
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
				BillDetailEntity billDetail = new BillDetailEntity();
				billDetail.setId_bill(idBill);
				billDetail.setId_product(itemCart.getValue().getProduct().getId());
				billDetail.setQuanty(itemCart.getValue().getQuanty());
				billDetail.setTotal(itemCart.getValue().getTotalPrice());
				billDetailRepository.save(billDetail);
				
				ProductEntity product = new ProductEntity();
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
		BillEntity bill = new BillEntity();
		try {
			bill = billRepository.findOne(id);
			bill.setFile(file);
			billRepository.save(bill);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
	public Page<BillEntity> getAllBillByIdUserLogin(int id, Pageable pageable) throws Exception{
		Page<BillEntity> listBill = null;
		try {
			listBill = billRepository.findAllBillByIdUserLogin(id, pageable);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listBill;
	}
	public List<BillDetailEntity> getBillDetailByIdUserLogin(int id) throws Exception{
		List<BillDetailEntity> listBillDetail = null;
		try {
			listBillDetail = billDetailRepository.findAllBillDetailByIdUserLogin(id);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listBillDetail;
	}
}
