package com.acdt.edu.commonstep;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.acdt.edu.pageobjectmodel.HomePage;
import com.acdt.edu.pageobjectmodel.SignupPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SignupStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(SignupStepDefinition.class);
	
	@When("^user click on start application button in home page$")
	public void user_click_on_start_application_button() throws Throwable {
		LOGGER.info("user click on start application button in home page");
		HomePage.clickStartApplication();
		
	   
	}

	@When("^user enter mandatory data for field \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enter_mandatory_data_for_field_and_and_and_and_and_and_and_and_and_and(String firstName, String middleName, String lastName, String programme, String gender, String country, String mobile, String email, String password, String confirmPassword, String captcha) throws Throwable {
		LOGGER.info("user enter mandatory data for field");
		SignupPage.validateSignupTitle();
		SignupPage.signup(firstName, middleName, lastName, programme, gender, country, mobile, email, password, confirmPassword, captcha);
	}
	
	@Then("^verify application display error message \"([^\"]*)\"$")
	public void verify_application_display_error_message(String message) throws Throwable {
	   LOGGER.info("verify application display error message");
	   SignupPage.ValidateErrorMessage(message);
	}
	
	@Then("^user select the all country and country code one by one successfully$")
	public void user_select_the_all_country_and_country_code_one_by_one_successfully() throws Throwable {
	 LOGGER.info("user select the all country and country code one by one successfully");
	

     Response response= RestAssured.given().contentType("application/json")
                .get("https://portal.acdt.edu.gh/acdt-dev/countryCodes");
     
    
     
     JsonPath path= new JsonPath(response.asString());
     
     
	 
	}




	@Then("^User should navigate to personal details page$")
	public void user_should_navigate_to_personal_details_page() throws Throwable {
	   
	   
	}

}
