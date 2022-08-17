package com.springmvc.Dto;
/**
 * @author PhamMinhThien
 * @since 2022
 **/
public class ProductJoinCategoryDto {
	private int id;
	private String name;
	private double price;
	private String img;
	private int quantity;
	private String nameCategory;

	/**
	 * ProductJoinCategory
	 * @param int id
	 * @param String name
	 * @param double price
	 * @param String img
	 * @param int quantity
	 * @param String nameCategory
	 **/
	public ProductJoinCategoryDto(int id, String name, double price, String img, int quantity, String nameCategory) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.img = img;
		this.quantity = quantity;
		this.nameCategory = nameCategory;
	}

	/**
	 * ProductJoinCategory
	 **/
	public ProductJoinCategoryDto() {
	}

	/**
	 * getId
	 * @return int id
	 **/
	public int getId() {
		return id;
	}

	/**
	 * getName
	 * @return String name
	 **/
	public String getName() {
		return name;
	}

	/**
	 * setName
	 * @param String name
	 * @return void
	 **/
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getPrice
	 * @return double price
	 **/
	public double getPrice() {
		return price;
	}

	/**
	 * setPrice
	 * @param double price
	 * @return void
	 **/
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * getImg
	 * @return String img
	 **/
	public String getImg() {
		return img;
	}

	/**
	 * setImg
	 * @param String img
	 * @return void
	 **/
	public void setImg(String img) {
		this.img = img;
	}

	/**
	 * getQuantity
	 * @return int quantity
	 **/
	public int getQuantity() {
		return quantity;
	}

	/**
	 * setQuantity
	 * @param int quantity
	 * @return void
	 **/
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * getNameCategory
	 * @return String nameCategory
	 **/
	public String getNameCategory() {
		return nameCategory;
	}

	/**
	 * setNameCategory
	 * @param String nameCategory
	 * @return void
	 **/
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
}
