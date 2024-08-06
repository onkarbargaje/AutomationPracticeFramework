package com.qa.ae.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.ae.pages.CartPage;
import com.qa.ae.pages.ContactUsPage;
import com.qa.ae.pages.HomePage;
import com.qa.ae.pages.LoginPage;
import com.qa.ae.pages.ProductsPage;

public class CommonActions {
	
	private WebDriver driver;
	private WebDriverWait wait;
	protected ActionsUtilities actutils;
	
	private By logout_lk=By.xpath("(//div[@class='shop-menu pull-right']//li)[4]/a");
	//private By products_lk=By.xpath("(//div[@class='shop-menu pull-right']//li)[2]/a");
	private By home_lk=By.xpath("//a[text()=' Home']");
	private By products_lk=By.xpath("//a[text()=' Products']");
	private By carts_lk=By.xpath("//a[text()=' Cart']");
	private By register_login_lk= By.linkText("Register / Login");
	private By signup_login_lk=By.xpath("//a[text()=' Signup / Login']");
	private By delete_account_lk=By.xpath("//a[text()=' Delete Account']");
	private By contactUs_lk=By.xpath("//a[text()=' Contact us']");
	
	public CommonActions(WebDriver driver)
	{
		this.driver=driver;
		actutils= new ActionsUtilities(driver);
	}
	
	public HomePage clickOnHomePageLink()
	{
		actutils.doClick(home_lk);
		return new HomePage(driver);
	}
	public ProductsPage clickOnProductsPageLink()
	{
		actutils.doClick(products_lk);
		return new ProductsPage(driver);
	}
	
	public CartPage clickOnCartPageLink()
	{
		actutils.doClick(carts_lk);
		return new CartPage(driver);
	}
	
	public LoginPage clickOnSignupLoginLk()
	{
		actutils.doClick(signup_login_lk);
		return new LoginPage(driver);
	}
	public LoginPage clickOnLogoutLink()
	{
		actutils.doClick(logout_lk);
		return new LoginPage(driver);
	}
	
	public void clickOnDeleteAccountLink()
	{
		actutils.doClick(delete_account_lk);
		
	}
	public ContactUsPage clickOnContactUsLink()
	{
		actutils.doClick(contactUs_lk);
		return new ContactUsPage(driver);
	}

}
