package com.coffeemaster.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.coffeemaster.bean.SessionBean;
import com.coffeemaster.exception.DatabaseUpdateFailureException;
import com.coffeemaster.model.Addition;
import com.coffeemaster.model.Orders;
import com.coffeemaster.model.Product;
import com.coffeemaster.repository.OrderRepository;

/**
 * @author adil
 *
 */
@Service
@Transactional
public class OrderDao {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private RelationModelDao relationModelDao;

	@Autowired
	private SessionBean sessionBean;

	@Autowired
	AdditionDao additionDao;

	private Orders order;

	/**
	 * 
	 */
	public void save() {

		try {
			createOrder();
			orderRepository.save(order);
		} catch (Exception e) {
			throw new DatabaseUpdateFailureException(e.getMessage());
		}

	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	/**
	 * @return
	 */
	public List<Orders> findAllOrders() {
		List<Orders> orders;
		try {
			orders = orderRepository.findAll();
		} catch (Exception e) {
			throw new DataAccessResourceFailureException(e.getMessage());
		}
		return orders;
	}

	/**
	 * @return
	 */
	public List<Product> findAllProduct() {
		try {
			return productDao.findAll();
		} catch (Exception e) {
			throw new DataAccessResourceFailureException(e.getMessage());
		}

	}

	/**
	 * @param productId
	 * @return
	 */
	public Product findProductById(int productId) {
		Product product;
		try {
			product = productDao.findById(productId);
		} catch (Exception e) {
			throw new DataAccessResourceFailureException(e.getMessage());
		}
		return product;
	}

	/**
	 * @param productId
	 * @return
	 */
	public List<Addition> findByProudctIdProductAddition(int productId) {
		List<Addition> realationModel;
		try {
			realationModel = relationModelDao.findByProudctIdProductAddition(productId);
		} catch (Exception e) {
			throw new DataAccessResourceFailureException(e.getMessage());
		}
		return realationModel;
	}

	/**
	 * 
	 */
	private void createOrder() {
		order = new Orders();
		order.setProductPrice(sessionBean.getRealPrice());
		order.setDiscount(sessionBean.getTotalDiscount());
		order.setUsers(sessionBean.getLoginUser());
		order.setProducts(productDao.save(sessionBean.getProducts()));
	}

}
