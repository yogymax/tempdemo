package com.infy.page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.infy.app.util.BrowserLevelUtil;
import com.infy.app.util.InitializeBrowser;

public class LoginPO {
	
	@FindBy(id="txtUsername")
	WebElement userNameInput;

	@FindBy(id="txtPassword")
	WebElement passwordInput;
	
	@FindBy(id="btnLogin")
	WebElement loginBtn;
	
	@FindBy(id="spanMessage")
	WebElement errorMessage;
	
	public void enterCredentials(String username, String password){
		this.userNameInput.clear();
		this.userNameInput.sendKeys(username);
		
		this.passwordInput.clear();
		this.passwordInput.sendKeys(password);
		
	}
	
	public String clickOnLoginErrorMsg(){
		loginBtn.click();
		return getErrorMessage();
	}

	
	public DashboardPO clickOnLoginDashBoard(){
		loginBtn.click();
		return PageFactory.initElements(InitializeBrowser.driver, DashboardPO.class);
	}
	
	public String getErrorMessage(){
		if(BrowserLevelUtil.checkElementPresence(errorMessage)){
			return errorMessage.getText();
		}
		return null;
	}
	
	
}
