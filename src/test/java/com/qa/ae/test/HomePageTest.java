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

}
