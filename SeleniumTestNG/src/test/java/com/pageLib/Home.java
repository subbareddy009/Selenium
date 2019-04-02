package com.pageLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {
	
	WebDriver driver;
	
	public Home(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(linkText="Register")
     WebElement registerLink;
	
     @FindBy(linkText="Log in")
     WebElement loginLink;
     
     public String clickOnRegisterLnk(){
    	 
    	 registerLink.click();
    	 return driver.getTitle();
     }
     
     public String clickloginlink()
 	{
    	 loginLink.click();
 		return driver.getCurrentUrl();
 	}
     

 
 
}
