package com.qa.ae.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage 
{
	private WebDriver driver;
	
	private By name_tf= By.xpath("//input[@placeholder='Name']");
	private By email_tf= By.xpath("//input[@data-qa='signup-email']");
	private By signup_bt= By.xpath("//button[@data-qa='signup-button']");
	private By signup_text= By.xpath("//h2[text()='New User Signup!']");
	
	public SignupPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public String getSignupPageTitle()
	{
		String Title=driver.getTitle();
		System.out.println("page title is" +Title);
		return Title;
	} 
	
	public boolean isSignupTextdisplayed() throws InterruptedException
	{
		Thread.sleep(2000);
		return driver.findElement(signup_text).isDisplayed();
	}
	
	public void doSignup()
	{
		driver.findElement(name_tf).sendKeys("Onkar Bargaje");
		driver.findElement(email_tf).sendKeys("Automation@1234");
		driver.findElement(signup_bt).click();
	}

}
