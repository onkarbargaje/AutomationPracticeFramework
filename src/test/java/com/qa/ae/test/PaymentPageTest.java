package com.qa.ae.test;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.ae.base.BaseTest;

public class PaymentPageTest extends BaseTest
{
//	@BeforeClass
//	public void OrderConfirmationPageTestSetup() {
//		homepage = loginpage.doLogin();
//		productspage=homepage.doClickOnProductsLink();
//		cartpage=productspage.navigateToViewCart();
//		checkoutpage=cartpage.clickOnProceedToCheckOutBt();
//		paymentpage=checkoutpage.clickOnPlaceOrderBt();
		
//	}
	
	@Test(priority = 1,groups = {"smoke", "sanity","regression"})
	public void enterCardDetailsTest()
	{
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		productspage=homepage.doClickOnProductsLink();
		cartpage=productspage.navigateToViewCart();
		checkoutpage=cartpage.clickOnProceedToCheckOutBt();
		paymentpage=checkoutpage.clickOnPlaceOrderBt();
		paymentpage.enterCardDetails();
	}
	
	@Test(priority =3,groups = {"smoke","regression"} )
	public void clickOnClickAndPlaceOrderTest()
	{
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		productspage=homepage.doClickOnProductsLink();
		cartpage=productspage.navigateToViewCart();
		checkoutpage=cartpage.clickOnProceedToCheckOutBt();
		paymentpage=checkoutpage.clickOnPlaceOrderBt();
		paymentpage.enterCardDetails();
		orderconfirmationpage=paymentpage.clickOnPlaceAndConfirmOrder();
		String actMessage=orderconfirmationpage.getOrderConfirmationMessage();
		Assert.assertEquals(actMessage, "Congratulations! Your order has been confirmed!");
	}
	
	@Test(priority=2,groups = { "sanity"})
	public void textEnteredInAllFieldsOfPaymentPageTest()
	{
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		productspage=homepage.doClickOnProductsLink();
		cartpage=productspage.navigateToViewCart();
		checkoutpage=cartpage.clickOnProceedToCheckOutBt();
		paymentpage=checkoutpage.clickOnPlaceOrderBt();
		List<String> attributeValueList=paymentpage.textEnteredInAllFiledsOfPaymentPage();
		System.out.println(Arrays.asList(attributeValueList));
		int actAttrFieldsSize=attributeValueList.size();
		System.out.println("Text enter in "+ actAttrFieldsSize + " no of fields");
		int expeAttrFieldsSize= 5;
		Assert.assertEquals(actAttrFieldsSize, expeAttrFieldsSize);
	}
}
