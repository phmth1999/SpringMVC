package com.springmvc.Repositories.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.Dto.CartDto;
import com.springmvc.Entity.ProductEntity;
import com.springmvc.Repositories.ICartDao;
import com.springmvc.Repositories.IProductRepository;
@Repository
public class CartDaoImpl implements ICartDao{
	@Autowired
	IProductRepository productRepository;
	
	public HashMap<Integer, CartDto> AddCart(int id, HashMap<Integer, CartDto> cart, int quanty)throws Exception {
		CartDto itemCart = new CartDto();
		try {
			ProductEntity product = productRepository.findOne(id);
			if (product != null && cart.containsKey(id)) {
				itemCart = cart.get(id);
				itemCart.setQuanty(itemCart.getQuanty() + quanty);
				itemCart.setTotalPrice(itemCart.getQuanty() * itemCart.getProduct().getPrice());
			} else {
				if(quanty>1){
					itemCart.setProduct(product);
					itemCart.setQuanty(quanty);
					itemCart.setTotalPrice(itemCart.getQuanty() * itemCart.getProduct().getPrice());
				}else{
					itemCart.setProduct(product);
					itemCart.setQuanty(1);
					itemCart.setTotalPrice(product.getPrice());
				}
			}
			cart.put(id, itemCart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}
	
	public HashMap<Integer, CartDto> EditCart(int id, int quanty, HashMap<Integer, CartDto> cart)throws Exception {
		try {
			if (cart == null) {
				return cart;
			}
			CartDto itemCart = new CartDto();
			if (cart.containsKey(id)) {
				itemCart = cart.get(id);
				itemCart.setQuanty(quanty);
				itemCart.setTotalPrice(quanty * itemCart.getProduct().getPrice());
			}
			cart.put(id, itemCart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}
	
	public HashMap<Integer, CartDto> DeleteCart(int id, HashMap<Integer, CartDto> cart) throws Exception{
		try {
			if (cart == null) {
				return cart;
			}

			if (cart.containsKey(id)) {
				cart.remove(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}
	
	public int TotalQuanty(HashMap<Integer, CartDto> cart)throws Exception {
		int totalQuanty = 0;
		try {
			for(Map.Entry<Integer, CartDto> itemCart : cart.entrySet()) {
				totalQuanty += itemCart.getValue().getQuanty();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalQuanty;
	}
	
	public double TotalPrice(HashMap<Integer, CartDto> cart)throws Exception {
		double totalPrice = 0;
		try {
			for(Map.Entry<Integer, CartDto> itemCart : cart.entrySet()) {
				totalPrice += itemCart.getValue().getTotalPrice();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalPrice;
	}
}
