package com.coffeemaster.controller;


import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import javax.servlet.http.HttpServletRequest;
import com.coffeemaster.bean.SessionBean;
import com.coffeemaster.dao.OrderDao;
import com.coffeemaster.model.Product;
import com.coffeemaster.util.PriceCalculation;
import com.coffeemaster.util.PriceModel;

/**
 * @author adil
 *
 */
@Named
@ManagedBean
@Scope(scopeName = "view")
public class OrderDetailController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private List<Product> products = null;

	private Product selectedProduct;

	private PriceModel priceModel;
	
	@Autowired
	private SessionBean sessionBean;
	
	@Autowired
	private PriceCalculation priceCalculation;
	
	@Autowired
	private OrderDao orderDao;

	@PostConstruct
	public void init() {
		products = sessionBean.getProducts();
		if (products != null) {
			logger.info("Products not null");
			priceCalculation();
		}
			
	}

	/**
	 * 
	 */
	private void priceCalculation() {
		priceCalculation.totalPrice(products);
		priceCalculation.discountCalculation();
		priceCalculation.realPrice();
		getSessionVaribale();
		
	}
	
	
	/**
	 * 
	 */
	private void getSessionVaribale() {
		priceModel  = new PriceModel();
		priceModel.setTotalDiscount(sessionBean.getTotalDiscount());
		priceModel.setTotalPrice(sessionBean.getTotalPrice());
		priceModel.setRealPrice(sessionBean.getRealPrice());
	}

	public String pay() {
		orderDao.save();
		return killSession();
	}

	/**
	 * @return
	 */
	private String killSession() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		request.getSession().invalidate();
		return "/login?faces-redirect=true";
		
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}


	public PriceModel getPriceModel() {
		return priceModel;
	}
	
	public void setPriceModel(PriceModel priceModel) {
		this.priceModel = priceModel;
	}

}
