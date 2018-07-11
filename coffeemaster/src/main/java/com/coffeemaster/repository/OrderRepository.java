package com.coffeemaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coffeemaster.model.Orders;

/**
 * @author adil
 *
 */
@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{

}
