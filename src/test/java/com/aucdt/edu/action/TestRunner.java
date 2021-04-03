
package com.aucdt.edu.action;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.relevantcodes.extentreports.ExtentReports;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/featurefile/", tags = {
		"@FemaleGhana" }, plugin = { "pretty", "html:target/cucumber-html-report",
				"json:target/cucumber.json", "junit:target/cucumber.xml"
				 }, glue = { "com.acdt.edu" })

public class TestRunner {
	public static ExtentReports report;
	public static String reportName;
	@BeforeClass
	public static void beforeClass() {
		reportName = System.getProperty("user.dir")+"/target/test-report.html";
		report=new ExtentReports(reportName);
		
		File ScreenShotDir= new File(System.getProperty("user.dir")+"/src/test/resources/ExtendReportSnap/");
		for(File file:ScreenShotDir.listFiles()){
			file.delete();
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		System.setProperty("currentdate", dateFormat.format(new Date()));
		
	}

	@AfterClass
	public static void afterClass() {
		report.flush();
		/*if (SeleniumUtil.getDriver() != null) {
			
			SeleniumUtil.closeBrowser();
			SeleniumUtil.setDriver(null);
			SeleniumUtil.driverStatus=false;
		}*/

	}
	
	public static ExtentReports getExtentReport() {
		return report;
	}
    

}
