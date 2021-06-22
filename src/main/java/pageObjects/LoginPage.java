package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	//create constructor to send an argument 
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this. driver = driver;
	}

	//By loginBtn = By.className("theme-btn register-btn");
	By email = By.cssSelector("[id*='user_email']");
	By password = By.cssSelector("[id = 'user_password']");
	By logBtn = By. name("commit");
	
	public WebElement getEmail() {
		return driver.findElement(email);		
		}
	public WebElement getPassword() {
		return driver.findElement(password);		
		}
	public WebElement getLogBtn() {
		
		return driver.findElement(logBtn);
	}
	
	
//all objects of landing page to be created here
	
	

}
