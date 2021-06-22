package resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
	prop = new Properties(); //Properties class
	//Creating variable to pass path of data.properties file
	FileInputStream fis = new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
	prop.load(fis); //loading the file path in prop variable
	
	String browserName = prop.getProperty("browser");
	
	if(browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\new driver\\chromedriver_win32(1)\\chromedriver.exe");
		driver =  new ChromeDriver();
	}
	else if(browserName.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver","E:\\Selenium\\geckodriver.exe");
		driver =  new FirefoxDriver();
	}
	/* else if(browserName.equals("IE"))
	{ 
		System.setProperty("webdriver.ie.driver","C:\\Users\\Hp\\Downloads\\Selenium\\new driver\\chromedriver.exe"); //need to change IE driver path
		WebDriver driver =  new InternetExplorerDriver();	
	} */
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //giving implicit wait 
	return driver;
	//return prop;
}
	
	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".jpeg"; //passing name for failed test +""
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		
	}
	
}
