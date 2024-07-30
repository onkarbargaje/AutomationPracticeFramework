package com.qa.ae.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.qa.ae.utilities.ActionsUtilities;

public class HomePage 
{
	protected WebDriver driver;
	protected ActionsUtilities actutils;
	
	//protected By logout_lk=By.linkText(" Logout");
	private By logout_lk=By.xpath("(//div[@class='shop-menu pull-right']//li)[4]/a");
	private By products_lk=By.xpath("(//div[@class='shop-menu pull-right']//li)[2]/a");
	private By footer_subscription= By.xpath("(//div[@class='single-widget']//h2)");
	private By footer_subscription_tf=By.id("susbscribe_email");
	private By footer_subscription_btn=By.xpath("//button[@type='submit']");
	private By alert_success_msg=By.xpath("//div[text()='You have been successfully subscribed!']");
	
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
	
	/**
	 * added on feature branch
	 * @return 
	 */
	
	public String getFooterText()
	{
		actutils.scrollByVisibilityOfElement(footer_subscription);
		String footerText=actutils.getText(footer_subscription);
		System.out.println(footerText);
		return footerText;
	}
	
	public void enterEmailInFooterTextBox()
	{
		actutils.doSendKeys(footer_subscription_tf, "bargajeon@gmail.com", 5);
	}
	
	public void clickOnFooterTextBoxArrow()
	{
		actutils.doClick(footer_subscription_btn);
	}
	public String getSubscriptionAlertMessage()
	{
		String actAlertMsg=actutils.getText(alert_success_msg, 2);
		return actAlertMsg;
	}
	

}
