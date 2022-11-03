package com.springmvc.Services.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springmvc.Converter.BillConverter;
import com.springmvc.Converter.BillDetailConverter;
import com.springmvc.Dto.BillDetailDto;
import com.springmvc.Dto.BillDto;
import com.springmvc.Dto.CartDto;
import com.springmvc.Entity.BillEntity;
import com.springmvc.Entity.BillDetailEntity;
import com.springmvc.Entity.ProductEntity;
import com.springmvc.Repositories.IBillDetailRepository;
import com.springmvc.Repositories.IBillRepository;
import com.springmvc.Repositories.IProductRepository;
import com.springmvc.Security.CustomSuccesHandler;
import com.springmvc.Services.IBillService;
@Service
public class BillServiceImpl implements IBillService{
	final static Logger logger = Logger.getLogger(BillServiceImpl.class);
	@Autowired
	private IProductRepository productRepository;
	
	@Autowired
	private IBillRepository billRepository;
	
	@Autowired
	private IBillDetailRepository billDetailRepository;

	public Page<BillDto> getAllBill(Pageable pageable) throws Exception {
		Page<BillDto> listBillDto = null;
		try {
			Page<BillEntity> listBillEntity = billRepository.findAll(pageable);
			listBillDto = listBillEntity.map(new Converter<BillEntity, BillDto>() {

				@Override
				public BillDto convert(BillEntity billEntity) {
					BillDto billDto = BillConverter.toDto(billEntity);
					return billDto;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listBillDto;
	}

	public void addBill(BillDto billDto, int quanty, double total) throws Exception {
		try {
			int id_user = CustomSuccesHandler.getPrincipal().getId();
			billDto.setId_user(id_user);
			billDto.setQuanty(quanty);
			billDto.setTotal(total);
			BillEntity billEntity = BillConverter.toEntity(billDto);
			billRepository.save(billEntity);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		
	}

	public void addBillDetail(int idBill, HashMap<Integer, CartDto> cart) throws Exception {
		try {
			for (Map.Entry<Integer, CartDto> itemCart : cart.entrySet()) {
				BillDetailEntity billDetailEntity = new BillDetailEntity();
				billDetailEntity.setId_bill(idBill);
				billDetailEntity.setId_product(itemCart.getValue().getProduct().getId());
				billDetailEntity.setQuanty(itemCart.getValue().getQuanty());
				billDetailEntity.setTotal(itemCart.getValue().getTotalPrice());
				billDetailRepository.save(billDetailEntity);
				
				ProductEntity productEntity = new ProductEntity();
				productEntity = productRepository.findOne(itemCart.getValue().getProduct().getId());
				productEntity.setQuantity(productEntity.getQuantity() - itemCart.getValue().getQuanty());
				productEntity.setQuantity_sold(productEntity.getQuantity_sold() + itemCart.getValue().getQuanty());
				productRepository.save(productEntity);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
	public void editBill(int id, String file) throws Exception{
		BillEntity billEntity = new BillEntity();
		try {
			billEntity = billRepository.findOne(id);
			billEntity.setFile(file);
			billRepository.save(billEntity);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
	public Page<BillDto> getAllBillByIdUserLogin(int id, Pageable pageable) throws Exception{
		Page<BillDto> listBillDto = null;
		try {
			Page<BillEntity> listBillEntity = billRepository.findAllBillByIdUserLogin(id, pageable);
			listBillDto = listBillEntity.map(new Converter<BillEntity, BillDto>() {
				@Override
				public BillDto convert(BillEntity billEntity) {
					BillDto billDto = BillConverter.toDto(billEntity);
					return billDto;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listBillDto;
	}
	public List<BillDetailDto> getBillDetailByIdUserLogin(int id) throws Exception{
		List<BillDetailDto> listBillDetailDto = new ArrayList<BillDetailDto>();
		try {
			List<BillDetailEntity> listBillDetailEntity = billDetailRepository.findAllBillDetailByIdUserLogin(id);
			for (BillDetailEntity billDetailEntity : listBillDetailEntity) {
				BillDetailDto billDetailDto = BillDetailConverter.toDto(billDetailEntity);
				listBillDetailDto.add(billDetailDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listBillDetailDto;
	}
}
