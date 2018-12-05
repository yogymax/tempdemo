package com.infy.app.util;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class BrowserLevelUtil {

	public static boolean checkElementPresence(WebElement element) {
		try{
			return element.isDisplayed();
		}catch(NoSuchElementException e){
			return false;
		}
	}

	
	
	
}
