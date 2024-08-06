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
	
	@Test (priority = 2, groups= {"smoke", "sanity","regression"})
	public void navigateToCheckoutPageTest()
	{
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		productspage=homepage.doClickOnProductsLink();
		cartpage=productspage.navigateToViewCart();
		checkoutpage=cartpage.clickOnProceedToCheckOutBt();
		String actCheckoutPageTitle=checkoutpage.getCheckoutPageTitle();
		Assert.assertEquals(actCheckoutPageTitle, "Automation Exercise - Checkout");
	}
	//Test Case 13: Verify Product quantity in Cart
	@Test (priority = 1,groups = {"smoke", "sanity","regression"})
	public void productQuantityInCartTest()
	{
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		productspage=homepage.doClickOnProductsLink();
		productspage.clickOnViewProductLink();
		productspage.enterProductQuantity(4);
		productspage.clickOnAddToCartButton();
		cartpage=productspage.clickOnViewCartLink();
		String actProductQty=cartpage.getFirstProductQuantity();
		System.out.println(actProductQty);
		Assert.assertEquals(actProductQty, "4");
	}
	
	//Test Case 17: Remove Products From Cart
	@Test (priority = 3 ,groups = {"smoke", "sanity","regression"})
	public void removeProductsFromCartTest()
	{
		homepage= loginpage.navigateToHomePage();
		homepage.clickOnAddToCartlk();
		cartpage=homepage.clickOnViewCartLink();
		String actMsg=cartpage.clickOnCartQtyDeleteBtn();
		Assert.assertEquals(actMsg, "Cart is empty!");
	}
	
	//Test Case 20: Search Products and Verify Cart After Login
	@Test (priority = 4 ,groups = {"smoke", "sanity","regression"})
	public void verifyLoginAfterAddingProductToCartTest()
	{
		productspage=loginpage.navigateToProductsPage();
		productspage.searchEnteredProductName();
		productspage.isProductAvailable();
		productspage.productAddToCart();
		cartpage=productspage.clickOnViewCartLink();
		loginpage=cartpage.clickOnSignupLogin_lk();
		loginpage.doLogin("bargajeonkar99@gmail.com", "Automation@1234");
		cartpage=loginpage.navigateToCartPage();
		cartpage.isProductAvailableInCart();
		Assert.assertTrue(cartpage.isProductAvailableInCart());
		
		
		
	}

}
