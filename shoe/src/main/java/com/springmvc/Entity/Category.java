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
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	/**
	 * Category
	 **/
	public Category() {
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
	 * @return void
	 **/
	public void setName(String name) {
		this.name = name;
	}
}
