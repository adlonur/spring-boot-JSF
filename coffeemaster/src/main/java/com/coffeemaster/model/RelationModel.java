package com.coffeemaster.model;

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
@Table(name = "RelationModel")
public class RelationModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "PRODUCT_ID")
	private int productId;
	
	@Column(name = "ADDITION_ID")
	private int additionId;
	
	public RelationModel() {

	}

	public RelationModel(int id, int productId, int additionId) {
		this.id = id;
		this.productId = productId;
		this.additionId = additionId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getAddition() {
		return additionId;
	}

	public void setAddition(int additionId) {
		this.additionId = additionId;
	}


}
