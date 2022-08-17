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
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="fullname")
	private String fullname;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="role")
	private String role;
	
	@Column(name="enabled")
	private int enabled;
	
	@Column(name="publickey")
	private String publickey;
	
	/**
	 * getPublickey
	 * @return String publickey
	 **/
	public String getPublickey() {
		return publickey;
	}

	/**
	 * setPublickey
	 * @param String publickey
	 * @return void
	 **/
	public void setPublickey(String publickey) {
		this.publickey = publickey;
	}

	/**
	 * setFullname
	 * @param String fullname
	 * @return void
	 **/
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	/**
	 * User
	 **/
	public User() {
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
	 * @return void
	 **/
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * getRole
	 * @return String role
	 **/
	public String getRole() {
		return role;
	}

	/**
	 * setRole
	 * @param String role
	 * @return void
	 **/
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * getEnabled
	 * @return int enabled
	 **/
	public int getEnabled() {
		return enabled;
	}

	/**
	 * setEnabled
	 * @param int enabled
	 * @return void
	 **/
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	/**
	 * getId
	 * @return int id
	 **/
	public int getId() {
		return id;
	}
	
	/**
	 * getUsername
	 * @return String username
	 **/
	public String getUsername() {
		return username;
	}

	/**
	 * setUsername
	 * @param String username
	 * @return void
	 **/
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * getPassword
	 * @return String password
	 **/
	public String getPassword() {
		return password;
	}

	/**
	 * setPassword
	 * @param String password
	 * @return void
	 **/
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * getFullname
	 * @return String fullname
	 **/
	public String getFullname() {
		return fullname;
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
	 * @return void
	 **/
	public void setAddress(String address) {
		this.address = address;
	}
}
