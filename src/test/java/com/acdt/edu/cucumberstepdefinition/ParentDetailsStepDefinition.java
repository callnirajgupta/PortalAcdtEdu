package com.acdt.edu.cucumberstepdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import com.acdt.edu.commonstep.GlobalStepDefinition;
import com.acdt.edu.pageobjectmodel.ParentDetailsPage;
import com.acdt.edu.pageobjectmodel.ProgrammeSelectionPage;
import com.acdt.edu.util.SeleniumUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ParentDetailsStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(ParentDetailsStepDefinition.class);
	public static List<Map<String,String>> parentDetailsDataTable = new ArrayList<Map<String,String>>() ;
	
	@When("^user enter mandatory fields data in parent details page and validate error message$")
	public void parentDetailsMandatoryFieldsAndError(List<Map<String, String>> dataTable) throws Throwable {
		LOGGER.info("user enter mandatory fields data in parent details page and validate error message");
		List<String> list = new ArrayList<String>();
		boolean flag = true;
		for (int i = 0; i < dataTable.size(); i++) {
			if(i!=0){
				SeleniumUtil.refreshPage();
				SeleniumUtil.wait(3000);
			}
			ParentDetailsPage.parentDetailFilling(dataTable.get(i).get("Title"), dataTable.get(i).get("FirstName"),
					dataTable.get(i).get("MiddleName"), dataTable.get(i).get("SurName"),
					dataTable.get(i).get("Relationship"), dataTable.get(i).get("Company"),
					dataTable.get(i).get("Occupation"), dataTable.get(i).get("Address1"),
					dataTable.get(i).get("Address2"), dataTable.get(i).get("Country"), dataTable.get(i).get("CityTown"),
					dataTable.get(i).get("State"), dataTable.get(i).get("Mobile"), dataTable.get(i).get("Telephone"),
					dataTable.get(i).get("Email"), dataTable.get(i).get("PostalCode"));
			ParentDetailsPage.clickNextButton();
			//
			try {
				SeleniumUtil.wait(2000);
				LOGGER.info("Validating error message as "+ dataTable.get(i).get("Message"));
	            Assert.assertEquals("The Error message is Not matching ", dataTable.get(i).get("Message"), ParentDetailsPage.getErrorMessage());
				 
			} catch (AssertionError e) {
				list.add(dataTable.get(i).get("Message"));
				flag = false;
				LOGGER.error("The Error message is Not displaying  as " + dataTable.get(i).get("Message"));
				SeleniumUtil.failTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), " Error message is not matching");
			    if(SeleniumUtil.getWebElements(By.xpath(ProgrammeSelectionPage.PROGRAMME_SELECTION_HEADER_XPATH)).size()>0){
			    	SeleniumUtil.getDriver().navigate().back();
			    }
			}catch(Exception e){
				flag = false;
				list.add(dataTable.get(i).get("Message"));
				SeleniumUtil.failTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), " Error message is not matching");
				LOGGER.error("The Error message is Not displaying  as " + dataTable.get(i).get("Message"));
				if(SeleniumUtil.getWebElements(By.xpath(ProgrammeSelectionPage.PROGRAMME_SELECTION_HEADER_XPATH)).size()>0){
			    	SeleniumUtil.getDriver().navigate().back();
			    }
			} 
			
			
		}

		Assert.assertTrue("The error message is not matching" + list, flag);
		
		
	}
	
	@When("^user enter invalid fields data in parent details page and validate error message$")
	public void invalidDataAndValidationINParentDetailsPage(List<Map<String, String>> dataTable) throws Throwable{
		LOGGER.info("user enter mandatory fields data in parent details page and validate error message");
		List<String> list = new ArrayList<String>();
		boolean flag = true;
		for (int i = 0; i < dataTable.size(); i++) {
			if(i!=0){
				SeleniumUtil.refreshPage();
			}
			ParentDetailsPage.parentDetailFilling(dataTable.get(i).get("Title"), dataTable.get(i).get("FirstName"),
					dataTable.get(i).get("MiddleName"), dataTable.get(i).get("SurName"),
					dataTable.get(i).get("Relationship"), dataTable.get(i).get("Company"),
					dataTable.get(i).get("Occupation"), dataTable.get(i).get("Address1"),
					dataTable.get(i).get("Address2"), dataTable.get(i).get("Country"), dataTable.get(i).get("CityTown"),
					dataTable.get(i).get("State"), dataTable.get(i).get("Mobile"), dataTable.get(i).get("Telephone"),
					dataTable.get(i).get("Email"), dataTable.get(i).get("PostalCode"));
			

			try {
				String appError = ParentDetailsPage.getFieldValidationErrorMessage();
                 System.out.println("print error message");
				if (!appError.equals(dataTable.get(i).get("Message"))) {
					list.add(dataTable.get(i).get("Message"));
					flag = false;
					LOGGER.error("The error message is not matching" + dataTable.get(i).get("Message"));
				} else {
					LOGGER.info("The error message is matching" + dataTable.get(i).get("Message"));
				}
			} catch (Exception e) {
				LOGGER.error("The error message is not displayed as " + dataTable.get(i).get("Message"));
				list.add(dataTable.get(i).get("Message"));
				flag = false;
			}
			
		}

		Assert.assertTrue("The error message is not matching" + list, flag);
		

	}
	

	
	@When("^user enter mandatory fields data in parent details page$")
	public void enterMandatoryFieldsAndNavigateToProgrameSelectionPage(List<Map<String, String>> dataTable) throws Throwable{
		LOGGER.info("user enter mandatory fields data in parent details page");
		parentDetailsDataTable=dataTable;
		for (int i = 0; i < dataTable.size(); i++) {
			
			ParentDetailsPage.parentDetailFilling(dataTable.get(i).get("Title"), dataTable.get(i).get("FirstName"),
					dataTable.get(i).get("MiddleName"), dataTable.get(i).get("SurName"),
					dataTable.get(i).get("Relationship"), dataTable.get(i).get("Company"),
					dataTable.get(i).get("Occupation"), dataTable.get(i).get("Address1"),
					dataTable.get(i).get("Address2"), dataTable.get(i).get("Country"), dataTable.get(i).get("CityTown"),
					dataTable.get(i).get("State"), dataTable.get(i).get("Mobile"), dataTable.get(i).get("Telephone"),
					dataTable.get(i).get("Email"), dataTable.get(i).get("PostalCode"));
			
		}	
	}
	
	@Then("^verify that user navigation to programme selection page$")
	public void navigateToProgrameSelectionPage(){
		LOGGER.info("verify that user navigation to programme selection page");
		ProgrammeSelectionPage.validateProgrammeSelectionTitle();
	}
	
	@When("^user click on previous button in parent details page$")
	public void clickOnPreviousButtonInParentDetails(){
		LOGGER.info("user click on previous button in parent details page");
		ParentDetailsPage.clickPreviousButton();
		
	}
	
	@Then("^validate that particular of parent filled data persist$")
	public void validate_that_particular_of_parent_filled_data_persist(){
		boolean flag=false;
		try {
			SeleniumUtil.wait(5000);
			Assert.assertEquals("The Title is not matching",ParentDetailsPage.getTitleFilledText(),
					parentDetailsDataTable.get(0).get("Title").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			
			Assert.assertEquals("The SurName is not matching",ParentDetailsPage.getSurNameFilledText(),
					parentDetailsDataTable.get(0).get("SurName"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
		
			Assert.assertEquals("The FirstName is not matching",ParentDetailsPage.getFirstNameFilledText(),
					parentDetailsDataTable.get(0).get("FirstName"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			
			Assert.assertEquals("The MiddleName is not matching",ParentDetailsPage.getMiddleNameFilledText(),
					parentDetailsDataTable.get(0).get("MiddleName"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			
			Assert.assertEquals("The Relationship is not matching",ParentDetailsPage.getRelationshipFilledText(parentDetailsDataTable.get(0).get("Relationship")),
					parentDetailsDataTable.get(0).get("Relationship"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			
			Assert.assertEquals("The Company is not matching",ParentDetailsPage.getCompanyFilledText(),
					parentDetailsDataTable.get(0).get("Company"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			
			Assert.assertEquals("The Occupation is not matching",ParentDetailsPage.getOccupationFilledText(),
					parentDetailsDataTable.get(0).get("Occupation"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			
			Assert.assertEquals("The Address1 is not matching",ParentDetailsPage.getAddress1FilledText(),
					parentDetailsDataTable.get(0).get("Address1"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			
			Assert.assertEquals("The Address2 is not matching",ParentDetailsPage.getAddress2FilledText(),
					parentDetailsDataTable.get(0).get("Address2"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			
			Assert.assertEquals("The Country is not matching",ParentDetailsPage.getCountryFilledText(),
					parentDetailsDataTable.get(0).get("Country").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			
			Assert.assertEquals("The CityTown is not matching",ParentDetailsPage.getCityFilledText(),
					parentDetailsDataTable.get(0).get("CityTown"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
        try {
			Assert.assertEquals("The State is not matching",ParentDetailsPage.getStateFilledText(),
					parentDetailsDataTable.get(0).get("State"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
        
        /*try {
			Assert.assertEquals("The Mobile is not matching",ParentDetailsPage.getMobileFilledText(),
					parentDetailsDataTable.get(0).get("Mobile"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
        
        try {
			Assert.assertEquals("The Telephone is not matching",ParentDetailsPage.getTelephoneFilledText(),
					parentDetailsDataTable.get(0).get("Telephone"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}*/
        
        try {
			Assert.assertEquals("The Email is not matching",ParentDetailsPage.getEmailFilledText(),
					parentDetailsDataTable.get(0).get("Email"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
        
        try {
			Assert.assertEquals("The PostalCode is not matching",ParentDetailsPage.getPostalCodeFilledText(),
					parentDetailsDataTable.get(0).get("PostalCode"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		Assert.assertFalse("particular of parent filled data is not persist", flag);
	}
	
	
}
