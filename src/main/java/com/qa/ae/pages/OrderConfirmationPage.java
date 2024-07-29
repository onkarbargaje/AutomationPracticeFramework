package com.qa.ae.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ae.utilities.ActionsUtilities;

public class OrderConfirmationPage  {
	
	protected WebDriver driver;
	protected ActionsUtilities actutils;
	
	private By orderConfirmSuccess_Message=By.xpath("//p[text()='Congratulations! Your order has been confirmed!']");

	public OrderConfirmationPage(WebDriver driver)
	{
		this.driver=driver;
		actutils= new ActionsUtilities (driver);
	}
	
	public String getOrderConfirmationMessage()
	{
		return actutils.getText(orderConfirmSuccess_Message, 5);
		
	}
	

}
