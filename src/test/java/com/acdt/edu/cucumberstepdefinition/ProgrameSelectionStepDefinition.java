package com.acdt.edu.cucumberstepdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

import com.acdt.edu.pageobjectmodel.ContactInformationPage;
import com.acdt.edu.pageobjectmodel.EducationalBackgroundPage;
import com.acdt.edu.pageobjectmodel.ProgrammeSelectionPage;
import com.acdt.edu.util.SeleniumUtil;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProgrameSelectionStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(ProgrameSelectionStepDefinition.class);
	public static List<Map<String,String>> programeSelectionDataTable = new ArrayList<Map<String,String>>() ;
	
	@When("^user enter mandatory fields data in programme selection page and validate error message$")
	public void enterMandatoryfieldsInProgrammeSelectionAndErrorValidation(List<Map<String,String>> dataTable) throws Throwable{
		List<String> list = new ArrayList<String>();
	    boolean flag=true;
	    for(int i=0;i<dataTable.size();i++){
		if(i!=0){
			SeleniumUtil.refreshPage();
		}
	    ProgrammeSelectionPage.programmeSelectionDetailsFilling(dataTable.get(i).get("ProgrammeType"), dataTable.get(i).get("ProgrammeTitle"));
	    ProgrammeSelectionPage.clickNextButton();
		 String appError=ProgrammeSelectionPage.getErrorMessage();
		    
		    if(!appError.equals(dataTable.get(i).get("Message"))){
		    	list.add(appError);
		    	flag=false;
		    }
		    
		    }
		    
		    Assert.assertTrue("The error message is not matching for programme selection"+list, flag);
	}

	
	@When("^user enter mandatory fields data in programme selection page$")
	public void enterMandatoryFieldsDataInProgrammeSelectionPage(List<Map<String,String>> dataTable) throws InterruptedException{
		programeSelectionDataTable=dataTable;
		ProgrammeSelectionPage.programmeSelectionDetailsFilling(dataTable.get(0).get("ProgrammeType"), dataTable.get(0).get("ProgrammeTitle"));
	
	}
	
	@Then("^verify that user navigation to Educational Background page$")
	public void userNavigationToEducationalBackground(){
		EducationalBackgroundPage.validateEducationalBackgroundTitle();
	}
	
}
