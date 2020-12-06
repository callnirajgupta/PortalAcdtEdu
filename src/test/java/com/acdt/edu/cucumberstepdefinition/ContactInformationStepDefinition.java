package com.acdt.edu.cucumberstepdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import com.acdt.edu.pageobjectmodel.ContactInformationPage;
import com.acdt.edu.pageobjectmodel.ParentDetailsPage;
import com.acdt.edu.pageobjectmodel.PersonalDetailsPage;
import com.acdt.edu.util.SeleniumUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContactInformationStepDefinition {
	
	private static final Logger LOGGER = LogManager.getLogger(ContactInformationStepDefinition.class);
	public static List<Map<String,String>> contactInformationPostalAddressDataTable = new ArrayList<Map<String,String>>() ;
	 
	
	 @When("^user enter data in contact information page for postal address$")
	public void user_enter_data_in_contact_information_page_for_postal_address(List<Map<String,String>> dataTable) throws Throwable {
		LOGGER.info("user enter data in contact information page for postal address");
		contactInformationPostalAddressDataTable=dataTable;
		
		ContactInformationPage.postalAddressFilling(dataTable.get(0).get("Address1"),dataTable.get(0).get("Address2"), dataTable.get(0).get("City"), dataTable.get(0).get("State"),dataTable.get(0).get("Country") , dataTable.get(0).get("PostalCode"),dataTable.get(0).get("Phone"));
	
	}

	@When("^user click check as postal address is same as permanent address$")
	public void user_click_check_as_postal_address_is_same_as_permanent_address() throws Throwable {
		LOGGER.info("user click check as postal address is same as permanent address");
		ContactInformationPage.clickCheckBoxPostalSamePermanent();
	}

	@Then("^verify that postal address is matching permanent address$")
	public void verify_that_postal_address_is_matching_permanent_address() throws Throwable {
		LOGGER.info("verify that postal address is matching permanent address");
		ContactInformationPage.validatePostalAddressSamePermanentAddress(contactInformationPostalAddressDataTable.get(0).get("Address1"),contactInformationPostalAddressDataTable.get(0).get("Address2"), contactInformationPostalAddressDataTable.get(0).get("City"), contactInformationPostalAddressDataTable.get(0).get("State"),contactInformationPostalAddressDataTable.get(0).get("Country") , contactInformationPostalAddressDataTable.get(0).get("PostalCode"),contactInformationPostalAddressDataTable.get(0).get("Phone"));
	    
	}
    
	@When("^user enter  mandatory fields data in contact information page for postal address and validate error message$")
	public void mandatoryFieldsdataToPostalAndPermanentAddress(List<Map<String,String>> dataTable) throws Throwable{
		LOGGER.info("user enter  mandatory fields data in contact information page for postal address and permanent address and validate error message");
		List<String> list = new ArrayList<String>();
	    boolean flag=true;
	    for(int i=0;i<dataTable.size();i++){
		ContactInformationPage.postalAddressFilling(dataTable.get(i).get("Address1"),dataTable.get(i).get("Address2"), dataTable.get(i).get("City"), dataTable.get(i).get("State"),dataTable.get(i).get("Country") , dataTable.get(i).get("PostalCode"),dataTable.get(i).get("Phone"));
		
		ContactInformationPage.permanentAddressFilling("Address1","Address2", "City", "State","Afghanistan" , "1313124","+9133456789");
		ContactInformationPage.clickNextButton();
		try{
		 String appError=ContactInformationPage.getErrorMessage();
		    
		    if(!appError.equals(dataTable.get(i).get("Message"))){
		    	list.add(dataTable.get(i).get("Message"));
		    	flag=false;
		    	LOGGER.info("Error message is matching as "+dataTable.get(i).get("Message"));
		    }else{
		    	LOGGER.error("Error message is Not matching as "+dataTable.get(i).get("Message"));	
		    }
		}catch(Exception e){
			list.add(dataTable.get(i).get("Message"));
	    	flag=false;
	    	LOGGER.error("Error message is Not displayed as "+dataTable.get(i).get("Message"));
		}
		    SeleniumUtil.refreshPage();
		    }
		    
		    Assert.assertTrue("The error message is not matching for postal address"+list, flag);
		
	}
	
	@When("^user enter  mandatory fields data in contact information page for permanent address and validate error message$")
	public void mandatoryFieldsdataToPermanentAndPermanentAddress(List<Map<String,String>> dataTable) throws Throwable{
		LOGGER.info("user enter  mandatory fields data in contact information page for permanent address and permanent address and validate error message");
		
		List<String> list = new ArrayList<String>();
	    boolean flag=true;
	    for(int i=0;i<dataTable.size();i++){
		
		ContactInformationPage.postalAddressFilling("Address1","Address2", "City", "State","Afghanistan" , "1313124","+919241521992");
		ContactInformationPage.permanentAddressFilling(dataTable.get(i).get("Address1"),dataTable.get(i).get("Address2"), dataTable.get(i).get("City"), dataTable.get(i).get("State"),dataTable.get(i).get("Country") , dataTable.get(i).get("PostalCode"),dataTable.get(i).get("Phone"));
		Thread.sleep(5000);
		ContactInformationPage.clickNextButton();
		 String appError=ContactInformationPage.getErrorMessage();
		    
		    if(!appError.equals(dataTable.get(i).get("Message"))){
		    	list.add(appError);
		    	flag=false;
		    }
		    SeleniumUtil.refreshPage();
		    }
		    
		    Assert.assertTrue("The error message is not matching for permanent address"+list, flag);
		
	}
	
	@When("^user click next button$")
	public void clicknextbutton(){
		ContactInformationPage.clickNextButton();
		
	}
	
	@When("^verify that user navigate to particular of parent page$")
	public void navigateToParticularToParent(){
		ParentDetailsPage.validateParentDetailsTitle();	
	}
	
	@When("^user click on previous button in Contact Information page$")
	public void clickPreviousButtonInContactInformationPage(){
		ContactInformationPage.clickPreviousButton();
	}
		
	@Then("^validate that contact information filled data persist$")
	public void validate_that_contact_information_filled_data_persist(){
		LOGGER.info("validate that contact information filled data persist");
		boolean flag=false;
		try {
			SeleniumUtil.wait(5000);
			Assert.assertEquals("The Address1 is not matching",ContactInformationPage.getPostalAddress1FilledText(),
					contactInformationPostalAddressDataTable.get(0).get("Address1"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			Assert.assertEquals("The Address2 is not matching",ContactInformationPage.getPostalAddress2FilledText(),
					contactInformationPostalAddressDataTable.get(0).get("Address2"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		try {
			Assert.assertEquals("The City is not matching",ContactInformationPage.getPostalCityFilledText(),
					contactInformationPostalAddressDataTable.get(0).get("City"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			Assert.assertEquals("The State is not matching",ContactInformationPage.getPostalStateFilledText(),
					contactInformationPostalAddressDataTable.get(0).get("State"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			Assert.assertEquals("The Country is not matching",ContactInformationPage.getPostalCountryFilledText(),
					contactInformationPostalAddressDataTable.get(0).get("Country").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			Assert.assertEquals("The PostalCode is not matching",ContactInformationPage.getPostalCodeFilledText(),
					contactInformationPostalAddressDataTable.get(0).get("PostalCode"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		/*try {
			Assert.assertEquals("The Phone is not matching",ContactInformationPage.getPostalPhoneFilledText(),
					contactInformationPostalAddressDataTable.get(0).get("Phone"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}*/
		
		try {
			SeleniumUtil.wait(5000);
			Assert.assertEquals("The Permanent Address1 is not matching",ContactInformationPage.getPermanentAddress1FilledText(),
					contactInformationPostalAddressDataTable.get(0).get("Address1"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			Assert.assertEquals("The Permanent Address2 is not matching",ContactInformationPage.getPermanentAddress2FilledText(),
					contactInformationPostalAddressDataTable.get(0).get("Address2"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		try {
			Assert.assertEquals("The Permanent City is not matching",ContactInformationPage.getPermanentCityFilledText(),
					contactInformationPostalAddressDataTable.get(0).get("City"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			Assert.assertEquals("The  Permanent State is not matching",ContactInformationPage.getPermanentStateFilledText(),
					contactInformationPostalAddressDataTable.get(0).get("State"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			Assert.assertEquals("The Permanent Country is not matching",ContactInformationPage.getPermanentCountryFilledText(),
					contactInformationPostalAddressDataTable.get(0).get("Country").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		try {
			Assert.assertEquals("The Permanent PostalCode is not matching",ContactInformationPage.getPermanentCodeFilledText(),
					contactInformationPostalAddressDataTable.get(0).get("PostalCode"));
		} catch (AssertionError e) {
			e.printStackTrace();
			flag=true;
		}
		
		Assert.assertFalse("The Contact information filled data is not Matching",flag);
	}

}
