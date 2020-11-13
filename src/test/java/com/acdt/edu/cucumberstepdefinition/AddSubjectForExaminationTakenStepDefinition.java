package com.acdt.edu.cucumberstepdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

import com.acdt.edu.pageobjectmodel.AddSubjectForExamination;
import com.acdt.edu.pageobjectmodel.ExaminationPage;
import com.acdt.edu.pageobjectmodel.FinancingYourStudyPage;
import com.acdt.edu.util.SeleniumUtil;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddSubjectForExaminationTakenStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(AddSubjectForExaminationTakenStepDefinition.class);
	
	@When("^user add new subject$")
	public void userAddSubject(){
		AddSubjectForExamination.clickAddSubject();
		
	}
    @And("^user delete the newly added subject$")
    public void userDeleteSubject(){
    	AddSubjectForExamination.clickDeleteSubject(2);
    }
    @Then("^verify that default subject is not deleted$")
    public void verifyDefaultSubjectNotDeleted(){
    	AddSubjectForExamination.validateDefaultSubjectDisplay();
    }
    
    @When("^user enter mandatory fields data in Add Subject for Examination Taken Page and validate error message$")
    public void verifyMandatoryFieldForAddSubjectForExaminationTaken(List<Map<String, String>> dataTable){
    	
    	LOGGER.info("user enter mandatory fields data in Add Subject for Examination Taken Page and validate error message");
		List<String> list = new ArrayList<String>();
		boolean flag = true;
		for (int i = 0; i < dataTable.size(); i++) {
			if(i!=0){
				SeleniumUtil.refreshPage();
			}
			AddSubjectForExamination.enterMandatoryFieldForAddSubjectForExaminationTaken(
					dataTable.get(i).get("Subject1"), dataTable.get(i).get("Grade1"),
					dataTable.get(i).get("Subject2"),dataTable.get(i).get("Grade2"));

			AddSubjectForExamination.clickNextButton();
			try {
				String appError = AddSubjectForExamination.getErrorMessage();
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
    
    @Then("^user validate error message for New Subject$")
    public void userValidateErrorMessageForNewSubject(List<Map<String, String>> dataTable){
    	
    	LOGGER.info("user validate error message for New Subject");
		List<String> list = new ArrayList<String>();
		boolean flag = true;
		for (int i = 0; i < dataTable.size(); i++) {
			if(i!=0){
				SeleniumUtil.refreshPage();
			}
			AddSubjectForExamination.clickAddSubject();
			AddSubjectForExamination.enterNewSubjectFieldsForAddSubjectForExaminationTaken(
					dataTable.get(i).get("Grade1"), dataTable.get(i).get("Grade2"),
					dataTable.get(i).get("Subject3"),dataTable.get(i).get("Grade3"));

			AddSubjectForExamination.clickNextButton();
			try {
				String appError = AddSubjectForExamination.getErrorMessage();
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
    
    @When("^user enter mandatory fields data in Add Subject for Examination Taken Page$")
    public void enterMandatoryfieldsdataAddSubjectforExaminationTakenPage(List<Map<String, String>> dataTable){
    	AddSubjectForExamination.enterMandatoryFieldForAddSubjectForExaminationTaken(
				dataTable.get(0).get("Subject1"), dataTable.get(0).get("Grade1"),
				dataTable.get(0).get("Subject2"),dataTable.get(0).get("Grade2"));

    }
    @Then("^verify that user navigation to Financing Your Study page$")
    public void navigatetoFinancingYourStudyPage(){
    	
    	FinancingYourStudyPage.validateFinancingYourStudyTitle();
    	
    }
}
