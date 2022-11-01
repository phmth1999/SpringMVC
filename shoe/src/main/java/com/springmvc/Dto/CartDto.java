package com.springmvc.Dto;

import com.springmvc.Entity.ProductEntity;
public class CartDto {
	private int quanty;
	private double totalPrice;
	private ProductEntity product;

	public CartDto() {
	}

	public CartDto(int quanty, double totalPrice, ProductEntity product) {
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

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	
	
}
