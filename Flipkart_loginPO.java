package Flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Flipkart_loginPO {
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement usernametext;
	@FindBy(xpath="//input[@type='password']")
	private WebElement passtextbox;
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement loginbtn;

	public Flipkart_loginPO(WebDriver driver)
	
	{
	  PageFactory.initElements(driver, this);	
	}

	public WebElement getUsernametext() {
		return usernametext;
	}

	public WebElement getPasstextbox() {
		return passtextbox;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	
}
