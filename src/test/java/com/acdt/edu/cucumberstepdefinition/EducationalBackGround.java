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
import com.acdt.edu.pageobjectmodel.EducationalBackgroundPage;
import com.acdt.edu.pageobjectmodel.ExaminationPage;
import com.acdt.edu.pageobjectmodel.ParentDetailsPage;
import com.acdt.edu.pageobjectmodel.ProgrammeSelectionPage;
import com.acdt.edu.util.SeleniumUtil;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EducationalBackGround {
	private static final Logger LOGGER = LogManager.getLogger(EducationalBackGround.class);
	public static List<Map<String,String>> educationalBackGroundDataTable = new ArrayList<Map<String,String>>() ;
	
	@When("^user enter mandatory fields data in Educational Background page and validate error message$")
	public void user_enter_mandatory_fields_data_in_Educational_Background_page_and_validate_error_message(
			List<Map<String, String>> dataTable) throws Throwable {
		LOGGER.info(
				"user enter mandatory fields data in Educational Background page and validate error message");
		List<String> list = new ArrayList<String>();
		boolean flag = true;
		for (int i = 0; i < dataTable.size(); i++) {
			if(i!=0){
				SeleniumUtil.refreshPage();
			}
			EducationalBackgroundPage.enterCurrentEducationalBackGroundDetails(
					dataTable.get(i).get("RecentInstitution"), dataTable.get(i).get("City"),
					dataTable.get(i).get("Country"), dataTable.get(i).get("YearOfEntry"),
					dataTable.get(i).get("YearOfCompletion"), dataTable.get(i).get("Qualification"),dataTable.get(i).get("OtherQualification"));

			EducationalBackgroundPage.clickNextButtonInEducationalBackGround();
			
			
			////
			
			try {
				SeleniumUtil.wait(2000);
				
	            Assert.assertEquals("The Error message is Not matching ", dataTable.get(i).get("Message"), EducationalBackgroundPage.getErrorMessage());
				
			} catch (AssertionError e) {
				list.add(dataTable.get(i).get("Message"));
				flag = false;
				LOGGER.error("The Error message is Not displaying  as " + dataTable.get(i).get("Message"));
				SeleniumUtil.failTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), " Error message is not matching");
			    if(SeleniumUtil.getWebElements(By.xpath(ExaminationPage.EXAMINATION_HEADER_XPATH)).size()>0){
			    	SeleniumUtil.getDriver().navigate().back();
			    }
			}catch(Exception e){
				flag = false;
				SeleniumUtil.failTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), " Error message is not matching");
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
	
	@When("^user enter mandatory fields data for current Education Background in Educational Background page$")
		public void mandatoryFieldsForCurrentEducationBackGround(List<Map<String, String>> dataTable) throws InterruptedException{
		
		EducationalBackgroundPage.enterCurrentEducationalBackGroundDetails(
				dataTable.get(0).get("RecentInstitution"), dataTable.get(0).get("City"),
				dataTable.get(0).get("Country"), dataTable.get(0).get("YearOfEntry"),
				dataTable.get(0).get("YearOfCompletion"), dataTable.get(0).get("Qualification"),dataTable.get(0).get("OtherQualification"));

	}

   @When("^user enter mandatory fields data for Other Education Background in Educational Background page and validate error message$")
   public void mandatoryFieldsForOtherEducationBackGround(List<Map<String, String>> dataTable) throws InterruptedException{
	   LOGGER.info(
				"user enter mandatory fields data for Other Education Background in Educational Background page and validate error message");
		List<String> list = new ArrayList<String>();
		boolean flag = true;
		for (int i = 0; i < dataTable.size(); i++) {
			if(i!=0){
				SeleniumUtil.refreshPage();
			}
			EducationalBackgroundPage.enterCurrentEducationalBackGroundDetails(
					"TestCurrentInstitution", "TestCurrentCity",
					"Afghanistan","10/6/1999",
					"10/6/1999", "WASSCE","TestCurrentQualification");
			EducationalBackgroundPage.clickOtherEducationalBackGroundButton();
			EducationalBackgroundPage.validateOtherEducationalBackgroundTitle();
			EducationalBackgroundPage.enterOtherEducationalBackGroundDetails(
					dataTable.get(i).get("OtherInstitution"), dataTable.get(i).get("City"),
					dataTable.get(i).get("Country"), dataTable.get(i).get("YearOfEntry"),
					dataTable.get(i).get("YearOfCompletion"), dataTable.get(i).get("Qualification"),dataTable.get(i).get("OtherQualification"));

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
   
   @When("^user enter mandatory fields data for Previous Education Background in Educational Background page and validate error message$")
   public void mandatoryFieldsForPreviousEducationBackGround(List<Map<String, String>> dataTable) throws InterruptedException{
	   LOGGER.info("user enter mandatory fields data for Previous Education Background in Educational Background page and validate error message");
		List<String> list = new ArrayList<String>();
		boolean flag = true;
		for (int i = 0; i < dataTable.size(); i++) {
			if(i!=0){
				SeleniumUtil.refreshPage();
			}
			EducationalBackgroundPage.enterCurrentEducationalBackGroundDetails(
					"TestCurrentInstitution", "TestCurrentCity",
					"Afghanistan","10/6/1999",
					"10/6/1999", "WASSCE","TestCurrentQualification");
			EducationalBackgroundPage.clickYesNoRadioButton("Yes");
			EducationalBackgroundPage.validatePreviousAttendanceUniversityTitle();
			EducationalBackgroundPage.enterPreviousEducationalBackGroundDetails(
					dataTable.get(i).get("PreviousInstitute"), dataTable.get(i).get("NameUsed"),
					dataTable.get(i).get("DateOfAddmission"), dataTable.get(i).get("Hostel"),
					dataTable.get(i).get("ProgrammeOfStudy"), dataTable.get(i).get("LastYearStudy"),dataTable.get(i).get("ReasonOfLeaving"));
			
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
   
   @When("^user enter fields data in Educational Background page$")
   public void EnterFieldsDataInEducationalBackGround(List<Map<String, String>> dataTable) throws InterruptedException{
		
	   educationalBackGroundDataTable=dataTable;
	   EducationalBackgroundPage.enterCurrentEducationalBackGroundDetails(
				dataTable.get(0).get("RecentInstitution"), dataTable.get(0).get("City"),
				dataTable.get(0).get("Country"), dataTable.get(0).get("YearOfEntry"),
				dataTable.get(0).get("YearOfCompletion"), dataTable.get(0).get("Qualification"),dataTable.get(0).get("OtherQualification"));
   }
   
   @Then("^verify that user navigation to Examination page$")
   public void NavigateToExaminationPage(){
	   ExaminationPage.validateExaminationTitle();
   }
   
   @When("^user enter fields data for other Educational background$")
   public void EnterFieldsDataInOtherEducationalBackGround(List<Map<String, String>> dataTable) throws InterruptedException{
	   EducationalBackgroundPage.enterOtherEducationalBackGroundDetails(
				dataTable.get(0).get("OtherInstitution"), dataTable.get(0).get("City"),
				dataTable.get(0).get("Country"), dataTable.get(0).get("YearOfEntry"),
				dataTable.get(0).get("YearOfCompletion"), dataTable.get(0).get("Qualification"),dataTable.get(0).get("OtherQualification"));
   }
   
   @When("^user enter fields data for previous Educational background$")
   public void EnterFieldsDataInPreviousEducationalBackGround(List<Map<String, String>> dataTable) throws InterruptedException{
	   EducationalBackgroundPage.enterPreviousEducationalBackGroundDetails(
				dataTable.get(0).get("PreviousInstitute"), dataTable.get(0).get("NameUsed"),
				dataTable.get(0).get("DateOfAddmission"), dataTable.get(0).get("Hostel"),
				dataTable.get(0).get("ProgrammeOfStudy"), dataTable.get(0).get("LastYearStudy"),dataTable.get(0).get("ReasonOfLeaving"));
		
   }
   
   @When("^user click on previous button in Educational Background page$")
   public void userclickOnPreviousButtonInEducationalBackgroundPage(){
	   EducationalBackgroundPage.clickPreviousButton();
   }
   
   @Then("^validate that Educational Background page filled data persist$")
   public void validateThatEducationalBackgroundPageFilledDataPersist(){
	   boolean flag=false;
		try {
			SeleniumUtil.wait(5000);
			Assert.assertEquals("The RecentInstitution is not matching",EducationalBackgroundPage.getRecentInstitutionFilledText(),
					educationalBackGroundDataTable.get(0).get("RecentInstitution"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			
			Assert.assertEquals("The City is not matching",EducationalBackgroundPage.getCityFilledText(),
					educationalBackGroundDataTable.get(0).get("City"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		try {
			Assert.assertEquals("The Country is not matching",EducationalBackgroundPage.getCountryFilledText(),
					educationalBackGroundDataTable.get(0).get("Country").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		try {
			Assert.assertEquals("The YearOfEntry is not matching",EducationalBackgroundPage.getYearOfEntryFilledText(),
					educationalBackGroundDataTable.get(0).get("YearOfEntry"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		try {
			Assert.assertEquals("The YearOfCompletion is not matching",EducationalBackgroundPage.getYearOfCompletionFilledText(),
					educationalBackGroundDataTable.get(0).get("YearOfCompletion"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		try {
			Assert.assertEquals("The Qualification is not matching",EducationalBackgroundPage.getQualificationFilledText(),
					educationalBackGroundDataTable.get(0).get("Qualification"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			Assert.assertEquals("The OtherQualification is not matching",EducationalBackgroundPage.getOtherQualificationFilledText(),
					educationalBackGroundDataTable.get(0).get("OtherQualification"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		Assert.assertFalse("The Education BackGround Page filled data is not Matching",flag);
	   
   }
}
