package com.acdt.edu.cucumberstepdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

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
		for (int i = 0; i < dataTable.size(); i++) {

			PersonalDetailsPage.personalDetailFilling(dataTable.get(i).get("Image"), dataTable.get(i).get("Title"),
					dataTable.get(i).get("FirstName"), dataTable.get(i).get("MiddleName"),
					dataTable.get(i).get("LastName"), dataTable.get(i).get("OtherName"), dataTable.get(i).get("Gender"),
					dataTable.get(i).get("DOB"), dataTable.get(i).get("CountryOfBirth"),
					dataTable.get(i).get("CityOfBirth"), dataTable.get(i).get("Nationality"),
					dataTable.get(i).get("Religion"), dataTable.get(i).get("HomeTown"), dataTable.get(i).get("Region"),
					dataTable.get(i).get("SpecialNeed"), dataTable.get(i).get("Comment"));
			try {
				String appError = PersonalDetailsPage.getErrorMessage();

				if (!appError.equals(dataTable.get(i).get("Message"))) {
					list.add(dataTable.get(i).get("Message"));
					flag = false;
					LOGGER.info("The Error message is matching as " + dataTable.get(i).get("Message"));
				} else {
					LOGGER.error("The Error message is Not matching as " + dataTable.get(i).get("Message"));
				}
			} catch (Exception e) {
				list.add(dataTable.get(i).get("Message"));
				flag = false;
				LOGGER.error("The Error message is Not displaying  as " + dataTable.get(i).get("Message"));
			}
			SeleniumUtil.refreshPage();
			Thread.sleep(2000);
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

	}

	@Then("^User should navigate to contact information page$")
	public void userNavigatetoContactInformationPage() {
		ContactInformationPage.validateContactInformationTitle();
	}
}
