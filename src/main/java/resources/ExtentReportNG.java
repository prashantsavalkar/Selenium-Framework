package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	// ExtentSparkReport // ExtentReport
	
		public static ExtentReports ExtentReports() {
			//html -> index.html
			String path = System.getProperty("user Dir") + "//reports//index.html";
			
			ExtentSparkReporter reporter = new ExtentSparkReporter(path); 
		reporter.config().setDocumentTitle("Test Report");
		reporter.config().setReportName("Automation Test Report");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Prashant Savalkar");
	
		return extent;
		}

}
