package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	public static final ExtentReports extentReports = new ExtentReports();//Prevents creating multiple reports

	public synchronized static ExtentReports createExtentReports() //makes it safe for multi-threaded use—especially when running tests with parallel execution 
	{
	ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");//creating a rich‑HTML reporter that tells ExtentReports where to write the output
	reporter.config().setReportName("7RMartSupermarket");//will set the report title that appears in the report’s top‑navigation bar/tab (above the dashboard) to “7RMartSupermarket”.
	extentReports.attachReporter(reporter);// attaching your HTML reporter (e.g., ExtentSparkReporter) to the main reporting engine
	extentReports.setSystemInfo("Organization", "Obsqura");//
	extentReports.setSystemInfo("Name", " Binsy "); 
	return extentReports;
	}

}
     