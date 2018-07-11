package com.coffeemaster.controller;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import com.coffeemaster.bean.SessionBean;
import com.coffeemaster.dao.ManagerDao;
import com.coffeemaster.dao.ReporterDao;
import com.coffeemaster.dao.UserDao;
import com.coffeemaster.model.Manager;
import com.coffeemaster.model.Reporter;
import com.coffeemaster.model.User;


/**
 * @author adil
 *
 */
@Named
@ManagedBean
@Scope("request")
public class LoginController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private static final String errorMessagge = "Wrong credentials";
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ReporterDao reporterDao;
	
	@Autowired
	private ManagerDao managerDao;
	
	@Autowired
	private SessionBean sessionBean;
	
	private String email;
	private String password;

	@PostConstruct
	private void init() {

		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String error = request.getParameter("err");

		if (error != null && error.equals("notloggedin")) {
			String errMsg = "You need to login to see secure pages";
			logger.info("Catch Error");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(errMsg, errMsg));
		}
	}
	
	
	/**
	 * @return
	 */
	public String login() {

		User user = userDao.findByEmailAndPassword(email,password);
		Reporter reporter = reporterDao.findByEmailAndPassword(email, password);
		Manager manager = managerDao.findByEmailAndPassword(email, password);
		if (user != null) {
			sessionBean.setLogin(true);
			sessionBean.setLoginUser(user);
			logger.info("Login User");
			return "/product/order?faces-redirect=true";
		} else if (reporter != null) {
			sessionBean.setLogin(true);
			sessionBean.setLoggedInReporter(reporter);
			return "/report/report?faces-redirect=true";
		}else if(manager != null){
			sessionBean.setLogin(true);
			sessionBean.setLogginManager(manager);
			return "/manager/manager?faces-redirect=true";
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(errorMessagge,errorMessagge));
			logger.info("Face Error Message");
		}
		
		return "login";
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	

	
}
