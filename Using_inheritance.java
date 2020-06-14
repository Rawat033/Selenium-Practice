package Flipkart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Using_inheritance {
	public static WebDriver driver;  // global WebDriver 
	 @BeforeMethod
	  @Parameters({"baseURL"})
	  public void precondition(String baseURL)
	  {
		  System.setProperty("webdriver.chrome.driver","./exe2/chromedriver.exe" );
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		  driver.get(baseURL);
		  
	  }
	  
	  @AfterMethod
	  public void postconbaseURLdition()
	  {
		  driver.close();
		  Reporter.log("Browser closed", true);
	  }

}
