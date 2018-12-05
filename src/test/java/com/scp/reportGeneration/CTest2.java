package com.scp.reportGeneration;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReportGeneration.class)
public class CTest2 {


	@Test
	public void p1(){
		System.out.println("inside m1");
	}
	
	@Test
	public void p2(){
		System.out.println("inside m3");
	}
	
	@Test
	public void p3(){
		System.out.println("inside m3");
	}
	
	@Test
	public void p4(){
		System.out.println("inside m4");
		Assert.fail("failed");
	}
	
	@Test
	public void p5(){
		System.out.println("inside m4");
	}
	
	@Test
	public void p6(){
		System.out.println("inside m4");
	}

}
