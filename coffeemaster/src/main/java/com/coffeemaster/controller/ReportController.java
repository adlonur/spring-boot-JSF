package com.coffeemaster.controller;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import com.coffeemaster.dao.ReportDao;


/**
 * @author adil
 *
 */
@Named
@ManagedBean
@Scope("request")
public class ReportController {
	
	@Autowired
	private ReportDao reportDao;
	
	private StreamedContent chart;
	
	@PostConstruct
	public void init() {
		chart = reportDao.createChart();
	}

	public StreamedContent getChart() {
		return chart;
	}

	
}
