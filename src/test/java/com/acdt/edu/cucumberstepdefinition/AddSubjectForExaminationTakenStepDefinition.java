package com.acdt.edu.cucumberstepdefinition;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.acdt.edu.pageobjectmodel.AddSubjectForExamination;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddSubjectForExaminationTakenStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(ContactInformationStepDefinition.class);
	
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
}
