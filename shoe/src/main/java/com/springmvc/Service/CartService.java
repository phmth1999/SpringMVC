package com.springmvc.Service;

import java.util.HashMap;

import com.springmvc.Dto.CartDto;

public interface CartService {
	public HashMap<Integer, CartDto> AddCart(int id, HashMap<Integer, CartDto> cart, int quanty) throws Exception;
	public HashMap<Integer, CartDto> EditCart(int id, int quanty, HashMap<Integer, CartDto> cart) throws Exception;
	public HashMap<Integer, CartDto> DeleteCart(int id, HashMap<Integer, CartDto> cart) throws Exception;
	public int TotalQuanty(HashMap<Integer, CartDto> cart) throws Exception;
	public double TotalPrice(HashMap<Integer, CartDto> cart) throws Exception;
}
