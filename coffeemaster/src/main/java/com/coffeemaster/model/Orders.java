package com.coffeemaster.model;

import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author adil
 *
 */
@Entity
@Table(name = "Orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "ORDERDATE")
	private Date orderDate;
	
	@Column(name = "PRODUCTPRICE")
	private double productPrice;
	
	@Column(name = "DISCOUNT")
	private double discount;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Product> products;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User users;
	
	
	public Orders() {

	}


	public Orders(int id, Date orderDate, double productPrice, double discount, List<Product> products, User users) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.productPrice = productPrice;
		this.discount = discount;
		this.products = products;
		this.users = users;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	public double getDiscount() {
		return discount;
	}


	public void setDiscount(double discount) {
		this.discount = discount;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public User getUsers() {
		return users;
	}


	public void setUsers(User users) {
		this.users = users;
	}
	
}
