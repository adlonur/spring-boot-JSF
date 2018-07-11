package com.coffeemaster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coffeemaster.model.Product;

/**
 * @author adil
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	public Product findById(int id);
	
	@Query("SELECT u FROM Product u where u.clone Is Null")
	public List<Product> findAllAndCloneIsNull();
	
}
