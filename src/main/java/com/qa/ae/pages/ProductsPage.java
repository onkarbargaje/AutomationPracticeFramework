package com.qa.ae.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ae.utilities.ActionsUtilities;

public class ProductsPage {
	
	protected WebDriver driver;
	protected ActionsUtilities actutils;
	private By searchProduct_tf=By.id("search_product");
	//private By searchProduct_tf=By.xpath("(//input[@id='search_product'])[1]");
	//private By searchProduct_tf=By.xpath("//input[@placeholder='Search Product']");
	private By searchProduct_bt=By.id("submit_search");
	private By viewProducts_link=By.xpath("(//a[text()='View Product'])[1]");
	private By addToCart_bt=By.xpath("//button[@type='button']");
	private By searchResult_img=By.xpath("//div[@class='product-image-wrapper']");
	private By addToCartSuccess_msg=By.xpath("//p[text()='Your product has been added to cart.']");
	private By viewCart_lk=By.xpath("//u[text()='View Cart']");
	
	

	public ProductsPage(WebDriver driver) 
	{
		this.driver=driver;
		actutils= new ActionsUtilities (driver);
	}
	
	
	public boolean isSearchProductTFDisplayed()
	{
		//return actutils.isElementIsDisplayed(searchProduct_tf);
		return actutils.isElementIsDisplayed(searchProduct_tf, 5);
	}
	
	public void searchEnteredProductName()
	{
		actutils.doSendKeys(searchProduct_tf, "top");
		actutils.doClick(addToCart_bt);	
	}
	
	public boolean isProductAvailable()
	{
		return actutils.isElementIsDisplayed(searchResult_img, 2);
	}
	
	public void viewProductDetails()
	{
		actutils.doClick(viewProducts_link);
	}
	
	public boolean productAddToCart()
	{
		actutils.waitForVisibilityOfElement(searchProduct_tf, 5).sendKeys("short");
		actutils.doClick(viewProducts_link, 2);
		actutils.doClick(addToCart_bt);
		return actutils.isElementIsDisplayed(addToCartSuccess_msg, 2);
	}
	
	/**
	 * below method is to navigate to cart when we click on Add to cart button and then
	 * "view cart" link in the popup
	 * @return 
	 */
	public CartPage navigateToViewCart()
	{
		actutils.waitForVisibilityOfElement(searchProduct_tf, 5).sendKeys("t shirt");
		//actutils.doSendKeys(searchProduct_tf, "t shirt");
		actutils.doClick(viewProducts_link, 2);
		actutils.doClick(addToCart_bt);
		actutils.doClick(viewCart_lk, 2);
		return new CartPage(driver);
	}
	public void clickOnViewCartFromPopup()
	{
		
	}

}
