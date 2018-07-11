package com.coffeemaster.util;

import java.util.ArrayList;
import java.util.List;
import com.coffeemaster.model.Manager;



/**
 * @author adil
 *
 */
public class ServiceUtil {
	
	private ServiceUtil() {
	}
	
	/**
	 * @param isRepo
	 * @return
	 */
	public static List<Manager> getMockManagerList(boolean isRepo) {
		List<Manager> managerList = new ArrayList<>();
		managerList.add(getMockManager("adil", isRepo));
		managerList.add(getMockManager("onur", isRepo));
		return managerList;
	}
	
	/**
	 * @param name
	 * @param isRepo
	 * @return
	 */
	public static Manager getMockManager(String name, boolean isRepo) {

		Manager manager = new Manager();
		if (!isRepo) {
			manager.setId(100);
		} 
		manager.setName(name);
		return manager;
	}

}
