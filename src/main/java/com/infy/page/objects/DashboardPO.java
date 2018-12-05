package com.infy.page.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.infy.app.util.InitializeBrowser;

public class DashboardPO {
	
	@FindBy(id="welcome")
	WebElement welcome;
	
	@FindBy(xpath="//*[@id=\"menu_pim_viewPimModule\"]/b")
	WebElement pim;
	
	@FindBy(id="menu_pim_viewEmployeeList")
	WebElement empList;
	
	@FindBy(id="search-results")
	WebElement employeeInfoTable;	
	
	
	
	public String getWelcomeMessage(){
		try{
			return welcome.getText();
		}catch(Exception e){
			return null;
		}
		
	}
	
	//adhi login-- wlcom page verify--pim mouse hover-- emplist option-- emplist.click-- result table-- search kr table tag--tr--td
	
	public void gotoEmployeeListInfo() throws InterruptedException{
		//Actions actions = new Actions(InitializeBrowser.driver);
		//actions.moveToElement(pim).moveToElement(empList).click().build();
		pim.click();
		Thread.sleep(3000);
	}

	public void selectEmpRecord(String name) throws InterruptedException{
		gotoEmployeeListInfo(); // navigate to employee info table
		
		WebElement empTableBody = employeeInfoTable.findElement(By.tagName("table")).findElement(By.tagName("tbody")); // get tablebody
		List<WebElement> listOfRows = empTableBody.findElements(By.tagName("tr")); // get all rows
		for(WebElement row :listOfRows){ // iterate row one by one
			List<WebElement> listOfColmn= row.findElements(By.tagName("td")); // get single row colmns
			System.out.println(listOfColmn.get(2).getText());// find 3rd cell from colmn -- firstname
			if(listOfColmn.get(2).getText().equals(name)){		 // check name steven if present --
				listOfColmn.get(0).findElement(By.tagName("input")).click(); // click on his checkbox
				//break; // break the loop
			}
			
		}
			
		
	}
	
}



/**


Run TestNG -- No Option -- run as TestNG Test
Changed Eclipse -- juno/mars -- Neon --Maven project structure
commnad line -- move to project location's pom.xml -- mvn clean install
--chrome/Firefox browser latest browser---


src/main/java

	InitializeBrowser.java
		Started from InitializeBrowser -- written iniDriver(SetOfBrowsers btype, String url)

	ApplevelConstants.java
		SetOfBrowsers btype -- defined this enum -- which is predefined constant inside ApplevelConstant
		String url -- defined this site url -- which is predefined constant inside ApplevelConstant
	
	LoginPO
		list of all elements and bind it thru locators - id name taganame
		write down all methods --
			such as enterCredetails(u,p)
				username.sendkeys(u)
				password.sendkeys(p)
				loginbtn.click()
	DashBoardPO
		list of all elements and bind it thru locators - id name taganame
		write down all methods --
				selectEmpRecord -- commented inside code
				navigateToEmpList -- 
	
src/test/java
	DyanamicTableTest -- 



*/