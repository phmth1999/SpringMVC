package com.springmvc.Service.Impl;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.Dto.CartDto;
import com.springmvc.Repositories.ICartDao;
import com.springmvc.Service.CartService;
@Service
public class CartServiceImpl implements CartService{
	final static Logger logger = Logger.getLogger(CartServiceImpl.class);
	@Autowired
	private ICartDao cartDao;

	public HashMap<Integer, CartDto> AddCart(int id, HashMap<Integer, CartDto> cart, int quanty) throws Exception {
		HashMap<Integer, CartDto> listCartDto = null;
		try {
			listCartDto = cartDao.AddCart(id, cart, quanty);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listCartDto;
	}

	public HashMap<Integer, CartDto> EditCart(int id, int quanty, HashMap<Integer, CartDto> cart) throws Exception {
		HashMap<Integer, CartDto> listCartDto = null;
		try {
			listCartDto = cartDao.EditCart(id, quanty, cart);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listCartDto;
	}

	public HashMap<Integer, CartDto> DeleteCart(int id, HashMap<Integer, CartDto> cart) throws Exception {
		HashMap<Integer, CartDto> listCartDto = null;
		try {
			listCartDto = cartDao.DeleteCart(id, cart);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listCartDto;
	}

	public int TotalQuanty(HashMap<Integer, CartDto> cart) throws Exception {
		int totalQuanty = 0;
		try {
			totalQuanty = cartDao.TotalQuanty(cart);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return totalQuanty;
	}

	public double TotalPrice(HashMap<Integer, CartDto> cart) throws Exception {
		double totalPrice = 0;
		try {
			totalPrice = cartDao.TotalPrice(cart);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return totalPrice;
	}
}
