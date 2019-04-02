package com.runner;

import org.testng.annotations.Test;

import com.pageLib.Home;
import com.pageLib.Login;
import com.pageLib.Register;

import Selenium.MyLearning.LaunchDriver;
import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class MainDriver {
	WebDriver driver;
	Home homePage;
	Login loginPage;
	Register registerPage;
	
  @BeforeTest
  public void beforeTest() {
	    driver= new LaunchDriver().getPgDriver("chrome");
		driver.manage().window().maximize();
		driver.get("http://demowebshop.tricentis.com/");
		homePage=PageFactory.initElements(driver, Home.class);
		loginPage=PageFactory.initElements(driver,Login.class);
		registerPage=PageFactory.initElements(driver,Register.class);
  }
  @Test(priority=1)
	public void testHomePage() {
		String title=homePage.clickOnRegisterLnk();
		Assert.assertEquals(title,"Demo Web Shop. Register");
	}
  @Test(priority=2)
	public void testRegistration()
	{
		String message=registerPage.registersubmit();
		Assert.assertEquals(message,"registration completed");
		
	}
	@Test(dependsOnMethods="testRegistration")
	public void testLogin()
	{
		homePage.clickloginlink();
		String title=loginPage.loginSubmit();
		Assert.assertEquals(title,"Demo Web Shop");
		registerPage.clickLogout();
	}


	@AfterTest
	public void afterTest() {
		homePage=null;
		loginPage=null;
		registerPage=null;
		driver.close();
	}
}
