package com.springmvc.Security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
/**
 * @author PhamMinhThien
 * @since 2022
 **/
@SuppressWarnings("serial")
public class MyUser extends User {
	private int id;
	private String fullName;
	private String email;
	
	/**
	 * MyUser
	 * @param String username
	 * @param String password
	 * @param Collection<? extends GrantedAuthority> authorities
	 * @return void
	 **/
	public MyUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	/**
	 * getEmail
	 * @return String email
	 **/
	public String getEmail() {
		return email;
	}

	/**
	 * setEmail
	 * @param String email
	 * @return void
	 **/
	public void setEmail(String email) {
		this.email = email;
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
	 * @return void
	 **/
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * getFullName
	 * @return String fullName
	 **/
	public String getFullName() {
		return fullName;
	}

	/**
	 * setFullName
	 * @param String fullName
	 * @return void
	 **/
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
