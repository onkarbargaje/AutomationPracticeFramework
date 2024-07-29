package com.qa.ae.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ae.utilities.ActionsUtilities;

public class LoginPage {
	
private WebDriver driver;
protected ActionsUtilities actutils;
	
	private By email_tf= By.xpath("//input[@data-qa='login-email']");
	private By password_tf= By.xpath("//input[@data-qa='login-password']");
	private By login_bt= By.xpath("//button[@data-qa='login-button']");
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		actutils=new ActionsUtilities (driver);
	}
	
	public HomePage doLogin(String username, String password)
	{
		actutils.doSendKeys(email_tf,username);
		actutils.doSendKeys(password_tf, password);
		actutils.doClick(login_bt);
		return new HomePage(driver);
	}

}
