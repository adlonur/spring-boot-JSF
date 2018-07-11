package com.coffeemaster.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coffeemaster.model.Addition;
import com.coffeemaster.model.RelationModel;
import com.coffeemaster.repository.RelationModelRepository;

/**
 * @author adil
 *
 */
@Service
@Transactional
public class RelationModelDao {

	@Autowired
	private RelationModelRepository relationModelRepository;

	@Autowired
	private AdditionDao additionDao;

	/**
	 * @param productId
	 * @return
	 */
	public List<Addition> findByProudctIdProductAddition(int productId) {
		List<Addition> additions;
		try {
			List<RelationModel> relationModelList = relationModelRepository.findByProductId(productId);
			additions = additionDao.findByAdditionList(relationModelList);
		} catch (Exception e) {
			throw new DataAccessResourceFailureException(e.getMessage());
		}
		return additions;

	}

}
