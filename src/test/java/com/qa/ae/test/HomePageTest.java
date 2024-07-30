package com.qa.ae.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.ae.base.BaseTest;

public class HomePageTest extends BaseTest {

//	@BeforeClass
//	public void HomePageTestSetup() {
//		homepage = loginpage.doLogin();
//	}

	@Test(priority = 1,groups = {"smoke", "sanity","regression"})
	public void HomePageLogoutLinkTest() throws InterruptedException {
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertTrue(homepage.isLogoutLinkDisplayed());
	}

	@Test(priority = 2,groups = {"sanity","regression"})
	public void HomePageTitleTest() {
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        String actualHomePageTitle = homepage.getHomePageTitle();
		Assert.assertEquals(actualHomePageTitle, "Automation Exercise");
	}
	
	/**
	 * added on feature branch
	 */
	@Test(priority = 3,groups = {"smoke", "sanity","regression"})
   public void verifyFooterTextTest()
   {
	   homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	  String actFooterText= homepage.getFooterText();
	  Assert.assertEquals(actFooterText, "SUBSCRIPTION");
   }
	//Test Case 10: Verify Subscription in home page
	@Test(priority = 4,groups = {"smoke", "sanity","regression"})
	public void verifySubscriptionAlertMessageTest()
	{
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		homepage.enterEmailInFooterTextBox();
		homepage.clickOnFooterTextBoxArrow();
		String actAlertMsg=homepage.getSubscriptionAlertMessage();
		Assert.assertEquals(actAlertMsg, "You have been successfully subscribed!");
	}
}
