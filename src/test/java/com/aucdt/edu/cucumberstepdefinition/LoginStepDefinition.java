package com.acdt.edu.cucumberstepdefinition;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import com.acdt.edu.commonstep.GlobalStepDefinition;
import com.acdt.edu.pageobjectmodel.LoginPage;
import com.acdt.edu.pageobjectmodel.SignupPage;
import com.acdt.edu.util.SeleniumUtil;
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
		
	   SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), "Login page loaded successfully");
		
		LoginPage.enterEmailAndPassword(SignupPage.emailAuto, SignupStepDefinition.signupDataTable.get(0).get("Password"));
		//LoginPage.enterEmailAndPassword("automation1606567637458@acdt.edu.gh", "password");
		LoginPage.clickCaptchaCheckBox();
		
		LoginPage.clickLoginButton();
	}
	
	@When("^user enter email \"([^\"]*)\" and password \"([^\"]*)\" and captcha \"([^\"]*)\" and click login button$")
	public void user_enter_email_and_password_and_captcha_and_click_login_button(String email, String password, String captcha) throws Throwable {
		LOGGER.info("user enter email"+email+" and password " +password+" and and captcha "+captcha+" and click login button"); 
		
		LoginPage.enterEmailAndPassword(email,password);
		if("checked".equalsIgnoreCase(captcha)){
			LoginPage.clickCaptchaCheckBox();	
		}
		
		LoginPage.clickLoginButton();
	
	}

	@Then("^verify login display error message \"([^\"]*)\"$")
	public void verify_application_display_error_message(String message) throws Throwable {
	   LOGGER.info("verify application display error message");
	   LoginPage.getErrorMessage();
	   Assert.assertEquals("error message not matching",message, LoginPage.getErrorMessage());
	   SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), "Login page Error message successfully");
	   
	}
	
	@When("^user click on logout menu$")
	public void ClickLogoutInapplicationSubmition(){
		LoginPage.clickLogoutButton();
	}
}
