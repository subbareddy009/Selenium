package com.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.helper.DriverUtility;

public class NewTest3 {
	@Test
	@Parameters("node")
	public void testLoginDemoWebShop(String node) throws MalformedURLException
	{
		//WebDriver driver=DriverUtility.getDriver("chrome");
		DesiredCapabilities ds=DesiredCapabilities.chrome();
		ds.setPlatform(Platform.ANY);
		WebDriver driver=new RemoteWebDriver(new URL(node), ds);
		driver.manage().window().maximize();
		driver.get("http://demowebshop.tricentis.com/login");
		WebElement email=driver.findElement(By.id("Email"));
		email.sendKeys("askmail@email.com");
		
		WebElement password=driver.findElement(By.id("Password"));
		password.sendKeys("abc123");
		
		WebElement login=driver.findElement(By.cssSelector("input[value='Log in']"));
		login.click();
		Assert.assertEquals(driver.getTitle(),"Demo Web Shop");
	}
}
