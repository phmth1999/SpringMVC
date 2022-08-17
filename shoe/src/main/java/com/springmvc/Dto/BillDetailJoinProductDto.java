package com.springmvc.Dto;

public class BillDetailJoinProductDto {
	private int id_bill;
	private String img;
	private String name;
	private double price;
	private int quanty;
	private double total;
	public BillDetailJoinProductDto(int id_bill, String img, String name, double price, int quanty, double total) {
		this.id_bill = id_bill;
		this.img = img;
		this.name = name;
		this.price = price;
		this.quanty = quanty;
		this.total = total;
	}
	public BillDetailJoinProductDto(){
		
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
	public int getId_bill() {
		return id_bill;
	}
	
}
