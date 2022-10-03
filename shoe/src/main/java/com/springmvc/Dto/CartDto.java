package com.springmvc.Dto;

import com.springmvc.Entity.Product;
/**
 * @author PhamMinhThien
 * @since 2022
 **/
public class CartDto {
	private int quanty;
	private double totalPrice;
	private Product product;

	/**
	 * CartDto
	 **/
	public CartDto() {
	}

	/**
	 * CartDto
	 * @param int quanty
	 * @param double totalPrice
	 * @param Product product
	 **/
	public CartDto(int quanty, double totalPrice, Product product) {
		this.quanty = quanty;
		this.totalPrice = totalPrice;
		this.product = product;
	}

	/**
	 * getQuanty
	 * @return int quanty
	 **/
	public int getQuanty() {
		return quanty;
	}

	/**
	 * setQuanty
	 * @param int quanty
	 **/
	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}

	/**
	 * getTotalPrice
	 * @return double totalPrice
	 **/
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * setTotalPrice
	 * @param double totalPrice
	 **/
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * getProduct
	 * @return Product product
	 **/
	public Product getProduct() {
		return product;
	}

	/**
	 * setProduct
	 * @param Product product
	 **/
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
