package com.coffeemaster.dao;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coffeemaster.exception.BadRequestException;
import com.coffeemaster.model.Orders;
import com.coffeemaster.model.Product;

/**
 * @author adil
 *
 */
@Service
@Transactional
public class ReportDao {
	 
	@Autowired
	private OrderDao orderDao;

	@Autowired
	private ProductDao productDao;
	
	/**
	 * @return
	 */
	public StreamedContent createChart() {
		StreamedContent chart;
		try {
		JFreeChart jfreechart = ChartFactory.createPieChart("PERCENTAGES",createDataset(orderDao.findAllOrders(), productDao.findAll()) , true, true, false);
		File chartFile = new File("dynamichart");
		ChartUtilities.saveChartAsPNG(chartFile, jfreechart, 500, 500);
		chart = new DefaultStreamedContent(new FileInputStream(chartFile), "image/png");
		} catch (Exception e) {
			throw new BadRequestException(e.getMessage());
		}
		return chart;
	}

	/**
	 * @param orders
	 * @param products
	 * @return
	 */
	private PieDataset createDataset(List<Orders> orders, List<Product> products) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		double count = 0;
		double totalProductSize = 0;
		for (int i = 0; i < products.size(); i++) {
			String productName = products.get(i).getProductName();
			for (Orders order : orders) {

				for (Product orderProduct : order.getProducts()) {
					totalProductSize++;
					if (orderProduct.getProductName().equals(productName))
						count++;
				}

			}
			double oran = (count / totalProductSize) * 100;
			dataset.setValue(productName + " %" + oran, oran);
			totalProductSize = 0;
			count = 0;
		}

		return dataset;
	}


}
