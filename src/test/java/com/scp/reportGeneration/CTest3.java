package com.scp.reportGeneration;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReportGeneration.class)
public class CTest3 {

	@Test
	public void m1(){
		System.out.println("inside m1");
	}
	
	@Test
	public void m2(){
		System.out.println("inside m3");
	}
	
	@Test
	public void m3(){
		System.out.println("inside m3");
	}
	
	@Test
	public void m4(){
		System.out.println("inside m4");
	}
}
