package com.qa.ae.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ae.utilities.ActionsUtilities;

public class CartPage 
{
	protected WebDriver driver;
	protected ActionsUtilities actutils;
	
	private By proceed_to_checkout_bt= By.linkText("Proceed To Checkout");
	private By first_product_qty=By.xpath("(//div[@id='cart_info']//td[@class='cart_quantity'])[1]");
	private By register_login_lk= By.linkText("Register / Login");
	private By cart_qty_delete_btn=By.xpath("//a[@class='cart_quantity_delete']");
	private By empty_cart_msg=By.xpath("//b[text()='Cart is empty!']");
	
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
	
	public String getFirstProductQuantity()
	{
		return actutils.getText(first_product_qty, 4);
	}
	
    public LoginPage navigateToRegisterLoginLinkAfterClickOnProceedToCheckoutBtn()
    {
    	actutils.doClick(proceed_to_checkout_bt, 2);
    	actutils.doClick(register_login_lk, 2);
    	return new LoginPage(driver);
    }
    
    public String clickOnCartQtyDeleteBtn()
    {
    	actutils.doClick(cart_qty_delete_btn);
    	String empty_cart_ms=actutils.getText(empty_cart_msg, 2);
    	System.out.println(empty_cart_ms);
    	return empty_cart_ms;
    }
}
