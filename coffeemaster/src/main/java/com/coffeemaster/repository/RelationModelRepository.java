package com.coffeemaster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coffeemaster.model.RelationModel;

/**
 * @author adil
 *
 */
@Repository
public interface RelationModelRepository extends JpaRepository<RelationModel, Integer>{
	
	public List<RelationModel> findByProductId(int productId);
     
}
