package com.pageLib;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.CacheLookup;

public class Register {
	
WebDriver driver;
	
	public Register(WebDriver driver) {
		this.driver = driver;
	}
	
	
    @FindBy(id="gender-male")
    WebElement genderMale;
  
    @FindBy(id="gender-female")
    WebElement genderFemale;
 
    @FindBy(id="FirstName")
    WebElement  firstName;
 
    @FindBy(id="LastName")
    WebElement  lastName;
 
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmpassword;
	
	@FindBy(id="register-button")
	WebElement register;
	
	@FindBy(xpath="//div[@class='gender']//label")
	WebElement gender;
	@FindBy(linkText="Log out")
	@CacheLookup
	WebElement logout;
	
	public String registersubmit()
	{
		genderMale.click();
		firstName.sendKeys("Subba");
		lastName.sendKeys("Nani");
		email.sendKeys("SubbaNani@test.com");
		password.sendKeys("abc123");
		confirmpassword.sendKeys("abc123");
		register.click();
		return "registration completed";
	}
	
	public void clickLogout()
	{
		logout.click();
	}
 
}
