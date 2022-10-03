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
@Table(name = "brand")
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	/**
	 * Brand
	 **/
	public Brand() {
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
	 * setId
	 * @param int id
	 **/
	public void setId(int id) {
		this.id = id;
	}
	
}
