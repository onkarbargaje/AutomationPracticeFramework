package com.qa.ae.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.ae.base.BaseTest;

public class ProductsPageTest extends BaseTest
{
//	@BeforeClass
//	public void ProductsPageTestSetup() {
//		homepage = loginpage.doLogin();
//		//productspage=homepage.doClickOnProductsLink();
//	}
	
	
	
	
	@Test(priority = 1,groups = {"smoke", "sanity","regression"})
	public void searchProductTfTest()
	{
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		productspage=homepage.doClickOnProductsLink();
	Assert.assertTrue(productspage.isSearchProductTFDisplayed());	
	}
	
	@Test(priority = 2,groups = {"smoke","regression"})
	public void searchProductResultTest()
	{
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		productspage=homepage.doClickOnProductsLink();
		productspage.searchEnteredProductName();
	}
	
	@Test(priority = 3,groups = {"smoke", "regression"})
	public void verifySearchedProductResultTest()
	{
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		productspage=homepage.doClickOnProductsLink();
		productspage.searchEnteredProductName();
	Assert.assertTrue(productspage.isProductAvailable());	
	}
	
	@Test(priority = 4,groups = {"smoke"})
	public void viewSearchedProductDetailsTest()
	{
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		productspage=homepage.doClickOnProductsLink();
		productspage.viewProductDetails();
	}
	
	@Test(priority = 5,groups = {"smoke", "sanity","regression"})
	public void searchedProductAddToCartTest()
	{
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		productspage=homepage.doClickOnProductsLink();
		Assert.assertTrue(productspage.productAddToCart());
	}
	@Test(priority = 6,groups = {"smoke", "sanity","regression"})
	public void navigateToCartPageTest()
	{
	    homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		productspage=homepage.doClickOnProductsLink();
		cartpage=productspage.navigateToViewCart();
		String actCartPageTitle=cartpage.getCartPageTitle();
		Assert.assertEquals(actCartPageTitle, "Automation Exercise - Checkout");
	}

}
