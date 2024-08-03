package com.qa.ae.test;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.ae.base.BaseTest;
import com.qa.ae.utilities.ExcelUtils;

public class ContactUsPageTest extends BaseTest 
{
	
	@DataProvider
	public Object[][] getContactUsFormData()
	{
		Object contactusdata [] []=ExcelUtils.getTestData("ContactUs");
		return contactusdata;
	}
	@Test(dataProvider = "getContactUsFormData",priority=1,groups = {"smoke", "sanity","regression"})
	public void verifyContactUsFormTest(String name, String email, String subject, String message)
	{
		contactuspage=loginpage.navigateToContactUsForm();
		contactuspage.fillContactUsForm(name, email, subject,  message);
		contactuspage.clickOnSubmitBtn();
		contactuspage.acceptTheAlert();
		Assert.assertTrue(contactuspage.getSuccessMsg()); ;
	}
	
	
}
