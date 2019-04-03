package com.test;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class NewTest5 {
	
	@Test
	public void testHdfc() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.hdfcbank.com/");
		
		  driver.findElement(By.id("loginsubmit")).click();
		  
		  String home=driver.getWindowHandle(); Set<String>
		  set=driver.getWindowHandles(); for(String s:set) { System.out.println(s); }
		  Object[] obj=set.toArray(); driver.switchTo().window(obj[1].toString());
		  driver.manage().window().maximize(); System.out.println(driver.getTitle());
		  driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/a")).click();
		  //driver.switchTo().window(obj[0].toString()); //Thread.sleep(10000);
		  driver.switchTo().frame(driver.findElement(By.name("login_page")));
		  driver.findElement(By.cssSelector("img[alt='continue']")).click();
		  if(ExpectedConditions.alertIsPresent()!=null) { Alert
		  al=driver.switchTo().alert(); System.out.println(al.getText()); al.accept();
		  } driver.findElement(By.name("fldLoginUserId")).sendKeys("567865");
		  driver.close(); driver.switchTo().window(home); driver.close();
		  //driver.quit();
		 	
		}

}
