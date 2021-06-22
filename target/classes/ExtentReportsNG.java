package resources;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;


public class ExtentReportsNG {
	static ExtentReports extent;
	public static ExtentReports getReportObject() {
		
		
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter. config().setReportName("Web Automation results");
		reporter. config().setDocumentTitle("test results");
		extent = new ExtentReports();
		extent. attachReporter(reporter);
		extent.setSystemInfo("tester","PM");
		return  extent;
	}
	

}
