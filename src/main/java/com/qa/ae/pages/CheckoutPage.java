package com.qa.ae.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ae.utilities.ActionsUtilities;

public class CheckoutPage
{
	protected WebDriver driver;
	protected ActionsUtilities actutils;
	
	private By placeOrder_bt= By.linkText("Place Order");
	
	public CheckoutPage(WebDriver driver) 
	{
		this.driver=driver;
		actutils= new ActionsUtilities (driver);
	}
	
	public String getCheckoutPageUrl()
	{
		return actutils.getCurrentPageURL(driver);
	}
	
	public String getCheckoutPageTitle()
	{
		return actutils.getCurrentPageTitle(driver);
	}
	
	public PaymentPage clickOnPlaceOrderBt()
	{
		actutils.doClick(placeOrder_bt, 2);
		return new PaymentPage(driver);
	}

}
