package com.aucdt.edu.cucumberstepdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

import com.aucdt.edu.commonstep.GlobalStepDefinition;
import com.aucdt.edu.pageobjectmodel.ApplicationSummaryPage;
import com.aucdt.edu.pageobjectmodel.RefereePage;
import com.aucdt.edu.util.SeleniumUtil;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class RefereeStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(RefereeStepDefinition.class);
	public static List<Map<String,String>> refereeDataTable = new ArrayList<Map<String,String>>() ;
	
	@When("user enter mandatory fields data in Referee page and validate error message$")
	public void enterMandatoyFieldDataRefereePageAndValidationMessage(List<Map<String, String>> dataTable){
		LOGGER.info("user enter mandatory fields data in Financing Your Study page and validate error message");
		List<String> list = new ArrayList<String>();
		boolean flag = true;
		for (int i = 0; i < dataTable.size(); i++) {
			if(i!=0){
				SeleniumUtil.refreshPage();
			}
			RefereePage.fillingDataInRefereePage(dataTable.get(i).get("Title"),dataTable.get(i).get("Position"),dataTable.get(i).get("FullName") ,dataTable.get(i).get("Email") ,dataTable.get(i).get("Occupation") ,dataTable.get(i).get("Date"),dataTable.get(i).get("Signature") );
			RefereePage.clickPreviewButton();
			
			try {
				SeleniumUtil.wait(2000);
				
	            Assert.assertEquals("The Error message is Not matching ", dataTable.get(i).get("Message"), RefereePage.getErrorMessage());
				
			} catch (AssertionError e) {
				list.add(dataTable.get(i).get("Message"));
				flag = false;
				LOGGER.error("The Error message is Not displaying  as " + dataTable.get(i).get("Message"));
				SeleniumUtil.failTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), " Error message is not matching");
			    if(SeleniumUtil.getWebElements(ApplicationSummaryPage.APPLICATION_SUMMARY_HEADER_XPATH).size()>0){
			    	SeleniumUtil.getDriver().navigate().back();
			    }
			}catch(Exception e){
				flag = false;
				SeleniumUtil.failTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), " Error message is not matching");
				 if(SeleniumUtil.getWebElements(ApplicationSummaryPage.APPLICATION_SUMMARY_HEADER_XPATH).size()>0){
				    	SeleniumUtil.getDriver().navigate().back();
				    }
			}
			
		}

		Assert.assertTrue("The error message is not matching for Referee page" + list, flag);
	}
	
	
	@When("^user enter mandatory fields data in Referee page$")
	public void userEnterMandatoryFields_DataInRefereePage(List<Map<String, String>> dataTable){
		LOGGER.info("user enter mandatory fields data in Referee page");
		refereeDataTable = dataTable;
		RefereePage.fillingDataInRefereePage(dataTable.get(0).get("Title"),dataTable.get(0).get("Position"),dataTable.get(0).get("FullName") ,dataTable.get(0).get("Email") ,dataTable.get(0).get("Occupation") ,dataTable.get(0).get("Date"),dataTable.get(0).get("Signature") );
	}
	
	@When("^user click Preview button$")
	public void userClickPreviewButton(){
		LOGGER.info("user click Preview button");
		RefereePage.clickPreviewButton();
	}
	
    @Then("^verify that user navigation to Application Summary page$")
    public void user_navigation_to_Application_Summary_page(){
    	LOGGER.info("verify that user navigation to Application Summary page");
    	ApplicationSummaryPage.validateApplicationSummaryTitle();
    }
    
    @When("^user click on previous button in Referee page$")
    public void userClickOnPreviousButtonInRefereePage(){
    	LOGGER.info("user click on previous button in Referee page");
    	RefereePage.clickPreviousButton();
    }
    
    @Then("validate that Referee page filled data persist")
    public void validateThatRefereePageFilledDataPersist(){
    	boolean flag=false;
		try {
			SeleniumUtil.wait(5000);
			Assert.assertEquals("The Title is not matching",RefereePage.getTitleFilledText(),
					refereeDataTable.get(0).get("Title").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			
			Assert.assertEquals("The Position is not matching",RefereePage.getPositionFilledText(),
					refereeDataTable.get(0).get("Position"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
      try {
			Assert.assertEquals("The FullName is not matching",RefereePage.getFullNameFilledText(),
					refereeDataTable.get(0).get("FullName"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
      
      try {
			Assert.assertEquals("The Email is not matching",RefereePage.getEmailFilledText(),
					refereeDataTable.get(0).get("Email"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
      
      try {
			Assert.assertEquals("The Occupation  is not matching",RefereePage.getOccupationFilledText(),
					refereeDataTable.get(0).get("Occupation"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
	  
      try {
			Assert.assertEquals("The Date  is not matching",RefereePage.getDateFilledText(),
					refereeDataTable.get(0).get("Date"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
      
      try {
			Assert.assertEquals("The Signature  is not matching",RefereePage.getSignatureFilledText(),
					refereeDataTable.get(0).get("Signature"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		Assert.assertFalse("The Referee Page filled data is not Matching",flag);
    	
    }
}
