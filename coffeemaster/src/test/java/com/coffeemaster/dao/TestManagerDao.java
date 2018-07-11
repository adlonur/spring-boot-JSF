package com.coffeemaster.dao;

import static org.junit.Assert.assertNotNull;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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
public class TestManagerDao {
	
	private static ManagerDao managerDao;
	
	private static Manager existingManager;

	@BeforeClass
	public static void setUpMockedMethods() {
	
		managerDao = Mockito.spy(ManagerDao.class);
		Mockito.doAnswer(AdditionalAnswers.<Manager>returnsFirstArg()).when(managerDao).save(Mockito.any(Manager.class));	
		existingManager = ServiceUtil.getMockManager("exists",true);
		Mockito.doReturn(existingManager).when(managerDao).findById(Mockito.any(Integer.class));
	}
	
	@Test
	public void saveTestForsuccess() {
		Manager newManager = new Manager();
		Manager createdManager = managerDao.save(newManager);
		assertNotNull(createdManager.getId());
	}
		
	
}
