package com.acdt.edu.cucumberstepdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

import com.acdt.edu.pageobjectmodel.AddSubjectForExamination;
import com.acdt.edu.pageobjectmodel.FinancingYourStudyPage;
import com.acdt.edu.pageobjectmodel.RefereePage;
import com.acdt.edu.util.SeleniumUtil;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FinancingYourStudyStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(FinancingYourStudyStepDefinition.class);
	
  @When("^user enter mandatory fields data in Financing Your Study page and validate error message$")
  public void user_enter_mandatory_fields_data_Financing_Your_Study_page_and_validate_error_message(List<Map<String, String>> dataTable){
	  LOGGER.info("user enter mandatory fields data in Financing Your Study page and validate error message");
		List<String> list = new ArrayList<String>();
		boolean flag = true;
		for (int i = 0; i < dataTable.size(); i++) {
			if(i!=0){
				SeleniumUtil.refreshPage();
			}
			FinancingYourStudyPage.enterDataInFinancingYourStudyDetails(
					dataTable.get(i).get("IntendToFinance"), dataTable.get(i).get("Other"));

			FinancingYourStudyPage.clickNextButton();
			try {
				String appError = FinancingYourStudyPage.getErrorMessage();
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

		Assert.assertTrue("The error message is not matching for Financing Your Study" + list, flag);
  
  }
  
  
  @When("^user enter mandatory fields data in Financing Your Study page$")
  public void user_enter_mandatory_fields_data_in_Financing_Your_Study_page(List<Map<String, String>> dataTable){
	  LOGGER.info("user enter mandatory fields data in Financing Your Study page");
	  FinancingYourStudyPage.enterDataInFinancingYourStudyDetails(
				dataTable.get(0).get("IntendToFinance"), dataTable.get(0).get("Other"));

		
  }
  
  @Then("^verify that user navigation to Referee page$") 
  public void verify_that_user_navigation_to_Referee_page(){
	  RefereePage.validateRefereeTitle();
	  
  }
}
