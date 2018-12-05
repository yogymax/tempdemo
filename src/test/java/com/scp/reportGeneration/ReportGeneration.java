package com.scp.reportGeneration;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 *  A imp ItestListener
 *  p
 *  f
 *  s
 *  	onTestPass
 *    	  p++
 *    onTestFail
 *    	f++
 *    onTestSkip 
 * 	s++
 * 
 * 	onfinish
 * 			generate(pfv
 * 
 * 
 *
 */

public class ReportGeneration implements ITestListener{

		static int passCount = 0;
		static int failCount = 0;
		static int skipCount = 0;
	
	public void onTestStart(ITestResult result) {
		System.out.println("Execution started of --- "+result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(" Testcase  "+result.getMethod().getMethodName() +" Passed");
		passCount++;
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(" Testcase  "+result.getMethod().getMethodName() +" failed");
		failCount++;
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println(" Testcase  "+result.getMethod().getMethodName() +" Skippeded");
		skipCount++;
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		System.out.println("Suite Execution started");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("suite execution finished");
		System.out.println("No of tests \n Passed : " + passCount +" \n Failed : "+failCount +" \n Skiped : "+skipCount);
		
		try {
			GeneratePieChart.generatePieReport(passCount, failCount, skipCount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
