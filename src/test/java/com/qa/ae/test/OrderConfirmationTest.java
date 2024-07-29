package com.qa.ae.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.ae.base.BaseTest;

public class OrderConfirmationTest extends BaseTest
{
//	@BeforeClass
//	public void OrderConfirmationPageTestSetup() {
//		homepage = loginpage.doLogin();
//		
//	}
	
	@Test(groups = {"smoke", "sanity","regression"})
	public void OrderConfirmationSuccessMessageTest()
	{
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		productspage=homepage.doClickOnProductsLink();
		cartpage=productspage.navigateToViewCart();
		checkoutpage=cartpage.clickOnProceedToCheckOutBt();
		paymentpage=checkoutpage.clickOnPlaceOrderBt();
		orderconfirmationpage=paymentpage.clickOnPlaceAndConfirmOrder();
		String actMessage=orderconfirmationpage.getOrderConfirmationMessage();
		Assert.assertEquals(actMessage, "Congratulations! Your order has been confirmed!");
	}

}
