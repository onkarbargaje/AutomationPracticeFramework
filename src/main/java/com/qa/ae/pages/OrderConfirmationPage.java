package com.qa.ae.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ae.utilities.ActionsUtilities;
import com.qa.ae.utilities.CommonActions;

public class OrderConfirmationPage  {
	
	protected WebDriver driver;
	protected ActionsUtilities actutils;
	protected CommonActions commonactions;
	
	private By orderConfirmSuccess_Message=By.xpath("//p[text()='Congratulations! Your order has been confirmed!']");
    private By delete_account_lk=By.xpath("//a[text()=' Delete Account']");
	private By deleteAccount_Message=By.xpath("//p[text()='Your account has been permanently deleted!']");
	private By continue_btn= By.xpath("//a[text()='Continue']");

    
	public OrderConfirmationPage(WebDriver driver)
	{
		this.driver=driver;
		actutils= new ActionsUtilities (driver);
		commonactions=new CommonActions(driver);
	}
	
	public String getOrderConfirmationMessage()
	{
		return actutils.getText(orderConfirmSuccess_Message, 5);
		
	}
	
	public void clickOnDeleteAccountLk()
	{
		System.out.println(getOrderConfirmationMessage());
		//actutils.doClick(delete_account_lk, 2);
		commonactions.clickOnDeleteAccountLink();
	}
	public void getDeleteAccountMessage()
	{
		 String mesg=actutils.getText(deleteAccount_Message, 5);
		 System.out.println(mesg);
		
	}
	
	public void clickOnContinueBtn()
	{
		actutils.doClick(continue_btn, 2);
	}
	

}
