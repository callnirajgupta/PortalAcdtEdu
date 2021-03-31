package com.acdt.edu.cucumberstepdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.acdt.edu.commonstep.GlobalStepDefinition;
import com.acdt.edu.pageobjectmodel.ContactInformationPage;
import com.acdt.edu.pageobjectmodel.PersonalDetailsPage;
import com.acdt.edu.util.SeleniumUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PersonalDetailsStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(PersonalDetailsStepDefinition.class);
	public static List<Map<String,String>> PersonalDataTable= new ArrayList<Map<String,String>>();
	
	 @Then("^verify that fields \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" are prefilled from Signup page$")
	public void verify_that_fields_and_and_and_are_prefilled_from_previous(String firstName, String surname,
			String gender, String country) throws Throwable {
		LOGGER.info("Verify that fields are prefilled from Signup page");
		PersonalDetailsPage.validatePrefilledFieldsFromSignUpPage(firstName, surname, gender, country);
	}

	@When("^user enter mandatory data in personal details page for following fields and validate error message$")
	public void user_enter_mandatory_data_in_personal_details_page_for_field(List<Map<String, String>> dataTable)
			throws Throwable {
		LOGGER.info("user enter mandatory data in personal details page for following fields");
		List<String> list = new ArrayList<String>();
		boolean flag = true;
		SeleniumUtil.getDriver().manage().deleteAllCookies();
		Thread.sleep(5000);
		SeleniumUtil.refreshPage();
		Thread.sleep(5000);
		PersonalDetailsPage.personalDetailClear(dataTable.get(0).get("Image"), dataTable.get(0).get("Title"),
				dataTable.get(0).get("FirstName"), dataTable.get(0).get("MiddleName"),
				dataTable.get(0).get("LastName"), dataTable.get(0).get("OtherName"), dataTable.get(0).get("Gender"),
				dataTable.get(0).get("DOB"), dataTable.get(0).get("CountryOfBirth"),
				dataTable.get(0).get("CityOfBirth"), dataTable.get(0).get("Nationality"),
				dataTable.get(0).get("Religion"), dataTable.get(0).get("HomeTown"), dataTable.get(0).get("Region"),
				dataTable.get(0).get("SpecialNeed"), dataTable.get(0).get("Comment"));
		for (int i = 0; i < dataTable.size(); i++) {
			SeleniumUtil.getDriver().manage().deleteAllCookies();
			Thread.sleep(5000);
			SeleniumUtil.refreshPage();
			Thread.sleep(5000);
			SeleniumUtil.scrollUp();
			
			PersonalDetailsPage.personalDetailFilling(dataTable.get(i).get("Image"), dataTable.get(i).get("Title"),
					dataTable.get(i).get("FirstName"), dataTable.get(i).get("MiddleName"),
					dataTable.get(i).get("LastName"), dataTable.get(i).get("OtherName"), dataTable.get(i).get("Gender"),
					dataTable.get(i).get("DOB"), dataTable.get(i).get("CountryOfBirth"),
					dataTable.get(i).get("CityOfBirth"), dataTable.get(i).get("Nationality"),
					dataTable.get(i).get("Religion"), dataTable.get(i).get("HomeTown"), dataTable.get(i).get("Region"),
					dataTable.get(i).get("SpecialNeed"), dataTable.get(i).get("Comment"));
			PersonalDetailsPage.clickNextButton();
			try {
				SeleniumUtil.wait(2000);
				
                Assert.assertEquals("The Error message is Not matching ", dataTable.get(i).get("Message"), PersonalDetailsPage.getErrorMessage());
				
			} catch (AssertionError e) {
				list.add(dataTable.get(i).get("Message"));
				flag = false;
				LOGGER.error("The Error message is Not displaying  as " + dataTable.get(i).get("Message"));
				SeleniumUtil.failTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), " Error message is not matching");
			    if(SeleniumUtil.getWebElements(By.xpath(ContactInformationPage.CONTACT_INORMATION_TITLE_XPATH)).size()>0){
			    	SeleniumUtil.getDriver().navigate().back();
			    }
			    

			    
			}catch(Exception e){
				flag = false;
				SeleniumUtil.failTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), " Error message is not matching");
			}
			
			
		}

		Assert.assertTrue("The error message is not matching" + list, flag);

	}

	@When("^user enter mandatory data in personal details page for following fields$")
	public void PersonalDetailsMandatory(List<Map<String, String>> dataTable) throws Throwable {
		PersonalDataTable=dataTable;
		PersonalDetailsPage.personalDetailFilling(dataTable.get(0).get("Image"), dataTable.get(0).get("Title"),
				dataTable.get(0).get("FirstName"), dataTable.get(0).get("MiddleName"), dataTable.get(0).get("LastName"),
				dataTable.get(0).get("OtherName"), dataTable.get(0).get("Gender"), dataTable.get(0).get("DOB"),
				dataTable.get(0).get("CountryOfBirth"), dataTable.get(0).get("CityOfBirth"),
				dataTable.get(0).get("Nationality"), dataTable.get(0).get("Religion"), dataTable.get(0).get("HomeTown"),
				dataTable.get(0).get("Region"), dataTable.get(0).get("SpecialNeed"), dataTable.get(0).get("Comment"));
		PersonalDetailsPage.clickNextButton();
		
	}
	
	@When("^user enter fields data in personal details page for following fields$")
	public void EnterfieldsDataInPersonalDetailsPage(List<Map<String, String>> dataTable) throws Throwable{
		
		PersonalDetailsPage.personalDetailFilling(dataTable.get(0).get("Image"), dataTable.get(0).get("Title"),
				dataTable.get(0).get("FirstName"), dataTable.get(0).get("MiddleName"), dataTable.get(0).get("LastName"),
				dataTable.get(0).get("OtherName"), dataTable.get(0).get("Gender"), dataTable.get(0).get("DOB"),
				dataTable.get(0).get("CountryOfBirth"), dataTable.get(0).get("CityOfBirth"),
				dataTable.get(0).get("Nationality"), dataTable.get(0).get("Religion"), dataTable.get(0).get("HomeTown"),
				dataTable.get(0).get("Region"), dataTable.get(0).get("SpecialNeed"), dataTable.get(0).get("Comment"));
	}

	@Then("^User should navigate to contact information page$")
	public void userNavigatetoContactInformationPage() {
		ContactInformationPage.validateContactInformationTitle();
	}
	
	@When("^user click on logout buttton$")
	public void clickLogoutButton(){
		PersonalDetailsPage.ClickLogoutInPersonalDetailPage();
	}
	
	@Then("^validate that personal details filled data persist$")
	public void validateThatPersonalDetailsFilledDataPersist(){
		LOGGER.info("validate that personal details filled data persist");
		SeleniumUtil.wait(3000);
		boolean flag=false;
		try {
			Assert.assertEquals("The Title is not matching", PersonalDetailsPage.getFilledTitleText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Title").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			Assert.assertTrue("The Photo is not matching", PersonalDetailsPage.validateuploadedPassportPhoto().contains(PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Image")));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			Assert.assertEquals("The FirstName is not matching", PersonalDetailsPage.getFilledFirstNameText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("FirstName"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		try {
			Assert.assertEquals("The MiddleName is not matching", PersonalDetailsPage.getFilledMiddleNameText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("MiddleName"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			Assert.assertEquals("The LastName is not matching", PersonalDetailsPage.getFilledSurNameText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("LastName"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			Assert.assertEquals("The OtherName is not matching", PersonalDetailsPage.getFilledOtherNameText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("OtherName"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			Assert.assertEquals("The Gender is not matching", PersonalDetailsPage.getFilledGenderText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Gender"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		try {
			//String[] DOB = PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("DOB").split("/");
			Assert.assertEquals("The DOB is not matching", PersonalDetailsPage.getFilledDOBText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("DOB"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			Assert.assertEquals("The CountryOfBirth is not matching", PersonalDetailsPage.getFilledCountryOfBirthText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("CountryOfBirth").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			Assert.assertEquals("The CityOfBirth is not matching", PersonalDetailsPage.getFilledPlaceOfBirthText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("CityOfBirth"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			Assert.assertEquals("The Nationality is not matching", PersonalDetailsPage.getFilledNationalityText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Nationality").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		try {
			Assert.assertEquals("The Religion is not matching", PersonalDetailsPage.getFilledReligionText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Religion").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			Assert.assertEquals("The HomeTown is not matching", PersonalDetailsPage.getFilledHomeTownText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("HomeTown"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			Assert.assertEquals("The Region is not matching", PersonalDetailsPage.getFilledRegionText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Region").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		
		try {
			Assert.assertEquals("The SpecialNeed is not matching", PersonalDetailsPage.getFilledSpecialNeedYesText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("SpecialNeed"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		
		try {
			Assert.assertEquals("The Comment is not matching", PersonalDetailsPage.getFilledSpecialNeedCommentText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Comment"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		Assert.assertFalse("The fields data is not matching in personal details page", flag);
	}
}
