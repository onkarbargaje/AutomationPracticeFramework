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
	private By contactUs_lk=By.xpath("//a[text()=' Contact us']");
	private By home_lk=By.xpath("//a[text()=' Home']");
	
	//for signup
	private By name_tf= By.xpath("//input[@placeholder='Name']");
	private By signup_email_tf= By.xpath("//input[@data-qa='signup-email']");
	private By signup_bt= By.xpath("//button[@data-qa='signup-button']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		actutils=new ActionsUtilities (driver);
	}
	
//	public HomePage doLogin(String username, String password)
//	{
//		actutils.doSendKeys(email_tf,username);
//		actutils.doSendKeys(password_tf, password);
//		actutils.doClick(login_bt);
//		return new HomePage(driver);
//	}
	
	// added on feature branch
    public ContactUsPage navigateToContactUsForm()
    {
    	actutils.doClick(contactUs_lk);
    	return new ContactUsPage(driver);
    }
    
    public HomePage navigateToHomePage()
    {
    	actutils.doClick(home_lk);
    	return new HomePage(driver);
    }
    
    public HomePage doLogin(String username, String password)
	{
		actutils.doSendKeys(email_tf,username);
		actutils.doSendKeys(password_tf, password);
		actutils.doClick(login_bt);
		return navigateToHomePage();
	}
    
    public SignupPage doSignUp(String name, String email)
    {
    	driver.findElement(name_tf).sendKeys(name);
		driver.findElement(signup_email_tf).sendKeys(email);
		driver.findElement(signup_bt).click();
		return new SignupPage(driver);
    }
}
