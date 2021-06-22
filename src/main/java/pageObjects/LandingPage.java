package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	//create constructor to send an argument 
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this. driver = driver;
	}

	//By loginBtn = By.className("theme-btn register-btn");
	By loginBtn = By.cssSelector("body > app-root > div > header > div.header-top > div > div > div.top-right.clearfix > div:nth-child(3) > a");
	public WebElement loginBtn() {
		return driver.findElement(loginBtn);		
		}
	
	By title = By.cssSelector(".pull-left> h2");
	public WebElement getTitle() {
		return driver.findElement(title);	
	}
	
	By naviBar = By. cssSelector("ul.navigation.clearfix");
	public WebElement getNavigation() {
		return driver.findElement(naviBar);	
	}
	
//all objects of landing page to be created here
	
	

}
