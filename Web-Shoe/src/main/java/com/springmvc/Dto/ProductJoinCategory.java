package com.springmvc.Dto;

public class ProductJoinCategory {
	private int id;
	private String name;
	private double price;
	private String img;
	private int quantity;
	private String nameCategory;

	public ProductJoinCategory(int id, String name, double price, String img, int quantity, String nameCategory) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.img = img;
		this.quantity = quantity;
		this.nameCategory = nameCategory;
	}

	public ProductJoinCategory() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

}
