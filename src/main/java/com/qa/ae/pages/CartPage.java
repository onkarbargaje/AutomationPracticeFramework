package com.qa.ae.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.ae.utilities.ActionsUtilities;
import com.qa.ae.utilities.CommonActions;

public class CartPage 
{
	protected WebDriver driver;
	protected ActionsUtilities actutils;
	protected CommonActions commonactions;
	
	private By proceed_to_checkout_bt= By.linkText("Proceed To Checkout");
	private By first_product_qty=By.xpath("(//div[@id='cart_info']//td[@class='cart_quantity'])[1]");
	private By register_login_lk= By.linkText("Register / Login");
	private By cart_qty_delete_btn=By.xpath("//a[@class='cart_quantity_delete']");
	private By empty_cart_msg=By.xpath("//b[text()='Cart is empty!']");
	private By signup_login_lk=By.xpath("//a[text()=' Signup / Login']");
	private By cart_table_prDescription_count=By.xpath("//table[@id='cart_info_table']//td[@class='cart_description']");
	
	
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
		actutils= new ActionsUtilities (driver);
		commonactions=new CommonActions(driver);
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
    
    public LoginPage clickOnSignupLogin_lk()
    {
//    	actutils.doClick(signup_login_lk);
//    	return new LoginPage(driver);
    	return commonactions.clickOnSignupLoginLk();
    }
    
    public boolean isProductAvailableInCart()
    {
    	List<WebElement> cart_table_products=actutils.getElementsCount(cart_table_prDescription_count);
    	boolean isProductAvailableInCart = false;
    	if(cart_table_products.size()>=1)
    	{
    		isProductAvailableInCart=true;
    		System.out.println("product/s available in the cart");
    	}
    	else
    	{
    		System.out.println("product/s is not available in the cart");
    	}
    	return isProductAvailableInCart;
    }
}
