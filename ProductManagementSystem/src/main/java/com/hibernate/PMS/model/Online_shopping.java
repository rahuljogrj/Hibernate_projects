package com.hibernate.PMS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Online_shopping")

public class Online_shopping {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "product_id")
	private int id;

	@Column(name = "product_name")
	private String p_name;

	@Column(name = "product_brand")
	private String p_brand;

	@Column(name = "product_cate")
	private String p_cate;

	@Column(name = "product_price")
	private int p_price;

	@Column(name = "product_qun")
	private int p_qun;

	
	
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_brand() {
		return p_brand;
	}

	public void setP_brand(String p_brand) {
		this.p_brand = p_brand;
	}

	public String getP_cate() {
		return p_cate;
	}

	public void setP_cate(String p_cate) {
		this.p_cate = p_cate;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public int getP_qun() {
		return p_qun;
	}

	public void setP_qun(int p_qun) {
		this.p_qun = p_qun;
	}

	public Online_shopping(String p_name, String p_brand, String p_cate, int p_price, int p_qun) {
		super();
		this.p_name = p_name;
		this.p_brand = p_brand;
		this.p_cate = p_cate;
		this.p_price = p_price;
		this.p_qun = p_qun;
	}

	public Online_shopping() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Online_shopping [id=" + id + ", p_name=" + p_name + ", p_brand=" + p_brand + ", p_cate=" + p_cate
				+ ", p_price=" + p_price + ", p_qun=" + p_qun + "]";
	}

	
	
}
