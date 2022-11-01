package com.springmvc.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "billdetail")
public class BillDetailEntity extends BaseEntity{
	
	@Column(name="id_product")
	private int id_product;
	
	@Column(name="id_bill")
	private int id_bill;
	
	@Column(name="quanty")
	private int quanty;
	
	@Column(name="total")
	private double total;

	public int getId_product() {
		return id_product;
	}

	public void setId_product(int id_product) {
		this.id_product = id_product;
	}

	public int getId_bill() {
		return id_bill;
	}

	public void setId_bill(int id_bill) {
		this.id_bill = id_bill;
	}

	public int getQuanty() {
		return quanty;
	}

	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	
	
}
