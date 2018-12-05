package com.scp.reportGeneration;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

///https://www.softwaretestinghelp.com/test-automation-frameworks-selenium-tutorial-20/

@Listeners(ReportGeneration.class)
public class CTest1 {



	@Test(dependsOnMethods="n2")
	public void n1(){
		System.out.println("inside m1");
		
	}
	
	@Test
	public void n2(){
		System.out.println("inside m3");
		Assert.fail("failed");
	}
	
	@Test
	public void n3(){
		System.out.println("inside m3");
	}
	
	@Test
	public void n4(){
		System.out.println("inside m4");
	}

}
