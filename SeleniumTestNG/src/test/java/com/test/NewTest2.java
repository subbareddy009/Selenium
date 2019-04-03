package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.helper.DriverUtility;

public class NewTest2 {
	
	@Test
	public void testGoogleHomePage()
	{
		/*
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		*/
		/*System.setProperty("webdriver.ie.driver","C:\\Selenium\\Drivers\\IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();
		*/
		/*System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Drivers\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();*/
		WebDriver driver=DriverUtility.getDriver("ie");
		
		driver.manage().window().maximize();
		driver.get("http://www.google.co.in/");
		String title=driver.getTitle();
		Assert.assertEquals(title,"Google");
		/*
		 * if(title.equals("Goo")) { System.out.println("test is passed"); } else {
		 * System.out.println("test is failed"); }
		 */
		System.out.println("test code continues...");
	}

}
