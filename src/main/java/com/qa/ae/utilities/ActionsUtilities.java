package com.qa.ae.utilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsUtilities {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public ActionsUtilities(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getElement(By locator)
	{ 
		WebElement element=null;
		try {
			element=driver.findElement(locator);
		} catch (NoSuchElementException e) {
			System.out.println("Element is not present on the page");
			e.printStackTrace();
		}
		return element;
	}
	
	public void doSendKeys(By locator, String text)
	{
		WebElement element=getElement(locator);
		element.clear();
		element.sendKeys(text);
	}
	
	public WebElement waitForVisibilityOfElement(By locator, int timeout)
	{
		wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void doSendKeys(By locator, String text, int timeout)
	{
		getElement(locator).clear();
		waitForVisibilityOfElement(locator, timeout).sendKeys(text);
	}
	
	public void doClick(By locator)
	{
		getElement(locator).click();
	}
	
	public void doClick(By locator, int timeout)
	{
		waitForVisibilityOfElement(locator, timeout).click();
	}
	
	public boolean isElementIsDisplayed(By locator)
	{
		return getElement(locator).isDisplayed();
	}
	
	public boolean isElementIsDisplayed(By locator, int timeout)
	{
		return waitForVisibilityOfElement(locator, timeout).isDisplayed();
	}
	
	public String waitForTitleIs(String title, int timeOut) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		try {
			if (wait.until(ExpectedConditions.titleIs(title))) {
				return driver.getTitle();
			}
		} catch (Exception e) {
			System.out.println("title is not found within : " + timeOut);
		}
		return null;

	}
	
	public String getCurrentPageTitle(WebDriver driver)
	{
		boolean flag=false;
		String actTitle=driver.getTitle();
		if(flag)
		{
			System.out.println("Current page title is "+actTitle);
			
		}
		return actTitle;
		
		
	}
	
	public String getCurrentPageURL(WebDriver driver)
	{
		boolean flag=false;
		String actURL=driver.getCurrentUrl();
		if(flag)
		{
			System.out.println("Current page URL is "+actURL);
			
		}
		return actURL;
		
		
	}
	
	public String getText(By locator)
	{
		WebElement element=getElement(locator);
		String text=element.getText();
		return text;
	}
	
	public String getText(By locator, int timeout)
	{
		wait= new WebDriverWait(driver,Duration.ofSeconds(timeout));
		WebElement element=wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
		String text=element.getText();
		return text;
	}
	
	public List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}
	
	public List<WebElement> getElementsCount(By locator)
	{
		return driver.findElements(locator);
	}
	
	public List<String> getElementsAttributeList(By locator,String attributeName)
	{
		List<WebElement> list=driver.findElements(locator);
		List<String> attributeList= new ArrayList<String>();
		
		for(WebElement e: list)
		{
			String attributeValue=e.getAttribute(attributeName);
			if(attributeValue != null && attributeValue.length() !=0 )
			{
				attributeList.add (attributeValue);
			}
		}
		
		System.out.println(attributeList.size());
		//return System.out.println(Arrays.asList(attributeList));
		
		//return Arrays.asList(attributeList);
		return attributeList;
	}
	/**
	 * added when working on feature branch
	 */
	
	public void scrollByVisibilityOfElement( By locator)
	{
		JavascriptExecutor js=  (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
	}
	
	/**
	 * below utility for alert
	 * @return 
	 */
	
	public Alert waitForJSAlert(int timeOut)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		 return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public Alert waitForJSAlert(int timeOut, int intervalTime) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(intervalTime)).ignoring(NoAlertPresentException.class)
				.withMessage("===alert is not found===");
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public String getAlertText(int timeOut)
	{
		Alert alert=waitForJSAlert(timeOut);
		String alertText=alert.getText();
		return alertText;
	}
	
	public void acceptTheAlert(int timeOut)
	{
		Alert alert=waitForJSAlert(timeOut);
		alert.accept();
	}
	
	public void dismissTheAlert(int timeOut)
	{
		Alert alert=waitForJSAlert(timeOut);
		alert.dismiss();
	}
	
	////++++++Select class dropdown utils++++
	
	public void selectValueByIndex(By locator, int index)
	{
		Select select=new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public void selectValueByVisibleText(By locator, String visibleText)
	{
		Select select=new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
	}
	
	public void selectByValue(By locator, String value)
	{
		Select select=new Select(getElement(locator));
		select.selectByValue(value);
	}
}
