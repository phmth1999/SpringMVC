package com.springmvc.Service.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
/**
 * @author PhamMinhThien
 * @since 2022
 **/
@Service
public class BillServiceImpl {
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private BillDetailRepository billDetailRepository;

	/**
	 * getAllDataBillSortDESC
	 * @return List<Bill> listBill
	 * @throws Exception
	 **/
	public Page<Bill> getAllDataBillSortDESC(Pageable pageable) throws Exception {
		Page<Bill> listBill = null;
		try {
			listBill = billRepository.findAllDataBillSortDESC(pageable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listBill;
	}

	/**
	 * getAllDataBillDetail
	 * @return List<BillDetail> listBillDetail
	 * @throws Exception
	 **/
	public List<BillDetail> getAllDataBillDetail() throws Exception {
		List<BillDetail> listBillDetail = null;
		try {
			listBillDetail = billDetailRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listBillDetail;
	}

	/**
	 * addBill
	 * @param Bill bill
	 * @param int quanty
	 * @param double total
	 * @return void
	 * @throws Exception
	 **/
	public void addBill(Bill bill, int quanty, double total) throws Exception {
		try {
			int id_user = CustomSuccesHandler.getPrincipal().getId();
			bill.setId_user(id_user);
			bill.setQuanty(quanty);
			bill.setTotal(total);
			billRepository.save(bill);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * addBillDetail
	 * @param int idBill
	 * @param HashMap<Integer, CartDto> cart
	 * @return void
	 * @throws Exception
	 **/
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
		}
	}
	public Page<Bill> getBillByIdUserLogin(int id, Pageable pageable) throws Exception{
		Page<Bill> listBill = null;
		try {
			listBill = billRepository.findAllByIdUserLogin(id, pageable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listBill;
	}
	public List<BillDetail> getBillDetailByIdUserLogin(int id) throws Exception{
		List<BillDetail> listBillDetail = null;
		try {
			listBillDetail = billDetailRepository.findAllByIdUserLogin(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listBillDetail;
	}
}
