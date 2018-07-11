package com.coffeemaster.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.coffeemaster.exception.DatabaseUpdateFailureException;
import com.coffeemaster.model.Manager;
import com.coffeemaster.repository.ManagerRepository;

/**
 * @author adil
 *
 */
@Service
@Transactional
public class ManagerDao {

	@Autowired
	private ManagerRepository managerRepository;

	/**
	 * @param email
	 * @param password
	 * @return
	 */
	public Manager findByEmailAndPassword(String email, String password) {
		Manager manager;
		try {
			manager = managerRepository.findByEmailAndPassword(email, password);
		} catch (Exception e) {
			throw new DataAccessResourceFailureException(e.getMessage());
		}
		return manager;
	}

	/**
	 * @param entity
	 * @return
	 */
	public Manager save(Manager entity) {
		Manager manager = null;
		try {
			manager = managerRepository.save(entity);
		} catch (Exception e) {
			throw new DatabaseUpdateFailureException(e.getMessage());
		}
		return manager;
	}

	/**
	 * @param id
	 * @return
	 */
	public Manager findById(int id) {
		Manager manager = null;
		try {
			manager = managerRepository.findById(id);
		} catch (Exception e) {
			throw new DataAccessResourceFailureException(e.getMessage());
		}
		return manager;
	}

}
