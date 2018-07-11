package com.coffeemaster.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coffeemaster.bean.SessionBean;
import com.coffeemaster.model.Addition;
import com.coffeemaster.model.Product;

/**
 * @author adil
 *
 */
@Component
public class PriceCalculation {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private double totalPrice = 0;

	private double totalDiscount = 0;

	private List<Integer> productTotalPrice;
	
	@Autowired
	private SessionBean sessionBean;

	/**
	 * @param products
	 * @return
	 */
	public List<Integer> totalPrice(List<Product> products) {

		productTotalPrice = new ArrayList<>();

		if (products != null) {
			for (Product product : products) {
				int productPrice = Integer.parseInt(product.getProductPrice());
				totalPrice = totalPrice + productPrice;
				try {
					if (product.getAdditions()!=null && !product.getAdditions().isEmpty()) {
						for (Addition addition : product.getAdditions()) {
							productPrice = productPrice + Integer.valueOf(addition.getAdditionPrice());
							totalPrice = totalPrice + Integer.valueOf(addition.getAdditionPrice());
						}
						productTotalPrice.add(productPrice);

					}
				} catch (Exception e) {
					logger.info("Catch addition exception");
				}
				
				logger.info("Total price calculated");
			}
		}
		sessionBean.setTotalPrice(totalPrice);
		return productTotalPrice;
	}

	/**
	 * @return
	 */
	public double discountCalculation() {

		double discountFirst = 0;
		double discountSecond = 0;
		if (productTotalPrice.size() >= 3) {
			Collections.sort(productTotalPrice);
			discountFirst = productTotalPrice.get(0);
		}
		if (totalPrice > 12) {
			discountSecond = totalPrice * 25 / 100;
		}
		logger.info("Total discount calculated");

		if (discountFirst > discountSecond) {
			 totalDiscount = discountFirst;
		} else {
			totalDiscount = discountSecond;
		}
		sessionBean.setTotalDiscount(totalDiscount);
		return totalDiscount;
	}

	/**
	 * @return
	 */
	public double realPrice() {
		double realPrice = totalPrice -totalDiscount;
		sessionBean.setRealPrice(realPrice);		
		return realPrice;
	}
	
	
	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public List<Integer> getProductTotalPrice() {
		return productTotalPrice;
	}

	public void setProductTotalPrice(List<Integer> productTotalPrice) {
		this.productTotalPrice = productTotalPrice;
	}

}
