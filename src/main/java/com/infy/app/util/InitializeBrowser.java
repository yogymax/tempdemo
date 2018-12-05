package com.infy.app.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.infy.app.constants.AppLevelConstants.SetOfBrowsers;

public class InitializeBrowser {

	public static WebDriver driver= null;
	
	/**
	 * @param browserType
	 * @param url
	 * @return
	 */
	public static WebDriver iniDriver(SetOfBrowsers browserType, String orangeHrmUrl){
		switch (browserType) {
		case Firefox:
			System.setProperty("webdriver.gecko.driver", "E:\\MySofts\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case Chrome:
			System.setProperty("webdriver.chrome.driver", "E:\\MySofts\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
			break;
		default:
			Assert.fail(browserType.toString() +" Specified browser not supported yet...!");
			break;
		}
		driver.get(orangeHrmUrl);
		return driver;
	}
	

		public static void takeSnapShot(String fileWithPath){
			System.out.println("taking screenshot" + fileWithPath);
		//Convert web driver object to TakeScreenshot
			TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
			File DestFile=new File(fileWithPath);
		//Copy file at destination
			try {
				FileUtils.copyFile(SrcFile, DestFile);
			} catch (IOException e) {
				e.printStackTrace();
			}

	}

}
