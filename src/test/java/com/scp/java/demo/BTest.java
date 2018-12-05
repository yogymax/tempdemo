/*package com.scp.java.demo;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scp.java.test.util.ScpTestListener;

@Listeners(value=ScpTestListener.class)
public class BTest {

		@Test
		public void p1(){
			System.out.println("p1");
		}
		

		@Test(dependsOnMethods="p3")
		public void p2(){
			System.out.println("p2");
		}
		
		@Test
		public void p3(){
			System.out.println("p3");
			Assert.fail("mark this as a fail test case");
		}
		
		@Test
		public void p4(){
			System.out.println("p4");
			Assert.fail("mark this as a fail test case");
		}
		
		@Test
		public void p6(){
			System.out.println("p6");
		}
		
		@Test
		public void p7(){
			System.out.println("p7");
		}

		@Test
		public void p5(){
			System.out.println("p5");
		}
		
		

	
	
}
*/