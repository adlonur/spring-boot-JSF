package com.coffeemaster.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coffeemaster.exception.DatabaseUpdateFailureException;
import com.coffeemaster.model.Addition;
import com.coffeemaster.model.RelationModel;
import com.coffeemaster.repository.AdditionRepository;

/**
 * @author adil
 *
 */
@Service
@Transactional
public class AdditionDao {

	@Autowired
	private AdditionRepository additionRepository;

	/**
	 * @param relationModelList
	 * @return
	 */
	public List<Addition> findByAdditionList(List<RelationModel> relationModelList) {
		List<Addition> additonList = new ArrayList<>();
		for (RelationModel relationModel : relationModelList) {
			try {
				additonList.add(additionRepository.findById(relationModel.getAddition()));
			} catch (Exception e) {
				throw new DataAccessResourceFailureException(e.getMessage());
			}
			
		}
		return additonList;
	}
	
	/**
	 * @param addition
	 */
	public void save(List<Addition> addition) {
		try {
			additionRepository.saveAll(addition);
		} catch (Exception e) {
			throw new DatabaseUpdateFailureException(e.getMessage());
		}
		
	
	}

}
