package com.acdt.edu.cucumberstepdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.acdt.edu.pageobjectmodel.ExaminationSubjectPage;
import com.acdt.edu.commonstep.GlobalStepDefinition;
import com.acdt.edu.pageobjectmodel.ExaminationPage;
import com.acdt.edu.pageobjectmodel.FinancingYourStudyPage;
import com.acdt.edu.pageobjectmodel.InstructionPage;
import com.acdt.edu.util.SeleniumUtil;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExaminationSubjectStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(ExaminationSubjectStepDefinition.class);
	public static List<Map<String,String>> examinationSubjectDataTable = new ArrayList<Map<String,String>>() ;
	
    @Then("^verify that default subject is displayed as \"([^\"]*)\" and \"([^\"]*)\"$")
    public void verifyDefaultSubjectNotDeleted(String subject1, String subject2){
    	ExaminationSubjectPage.validateDefaultSubjectDisplay(subject1,subject2);
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
			ExaminationSubjectPage.enterMandatoryFieldForExaminationSubjectTaken(
					 dataTable.get(i).get("Grade1"),
					dataTable.get(i).get("Grade2"),dataTable.get(i).get("Subject3"),dataTable.get(i).get("Grade3"),dataTable.get(i).get("Subject4"),dataTable.get(i).get("Grade4"),dataTable.get(i).get("Subject5"),dataTable.get(i).get("Grade5"),dataTable.get(i).get("Subject6"),dataTable.get(i).get("Grade6"));

			ExaminationSubjectPage.clickNextButton();
			
			//
			
			try {
				SeleniumUtil.wait(2000);
				
	            Assert.assertEquals("The Error message is Not matching ", dataTable.get(i).get("Message"), ExaminationSubjectPage.getErrorMessage());
				
			} catch (AssertionError e) {
				list.add(dataTable.get(i).get("Message"));
				flag = false;
				LOGGER.error("The Error message is Not displaying  as " + dataTable.get(i).get("Message"));
				SeleniumUtil.failTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), " Error message is not matching");
			    if(SeleniumUtil.getWebElements(By.xpath(FinancingYourStudyPage.FINANCING_YOUR_STUDY_HEADER_XPATH)).size()>0){
			    	SeleniumUtil.getDriver().navigate().back();
			    }
			}catch(Exception e){
				flag = false;
				SeleniumUtil.failTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), " Error message is not matching");
			}
			
		}

		Assert.assertTrue("The error message is not matching for Current Educational Background" + list, flag);

    	
    }
    
    
    
    @When("^user enter mandatory fields data in Examination Subject Page$")
    public void enterfieldsdataExaminationSubjectTakenPage(List<Map<String, String>> dataTable){
    	examinationSubjectDataTable = dataTable;
    	ExaminationSubjectPage.enterMandatoryFieldForExaminationSubjectTaken(
				 dataTable.get(0).get("Grade1"),
				dataTable.get(0).get("Grade2"),dataTable.get(0).get("Subject3"),dataTable.get(0).get("Grade3"),dataTable.get(0).get("Subject4"),dataTable.get(0).get("Grade4"),dataTable.get(0).get("Subject5"),dataTable.get(0).get("Grade5"),dataTable.get(0).get("Subject6"),dataTable.get(0).get("Grade6"));

    }
    @Then("^verify that user navigation to Financing Your Study page$")
    public void navigatetoFinancingYourStudyPage(){
    	
    	FinancingYourStudyPage.validateFinancingYourStudyTitle();
    	
    }
    
    @When("^user click on follow this link For more information on admission requirements$")
    public void userClickOnFollowThisLink(){
    	ExaminationSubjectPage.clickInstructionLink();
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
    
    @When("^user click on previous button in Examination Subject page$")
    public void userClickOnPreviousButtonInExaminationSubjectPage(){
    	ExaminationSubjectPage.clickPreviousButton();
    	
    }
    
    @Then("^validate that Examination Subject page filled data persist$")
    public void validateThatExaminationSubjectPageFilledDataPersist(){
    	boolean flag=false;
		try {
			SeleniumUtil.wait(5000);
			Assert.assertEquals("The Grade1 is not matching",ExaminationSubjectPage.getGrade1FilledText(),
					examinationSubjectDataTable.get(0).get("Grade1"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		
		try {
		
			Assert.assertEquals("The Grade2 is not matching",ExaminationSubjectPage.getGrade2FilledText(),
					examinationSubjectDataTable.get(0).get("Grade2"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			
			Assert.assertEquals("The Subject3 is not matching",ExaminationSubjectPage.getSubject3FilledText(),
					examinationSubjectDataTable.get(0).get("Subject3"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			Assert.assertEquals("The Grade3 is not matching",ExaminationSubjectPage.getGrade3FilledText(),
					examinationSubjectDataTable.get(0).get("Grade3"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
       try {	
			Assert.assertEquals("The Subject4 is not matching",ExaminationSubjectPage.getSubject4FilledText(),
					examinationSubjectDataTable.get(0).get("Subject4"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
       
       try {
			Assert.assertEquals("The Grade4 is not matching",ExaminationSubjectPage.getGrade4FilledText(),
					examinationSubjectDataTable.get(0).get("Grade4"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
       
       try {	
			Assert.assertEquals("The Subject5 is not matching",ExaminationSubjectPage.getSubject5FilledText(),
					examinationSubjectDataTable.get(0).get("Subject5"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
      
      try {
			Assert.assertEquals("The Grade5 is not matching",ExaminationSubjectPage.getGrade5FilledText(),
					examinationSubjectDataTable.get(0).get("Grade5"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
      
      try {	
			Assert.assertEquals("The Subject6 is not matching",ExaminationSubjectPage.getSubject6FilledText(),
					examinationSubjectDataTable.get(0).get("Subject6"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
     
     try {
			Assert.assertEquals("The Grade6 is not matching",ExaminationSubjectPage.getGrade6FilledText(),
					examinationSubjectDataTable.get(0).get("Grade6"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
       
		Assert.assertFalse("The Examination Subject Page filled data is not Matching",flag);
    }
}
