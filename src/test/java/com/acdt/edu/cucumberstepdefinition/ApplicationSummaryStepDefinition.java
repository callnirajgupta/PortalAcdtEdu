package com.acdt.edu.cucumberstepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

import com.acdt.edu.pageobjectmodel.ApplicationSummaryPage;
import com.acdt.edu.pageobjectmodel.SignupPage;

import cucumber.api.java.en.When;

public class ApplicationSummaryStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(ApplicationSummaryStepDefinition.class);

	@When("^verify the filled data in signup page is display correctly in application summary page$")
	public void verifyFilledDataInSignupPageIsCorrectlyDisplayedSummaryPage() {
		List<String> errorList= new ArrayList<>();
			
		
		LOGGER.info("verify the filled data in signup page is display correctly in application summary page");
		try {
			Assert.assertEquals("The Title is not matching", ApplicationSummaryPage.getPersonalTitleFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Title"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		try {
			Assert.assertEquals("The LastName is not matching", ApplicationSummaryPage.getPersonalSurNameFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("LastName"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		try {
			Assert.assertEquals("The FirstName is not matching",
					ApplicationSummaryPage.getPersonalFirstNameFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("FirstName"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		try {
			Assert.assertEquals("The MiddleName is not matching",
					ApplicationSummaryPage.getPersonalMiddleNameFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("MiddleName"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		try {
			Assert.assertEquals("The OtherName is not matching",
					ApplicationSummaryPage.getPersonalOtherNameFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("OtherName"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		try {
			Assert.assertEquals("The Gender is not matching", ApplicationSummaryPage.getPersonalGenderFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Gender"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		try {

			String[] DOB = PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("DOB").split("/");

			Assert.assertEquals("The DOB is not matching", ApplicationSummaryPage.getPersonalDateOfBirthFilledText(),
					DOB[2] + "-0" + DOB[1] + "-" + DOB[0]);
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		try {
			Assert.assertEquals("The CountryOfBirth is not matching",
					ApplicationSummaryPage.getPersonalCountryFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("CountryOfBirth"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		try {
			Assert.assertEquals("The CityOfBirth is not matching",
					ApplicationSummaryPage.getPersonalCityOfBirthFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("CityOfBirth"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		try {
			Assert.assertEquals("The Nationality is not matching",
					ApplicationSummaryPage.getPersonalNationalityFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Nationality"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		try {
			Assert.assertEquals("The Religion is not matching", ApplicationSummaryPage.getPersonalReligionFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Religion"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		try {
			Assert.assertEquals("The HomeTown is not matching", ApplicationSummaryPage.getPersonalHomeTownFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("HomeTown"));

		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		try {
			Assert.assertEquals("The Region is not matching", ApplicationSummaryPage.getPersonalRegionFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Region"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		try {
			Assert.assertEquals("The Email is not matching", ApplicationSummaryPage.getPersonalEmailFilledText(),
					SignupPage.emailAuto);
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		try {
			Assert.assertEquals("The Special Comment is not matching",
					ApplicationSummaryPage.getPersonalSpecialNeedYesFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Comment"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}

		try {
			Assert.assertEquals("The SpecialNeed is not matching",
					ApplicationSummaryPage.getPersonalSpecialNeedYesRadioFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("SpecialNeed"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			Assert.assertEquals("The Contact information address1 is not matching",
					ApplicationSummaryPage.getContactInformationPostalAddress1FilledText(),
					ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("Address1"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			Assert.assertEquals("The Contact information address2 is not matching",
					ApplicationSummaryPage.getContactInformationPostalAddress2FilledText(),
					ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("Address2"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			Assert.assertEquals("The Contact information city is not matching",
					ApplicationSummaryPage.getContactInformationPostalCityFilledText(),
					ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("City"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			Assert.assertEquals("The Contact information state is not matching",
					ApplicationSummaryPage.getContactInformationPostalStateFilledText(),
					ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("State"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			Assert.assertEquals("The Contact information country is not matching",
					ApplicationSummaryPage.getContactInformationPostalCountryFilledText(),
					ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("Country"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		try {
			Assert.assertEquals("The Contact information country is not matching",
					ApplicationSummaryPage.getContactInformationPostalPostalCodeFilledText(),
					ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("PostalCode"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			Assert.assertEquals("The Contact information postalcode is not matching",
					ApplicationSummaryPage.getContactInformationPostalPostalCodeFilledText(),
					ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("PostalCode"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			String telephone=ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("Phone");
			Assert.assertEquals("The Contact information Telephone is not matching",
					ApplicationSummaryPage.getContactInformationPostalTelephoneFilledText(),
					telephone.substring(3,telephone.length()));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		//***************
		
		try {
			Assert.assertEquals("The Permanent address1 is not matching",
					ApplicationSummaryPage.getContactInformationPermanentAddress1FilledText(),
					ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("Address1"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			Assert.assertEquals("The Permanent address2 is not matching",
					ApplicationSummaryPage.getContactInformationPermanentAddress2FilledText(),
					ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("Address2"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			Assert.assertEquals("The Permanent city is not matching",
					ApplicationSummaryPage.getContactInformationPermanentCityFilledText(),
					ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("City"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			Assert.assertEquals("The Permanent state is not matching",
					ApplicationSummaryPage.getContactInformationPermanentStateFilledText(),
					ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("State"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			Assert.assertEquals("The Permanent country is not matching",
					ApplicationSummaryPage.getContactInformationPermanentCountryFilledText(),
					ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("Country"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		try {
			Assert.assertEquals("The Permanent country is not matching",
					ApplicationSummaryPage.getContactInformationPermanentPostalCodeFilledText(),
					ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("PostalCode"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			Assert.assertEquals("The Permanent postalcode is not matching",
					ApplicationSummaryPage.getContactInformationPermanentPostalCodeFilledText(),
					ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("PostalCode"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			String telephone=ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("Phone");
			Assert.assertEquals("The Permanent Telephone is not matching",
					ApplicationSummaryPage.getContactInformationPermanentTelephoneFilledText(),
					telephone.substring(3,telephone.length()));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			Assert.assertEquals("The Particular of Parent Title is not matching",
					ApplicationSummaryPage.getParticularOfParentTitleFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Title"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			Assert.assertEquals("The Particular of Parent SurName is not matching",
					ApplicationSummaryPage.getParticularOfParentSurNameFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("SurName"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			Assert.assertEquals("The Particular of Parent FirstName is not matching",
					ApplicationSummaryPage.getParticularOfParentFirstNameFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("FirstName"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			Assert.assertEquals("The Particular of Parent MiddleName is not matching",
					ApplicationSummaryPage.getParticularOfParentMiddleNameFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("MiddleName"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			String Relationship=null;
			if(ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Relationship").equalsIgnoreCase("Parent")){
				Relationship=ApplicationSummaryPage.getParticularOfParentRelatioshipParentFilledText();
			}else if(ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Relationship").equalsIgnoreCase("Guardian")){
				Relationship=ApplicationSummaryPage.getParticularOfParentRelatioshipParentFilledText();
			}else if(ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Relationship").equalsIgnoreCase("Sponsor")){
				Relationship=ApplicationSummaryPage.getParticularOfParentRelatioshipParentFilledText();
			}
			
			Assert.assertEquals("The Particular of Parent Relationship is not matching",
					Relationship,
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Relationship"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			Assert.assertEquals("The Particular of Parent Company is not matching",
					ApplicationSummaryPage.getParticularOfParentCompanyFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Company"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		try {
			Assert.assertEquals("The Particular of Parent Occupation is not matching",
					ApplicationSummaryPage.getParticularOfParentOccupationFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Occupation"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			Assert.assertEquals("The Particular of Parent Address1 is not matching",
					ApplicationSummaryPage.getParticularOfParentAddres1FilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Address1"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			Assert.assertEquals("The Particular of Parent Address2 is not matching",
					ApplicationSummaryPage.getParticularOfParentAddress2FilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Address2"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			Assert.assertEquals("The Particular of Parent Country is not matching",
					ApplicationSummaryPage.getParticularOfParentCountryFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Country"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		try {
			Assert.assertEquals("The Particular of Parent CityTown is not matching",
					ApplicationSummaryPage.getParticularOfParentCityFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("CityTown"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			Assert.assertEquals("The Particular of Parent State is not matching",
					ApplicationSummaryPage.getParticularOfParentStateFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("State"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			Assert.assertEquals("The Particular of Parent Mobile is not matching",
					ApplicationSummaryPage.getParticularOfParentMobileFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Mobile"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			Assert.assertEquals("The Particular of Parent Telephone is not matching",
					ApplicationSummaryPage.getParticularOfParentTelephoneFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Telephone"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			Assert.assertEquals("The Particular of Parent Telephone is not matching",
					ApplicationSummaryPage.getParticularOfParentTelephoneFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Telephone"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			Assert.assertEquals("The Particular of Parent Email is not matching",
					ApplicationSummaryPage.getParticularOfParentEmailFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Email"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		try {
			Assert.assertEquals("The Particular of Parent PostalCode is not matching",
					ApplicationSummaryPage.getParticularOfParentPostalCodeFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("PostalCode"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(e.getMessage());
		}
		
		
		 LOGGER.error("Error List"+errorList);
		Assert.assertFalse("The fields data is not mathcing in Application Summary page", errorList.size()>0);
    
	}

}
