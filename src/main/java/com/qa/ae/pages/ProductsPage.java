package com.qa.ae.pages;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.ae.utilities.ActionsUtilities;
import com.qa.ae.utilities.CommonActions;

public class ProductsPage {
	
	protected WebDriver driver;
	protected ActionsUtilities actutils;
	protected CommonActions commonactions;
	
	private Map<String, String> productInfoMap = new HashMap<String, String>();
	private By searchProduct_tf=By.id("search_product");
	//private By searchProduct_tf=By.xpath("(//input[@id='search_product'])[1]");
	//private By searchProduct_tf=By.xpath("//input[@placeholder='Search Product']");
	private By searchProduct_bt=By.id("submit_search");
	private By viewProduct_link=By.xpath("(//a[text()='View Product'])[1]");
	private By addToCart_bt=By.xpath("//button[@type='button']");
	private By searchResult_img=By.xpath("//div[@class='product-image-wrapper']");
	private By addToCartSuccess_msg=By.xpath("//p[text()='Your product has been added to cart.']");
	private By viewCart_lk=By.xpath("//u[text()='View Cart']");
	
	private By product_details=By.xpath("//div[@class='product-information']//p");
	private By product_price=By.xpath("(//div[@class='product-information']//span)[2]");
	private By product_header=By.xpath("(//div[@class='product-information']//h2)");
	private By product_quantity_tf=By.xpath("//input[@type='number']");
	
	

	public ProductsPage(WebDriver driver) 
	{
		this.driver=driver;
		actutils= new ActionsUtilities (driver);
		commonactions=new CommonActions(driver);
	}
	
	
	public boolean isSearchProductTFDisplayed()
	{
		//return actutils.isElementIsDisplayed(searchProduct_tf);
		return actutils.isElementIsDisplayed(searchProduct_tf, 5);
	}
	
	public void searchEnteredProductName()
	{
		actutils.doSendKeys(searchProduct_tf, "jeans");
		actutils.doClick(addToCart_bt);	
	}
	
	public boolean isProductAvailable()
	{
		 boolean flag=actutils.isElementIsDisplayed(searchResult_img, 2);
		 
//		 if(flag)
//		 {
//			 System.out.println("Entered product is available......");
//		 }
//		 else
//		 {
//			 throw new RuntimeException("Entered product is not available..........");
//		 }
		return flag;
		
	}
	
	public void viewProductDetails()
	{
		actutils.doClick(viewProduct_link);
	}
	
	public boolean productAddToCart()
	{
		actutils.waitForVisibilityOfElement(searchProduct_tf, 5).sendKeys("short");
		actutils.doClick(viewProduct_link, 2);
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
		actutils.doClick(viewProduct_link, 2);
		actutils.doClick(addToCart_bt);
		//actutils.doClick(viewCart_lk, 2);
		//return new CartPage(driver);
		return clickOnViewCartLink();
	}
	public void clickOnViewProductLink()
	{
		actutils.doClick(viewProduct_link, 2);
	}
	
	
	///working on feature branch
	
	public String getProductsPageTitle()
	{
		return actutils.getCurrentPageTitle(driver);
	}
	
	public Map<String, String> getProductDetails()
	{
		getProductHeaderName();
		getProductMetaData();
		getProductPrice();
		System.out.println(productInfoMap);
		return productInfoMap;
		
	}
	private void getProductMetaData()
	{
		List<WebElement> productMetaData=actutils.getElements(product_details);
		//productInfoMap= new HashMap<String, String>(); //unordered collection
		productInfoMap= new LinkedHashMap<String, String>();  //ordered collection
		for(WebElement e: productMetaData)
		{
			String metaInfo=e.getText();
			String [] metaInfoArray=metaInfo.split(":");
			String key = metaInfoArray[0].trim();
			String value = metaInfoArray[1].trim();
			productInfoMap.put(key, value);
		}
		
	}
	
	private void getProductPrice()
	{
		String price= actutils.getElement(product_price).getText();
		String[] priceDetails=price.split(" ");
		String currency=priceDetails[0];
		String value=priceDetails[1];
		
		productInfoMap.put("currencyname", currency);
		productInfoMap.put("currencyvalue", value);
     		
	}
	public String getProductHeaderName()
	{
		String productHeaderName =actutils.getElement(product_header).getText();
		System.out.println("product name is "+productHeaderName );
		return productHeaderName;
	}
	
	public void enterProductQuantity(int qty)
	{
		//actutils.doSendKeys(product_quantity_tf, String.valueOf(qty));
		actutils.doSendKeys(product_quantity_tf, String.valueOf(qty), 2);
	}
	
	public void clickOnAddToCartButton()
	{
		actutils.doClick(addToCart_bt, 2);
	}
	
	public CartPage clickOnViewCartLink()
	{
		actutils.doClick(viewCart_lk,2);
		return new CartPage(driver);
	}
	
	

}
