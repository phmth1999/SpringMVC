package com.springmvc.Dto;
/**
 * @author PhamMinhThien
 * @since 2022
 **/
public class ProductJoinCategoryAndBrandDto {
	private int id;
	private String name;
	private double price;
	private String img;
	private int quantity;
	private String nameCategory;
	private String nameBrand;

	/**
	 * ProductJoinCategory
	 * @param int id
	 * @param String name
	 * @param double price
	 * @param String img
	 * @param int quantity
	 * @param String nameCategory
	 **/
	public ProductJoinCategoryAndBrandDto(int id, String name, double price, String img, int quantity, String nameCategory, String nameBrand) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.img = img;
		this.quantity = quantity;
		this.nameCategory = nameCategory;
		this.nameBrand = nameBrand;
	}
	/**
	 * getId
	 * @return int id
	 **/
	public int getId() {
		return id;
	}
	/**
	 * setId
	 * @param int id
	 **/
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * getNameBrand
	 * @return String nameBrand
	 **/
	public String getNameBrand() {
		return nameBrand;
	}
	/**
	 * setNameBrand
	 * @param String nameBrand
	 **/
	public void setNameBrand(String nameBrand) {
		this.nameBrand = nameBrand;
	}

	/**
	 * ProductJoinCategory
	 **/
	public ProductJoinCategoryAndBrandDto() {
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
	 **/
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
}
