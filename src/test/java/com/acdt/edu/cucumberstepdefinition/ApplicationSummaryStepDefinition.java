package com.acdt.edu.cucumberstepdefinition;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

import com.acdt.edu.pageobjectmodel.ApplicationSummaryPage;
import com.acdt.edu.pageobjectmodel.SignupPage;

import cucumber.api.java.en.When;


public class ApplicationSummaryStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(ApplicationSummaryStepDefinition.class);
	
	@When("^verify the filled data in signup page is display correctly in application summary page$")
	public void verifyFilledDataInSignupPageIsCorrectlyDisplayedSummaryPage(){
		
		
	
		Assert.assertEquals("The Title is not matching", ApplicationSummaryPage.getPersonalTitleFilledText(), PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Title"));
		Assert.assertEquals("The LastName is not matching", ApplicationSummaryPage.getPersonalSurNameFilledText(), PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("LastName"));
		Assert.assertEquals("The FirstName is not matching", ApplicationSummaryPage.getPersonalFirstNameFilledText(), PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("FirstName"));
		//Assert.assertEquals("The MiddleName is not matching", ApplicationSummaryPage.getPersonalMiddleNameFilledText(), PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("MiddleName"));
		//Assert.assertEquals("The OtherName is not matching", ApplicationSummaryPage.getPersonalOtherNameFilledText(), PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("OtherName"));
		//Assert.assertEquals("The Gender is not matching", ApplicationSummaryPage.getPersonalGenderFilledText(), PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Gender"));
		 try{Assert.assertEquals("The DOB is not matching", ApplicationSummaryPage.getPersonalDateOfBirthFilledText(), PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("DOB"));
		 }catch(Exception e){
			e.printStackTrace(); 
		 }
		 try{Assert.assertEquals("The CountryOfBirth is not matching", ApplicationSummaryPage.getPersonalCountryFilledText(), PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("CountryOfBirth"));
	}catch(Exception e){
		e.printStackTrace(); 
	 }
		 try{ Assert.assertEquals("The CityOfBirth is not matching", ApplicationSummaryPage.getPersonalCityOfBirthFilledText(), PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("CityOfBirth"));
}catch(Exception e){
	e.printStackTrace(); 
 }
		 try{Assert.assertEquals("The Nationality is not matching", ApplicationSummaryPage.getPersonalNationalityFilledText(), PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Nationality"));
	 }catch(Exception e){
			e.printStackTrace(); 
		 }
		 try{Assert.assertEquals("The Religion is not matching", ApplicationSummaryPage.getPersonalReligionFilledText(), PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Religion"));
	 }catch(Exception e){
			e.printStackTrace(); 
		 }
		 try{Assert.assertEquals("The HomeTown is not matching", ApplicationSummaryPage.getPersonalHomeTownFilledText(), PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("HomeTown"));
		
	 }catch(Exception e){
			e.printStackTrace(); 
		 }try{Assert.assertEquals("The Region is not matching", ApplicationSummaryPage.getPersonalRegionFilledText(), PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Region"));
	 }catch(Exception e){
			e.printStackTrace(); 
		 }
		 try{Assert.assertEquals("The Email is not matching", ApplicationSummaryPage.getPersonalEmailFilledText(), SignupPage.emailAuto);
	 }catch(Exception e){
			e.printStackTrace(); 
		 }
		 try{Assert.assertEquals("The Special Comment is not matching", ApplicationSummaryPage.getPersonalSpecialNeedYesFilledText(), PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Comment"));
	 }catch(Exception e){
			e.printStackTrace(); 
		 }
		 Assert.assertEquals("The SpecialNeed is not matching", ApplicationSummaryPage.getPersonalSpecialNeedYesRadioFilledText(), PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("SpecialNeed"));
		 
		
	}

}
