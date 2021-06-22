package testPackage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class validateTitle extends base {
	private static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("navigated to browser");
	}
	@Test
	public void validateTitleTest() throws IOException {			
		LandingPage ldnPage = new LandingPage(driver);
		//ldnPage.getTitle().getText();
		Assert. assertEquals(ldnPage.getTitle().getText(),"Featured Courses");
		log.info("test is successful");
		Assert. assertTrue(ldnPage.getNavigation(). isDisplayed());
		log.info("test is successful");
		}
	@AfterTest
	public void browseClose() {
		driver.close();
	}
}