package com.qa.ae.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.ae.base.BaseTest;

public class SignupPageTest extends BaseTest{
	
	@Test(priority = 1,groups = {"regression"})
	public void signupPageTextDisplayedTest() throws InterruptedException
	{
		Assert.assertTrue(signuppage.isSignupTextdisplayed());
	}
	
	@Test(priority = 2,groups = {"regression"})
	public void signupPageTitleTest()
	{
		String actualTitle=signuppage.getSignupPageTitle();
		Assert.assertEquals(actualTitle, "Automation Exercise - Signup / Login");
	}
	
	@Test(priority = 3,groups = {"smoke", "sanity","regression"})
	public void signupPageTest()
	{
		signuppage.doSignup();
	}

}
