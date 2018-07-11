package com.coffeemaster.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coffeemaster.exception.DatabaseUpdateFailureException;
import com.coffeemaster.model.User;
import com.coffeemaster.repository.UserRepository;

/**
 * @author adil
 *
 */
@Service
@Transactional
public class UserDao {

	@Autowired
	private UserRepository userRepository;

	/**
	 * @param email
	 * @param password
	 * @return
	 */
	public User findByEmailAndPassword(String email, String password) {
		User user;
		try {
			user = userRepository.findByEmailAndPassword(email, password);
		} catch (Exception e) {
			throw new DataAccessResourceFailureException(e.getMessage());
		}
		return user;
	}

	/**
	 * @param user
	 */
	public void save(User user) {
		try {
			userRepository.save(user);
		} catch (Exception e) {
			throw new DatabaseUpdateFailureException(e.getMessage());
		}
	}

}
