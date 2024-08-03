package com.qa.ae.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.qa.ae.factory.DriverFactory;
import com.qa.ae.pages.CartPage;
import com.qa.ae.pages.CheckoutPage;
import com.qa.ae.pages.ContactUsPage;
import com.qa.ae.pages.HomePage;
import com.qa.ae.pages.LoginPage;
import com.qa.ae.pages.OrderConfirmationPage;
import com.qa.ae.pages.PaymentPage;
import com.qa.ae.pages.ProductsPage;
import com.qa.ae.pages.SignupPage;

public class BaseTest {
	DriverFactory df;
	WebDriver driver;
	protected SoftAssert softassert;
    protected Properties prop;
	protected SignupPage signuppage; //only child class will access either in same or different package
    protected HomePage homepage;
    protected ContactUsPage contactuspage;
    protected LoginPage loginpage;
    protected ProductsPage productspage;
    protected CartPage cartpage;
    protected CheckoutPage checkoutpage;
    protected PaymentPage paymentpage;
    protected OrderConfirmationPage orderconfirmationpage;
	//@BeforeTest
    //@BeforeSuite
    
	@BeforeMethod(groups = {"smoke", "sanity","regression"})
	public void setUp() {
		df = new DriverFactory();
		prop=df.initProperties();
		driver=df.initDriver(prop);
		
		//driver=df.initDriver("firefox");// this will return webdriver we are string in driver reference
		signuppage=new SignupPage(driver); //when we create object of Signup page then SignupPage constructor will be
		//called by default and it is waiting for driver and we are passing 18 number driver to this
	    loginpage=new LoginPage(driver);
	    softassert= new SoftAssert();
	}
	
	
	
   //@AfterTest
    //@AfterSuite
	
   @AfterMethod(groups = {"smoke", "sanity","regression"})
    public void tearDown()
    {
	   if (driver != null) {
           driver.quit();
       }
    	//driver.quit();
    }

}
