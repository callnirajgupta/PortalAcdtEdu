package com.acdt.edu.cucumberstepdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.acdt.edu.pageobjectmodel.ExaminationSubject;
import com.acdt.edu.pageobjectmodel.ExaminationPage;
import com.acdt.edu.pageobjectmodel.FinancingYourStudyPage;
import com.acdt.edu.pageobjectmodel.InstructionPage;
import com.acdt.edu.util.SeleniumUtil;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExaminationSubjectStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(ExaminationSubjectStepDefinition.class);
	
	
    @Then("^verify that default subject is displayed as \"([^\"]*)\" and \"([^\"]*)\"$")
    public void verifyDefaultSubjectNotDeleted(String subject1, String subject2){
    	ExaminationSubject.validateDefaultSubjectDisplay(subject1,subject2);
    }
    
    
    
    @When("^user enter mandatory fields data in Examination Subject Page and validate error message$")
    public void verifyMandatoryFieldForAddSubjectForExaminationTaken(List<Map<String, String>> dataTable){
    	
    	LOGGER.info("user enter mandatory fields data in Add Subject for Examination Taken Page and validate error message");
		List<String> list = new ArrayList<String>();
		boolean flag = true;
		for (int i = 0; i < dataTable.size(); i++) {
			if(i!=0){
				SeleniumUtil.refreshPage();
			}
			ExaminationSubject.enterMandatoryFieldForExaminationSubjectTaken(
					 dataTable.get(i).get("Grade1"),
					dataTable.get(i).get("Grade2"),dataTable.get(i).get("Subject3"),dataTable.get(i).get("Grade3"),dataTable.get(i).get("Subject4"),dataTable.get(i).get("Grade4"),dataTable.get(i).get("Subject5"),dataTable.get(i).get("Grade5"),dataTable.get(i).get("Subject6"),dataTable.get(i).get("Grade6"));

			ExaminationSubject.clickNextButton();
			try {
				String appError = ExaminationSubject.getErrorMessage();
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
    
    
    
    @When("^user enter mandatory fields data in Examination Subject Page$")
    public void enterfieldsdataExaminationSubjectTakenPage(List<Map<String, String>> dataTable){
    	ExaminationSubject.enterMandatoryFieldForExaminationSubjectTaken(
				 dataTable.get(0).get("Grade1"),
				dataTable.get(0).get("Grade2"),dataTable.get(0).get("Subject3"),dataTable.get(0).get("Grade3"),dataTable.get(0).get("Subject4"),dataTable.get(0).get("Grade4"),dataTable.get(0).get("Subject5"),dataTable.get(0).get("Grade5"),dataTable.get(0).get("Subject6"),dataTable.get(0).get("Grade6"));

    }
    @Then("^verify that user navigation to Financing Your Study page$")
    public void navigatetoFinancingYourStudyPage(){
    	
    	FinancingYourStudyPage.validateFinancingYourStudyTitle();
    	
    }
    
    @When("^user click on follow this link For more information on admission requirements$")
    public void userClickOnFollowThisLink(){
    	ExaminationSubject.clickInstructionLink();
    }
    @When("^verify that user navigate to Instruction page in new tab$")
    public void Then_verify_that_user_navigate_to_Instruction_page(){
    	(new WebDriverWait(SeleniumUtil.getDriver(), 30)).until(ExpectedConditions.numberOfWindowsToBe(2));
    	String parentWindow=SeleniumUtil.getDriver().getWindowHandle();
    	Set<String> ListWindow=SeleniumUtil.getDriver().getWindowHandles();
    	for(String window:ListWindow){
    		if(!parentWindow.equals(window)){
    			SeleniumUtil.getDriver().switchTo().window(window);
    			InstructionPage.validateInstructionTitle();
    			SeleniumUtil.getDriver().close();
    			SeleniumUtil.getDriver().switchTo().window(parentWindow);
    		}
    	}
    	
    }
}
