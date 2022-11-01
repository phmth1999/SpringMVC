package com.springmvc.Repositories;

import java.util.HashMap;

import com.springmvc.Dto.CartDto;

public interface ICartDao {
	HashMap<Integer, CartDto> AddCart(int id, HashMap<Integer, CartDto> cart, int quanty) throws Exception;

	HashMap<Integer, CartDto> EditCart(int id, int quanty, HashMap<Integer, CartDto> cart) throws Exception;

	HashMap<Integer, CartDto> DeleteCart(int id, HashMap<Integer, CartDto> cart) throws Exception;

	int TotalQuanty(HashMap<Integer, CartDto> cart) throws Exception;

	double TotalPrice(HashMap<Integer, CartDto> cart) throws Exception;
}
