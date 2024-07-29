package com.qa.ae.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.ae.base.BaseTest;

public class LoginPageTest extends BaseTest {
	@Test(groups = {"smoke", "sanity","regression"})
	public void verifyloginPageTest() throws InterruptedException {
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		Assert.assertTrue(homepage.isLogoutLinkDisplayed());
		//Thread.sleep(5000);
	}

}
