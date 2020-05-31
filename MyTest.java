package Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class MyTest {
	WebDriver driver;
  @Test (priority=2)
  public void validlogin() {
	  WebElement text = driver.findElement(By.xpath("//td[@id='headerContainer']"));
	  Reporter.log(text.getText(),true);
	  driver.findElement(By.name("username")).sendKeys("admin");
	  driver.findElement(By.name("pwd")).sendKeys("manager");
	  driver.findElement(By.xpath("//a[@id='loginButton']")).click();
	  String asd = driver.findElement(By.xpath("//td[text()='Enter Time-Track']")).getText();
	  Reporter.log(asd , true);
  }
  @Test (priority=1)
  public void invalidlogin()
  {
	  WebElement text = driver.findElement(By.xpath("//td[@id='headerContainer']"));
	  Reporter.log(text.getText(),true);
	  driver.findElement(By.name("username")).sendKeys("admin");
	  driver.findElement(By.name("pwd")).sendKeys("mange");
	  driver.findElement(By.xpath("//a[@id='loginButton']")).click();
	  String aa = driver.findElement(By.xpath("//span[text()='Username or Password is invalid. Please try again.']")).getText();
	  Reporter.log(aa , true);
	  
  }
  
  @Test(priority=3)
  public void createuser()
  {
	  driver.findElement(By.name("username")).sendKeys("admin");
	  driver.findElement(By.name("pwd")).sendKeys("manager");
	  driver.findElement(By.xpath("//a[@id='loginButton']")).click();
	  driver.findElement(By.xpath("//div[text()='Users']/following-sibling::img")).click();
	  driver.findElement(By.xpath("//span[text()='Create New User']")).click();
	  driver.findElement(By.cssSelector("input[type='submit']")).click();
	  String actual = driver.findElement(By.xpath("(//span[@class='errormsg'])[1]")).getText();
	  String expected = "All fields marked with * must be filled in. Please specify: Username, Password, Retype Password, First Name, Last Name, E-mail Address.";
	  Assert.assertEquals(actual, expected);
	  Reporter.log(expected,true);	  
  }
  
  @Test(priority=4)
  public void userguide()
  {
	  driver.findElement(By.name("username")).sendKeys("admin");
	  driver.findElement(By.name("pwd")).sendKeys("manager");
	  driver.findElement(By.xpath("//a[@id='loginButton']")).click();
	  driver.findElement(By.xpath("//span[text()='Help & Support']")).click();
	  driver.findElement(By.xpath("((//div[@id='supportMenu']//tbody)[2]//td/div/div)[1]")).click();
	  Set<String> windows = driver.getWindowHandles();
	  Iterator<String> winid = windows.iterator();
	  String parentid = winid.next();
	  String childid = winid.next();
	  driver.switchTo().window(childid);
	  WebElement value = driver.findElement(By.xpath("((//a[@id='focusLink']/parent::div//tbody//td)[3]//a)[1]"));
	  String vl = value.getText();
	  Reporter.log(vl, true);
	  
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "./exe2/chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://desktop-pcdd7if/login.do");
	  driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  Reporter.log(" Browser closed ", true);
  }
  

}
