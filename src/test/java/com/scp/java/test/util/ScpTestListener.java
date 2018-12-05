package com.scp.java.test.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScpTestListener implements ITestListener {

	static double passCount = 0;
	static double failCount = 0;
	static double skipCount = 0;
	
	public void onTestStart(ITestResult result) {
		System.out.println("Executing " +result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(" This  \"" +result.getMethod().getMethodName() +"\" test case passed");
		passCount++;
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(" This  \"" +result.getMethod().getMethodName() +"\" test case failed");
		failCount++;
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println(" This  \"" +result.getMethod().getMethodName() +"\" test case Skiped");
		skipCount++;
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		System.out.println("Test Suite execution Started");
	}

	public void onFinish(ITestContext context) {
		System.out.println("Test Suite execution Finished");
		System.out.println("No of TestPassed -- " + passCount);
		System.out.println("No of TestFailed -- " + failCount);
		System.out.println("No of TestSkipped -- " + skipCount);
		try {
			ReportGenerationUtil.generateReport(passCount,failCount,skipCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
