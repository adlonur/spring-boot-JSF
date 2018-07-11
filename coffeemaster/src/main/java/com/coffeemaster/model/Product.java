package com.coffeemaster.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author adil
 *
 */
@Entity
@Table(name = "Product")
public class Product {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "PRODUCTNAME")
	private String productName;
	
	@Column(name = "PRODUCTPRICE")
	private String productPrice;
	
	@Column(name = "CLONE")
	private String clone;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Addition> additions;

	public Product() {

	}

	public Product(int id, String productName, String productPrice, String clone, List<Addition> additions) {
		super();
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.clone = clone;
		this.additions = additions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getClone() {
		return clone;
	}

	public void setClone(String clone) {
		this.clone = clone;
	}

	public List<Addition> getAdditions() {
		return additions;
	}

	public void setAdditions(List<Addition> additions) {
		this.additions = additions;
	}
	
}
