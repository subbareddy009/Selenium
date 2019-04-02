package com.pageLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	
WebDriver driver;
	
	public Login(WebDriver driver) {
		this.driver = driver;
	}
	

	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(xpath="//*[@value='Log in']")
	WebElement login;
	
	public String loginSubmit()
	{
		email.sendKeys("askmail@email.com");
		password.sendKeys("abc123");
		login.click();
		return driver.getTitle();
	}
	
}
