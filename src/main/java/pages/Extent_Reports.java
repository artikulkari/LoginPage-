package pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestBase;

public class Extent_Reports extends TestBase {
	
	static ExtentReports report;
	public static ExtentReports getReportInstance() {
		
		if(report==null) {
		String reportName=new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("C:\\Users\\Lenovo\\eclipse-workspace\\OctoberbatchMavenProjectsAutomation\\Extent_Reports\\"+reportName+".html");
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("os", "windows");
		report.setSystemInfo("Environment", "SIT");
		report.setSystemInfo("build_no", "101.02.02.124");
		report.setSystemInfo("browser", "edge");
		htmlReporter.config().setDocumentTitle("UI testing documents");
		htmlReporter.config().setReportName("UI Test Report");
		}
		return report;
	}
	
	

}
