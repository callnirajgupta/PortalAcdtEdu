package com.acdt.edu.cucumberstepdefinition;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.acdt.edu.pageobjectmodel.LoginPage;
import com.acdt.edu.pageobjectmodel.SignupPage;
import com.acdt.edu.util.SeleniumUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(LoginStepDefinition.class);


	
	@Then("^verify user navigate to login page$")
	 public void navigateToLoginPage(){
		 LoginPage.validateLoginTitle();
	 }
	
	@When("^user enter email and password and click login button$")
	public void userEnterEmailAndPassword(){
		LOGGER.info("user enter email and password and click login button");
		LoginPage.enterEmailAndPassword(SignupPage.emailAuto, SignupStepDefinition.signupDataTable.get(0).get("Password"));
		//LoginPage.enterEmailAndPassword("automation1606567637458@acdt.edu.gh", "password");
		LoginPage.clickCaptchaCheckBox();
		LoginPage.clickLoginButton();
	}

	
}
