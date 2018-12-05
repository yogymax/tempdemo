package com.infy.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {
	
	public static Connection connection = null;
	public static List<Emp> getListOfEmps(){
		if(connection ==null)
			try{  
				Class.forName("com.mysql.jdbc.Driver");  
														
				/**
				 * Mysql - 3306
				 * Oracle - 1503
				 * URL
						 * 1#Protocal -- set of rules for communication
						 * 2# db name
						 * 3#machinename/hostname/ipadress
						 * 4#.PortNo
						 * 5#schemaname
				 * UserName
				 * Password
				 * 	
				 */
				System.out.println("creating connection");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",  "admin",  "admin123");
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("select * from employee");  
				
				System.out.println("fetching data");
				List<Emp> listOfEmps = new ArrayList<Emp>();
				Emp e = null;
				while(rs.next()){
					e=new Emp(rs.getInt("id"), rs.getString("dept"), rs.getString("name"), rs.getDouble("salary"));
					listOfEmps.add(e);
					System.out.println(e);
				}
					
				con.close();
				System.out.println("connection closed");
				return listOfEmps;
				}catch(Exception e){ System.out.println(e);}  
		
		return null;
	}

}


class Emp{
	private int empId;
	private String deptName;
	private String empName;
	private double empSal;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}
	
	@Override
	public String toString() {
		return "\n Emp [empId=" + empId + ", deptName=" + deptName + ", empName="
				+ empName + ", empSal=" + empSal + "]";
	}
	public Emp(int empId, String deptName, String empName, double empSal) {
		super();
		this.empId = empId;
		this.deptName = deptName;
		this.empName = empName;
		this.empSal = empSal;
	}
	
	
	
	
	
}