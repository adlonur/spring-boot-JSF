package com.coffeemaster.util;

/**
 * @author adil
 *
 */
public class PriceModel {

	private double totalPrice = 0;

	private double totalDiscount = 0;
	
	private double realPrice = 0;

	public PriceModel() {

	}
	
	public PriceModel(double totalPrice, double totalDiscount, double realPrice) {
		super();
		this.totalPrice = totalPrice;
		this.totalDiscount = totalDiscount;
		this.realPrice = realPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public double getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public double getRealPrice() {
		return realPrice;
	}
	
	public void setRealPrice(double realPrice) {
		this.realPrice = realPrice;
	}
}
