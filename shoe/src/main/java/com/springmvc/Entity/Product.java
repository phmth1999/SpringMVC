package com.springmvc.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author PhamMinhThien
 * @since 2022
 **/
@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    @Column(name = "id_category")
    private int id_category;
    
    @Column(name = "id_brand")
    private int id_brand;
	
	@Column(name="name")
	private String name;
	
	@Column(name="img")
	private String img;
	
	@Column(name="price")
	private double price;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="quantity_sold")
	private int quantity_sold;
	
	/**
	 * Product
	 **/
	public Product() {
	}
	/**
	 * setId
	 * @param int id
	 **/
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * getId_brand
	 * @return int id_brand
	 **/
	public int getId_brand() {
		return id_brand;
	}
	/**
	 * setId_brand
	 * @param int id_brand
	 **/
	public void setId_brand(int id_brand) {
		this.id_brand = id_brand;
	}

	/**
	 * getId_category
	 * @return int id_category
	 **/
	public int getId_category() {
		return id_category;
	}

	/**
	 * setId_category
	 * @param int id_category
	 **/
	public void setId_category(int id_category) {
		this.id_category = id_category;
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
	 * getQuantity_sold
	 * @return int getQuantity_sold
	 **/
	public int getQuantity_sold() {
		return quantity_sold;
	}

	/**
	 * setQuantity_sold
	 * @param int quantity
	 **/
	public void setQuantity_sold(int quantity_sold) {
		this.quantity_sold = quantity_sold;
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
}
