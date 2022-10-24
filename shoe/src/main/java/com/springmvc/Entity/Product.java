package com.springmvc.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "product")
public class Product extends BaseEntity{
	
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

	public int getId_category() {
		return id_category;
	}

	public void setId_category(int id_category) {
		this.id_category = id_category;
	}

	public int getId_brand() {
		return id_brand;
	}

	public void setId_brand(int id_brand) {
		this.id_brand = id_brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity_sold() {
		return quantity_sold;
	}

	public void setQuantity_sold(int quantity_sold) {
		this.quantity_sold = quantity_sold;
	}
	
	
}
