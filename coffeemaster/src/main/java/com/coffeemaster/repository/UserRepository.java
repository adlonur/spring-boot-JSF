package com.coffeemaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coffeemaster.model.User;

/**
 * @author adil
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	 public User findByEmail(String email);
	
	 public User findByEmailAndPassword(String email,String password);
}
