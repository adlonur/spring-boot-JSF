package com.coffeemaster.controller;


import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.coffeemaster.bean.SessionBean;
import com.coffeemaster.dao.OrderDao;
import com.coffeemaster.model.Addition;

import com.coffeemaster.model.Product;

/**
 * @author adil
 *
 */
/**
 * @author adil
 *
 */
/**
 * @author adil
 *
 */
@Named
@ManagedBean
public class OrderController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private OrderDao orderDao;

	private int selectedOptions = 0;
	private List<Product> products;
	private List<Addition> additions = null;
	private List<Product> selectedProducts = new ArrayList<Product>();
	private Product selectedProduct;
	private List<Addition> selectedAddition;
	private boolean disable = true;
	Product cloneProduct;
	List<Addition> selectedAdditons;
	
	@Autowired
	private SessionBean sessionBean;

	@PostConstruct
	public void init() {
		products = orderDao.findAllProduct();
		logger.info("All Product");
	}

	/**
	 * @param event
	 */
	public void valueChanged(ValueChangeEvent event) {
		
		int productId = 0;
		if (event.getNewValue() != null) {
			productId = (Integer) event.getNewValue();
			selectedProduct = orderDao.findProductById(productId);
			selectedProduct.setAdditions(null);
			additions = orderDao.findByProudctIdProductAddition(productId);
		}
		logger.info("Product value Changed");
	}

	/**
	 * @param event
	 */
	@SuppressWarnings("unchecked")
	public void valueChanged2(ValueChangeEvent event) {
		selectedProduct.setAdditions(null);
		Object newObject = event.getNewValue();
		if (newObject instanceof List) {
			if (!((List<?>) newObject).isEmpty() && ((List<?>) newObject).get(0) instanceof Addition) {
				 selectedAdditons = (List<Addition>) newObject;
				 cloneSelectedProductObject();
			}
				
		}
		disable = false;
		logger.info("Addition value changed");
	}

	/**
	 * 
	 */
	public void addProduct() {	
		selectedProducts.add(selectedProduct);
		logger.info("Product Added");
	}

	/**
	 * @return
	 */
	public String approveProduct() {
		sessionBean.setProducts(selectedProducts);
		sessionBean.setAdditions(selectedAddition);
		logger.info("Product Approve");
		return "/product/orderDetail?faces-redirect=true";
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Addition> getAdditions() {
		return additions;
	}

	public void setAdditions(List<Addition> additions) {
		this.additions = additions;
	}

	public int getSelectedOptions() {
		return selectedOptions;
	}

	public void setSelectedOptions(int selectedOptions) {
		this.selectedOptions = selectedOptions;
	}

	public List<Addition> getSelectedAddition() {
		return selectedAddition;
	}

	public void setSelectedAddition(List<Addition> selectedAddition) {
		this.selectedAddition = selectedAddition;
	}

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	/**
	 * @return
	 */
	public Product cloneSelectedProductObject() {
		cloneProduct = new Product();
		cloneProduct.setClone("clone");
		cloneProduct.setProductName(selectedProduct.getProductName());
		cloneProduct.setProductPrice(selectedProduct.getProductPrice());
		cloneProduct.setAdditions(selectedAdditons);
		selectedProduct = cloneProduct;
		return cloneProduct;
	}
	
}
