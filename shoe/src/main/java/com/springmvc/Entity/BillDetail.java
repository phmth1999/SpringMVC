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
@Table(name = "billdetail")
public class BillDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="id_product")
	private int id_product;
	
	@Column(name="id_bill")
	private int id_bill;
	
	@Column(name="quanty")
	private int quanty;
	
	@Column(name="total")
	private double total;

	/**
	 * BillDetail
	 **/
	public BillDetail() {
	}
	
	/**
	 * getId_bill
	 * @return int id_bill
	 **/
	public int getId_bill() {
		return id_bill;
	}

	/**
	 * setId_bill
	 * @param int id_bill
	 * @return void
	 **/
	public void setId_bill(int id_bill) {
		this.id_bill = id_bill;
	}

	/**
	 * getId
	 * @return int id
	 **/
	public int getId() {
		return id;
	}

	/**
	 * getId_product
	 * @return int id_product
	 **/
	public int getId_product() {
		return id_product;
	}

	/**
	 * setId_product
	 * @param int id_product
	 * @return void
	 **/
	public void setId_product(int id_product) {
		this.id_product = id_product;
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
	 * @return void
	 **/
	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}

	/**
	 * getTotal
	 * @return double total
	 **/
	public double getTotal() {
		return total;
	}

	/**
	 * setTotal
	 * @param double total
	 * @return void
	 **/
	public void setTotal(double total) {
		this.total = total;
	}
}
