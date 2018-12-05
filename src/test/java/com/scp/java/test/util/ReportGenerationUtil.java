package com.scp.java.test.util;

import java.io.*;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class ReportGenerationUtil {

	   public static void generateReport(double pass,double fail,double skip) throws Exception {
		      DefaultPieDataset dataset = new DefaultPieDataset( );
		      dataset.setValue("Pass", new Double(pass) );
		      dataset.setValue("Fail", new Double(fail) );
		      dataset.setValue("Skip", new Double(skip) );

		      JFreeChart chart = ChartFactory.createPieChart(
		         "SCPTestReport",   // chart title
		         dataset,          // data
		         true,             // include legend
		         true,
		         false);
		         
		      int width = 640;   /* Width of the image */
		      int height = 480;  /* Height of the image */ 
		      File pieChart = new File( "TestReport.jpeg" ); 
		      ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
		   }
	
	
	
	
	
	
	
}
