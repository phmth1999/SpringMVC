package com.springmvc.Dto;
/**
 * @author PhamMinhThien
 * @since 2022
 **/
public class BillDetailJoinProductDto {
	private int id_bill;
	private String img;
	private String name;
	private double price;
	private int quanty;
	private double total;
	/**
	 * BillDetailJoinProductDto
	 * @param int id_bill
	 * @param String img
	 * @param String name
	 * @param double price
	 * @param int quanty
	 * @param double total
	 **/
	public BillDetailJoinProductDto(int id_bill, String img, String name, double price, int quanty, double total) {
		this.id_bill = id_bill;
		this.img = img;
		this.name = name;
		this.price = price;
		this.quanty = quanty;
		this.total = total;
	}
	/**
	 * BillDetailJoinProductDto
	 **/
	public BillDetailJoinProductDto(){
		
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
	 * getQuanty
	 * @return int quanty
	 **/
	public int getQuanty() {
		return quanty;
	}
	/**
	 * setQuanty
	 * @param int quanty
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
	 **/
	public void setTotal(double total) {
		this.total = total;
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
	 **/
	public void setId_bill(int id_bill) {
		this.id_bill = id_bill;
	}
	
}
