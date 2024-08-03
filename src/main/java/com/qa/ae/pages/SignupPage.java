package com.qa.ae.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ae.utilities.ActionsUtilities;

public class SignupPage 
{
	protected WebDriver driver;
	protected ActionsUtilities actutils;
	
	private By name_tf= By.xpath("//input[@placeholder='Name']");
	private By email_tf= By.xpath("//input[@data-qa='signup-email']");
	private By signup_bt= By.xpath("//button[@data-qa='signup-button']");
	private By signup_text= By.xpath("//h2[text()='New User Signup!']");
	private By password_tf= By.xpath("//input[@type='password']");
	private By day_dd=By.xpath("//select[@id='days']");
	private By months_dd=By.xpath("//select[@id='months']");
	private By year_dd=By.xpath("//select[@id='years']");
	private By fname_tf= By.xpath("//input[@data-qa='first_name']");
	private By lname_tf= By.xpath("//input[@data-qa='last_name']");
	private By address_tf= By.xpath("//input[@data-qa='address']");
	private By country_dd=By.xpath("//select[@id='country']");
	private By state_tf= By.xpath("//input[@data-qa='state']");
	private By city_tf= By.xpath("//input[@data-qa='city']");
	private By zipcode_tf= By.xpath("//input[@data-qa='zipcode']");
	private By mobile_number_tf= By.xpath("//input[@data-qa='mobile_number']");
	private By create_account_btn= By.xpath("//button[@data-qa='create-account']");
	private By create_account_success_msg=By.xpath("//p[text()='Congratulations! "
			+ "Your new account has been successfully created!']");
	private By continue_btn=By.xpath("//a[text()='Continue']");
	
	public SignupPage(WebDriver driver)
	{
		this.driver=driver;
		actutils=new ActionsUtilities (driver);
	}
	
	public String getSignupPageTitle()
	{
		String Title=driver.getTitle();
		System.out.println("page title is" +Title);
		return Title;
	} 
	
	public boolean isSignupTextdisplayed() throws InterruptedException
	{
		Thread.sleep(2000);
		return driver.findElement(signup_text).isDisplayed();
	}
	
	public void doSignup()
	{
		driver.findElement(name_tf).sendKeys("Onkar Bargaje");
		driver.findElement(email_tf).sendKeys("Automation@1234");
		driver.findElement(signup_bt).click();
		//return new SignupPage(driver);
	}
	
	public void doContinueSignup()
	{
		actutils.waitForVisibilityOfElement(password_tf, 2).sendKeys("kirti@1234");
		actutils.selectByValue(day_dd, "4");
		actutils.selectByValue(months_dd, "6");
		actutils.selectByValue(year_dd, "1998");
		actutils.doSendKeys(fname_tf, "kirti");
		actutils.doSendKeys(lname_tf, "bar");
		actutils.doSendKeys(address_tf, "2A/28");
		actutils.selectValueByVisibleText(country_dd, "India");
		actutils.doSendKeys(state_tf, "Maha");
		actutils.doSendKeys(city_tf, "pune");
		actutils.doSendKeys(zipcode_tf, "411111");
		actutils.doSendKeys(mobile_number_tf, "1234567890");
		actutils.doClick(create_account_btn);
		
	}
	
	/**
	 * this method is to click on Continue button after successfully creating account
	 * @return 
	 */
	public HomePage clickOnContinueBtn()
	{
		String acc_create_succ_mesg=actutils.getText(create_account_success_msg, 2);
		if(acc_create_succ_mesg.contains("Your new account has been successfully created"))
		{
			actutils.doClick(continue_btn);
			System.out.println("Account is created successfully");
			//return new HomePage(driver);
		}
//		else
//		{
//			System.out.println("Account is not created successfully");
//		}
		return new HomePage(driver);
	}

}
