package com.springmvc.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    @Column(name = "id_category")
    private int id_category;
	
	@Column(name="name")
	private String name;
	
	@Column(name="img")
	private String img;
	
	@Column(name="price")
	private double price;
	
	@Column(name="quantity")
	private int quantity;
	

	public Product() {
	}


	public int getId_category() {
		return id_category;
	}


	public void setId_category(int id_category) {
		this.id_category = id_category;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId_product(int id) {
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


}
