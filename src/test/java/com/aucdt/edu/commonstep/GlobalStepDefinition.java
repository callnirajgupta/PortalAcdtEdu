package com.acdt.edu.commonstep;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.acdt.edu.action.TestRunner;
import com.acdt.edu.util.SeleniumUtil;
import com.relevantcodes.extentreports.ExtentTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;


public class GlobalStepDefinition {
	
	private static final Logger LOGGER = LogManager.getLogger(GlobalStepDefinition.class);
	public static Scenario scenario;
	private static String scenarioName;
	public static ExtentTest extenttest;
	public WebDriver driver=null;

	@Before()
	public void Setup(Scenario scenario) {
		LOGGER.info("Inside Setup method");
		extenttest = TestRunner.getExtentReport().startTest(scenario.getName());
		GlobalStepDefinition.scenario=scenario;
		scenarioName=scenario.getName();
		SeleniumUtil.getInstance();
	
		

	}
	
	
	
	@Given("^user navigates to home page$")
	public void user_navigates_to_Home_page() throws Throwable {
		LOGGER.info("user navigates to login page");
		if (Boolean.FALSE.equals(SeleniumUtil.driverStatus)) {
			SeleniumUtil.getDriver();
			SeleniumUtil.maximizeBrowser();
		}
		SeleniumUtil.launchApplication(SeleniumUtil.getConfigProperties().getProperty("HomePageUrl"));
		SeleniumUtil.ImplicitWait();
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), "Home Page loaded successfully");
		
	}
	
	
	
	@After()
	public void TearDown(Scenario scenario) {
		LOGGER.info("Inside Teardown method");

		if (scenario.isFailed()) {
			LOGGER.debug("###################  i am inside screen shot after fail ####################");
			final byte[] screenshot = ((TakesScreenshot) SeleniumUtil.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
			SeleniumUtil.failTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), "The Step is failed");

		}
		if (SeleniumUtil.getDriver() != null) {
			
			SeleniumUtil.closeBrowser();
			SeleniumUtil.setDriver(null);
			SeleniumUtil.driverStatus=false;
		}

		
	}
	
	public static ExtentTest getExtentTest() {
		return extenttest;
	}
	
	 public static String getScenarioName() {
			return scenarioName;
		}
}
