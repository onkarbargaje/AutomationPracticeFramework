package com.qa.ae.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.ae.base.BaseTest;

public class CheckoutPageTest extends BaseTest 
{
//	@BeforeClass
//	public void ProductsPageTestSetup() {
//		homepage = loginpage.doLogin();
//		
//	}
   @Test(priority=1,groups = {"regression"})
   public void CheckoutPageURLTest()
   {
	   homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	   productspage=homepage.doClickOnProductsLink();
		cartpage=productspage.navigateToViewCart();
		checkoutpage=cartpage.clickOnProceedToCheckOutBt();
	   String actPageURL=checkoutpage.getCheckoutPageUrl();
	   Assert.assertEquals(actPageURL, "https://www.automationexercise.com/checkout");
   }
   
   @Test(priority=2,groups = {"smoke", "sanity","regression"})
   public void clickOnPalceOrderBtTest()
   {
	   homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	   productspage=homepage.doClickOnProductsLink();
		cartpage=productspage.navigateToViewCart();
		checkoutpage=cartpage.clickOnProceedToCheckOutBt();
	   paymentpage=checkoutpage.clickOnPlaceOrderBt();
	   String actURL=paymentpage.getCheckoutPageUrl();
	   Assert.assertEquals(actURL, "https://www.automationexercise.com/payment");
	   
	   
   }
}
