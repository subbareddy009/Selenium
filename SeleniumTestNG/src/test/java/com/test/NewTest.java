package com.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Selenium.MyLearning.LaunchDriver;
import junit.framework.Assert;

public class NewTest {
	WebDriver driver;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserValue ){
		driver=new LaunchDriver().getPgDriver(browserValue);
		driver.manage().window().maximize();
		driver.get("https://github.com/login");
				}
  @Test(dataProvider="dp1")
  public void f(String userName,String password) {
	  
	  driver.findElement(By.id("login_field")).sendKeys(userName);
	  driver.findElement(By.id("password")).sendKeys(password);
	  driver.findElement(By.name("commit")).click();
	  if(driver.findElement(By.xpath("//*[contains(text(),'Pull requests')]")).isDisplayed()){
		  driver.findElement(By.xpath("//summary//*[@class='avatar float-left mr-1']")).click();
		  driver.findElement(By.xpath("//*[contains(text(),'Sign out')]")).click();
		  driver.findElement(By.xpath("//*[@class='HeaderMenu-link no-underline mr-3']")).click();
	  }
	  
	  else{
		  Assert.assertEquals(driver.getTitle(), "Sign in to GitHub. GitHub");
	  }
  }
  @AfterClass
	public void afterClass(){
		driver.close();
	}
  
  @DataProvider(name="dp")
  public Object[][] getData(){
	  Object[][] obj={{"subbareddy009","Amma@0009"},
			          {"subbareddy009","Amma@0009"}};
	  return obj;
  }
  
  @DataProvider(name="dp1")
  public Object[][] getDataFromExcel(){
	  return ReadingDataFrmXl.testExcelData();
  }
  
}
