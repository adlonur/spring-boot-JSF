package com.coffeemaster.bean;



import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.coffeemaster.model.Addition;
import com.coffeemaster.model.Manager;
import com.coffeemaster.model.Product;
import com.coffeemaster.model.Reporter;
import com.coffeemaster.model.User;


/**
 * @author adil
 *
 */
@Component
@Scope(value = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionBean {
	
	private User logginUser;
	private Reporter loggedInReporter;
	private Manager logginManager;
	private boolean login = false;
	private User loginUser;
	private List<Addition> additions;
	private List<Product> products;
	private double totalPrice ;
	private double totalDiscount;
	private double realPrice;
	
	public boolean isLogin() {
		return login;
	}
	public void setLogin(boolean login) {
		this.login = login;
	}
	public User getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}
	
	public List<Addition> getAdditions() {
		return additions;
	}
	
	public void setAdditions(List<Addition> additions) {
		this.additions = additions;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
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
	
	public double getRealPrice() {
		return realPrice;
	}
	
	public void setRealPrice(double realPrice) {
		this.realPrice = realPrice;
	}

	public User getLogginUser() {
		return logginUser;
	}
	
	public void setLogginUser(User logginUser) {
		this.logginUser = logginUser;
	}
	
	public Reporter getLoggedInReporter() {
		return loggedInReporter;
	}
	
	public void setLoggedInReporter(Reporter loggedInReporter) {
		this.loggedInReporter = loggedInReporter;
	}
	
	public void setLogginManager(Manager logginManager) {
		this.logginManager = logginManager;
	}
	
	public Manager getLogginManager() {
		return logginManager;
	}
	
}
