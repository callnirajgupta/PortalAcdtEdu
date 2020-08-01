package com.acdt.edu.cucumberstepdefinition;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.acdt.edu.pageobjectmodel.LoginPage;
import com.acdt.edu.util.SeleniumUtil;
import cucumber.api.java.en.Given;


public class LoginScenario {
	private static final Logger LOGGER = LogManager.getLogger(LoginScenario.class);

	@Given("^user navigates to login page \"(.*?)\"$")
	public void user_navigates_to_login_page(String url) throws Throwable {
		LOGGER.info("user navigates to login page" + url);
		if (Boolean.FALSE.equals(SeleniumUtil.driverStatus)) {
			SeleniumUtil.getDriver();
			SeleniumUtil.maximizeBrowser();
		}
		SeleniumUtil.launchApplication(url);
		SeleniumUtil.ImplicitWait();
		LoginPage.validateLoginPageTitle();
		
	}

	
}
