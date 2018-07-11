package com.coffeemaster.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.coffeemaster.model.Reporter;


/**
 * @author adil
 *
 */
@Repository
public interface ReporterRepository extends JpaRepository<Reporter, Integer>{
	 public Reporter findByEmailAndPassword(String email,String password);
}
