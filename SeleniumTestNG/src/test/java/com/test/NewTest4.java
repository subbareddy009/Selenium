package com.test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest4 {
	
	@Test
	public void testGoogleApps()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a[title='Google apps']")).click();
		WebElement ul=driver.findElement(By.xpath("//div[@aria-label='Google apps']/ul"));	
		List<WebElement> list=ul.findElements(By.tagName("li"));
		System.out.println("The count of apps"+list.size());
		//Assert.assertEquals(list.size(),14);
		for(WebElement e:list)
		{
			if(e.getText().contains("Play"))
			{
				e.click();
				break;
			}
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("play"));
	}
}
