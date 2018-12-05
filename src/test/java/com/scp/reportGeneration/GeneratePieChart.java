package com.scp.reportGeneration;

import java.io.File;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class GeneratePieChart {

	//add maven dependency for jfreechart
	public static void generatePieReport(double passCount, double failCount, double skipCount) throws Exception {
	    
		DefaultPieDataset dataset = new DefaultPieDataset( );
	      dataset.setValue("Pass", new Double(passCount) );
	      dataset.setValue("Fail", new Double(failCount) );
	      dataset.setValue("Skip", new Double(skipCount) );

	      JFreeChart chart = ChartFactory.createPieChart(
	         "TestReport",   // chart title
	         dataset,          // data
	         true,             // include legend
	         true,
	         false);
	         
	      int width = 640;   /* Width of the image */
	      int height = 480;  /* Height of the image */ 
	      File pieChart = new File( "mytestreport.jpeg" ); 
	      ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
	   }
	
	
}
