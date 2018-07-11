package com.coffeemaster.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author adil
 *
 */
@Entity
@Table(name = "Addition")
public class Addition {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "ADDITIONNAME")
	private String additionName;

	@Column(name = "ADDITIONPRICE")
	private String additionPrice;
	
	
	public Addition() {

	}


	public Addition(int id, String additionName, String additionPrice, List<Product> products) {
		super();
		this.id = id;
		this.additionName = additionName;
		this.additionPrice = additionPrice;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdditionName() {
		return additionName;
	}

	public void setAdditionName(String additionName) {
		this.additionName = additionName;
	}

	public String getAdditionPrice() {
		return additionPrice;
	}

	public void setAdditionPrice(String additionPrice) {
		this.additionPrice = additionPrice;
	}

}
