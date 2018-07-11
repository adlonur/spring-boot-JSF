package com.coffeemaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coffeemaster.model.Addition;


/**
 * @author adil
 *
 */
@Repository
public interface AdditionRepository extends JpaRepository<Addition, Integer>{

	public Addition findById(int id);
}
