package com.acdt.edu.cucumberstepdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

import com.acdt.edu.pageobjectmodel.ApplicationSummaryPage;
import com.acdt.edu.pageobjectmodel.FinancingYourStudyPage;
import com.acdt.edu.pageobjectmodel.RefereePage;
import com.acdt.edu.util.SeleniumUtil;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class RefereeStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(RefereeStepDefinition.class);
   
	@When("user enter mandatory fields data in Referee page and validate error message$")
	public void enterMandatoyFieldDataRefereePageAndValidationMessage(List<Map<String, String>> dataTable){
		LOGGER.info("user enter mandatory fields data in Financing Your Study page and validate error message");
		List<String> list = new ArrayList<String>();
		boolean flag = true;
		for (int i = 0; i < dataTable.size(); i++) {
			if(i!=0){
				SeleniumUtil.refreshPage();
			}
			RefereePage.fillingDataInRefereePage(dataTable.get(i).get("Title"),dataTable.get(i).get("Position"),dataTable.get(i).get("FullName") ,dataTable.get(i).get("Email") ,dataTable.get(i).get("Occupation") ,dataTable.get(i).get("Date") );
			RefereePage.clickPreviewButton();
			try {
				String appError = RefereePage.getErrorMessage();
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

		Assert.assertTrue("The error message is not matching for Referee page" + list, flag);
	}
	
	
	@When("^user enter mandatory fields data in Referee page$")
	public void userEnterMandatoryFields_DataInRefereePage(List<Map<String, String>> dataTable){
		LOGGER.info("user enter mandatory fields data in Referee page");
		
		RefereePage.fillingDataInRefereePage(dataTable.get(0).get("Title"),dataTable.get(0).get("Position"),dataTable.get(0).get("FullName") ,dataTable.get(0).get("Email") ,dataTable.get(0).get("Occupation") ,dataTable.get(0).get("Date") );
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
}
