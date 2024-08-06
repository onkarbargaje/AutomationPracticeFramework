package com.qa.ae.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ae.utilities.ActionsUtilities;
import com.qa.ae.utilities.CommonActions;

public class ContactUsPage 
{
	private WebDriver driver;
	protected ActionsUtilities actutils;
	protected CommonActions commonactions;
	
	private By name_tf=By.xpath("//input[@name='name']");
	private By email_tf=By.xpath("//input[@name='email']");
	private By subject_tf=By.xpath("//input[@name='subject']");
	private By textarea_tf=By.xpath("//textarea[@name='message']");
	private By submit_btn=By.xpath("//input[@type='submit']");
	private By contactUs_form_success_msg=By.xpath("//div[@class='contact-form']"
			+ "//div[text()='Success! Your details have been submitted successfully.']");
	private By home_btn=By.xpath("//span[text()=' Home']");
	
	public ContactUsPage(WebDriver driver)
	{
		this.driver=driver;
		actutils=new ActionsUtilities (driver);
		commonactions=new CommonActions(driver);
	}
	
	public void fillContactUsForm(String name, String email, String subject, String message )
	{
		actutils.waitForVisibilityOfElement(name_tf, 3).sendKeys(name);
		actutils.doSendKeys(email_tf, email);
		actutils.doSendKeys(subject_tf, subject);
		actutils.doSendKeys(textarea_tf, message);
		
	}
	
	
	public void clickOnSubmitBtn()
	{
		actutils.doClick(submit_btn);
	}
	
	public void acceptTheAlert()
	{
		actutils.waitForJSAlert(2);
		String actAlertText=actutils.getAlertText(2);
		System.out.println(actAlertText);
		actutils.acceptTheAlert(2);
	}
	
	public boolean getSuccessMsg()
	{
		String actMessage=actutils.waitForVisibilityOfElement(contactUs_form_success_msg, 2).getText();
		System.out.println(actMessage);
		if(actMessage.contains("Success! Your details have been submitted successfully."))
		{
			actutils.doClick(home_btn);
			return true;
		}
		else {
			return false;
		}
			
	}
	public void clickOnHomeBtn()
	{
		actutils.doClick(home_btn);
	}

}
