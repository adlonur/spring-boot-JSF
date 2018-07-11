package com.coffeemaster.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coffeemaster.exception.DatabaseUpdateFailureException;
import com.coffeemaster.model.Product;
import com.coffeemaster.repository.ProductRepository;

/**
 * @author adil
 *
 */
@Service
@Transactional
public class ProductDao {

	@Autowired
	private ProductRepository productRepository;

	/**
	 * @return
	 */
	public List<Product> findAll() {

		List<Product> products;
		try {
			products = productRepository.findAllAndCloneIsNull();
		} catch (Exception e) {
			throw new DataAccessResourceFailureException(e.getMessage());
		}
		return products;

	}

	/**
	 * @param id
	 * @return
	 */
	public Product findById(int id) {
		Product product;
		try {
			product = productRepository.findById(id);
		} catch (Exception e) {
			throw new DataAccessResourceFailureException(e.getMessage());
		}
		return product;
	}

	/**
	 * @param product
	 * @return
	 */
	public List<Product> save(List<Product> product) {
		List<Product> products;
		try {
			products = productRepository.saveAll(product);
		} catch (Exception e) {
			throw new DatabaseUpdateFailureException(e.getMessage());
		}
		return products;
	}

}
