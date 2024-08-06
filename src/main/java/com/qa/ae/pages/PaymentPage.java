package com.qa.ae.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ae.utilities.ActionsUtilities;
import com.qa.ae.utilities.CommonActions;

public class PaymentPage {
	protected WebDriver driver;
	protected ActionsUtilities actutils;
	protected CommonActions commonactions;
	
	//private By cardHolderName_tf=By.name("name_on_card");
	private By cardHolderName_tf=By.xpath("//input[@name='name_on_card']");
	private By cardNumber_tf=By.xpath("//input[@name='card_number']");
	private By cvcNumber_tf=By.xpath("//input[@name='cvc']");
	private By cardExpiryMonth_tf=By.xpath("//input[@name='expiry_month']");
	private By cardExpiryYear_tf=By.xpath("//input[@name='expiry_year']");
	private By payAndConfirmOrder_bt=By.id("submit");
	
	private By payAndConfirmOrderAllFields_Details=By.cssSelector("input[name='name_on_card'],"
			+ "input[name='card_number'],input[name='cvc'],input[name='expiry_month'],"
			+ "input[name='expiry_year']");
	

	public PaymentPage(WebDriver driver) {
		
		this.driver=driver;
		actutils= new ActionsUtilities (driver);
		commonactions=new CommonActions(driver);
	}
	
	public String getCheckoutPageUrl()
	{
		return actutils.getCurrentPageURL(driver);
	}
	
	public String getCheckoutPageTitle()
	{
		return actutils.getCurrentPageTitle(driver);
	}
	
	public void enterCardDetails()
	{
		
		actutils.waitForVisibilityOfElement(cardHolderName_tf, 5).sendKeys("onkar barga");
		actutils.doSendKeys(cardNumber_tf,"1234 1234 1234 1234");
		actutils.doSendKeys(cvcNumber_tf, "234");
		actutils.doSendKeys(cardExpiryMonth_tf, "08");
		actutils.doSendKeys(cardExpiryYear_tf, "2026");
		
	}
	
	public OrderConfirmationPage clickOnPlaceAndConfirmOrder()
	{
		enterCardDetails();
		actutils.doClick(payAndConfirmOrder_bt);
		return new OrderConfirmationPage(driver);
	}
	
	public List<String> textEnteredInAllFiledsOfPaymentPage()
	{
		enterCardDetails();
		return actutils.getElementsAttributeList(payAndConfirmOrderAllFields_Details, "value");
	}

}
