package com.acdt.edu.cucumberstepdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

import com.acdt.edu.pageobjectmodel.ContactInformationPage;
import com.acdt.edu.pageobjectmodel.EducationalBackgroundPage;
import com.acdt.edu.util.SeleniumUtil;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EducationalBackGround {
	private static final Logger LOGGER = LogManager.getLogger(EducationalBackGround.class);

	@When("^user enter mandatory fields data in Educational Background page and validate error message$")
	public void user_enter_mandatory_fields_data_in_Educational_Background_page_and_validate_error_message(
			List<Map<String, String>> dataTable) throws Throwable {
		LOGGER.info(
				"user enter  mandatory fields data in contact information page for postal address and permanent address and validate error message");
		List<String> list = new ArrayList<String>();
		boolean flag = true;
		for (int i = 0; i < dataTable.size(); i++) {
			if(i!=0){
				SeleniumUtil.refreshPage();
			}
			EducationalBackgroundPage.enterCurrentEducationalBackGroundDetails(
					dataTable.get(i).get("RecentInstitution"), dataTable.get(i).get("City"),
					dataTable.get(i).get("Country"), dataTable.get(i).get("YearOfEntry"),
					dataTable.get(i).get("YearOfCompletion"), dataTable.get(i).get("Qualification"));

			EducationalBackgroundPage.clickNextButtonInEducationalBackGround();
			try {
				String appError = EducationalBackgroundPage.getErrorMessage();
                 System.out.println("print messaeg**************"+appError);
				if (!appError.equals(dataTable.get(i).get("Message"))) {
					list.add(dataTable.get(i).get("Message"));
					flag = false;
					LOGGER.info("Error message is matching as " + dataTable.get(i).get("Message"));
				} else {
					LOGGER.error("Error message is Not matching as " + dataTable.get(i).get("Message"));
				}
			} catch (Exception e) {
				list.add(dataTable.get(i).get("Message"));
				flag = false;
				LOGGER.error("Error message is Not displayed as " + dataTable.get(i).get("Message"));
			}
			
		}

		Assert.assertTrue("The error message is not matching for Current Educational Background" + list, flag);

	}
	
	@When("^user click Add Other Educational Background button$")
	public void user_click_Add_Other_Educational_Background_button() throws Throwable {
		LOGGER.info("user click Add Other Educational Background button");
		EducationalBackgroundPage.clickOtherEducationalBackGroundButton();
	}

	@Then("^verify that Other Educational Background section should display$")
	public void verify_that_Other_Educational_Background_section_should_display() throws Throwable {
		LOGGER.info("verify that Other Educational Background section should display");
		EducationalBackgroundPage.validateOtherEducationalBackgroundTitle();
	}

	@When("^user click on delete section button$")
	public void user_click_on_delete_section_button() throws Throwable {
		LOGGER.info("user click on delete section button");
		
		EducationalBackgroundPage.clickDeleteSectionOtherEducationalBackGroundButton();
	}

	@When("^user click on \"([^\"]*)\" on confirmation popup$")
	public void user_click_on_on_confirmation_popup(String yesNo) throws Throwable {
		LOGGER.info("user click on on confirmation popup");
		
		EducationalBackgroundPage.clickYesNoDeleteOtherEducationalConfirmation(yesNo);
	}


	@Then("^verify that Other Educational Background section should not display$")
	public void verify_that_Other_Educational_Background_section_should_not_display() throws Throwable {
		LOGGER.info("verify that Other Educational Background section should not display");
		EducationalBackgroundPage.validateOtherEducationalBackgroundNotDisplayedTitle();
	
	}

	@When("^user click on \"([^\"]*)\" radio button for Have you ever enrolled in a university$")
	public void user_click_on_radio_button_for_Have_you_ever_enrolled_in_a_university(String yesNo) throws Throwable {
		LOGGER.info("user click on radio button for Have you ever enrolled in a university");
	  
		EducationalBackgroundPage.clickYesNoRadioButton(yesNo);
	}

	@Then("^verify that Previous Attendance at a University section should display$")
	public void verify_that_Previous_Attendance_at_a_Universit_section_should_display() throws Throwable {
		LOGGER.info("verify that Previous Attendance at a Universit section should display");
		EducationalBackgroundPage.validatePreviousAttendanceUniversityTitle();
	}
	
	@Then("^verify that Previous Attendance at a University section should not display$")
	public void verify_that_Previous_Attendance_at_a_Universit_section_should_not_display() throws Throwable {
		LOGGER.info("verify that Previous Attendance at a Universit section should display");
		EducationalBackgroundPage.validatePreviousAttendanceUniversityNotDisplayTitle();
	}


}
