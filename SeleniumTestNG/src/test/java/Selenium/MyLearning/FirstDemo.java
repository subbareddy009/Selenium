package Selenium.MyLearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstDemo {

	@Test
	public void test(){
		
		WebDriver driver=new LaunchDriver().getPgDriver("chrome");
		
		driver.get("https://www.google.com");
	}
}
