package com.qa.ae.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ae.utilities.ActionsUtilities;

public class HomePage 
{
	protected WebDriver driver;
	protected ActionsUtilities actutils;
	
	//protected By logout_lk=By.linkText(" Logout");
	protected By logout_lk=By.xpath("(//div[@class='shop-menu pull-right']//li)[4]/a");
	protected By products_lk=By.xpath("(//div[@class='shop-menu pull-right']//li)[2]/a");
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		actutils=new ActionsUtilities(driver);
		
	}
	
	public String getHomePageTitle()
	{
		String HomepageTitle=driver.getTitle();
		System.out.println("Home Page title is "+HomepageTitle);
		return HomepageTitle;
	}
	
	public boolean isLogoutLinkDisplayed() 
	{
		return actutils.isElementIsDisplayed(logout_lk, 5);
		
	}
	
	public ProductsPage  doClickOnProductsLink()
	{
		actutils.waitForVisibilityOfElement(products_lk, 5).click();
		//actutils.doClick(products_lk, 5);
		
		return new ProductsPage(driver);
	}
	
	

}
