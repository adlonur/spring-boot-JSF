package com.coffeemaster.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import com.coffeemaster.model.Manager;
import com.coffeemaster.util.ServiceUtil;

/**
 * @author adil
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestManagerRepository {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ManagerRepository managerRepository;
	
	private static Manager adilManager;

	private static Manager onurManager;


	private static boolean isSetUp;

	/**
	 * 
	 */
	@Before
	public void setUpExampleData() {

		if (isSetUp) {
			return;
		}

		List<Manager> managerList = ServiceUtil.getMockManagerList(true);

		for (Manager manager : managerList) {
			entityManager.persistAndFlush(manager);
		}

		adilManager = ServiceUtil.getMockManager("adil",true);
		entityManager.persist(adilManager);

		onurManager = ServiceUtil.getMockManager("onur",true);
		onurManager.setPassword("12345");
		onurManager.setEmail("onur@gmail.com");
		entityManager.persist(onurManager);

	}
	
	
	/**
	 * 
	 */
	@Test
	public void findAlltest() {
		List<Manager> resultList = managerRepository.findAll();
		assertNotNull(resultList);
		assertTrue(containsName(resultList, "adil"));
		assertTrue(containsName(resultList, "onur"));
	}
	
	/**
	 * 
	 */
	@Test
	public void findOne() {
		Manager result = managerRepository.findById(adilManager.getId());
		assertNotNull(result);
		assertEquals("adil", result.getName());
	}
	
	/**
	 * 
	 */
	@Test
	public void findByEmailAndPassword() {
		Manager result = managerRepository.findByEmailAndPassword(onurManager.getEmail(),onurManager.getPassword());
		assertNotNull(result);
		assertEquals("onur", result.getName());
	}
	
	
	/**
	 * @param list
	 * @param name
	 * @return
	 */
	public boolean containsName(final List<Manager> list, final String name) {
		return list.stream().filter(o -> o.getName().equals(name)).findFirst().isPresent();
	}
	
	

}
