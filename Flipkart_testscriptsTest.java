package Flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Flipkart_testscriptsTest extends Using_inheritance {
  @Test
  public void Search_product() throws InterruptedException {
	  driver.findElement(By.xpath("//button[text()='✕']")).click();
	  Actions act=new Actions(driver);
	  WebElement login = driver.findElement(By.xpath("//a[text()='Login']"));
	  act.moveToElement(login).perform();
	  driver.findElement(By.xpath("//div[text()='My Profile']")).click();
	  Flipkart_loginPO flpo=new Flipkart_loginPO(driver);
	  flpo.getUsernametext().sendKeys("9582830705");
	  flpo.getPasstextbox().sendKeys("karbona26dl5saf7982");
	  flpo.getLoginbtn().click();
	  WebElement name = driver.findElement(By.xpath("(//div[@class='_2aUbKa'])[1]"));
	  Reporter.log(name.getText(), true);
	 }
}
