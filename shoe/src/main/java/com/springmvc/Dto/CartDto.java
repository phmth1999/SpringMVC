package com.springmvc.Dto;

import com.springmvc.Entity.Product;
public class CartDto {
	private int quanty;
	private double totalPrice;
	private Product product;

	public CartDto() {
	}

	public CartDto(int quanty, double totalPrice, Product product) {
		this.quanty = quanty;
		this.totalPrice = totalPrice;
		this.product = product;
	}

	public int getQuanty() {
		return quanty;
	}

	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
	
}
