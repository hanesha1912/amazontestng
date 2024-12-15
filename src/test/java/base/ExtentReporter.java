package base;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentReporter extends BaseTest {
	
	public static ExtentReports extent;
	public static String reportpath;
	
	
	public static ExtentReports getReportObject() {
		
	reportpath = System.getProperty("user.dir")+"/Reports/" + "TestReport.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(reportpath).viewConfigurer().viewOrder().as(new ViewName[] {ViewName.DASHBOARD,ViewName.TEST}).apply();
	reporter.config().setDocumentTitle("Amazon Test Report");
	reporter.config().setReportName("Test Report");
	reporter.config().setTheme(Theme.STANDARD);
	
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("QA","Hanesha");
	extent.setSystemInfo("Environment","Staging/UAT");
	extent.setSystemInfo("Approver","ManagementName");
	extent.setSystemInfo("OS","Windows");
	extent.setSystemInfo("Version","10.0");
	
	return extent;
	
	}
	
}