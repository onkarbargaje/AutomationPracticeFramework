package com.qa.ae.test;

import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.ae.base.BaseTest;
import com.qa.ae.utilities.ExcelUtils;

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
   
   /**
    * test cases added on feature branch
    */
   
   @DataProvider
	public Object[][] getUserRegisterationData()
	{
		Object registerUserdata [] []=ExcelUtils.getTestData("TC14");
		return registerUserdata;
	}
   //Test Case 14: Place Order: Register while Checkout
   @Test(dataProvider ="getUserRegisterationData", priority=3,groups = {"smoke", "sanity","regression"} )
   public void placeOrderAndRegisterBeforeCheckoutTest(String name, String email)
   {
	  homepage= loginpage.navigateToHomePage();
	  homepage.clickOnAddToCartlk();
	  cartpage=homepage.clickOnViewCartLink();
	  loginpage=cartpage.navigateToRegisterLoginLinkAfterClickOnProceedToCheckoutBtn();
	  signuppage=loginpage.doSignUp(name, email);
	  signuppage.doContinueSignup();
	  homepage=signuppage.clickOnContinueBtn();
	  cartpage=homepage.clickOnCartlk();
	 checkoutpage= cartpage.clickOnProceedToCheckOutBt();
	 paymentpage=checkoutpage.clickOnPlaceOrderBt();
	 orderconfirmationpage=paymentpage.clickOnPlaceAndConfirmOrder();
	 orderconfirmationpage.clickOnDeleteAccountLk();
	 orderconfirmationpage.getDeleteAccountMessage();
	 orderconfirmationpage.clickOnContinueBtn();
	 
	  
	   
   }
}
