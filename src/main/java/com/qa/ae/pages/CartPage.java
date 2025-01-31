package com.qa.ae.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ae.utilities.ActionsUtilities;

public class CartPage 
{
	protected WebDriver driver;
	protected ActionsUtilities actutils;
	
	private By proceed_to_checkout_bt= By.linkText("Proceed To Checkout");
	
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
		actutils= new ActionsUtilities (driver);
	}
	
	
	public String getCartPageTitle()
	{
		return actutils.waitForTitleIs("Automation Exercise - Checkout", 2);
	}
	
	public CheckoutPage clickOnProceedToCheckOutBt()
	{
		actutils.doClick(proceed_to_checkout_bt, 2);
		return new CheckoutPage(driver);
	}
	

}
