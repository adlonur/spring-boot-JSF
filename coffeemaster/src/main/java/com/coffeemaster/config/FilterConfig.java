package com.coffeemaster.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.coffeemaster.filter.CustomerFilter;
import com.coffeemaster.filter.ManagerFilter;
import com.coffeemaster.filter.ReporterFilter;
/**
 * @author adil
 *
 */
/**
 * @author adil
 *
 */
@Configuration
public class FilterConfig {
	

  /**
 * @return
 */
@Bean
  public FilterRegistrationBean<CustomerFilter> customerFilter() {
    FilterRegistrationBean<CustomerFilter> registration =
        new FilterRegistrationBean<CustomerFilter>();
    registration.setFilter(new CustomerFilter());
    registration.addUrlPatterns("/product/*");
    return registration;
  }
  
  /**
 * @return
 */
@Bean
  public FilterRegistrationBean<ReporterFilter> reporterFilter() {
    FilterRegistrationBean<ReporterFilter> registration =
        new FilterRegistrationBean<ReporterFilter>();
    registration.setFilter(new ReporterFilter());
    registration.addUrlPatterns("/report/*");
    return registration;
  }
  
  /**
 * @return
 */
@Bean
  public FilterRegistrationBean<ManagerFilter> managerFilter() {
    FilterRegistrationBean<ManagerFilter> registration =
        new FilterRegistrationBean<ManagerFilter>();
    registration.setFilter(new ManagerFilter());
    registration.addUrlPatterns("/manager/*");
    return registration;
  }

}