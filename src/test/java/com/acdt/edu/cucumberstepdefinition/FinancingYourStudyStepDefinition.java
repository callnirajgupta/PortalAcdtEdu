package com.acdt.edu.cucumberstepdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import com.acdt.edu.commonstep.GlobalStepDefinition;
import com.acdt.edu.pageobjectmodel.FinancingYourStudyPage;
import com.acdt.edu.pageobjectmodel.RefereePage;
import com.acdt.edu.util.SeleniumUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FinancingYourStudyStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(FinancingYourStudyStepDefinition.class);
	public static List<Map<String,String>> financingYourStudyDataTable = new ArrayList<Map<String,String>>() ;
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
			
			//
			try {
				SeleniumUtil.wait(2000);
				if(i==0){
					Assert.assertEquals("The Error message is Not matching ", dataTable.get(i).get("Message"), FinancingYourStudyPage.getErrorMessage1());	
				}else{
					Assert.assertEquals("The Error message is Not matching ", dataTable.get(i).get("Message"), FinancingYourStudyPage.getErrorMessage2());
				}
	            
				
			} catch (AssertionError e) {
				list.add(dataTable.get(i).get("Message"));
				flag = false;
				LOGGER.error("The Error message is Not displaying  as " + dataTable.get(i).get("Message"));
				SeleniumUtil.failTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), " Error message is not matching");
			    if(SeleniumUtil.getWebElements(By.xpath(RefereePage.REFEREE_HEADER_XPATH)).size()>0){
			    	SeleniumUtil.getDriver().navigate().back();
			    }
			}catch(Exception e){
				flag = false;
				SeleniumUtil.failTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), " Error message is not matching");
				if(SeleniumUtil.getWebElements(By.xpath(RefereePage.REFEREE_HEADER_XPATH)).size()>0){
			    	SeleniumUtil.getDriver().navigate().back();
			    }
			}
			
		}

		Assert.assertTrue("The error message is not matching for Financing Your Study" + list, flag);
  
  }
  
  
  @When("^user enter mandatory fields data in Financing Your Study page$")
  public void user_enter_mandatory_fields_data_in_Financing_Your_Study_page(List<Map<String, String>> dataTable){
	  LOGGER.info("user enter mandatory fields data in Financing Your Study page");
	  financingYourStudyDataTable=dataTable;
	  FinancingYourStudyPage.enterDataInFinancingYourStudyDetails(
				dataTable.get(0).get("IntendToFinance"), dataTable.get(0).get("Other"));

		
  }
  
  @Then("^verify that user navigation to Referee page$") 
  public void verify_that_user_navigation_to_Referee_page(){
	  RefereePage.validateRefereeTitle();
	  
  }
  
  @When("^user click on previous button in Financing Your Study page$")
  public void userClickOnPreviousButtonInFinancingYourStudyPage(){
	  FinancingYourStudyPage.clickPreviousButton();
	  
  }
  
  @Then("^validate that Financing Your Study page filled data persist$")
  public void validateThatFinancingYourStudyPageFilledDatapersist(){
	  boolean flag=false;
		try {
			SeleniumUtil.wait(5000);
			Assert.assertEquals("The IntendToFinance is not matching",FinancingYourStudyPage.getIntendToFinanceFilledText(),
					financingYourStudyDataTable.get(0).get("IntendToFinance").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			
			Assert.assertEquals("The IntendToFinance Other is not matching",FinancingYourStudyPage.getIntendToFinanceOtherFilledText(),
					financingYourStudyDataTable.get(0).get("Other"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
	  
		Assert.assertFalse("The Financing Your Study Page filled data is not Matching",flag);
  }
  
}
