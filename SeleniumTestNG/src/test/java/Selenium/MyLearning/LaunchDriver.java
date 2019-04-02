package Selenium.MyLearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchDriver {
	
	public WebDriver getPgDriver(String browserName){
		if(browserName.equalsIgnoreCase("Chrome")){
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		return new ChromeDriver();
	}
	else if(browserName.equalsIgnoreCase("ie"))
	{
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/Drivers/IEDriverServer.exe");
		return new InternetExplorerDriver();
	}
		else
		return null;	
	}

}
