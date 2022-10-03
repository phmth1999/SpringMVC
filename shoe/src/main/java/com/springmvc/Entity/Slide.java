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
@Table(name = "slide")
public class Slide {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="img")
	private String img;
	
	@Column(name="caption")
	private String caption;
	
	@Column(name="content")
	private String content;

	/**
	 * Slide
	 **/
	public Slide() {
	}

	/**
	 * getId
	 * @return int id
	 **/
	public int getId() {
		return id;
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
	 * getCaption
	 * @return String caption
	 **/
	public String getCaption() {
		return caption;
	}

	/**
	 * setCaption
	 * @param String caption
	 **/
	public void setCaption(String caption) {
		this.caption = caption;
	}

	/**
	 * getContent
	 * @return String content
	 **/
	public String getContent() {
		return content;
	}

	/**
	 * setContent
	 * @param String content
	 **/
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * setId
	 * @param int id
	 **/
	public void setId(int id) {
		this.id = id;
	}
	
}
