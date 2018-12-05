package com.infy.orange.hrm;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.infy.app.constants.AppLevelConstants;
import com.infy.app.constants.AppLevelConstants.SetOfBrowsers;
import com.infy.app.util.AppUtil;
import com.infy.app.util.ExcelOperations;
import com.infy.app.util.InitializeBrowser;
import com.infy.page.objects.DashboardPO;
import com.infy.page.objects.LoginPO;

public class DyanamicTableTest {

	public static String ERROR_SCREEN_SHOT = "C:\\Users\\Yogesh\\Desktop\\J#7\\";
	
	
	@Test(enabled=false)
	public void fileUploadDownloadScenarios() throws AWTException, InterruptedException, FindFailed, IOException{

		WebDriver driver = InitializeBrowser.iniDriver(SetOfBrowsers.Chrome, "http://toolsqa.com/automation-practice-form/");
		driver.findElement(By.id("photo")).click();
		TimeUnit.SECONDS.sleep(5);
		Runtime.getRuntime().exec("C:\\Users\\Yogesh\\Desktop\\sikuliPattern\\fileuploadscript.exe");
		
		//https://sqa.stackexchange.com/questions/18340/how-to-verify-two-images-using-selenium-webdriver
		//https://stackoverflow.com/questions/8567905/how-to-compare-images-for-similarity-using-java
		
/*		
		
		Pattern pattern0 = new Pattern("C:\\Users\\Yogesh\\Desktop\\sikuliPattern\\desktop.PNG");
		Pattern pattern1 = new Pattern("C:\\Users\\Yogesh\\Desktop\\sikuliPattern\\newFolder.PNG");
		Pattern pattern2 = new Pattern("C:\\Users\\Yogesh\\Desktop\\sikuliPattern\\filename.PNG");
		Pattern pattern3 = new Pattern("C:\\Users\\Yogesh\\Desktop\\sikuliPattern\\open.PNG");
		
		Screen s = new Screen();
		s.click(pattern0); // will select desktop
		s.doubleClick(pattern1);// will open new folder
		TimeUnit.SECONDS.sleep(5);
		s.click(pattern2); // will select desired file
		TimeUnit.SECONDS.sleep(5);
		s.click(pattern3); // will click on open button
		TimeUnit.SECONDS.sleep(5);
*/		
		/**
		 
		using Robot classes
		AppUtil.copyPathIntoClipBoard("C:\\Users\\Yogesh\\Desktop\\14253.jpg");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		TimeUnit.MILLISECONDS.sleep(10);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	 
		 */
			
		
	}
	
	
	@Test(dataProviderClass=ExcelOperations.class,dataProvider="readFromExcel",enabled=false)
	public void dyanmicTableHandling(String username,String password, String expectedMsg) throws InterruptedException{
		
		try{
			System.out.println(username +" -- " + password +"  -- "+expectedMsg);
			WebDriver driver = InitializeBrowser.iniDriver(SetOfBrowsers.Chrome,AppLevelConstants.ORANGE_HRM_URL );
			LoginPO loginPage =PageFactory.initElements(driver,LoginPO.class);
			loginPage.enterCredentials(username,password);
			
			if(expectedMsg.equalsIgnoreCase("SUCCESS")){
					DashboardPO dashboard = loginPage.clickOnLoginDashBoard();
					Assert.assertNotNull(dashboard.getWelcomeMessage());
			}else{
				loginPage.clickOnLoginErrorMsg();
				String errorMsg = loginPage.getErrorMessage();
				Assert.assertEquals(errorMsg, expectedMsg);
			}
			
			
		}catch(AssertionError e){
			InitializeBrowser.takeSnapShot(ERROR_SCREEN_SHOT+"dyanmicTableHandling.png");
			e.printStackTrace();
			Assert.fail("failed..!");
		}finally{
			InitializeBrowser.driver.close();
		}
		
		
		
	}
	
	
	@Test(dataProvider="data",dataProviderClass=MyAppDataProviders.class,enabled=false)
	public void checkValidInvalidCredetials(String uname,String password, String emsg){
		WebDriver driver = InitializeBrowser.iniDriver(SetOfBrowsers.Chrome,AppLevelConstants.ORANGE_HRM_URL );
		LoginPO loginPage =PageFactory.initElements(driver,LoginPO.class);
		loginPage.enterCredentials(uname,password);
		if(emsg.equals("Success")){
			DashboardPO dashboard = loginPage.clickOnLoginDashBoard();
			Assert.assertNotNull(dashboard);
		}else{
			String errorMsg = loginPage.clickOnLoginErrorMsg();
			Assert.assertEquals(errorMsg, emsg);
		}
	}

	
	
}
