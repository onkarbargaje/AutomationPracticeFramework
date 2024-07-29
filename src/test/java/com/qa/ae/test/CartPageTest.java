package com.qa.ae.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.ae.base.BaseTest;

public class CartPageTest extends BaseTest 
{
	
//	@BeforeClass
//	public void ProductsPageTestSetup() {
//		homepage = loginpage.doLogin();
//		productspage=homepage.doClickOnProductsLink();
//	}
	
	@Test (groups = {"smoke", "sanity","regression"})
	public void navigateToCheckoutPageTest()
	{
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		productspage=homepage.doClickOnProductsLink();
		cartpage=productspage.navigateToViewCart();
		checkoutpage=cartpage.clickOnProceedToCheckOutBt();
		String actCheckoutPageTitle=checkoutpage.getCheckoutPageTitle();
		Assert.assertEquals(actCheckoutPageTitle, "Automation Exercise - Checkout");
	}

}
