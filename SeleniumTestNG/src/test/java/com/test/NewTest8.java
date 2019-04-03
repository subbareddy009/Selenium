package com.test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.helper.DriverUtility;

public class NewTest8 {
	@Test
	public void testClearTrip() throws InterruptedException
	{
		WebDriver driver=DriverUtility.getDriver("chrome");
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com/");	
		Thread.sleep(5000);
		
		WebElement from=driver.findElement(By.id("FromTag"));
		//from.sendKeys("h");
		//from.sendKeys("y");
		//from.sendKeys("d");
		/*
		 * Actions act1=new Actions(driver);
		 * act1.keyDown(from,Keys.SHIFT).sendKeys(from,"h").perform();
		 * Thread.sleep(3000); act1.sendKeys("y").perform(); Thread.sleep(3000);
		 * act1.keyUp(Keys.SHIFT).perform(); Thread.sleep(3000);
		 * act1.sendKeys("d").perform(); Thread.sleep(3000);
		 * act1.sendKeys(Keys.ENTER).perform();
		 *
		 */
		
		WebElement to=driver.findElement(By.id("ToTag"));
		to.sendKeys("hyd");
		//Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(driver,15);
		//wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.id("ui-id-2"),By.className("list")));
		WebElement ul=driver.findElement(By.id("ui-id-2"));
		List<WebElement> list=ul.findElements(By.tagName("li"));
		
		for(WebElement e:list)
		{
			if(e.getText().contains("HDD"))
			{
				e.click();
				break;
			}
		}
	String val=driver.findElement(By.id("ToTag")).getAttribute("value");
	Assert.assertTrue(val.contains("HDD"));
		/*
		 * Actions act2=new Actions(driver); act2.sendKeys(to,"b").perform();
		 * Thread.sleep(3000); act2.sendKeys("a").perform(); Thread.sleep(3000);
		 * act2.sendKeys("n").perform(); Thread.sleep(3000);
		 * act2.sendKeys(Keys.ARROW_DOWN).perform(); Thread.sleep(3000);
		 * act2.sendKeys(Keys.ENTER).perform();
		 */
	}

}
