package com.coffeemaster.controller;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import com.coffeemaster.dao.OrderDao;
import com.coffeemaster.model.Orders;

/**
 * @author adil
 *
 */
@Named
@ManagedBean
@Scope(scopeName = "view")
public class FilterReportController {
	
	private List<Orders> orders;
    
    private List<Orders> filteredorders;
    
    @Autowired
    private OrderDao orderDao;

    @PostConstruct
    public void init() {
    	orders = orderDao.findAllOrders();
    }

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public List<Orders> getFilteredorders() {
		return filteredorders;
	}

	public void setFilteredorders(List<Orders> filteredorders) {
		this.filteredorders = filteredorders;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	} 
    
}
