package com.coffeemaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeemaster.model.Manager;

/**
 * @author adil
 *
 */
public interface ManagerRepository extends JpaRepository<Manager, Integer>{
	 public Manager findByEmailAndPassword(String email,String password);
	 
	 public Manager findById(int id);
	 
	 public Manager deleteById(int id);
}
