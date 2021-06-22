package testPackage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	private static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("driver is initialized");
	}
	
	
	@Test(dataProvider = "getData")
	public void HomePageTest(String Username, String Password) throws IOException {
		
		
		/*if(driver.getTitle(). equalsIgnoreCase("Privacy error")) {
			driver. findElement(By.xpath("//*[@id=\"details-button\"]")).click();
			driver. findElement(By.id("proceed-link")). click();
		}*/
	
		//creating object to class and invoke methods
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");
		LandingPage ldnPage = new LandingPage(driver);
		ldnPage. loginBtn().click();
		log.info("Login button is clicked");
		
		LoginPage lgnPage = new LoginPage(driver);
		lgnPage. getEmail(). sendKeys(Username);
		log.info("Username is enterd");

		lgnPage.getPassword().sendKeys(Password);
		log.info("Password is enterd");

		//System.out.println(text);
		lgnPage.getLogBtn().click();
		log.info("Submit button is pressed");

	}
	
	@DataProvider
	public Object[][] getData() {
		//creating array Object
		//row stands for how many different data types test should run
		//column stands for how many values per test case
		
		Object[][] data = new Object[2][2];
		//row 1
		data[0][0]="unrestricted";
		data[0][1]="123xyz";
		//data[0][2]="unrestricted user";
		
		//row 2
		data[1][0]="restricted";
		data[1][1]="123xyz";
		//data[1][2]="restricted user";
		
		return data;
	}
	
	@AfterTest
	public void browseClose() {
		driver.close();
	}
	
	
}