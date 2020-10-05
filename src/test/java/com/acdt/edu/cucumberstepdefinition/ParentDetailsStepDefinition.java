package com.acdt.edu.cucumberstepdefinition;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.acdt.edu.pageobjectmodel.ParentDetailsPage;

import cucumber.api.java.en.When;

public class ParentDetailsStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(ParentDetailsStepDefinition.class);

	
@When("^user enter mandatory fields data in parent details page and validate error message$")
public void parentDetailsMandatoryFieldsAndError(List<Map<String,String>> dataTable) throws Throwable{
	int i=0;
	
	ParentDetailsPage.parentDetailFilling(dataTable.get(i).get("Title"), dataTable.get(i).get("FirstName"), dataTable.get(i).get("MiddleName"), dataTable.get(i).get("SurName"), dataTable.get(i).get("Relationship"), dataTable.get(i).get("Company"), dataTable.get(i).get("Occupation"), dataTable.get(i).get("Address1"), dataTable.get(i).get("Address2"), dataTable.get(i).get("Country"), dataTable.get(i).get("CityTown"), dataTable.get(i).get("State"), dataTable.get(i).get("Mobile"), dataTable.get(i).get("Telephone"), dataTable.get(i).get("Email"), dataTable.get(i).get("PostalCode"));
	Thread.sleep(20000);                                                                   
}
}
