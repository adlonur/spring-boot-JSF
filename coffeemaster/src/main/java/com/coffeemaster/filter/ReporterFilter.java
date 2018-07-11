package com.coffeemaster.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coffeemaster.bean.SessionBean;

/**
 * @author adil
 *
 */
public class ReporterFilter implements Filter{

	SessionBean sessionBean;
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httprequest = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		 
		 try {
			 sessionBean = (SessionBean) httprequest.getSession().getAttribute("scopedTarget.sessionBean");
				if (sessionBean ==null && sessionBean.getLoggedInReporter() == null || !sessionBean.isLogin()) {

					
					resp.sendRedirect(httprequest.getContextPath() + "/login.xhtml?err=notloggedin");
				}
		} catch (Exception e) {
			resp.sendRedirect(httprequest.getContextPath() + "/login.xhtml?err=notloggedin");
		}
		

		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
