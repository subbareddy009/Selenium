package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.helper.DriverUtility;

public class NewTest6 {
	
	@Test
	public void testLinks() throws InterruptedException
	{
		WebDriver driver=DriverUtility.getDriver("chrome");
		driver.get("http://www.hdfcbank.com/");
		driver.manage().window().maximize();
		Actions act1=new Actions(driver);
		act1.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products']"))).perform();
		Thread.sleep(5000);
		act1.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/cards']"))).perform();
		Thread.sleep(5000);
		act1.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/cards/credit_cards']"))).click().perform();
		Assert.assertTrue(driver.getCurrentUrl().contains("cards"));
		//driver.findElement(By.xpath("//a[@href='/personal/products/cards/credit_cards']")).click();
	}

}
