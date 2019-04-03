package com.test;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.utils.FileUtil;
import com.helper.DriverUtility;

public class NewTest13 {
	ExtentHtmlReporter htmlreporter;
	ExtentReports reports;
	ExtentTest test;
	WebDriver driver;
	@BeforeTest
	public void beforeTest()
	{
		driver=DriverUtility.getDriver("chrome");
		htmlreporter=new ExtentHtmlReporter(System.getProperty
				("user.dir")+"/extent-reports/"+new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-ms").
				format(new Date())+".html");
		reports=new ExtentReports();
		reports.attachReporter(htmlreporter);
		//reports.createTest()

		reports.setSystemInfo("Host Name","Localhost");
		reports.setSystemInfo("Username","aswani.kumar.avilala");


		htmlreporter.config().setReportName("Selenium Test NG Report");
		htmlreporter.config().setTheme(Theme.DARK);
	}
	@AfterTest
	public void afterTest()
	{
		reports.flush();
	}
	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL,MarkupHelper.createLabel(result.getMethod().getMethodName()+" is failed", ExtentColor.RED));
			TakesScreenshot shot=(TakesScreenshot) driver;
			File src=shot.getScreenshotAs(OutputType.FILE);
			try {
				String filepath=System.getProperty("user.dir")+"/screenshots/"+result.getMethod().getMethodName()+".png";
				FileUtils.copyFile(src,new File(filepath));
				test.addScreenCaptureFromPath(filepath,"Demo web SHop title");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if((result.getStatus()==ITestResult.SUCCESS))
				{
			test.log(Status.PASS,MarkupHelper.createLabel(result.getMethod().getMethodName()+" is pass", ExtentColor.GREEN));
				}
	}
	@Test
	public void testPass()
	{
		test=reports.createTest("test pass");
		Assert.assertTrue(true);

	}
	@Test
	public void testFail()
	{
		test=reports.createTest("test fail");
		driver.get("http://demowebshop.tricentis.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("Email")).sendKeys("askmail@email.com");
		driver.findElement(By.id("Passw")).sendKeys("abc123");
		Assert.assertTrue(false);
	}

}
