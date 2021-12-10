package com.example.demo.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String productName, productBrand;
	
	public product() {
		super();
	}
	
	public product(String name, String brand) {
		super();
		this.productName = name;
		this.productBrand = brand;
	}
	
	public String getProductName() {
		return this.productName;
	}

	public String getBrandName() {
		return this.productBrand;
	}
	
	public void setProductName(String name) {
		this.productName = name;
	}

	public void setBrandName(String brand) {
		this.productBrand = brand;
	}
}
