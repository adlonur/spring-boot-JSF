package com.coffeemaster.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.coffeemaster.model.Reporter;
import com.coffeemaster.repository.ReporterRepository;

/**
 * @author adil
 *
 */
@Service
@Transactional
public class ReporterDao {

	@Autowired
	private ReporterRepository reporterRepository ;
	
	/**
	 * @param email
	 * @param password
	 * @return
	 */
	public Reporter findByEmailAndPassword(String email, String password) {
		Reporter reporter;
		try {
			reporter = reporterRepository.findByEmailAndPassword(email, password);
		} catch (Exception e) {
			throw new DataAccessResourceFailureException(e.getMessage());
		}
		return reporter;
	}
}
