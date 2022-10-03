package com.springmvc.Service.Impl;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.Dao.CartDao;
import com.springmvc.Dto.CartDto;
import com.springmvc.Service.CartService;
/**
 * @author PhamMinhThien
 * @since 2022
 **/
@Service
public class CartServiceImpl implements CartService{
	final static Logger logger = Logger.getLogger(CartServiceImpl.class);
	@Autowired
	private CartDao cartDao;

	/**
	 * AddCart
	 * @param int id
	 * @param HashMap<Integer, CartDto> cart
	 * @return HashMap<Integer, CartDto> listCartDto
	 * @throws Exception
	 **/
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

	/**
	 * EditCart
	 * @param int id
	 * @param int quanty
	 * @param HashMap<Integer, CartDto> cart
	 * @return HashMap<Integer, CartDto> listCartDto
	 * @throws Exception
	 **/
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

	/**
	 * DeleteCart
	 * @param int id
	 * @param HashMap<Integer, CartDto> cart
	 * @return HashMap<Integer, CartDto> listCartDto
	 * @throws Exception
	 **/
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

	/**
	 * TotalQuanty
	 * @param HashMap<Integer, CartDto> cart
	 * @return int totalQuanty
	 * @throws Exception
	 **/
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

	/**
	 * TotalPrice
	 * @param HashMap<Integer, CartDto> cart
	 * @return double totalPrice
	 * @throws Exception
	 **/
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
