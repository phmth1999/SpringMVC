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
@Table(name = "bill")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="id_user")
	private int id_user;
	
	@Column(name="user")
	private String user;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="fullname")
	private String fullname;
	
	@Column(name="address")
	private String address;
	
	@Column(name="total")
	private double total;
	
	@Column(name="quanty")
	private int quanty;
	
	@Column(name="note")
	private String note;
	
	@Column(name="sign")
	private String sign;
	
	@Column(name="file")
	private String file;
	
	@Column(name="data")
	private String data;
	
	/**
	 * Bill
	 **/
	public Bill() {
	}
	
	/**
	 * getData
	 * @return String data
	 **/
	public String getData() {
		return data;
	}
	
	/**
	 * setData
	 * @param String data
	 **/
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * getSign
	 * @return String sign
	 **/
	public String getSign() {
		return sign;
	}
	
	/**
	 * setSign
	 * @param String sign
	 **/
	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * getFile
	 * @return String file
	 **/
	public String getFile() {
		return file;
	}

	/**
	 * setFile
	 * @param String file
	 **/
	public void setFile(String file) {
		this.file = file;
	}

	/**
	 * getId
	 * @return int id
	 **/
	public int getId() {
		return id;
	}
	
	/**
	 * getId_user
	 * @return int id_user
	 **/
	public int getId_user() {
		return id_user;
	}

	/**
	 * setId_user
	 * @param int id_user
	 **/
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	/**
	 * getUser
	 * @return String user
	 **/
	public String getUser() {
		return user;
	}
	
	/**
	 * setUser
	 * @param String user
	 **/
	public void setUser(String user) {
		this.user = user;
	}
	
	/**
	 * getPhone
	 * @return String phone
	 **/
	public String getPhone() {
		return phone;
	}
	
	/**
	 * setPhone
	 * @param String phone
	 **/
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * getFullname
	 * @return String fullname
	 **/
	public String getFullname() {
		return fullname;
	}

	/**
	 * setFullname
	 * @param String fullname
	 **/
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	/**
	 * getAddress
	 * @return String address
	 **/
	public String getAddress() {
		return address;
	}

	/**
	 * setAddress
	 * @param String address
	 **/
	public void setAddress(String address) {
		this.address = address;
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
	 * getNote
	 * @return String note
	 **/
	public String getNote() {
		return note;
	}

	/**
	 * setNote
	 * @param String note
	 **/
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * setId
	 * @param int id
	 **/
	public void setId(int id) {
		this.id = id;
	}
	
}
