package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
		
		        // Creating a path where reports will be stored
				String path = System.getProperty("user.dir")+ "\\reports\\index.html";
				
				//responsible for creating html report file and do some configurations:
				ExtentSparkReporter reporter = new ExtentSparkReporter(path);
				
				// configuration - title of report
				reporter.config().setReportName("Web Automation Results");
			
				//configuration - title of page with all reports
				reporter.config().setDocumentTitle("Test results");
				
				extent = new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester: ", "Jakub Dejneka");
				return extent;
		
	}
}
