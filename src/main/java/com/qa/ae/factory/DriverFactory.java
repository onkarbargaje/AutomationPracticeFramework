package com.qa.ae.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	public WebDriver driver;
	public Properties prop;
	public FileInputStream fis;
	public static ThreadLocal<WebDriver> tlDriver= new ThreadLocal<WebDriver>();

	//public WebDriver initDriver(String browserName) { this is before passing browser from properties file
		public WebDriver initDriver(Properties prop) {
			String browserName=prop.getProperty("browser"); // after passing brow from properties
		System.out.println("browser name is " + browserName);

		if (browserName.equalsIgnoreCase("chrome")) {
			//driver = new ChromeDriver();
			tlDriver.set(new ChromeDriver()); //for thread safe in parallel execution

		} else if (browserName.trim().equalsIgnoreCase("edge")) {
			//driver = new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("firefox")) {
			//driver = new EdgeDriver();
			tlDriver.set(new EdgeDriver());
		} else {
			System.out.println("please enter the correct browser name");
		}
		
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.get(prop.getProperty("url"));
//		return driver;
		/**
		 * following is beacuase now we are using the threadlocal driver 
		 * so we have to use getDriver method instead of driver.manage()......
		 */
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
		
		return getDriver();
	}
		/**
		 * this method is to get the thread safe copy of driver as in initDriver method
		 * we have set the thread local driver
		 * @return 
		 */
		public static synchronized WebDriver getDriver()
		{
			return tlDriver.get();
		}
	
	public Properties initProperties()
	{
		//mvn clean install -Denv="delqa"  >>for running through maven on different env
		
		prop= new Properties();
		FileInputStream fis= null;
		String envName=System.getProperty("env");
		System.out.println("Test cases running on the env: "+envName);
		try {
		if(envName==null)
		{
			System.out.println("env name not given test cases running of DelQA env by default....");
			
				 fis= new FileInputStream("./src/main/resources/configuraions/delqa.config.properties");
		}
			else
			{
				switch (envName.toLowerCase().trim()) {
				case "prod": {
					fis= new FileInputStream("./src/main/resources/configuraions/application.properties");
					break;
				}
				case "delqa": {
					 fis= new FileInputStream("./src/main/resources/configuraions/delqa.config.properties");
					break;
				}
				case "stage": {
					fis= new FileInputStream("./src/main/resources/configuraions/stage.config.properties");
					break;
				}
				default:
					System.out.println("please pass correct env name");
				}
			}
		
		}
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//this is before implementing cross env logic
		
//		try {
//			 fis= new FileInputStream("./src/main/resources/configuraions/application.properties");
//			prop.load(fis);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return prop;
//		
	}
	public static String getScreenshot(String methodName) {

		// Get the driver instance
		TakesScreenshot screenshotTaker = (TakesScreenshot) getDriver();

		// Take the screenshot and save it to a temporary location
		File srcFile = screenshotTaker.getScreenshotAs(OutputType.FILE);

		// Define the path for the screenshots folder
		String screenshotsDirPath = System.getProperty("user.dir") + "/screenshots";

		// Create the screenshots folder if it doesn't exist
		File screenshotsDir = new File(screenshotsDirPath);
		if (!screenshotsDir.exists()) {
			if (screenshotsDir.mkdirs()) {
				System.out.println("Folder 'screenshots' created successfully at: " + screenshotsDirPath);
			} else {
				System.out.println("Failed to create the folder 'screenshots' at: " + screenshotsDirPath);
			}
		}

		// Define the destination path for the screenshot
		String screenshotPath = screenshotsDirPath + "/" + methodName + "_" + System.currentTimeMillis() + ".png";
		File destination = new File(screenshotPath);

		// Copy the screenshot to the destination path
		try {
			//FileUtils.copyDirectory(srcFile, destination);
			org.openqa.selenium.io.FileHandler.copy(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return destination.getAbsolutePath();
	}

}
