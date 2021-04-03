package com.acdt.edu.cucumberstepdefinition;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import com.acdt.edu.pageobjectmodel.ApplicationSummaryPage;
import com.acdt.edu.pageobjectmodel.SignupPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ApplicationSummaryStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(ApplicationSummaryStepDefinition.class);

	@When("^verify the filled data in signup page is display correctly in application summary page$")
	public void verifyFilledDataInSignupPageIsCorrectlyDisplayedSummaryPage() {
		List<String> errorList= new ArrayList<>();
			
		
		LOGGER.info("verify the filled data in signup page is display correctly in application summary page");
		try {
			Assert.assertEquals("The Title is not matching", ApplicationSummaryPage.getPersonalTitleFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Title").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add("The field is not Mathcing:"+PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Title"));
		}
		try {
			Assert.assertEquals("The LastName is not matching", ApplicationSummaryPage.getPersonalSurNameFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("LastName").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("LastName"));
		}
		try {
			Assert.assertEquals("The FirstName is not matching",
					ApplicationSummaryPage.getPersonalFirstNameFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("FirstName").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("FirstName"));
		}
		try {
			Assert.assertEquals("The MiddleName is not matching",
					ApplicationSummaryPage.getPersonalMiddleNameFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("MiddleName").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("MiddleName"));
		}
		try {
			Assert.assertEquals("The OtherName is not matching",
					ApplicationSummaryPage.getPersonalOtherNameFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("OtherName").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("OtherName"));
		}
		try {
			Assert.assertEquals("The Gender is not matching", ApplicationSummaryPage.getPersonalGenderFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Gender").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Gender"));
		}
		try {

			String[] DOB = PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("DOB").split("/");

			Assert.assertEquals("The DOB is not matching", ApplicationSummaryPage.getPersonalDateOfBirthFilledText(),
					DOB[2] + "-0" + DOB[1] + "-" + DOB[0]);
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("DOB"));
		}
		try {
			Assert.assertEquals("The CountryOfBirth is not matching",
					ApplicationSummaryPage.getPersonalCountryFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("CountryOfBirth").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("CountryOfBirth"));
		}
		try {
			Assert.assertEquals("The CityOfBirth is not matching",
					ApplicationSummaryPage.getPersonalCityOfBirthFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("CityOfBirth").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("CityOfBirth"));
		}
		try {
			Assert.assertEquals("The Nationality is not matching",
					ApplicationSummaryPage.getPersonalNationalityFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Nationality").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Nationality"));
		}
		try {
			Assert.assertEquals("The Religion is not matching", ApplicationSummaryPage.getPersonalReligionFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Religion").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Religion"));
		}
		try {
			Assert.assertEquals("The HomeTown is not matching", ApplicationSummaryPage.getPersonalHomeTownFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("HomeTown").toUpperCase());

		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("HomeTown"));
		}
		try {
			Assert.assertEquals("The Region is not matching", ApplicationSummaryPage.getPersonalRegionFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Region").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Region"));
		}
		try {
			Assert.assertEquals("The Email is not matching", ApplicationSummaryPage.getPersonalEmailFilledText(),
					SignupPage.emailAuto);
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(SignupPage.emailAuto);
		}
		try {
			Assert.assertEquals("The Special Comment is not matching",
					ApplicationSummaryPage.getPersonalSpecialNeedYesFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Comment"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("Comment"));
		}

		try {
			Assert.assertEquals("The SpecialNeed is not matching",
					ApplicationSummaryPage.getPersonalSpecialNeedYesRadioFilledText(),
					PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("SpecialNeed"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(PersonalDetailsStepDefinition.PersonalDataTable.get(0).get("SpecialNeed"));
		}
		
		try {
			Assert.assertEquals("The Contact information address1 is not matching",
					ApplicationSummaryPage.getContactInformationPostalAddress1FilledText(),
					ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("Address1").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("Address1"));
		}
		
		try {
			Assert.assertEquals("The Contact information address2 is not matching",
					ApplicationSummaryPage.getContactInformationPostalAddress2FilledText(),
					ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("Address2").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("Address2"));
		}
		
		try {
			Assert.assertEquals("The Contact information city is not matching",
					ApplicationSummaryPage.getContactInformationPostalCityFilledText(),
					ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("City").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("City"));
		}
		
		try {
			Assert.assertEquals("The Contact information state is not matching",
					ApplicationSummaryPage.getContactInformationPostalStateFilledText(),
					ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("State").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("State"));
		}
		
		try {
			Assert.assertEquals("The Contact information country is not matching",
					ApplicationSummaryPage.getContactInformationPostalCountryFilledText(),
					ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("Country").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("Country"));
		}
		
		
		try {
			Assert.assertEquals("The Contact information postalcode is not matching",
					ApplicationSummaryPage.getContactInformationPostalPostalCodeFilledText(),
					ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("PostalCode"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("PostalCode"));
		}
		
		try {
			String telephone=ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("Phone");
			Assert.assertEquals("The Contact information Telephone is not matching",
					ApplicationSummaryPage.getContactInformationPostalTelephoneFilledText(),
					telephone.substring(3,telephone.length()));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("Phone"));
		}
		
		//***************
		
		try {
			Assert.assertEquals("The Permanent address1 is not matching",
					ApplicationSummaryPage.getContactInformationPermanentAddress1FilledText(),
					ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("Address1").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("Address1"));
		}
		
		try {
			Assert.assertEquals("The Permanent address2 is not matching",
					ApplicationSummaryPage.getContactInformationPermanentAddress2FilledText(),
					ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("Address2").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("Address2"));
		}
		
		try {
			Assert.assertEquals("The Permanent city is not matching",
					ApplicationSummaryPage.getContactInformationPermanentCityFilledText(),
					ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("City").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("City"));
		}
		
		try {
			Assert.assertEquals("The Permanent state is not matching",
					ApplicationSummaryPage.getContactInformationPermanentStateFilledText(),
					ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("State").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("State"));
		}
		
		try {
			Assert.assertEquals("The Permanent country is not matching",
					ApplicationSummaryPage.getContactInformationPermanentCountryFilledText(),
					ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("Country").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("Country"));
		}
		
		
		try {
			Assert.assertEquals("The Permanent postalcode is not matching",
					ApplicationSummaryPage.getContactInformationPermanentPostalCodeFilledText(),
					ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("PostalCode"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("PostalCode"));
		}
		
		try {
			String telephone=ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("Phone");
			Assert.assertEquals("The Permanent Telephone is not matching",
					ApplicationSummaryPage.getContactInformationPermanentTelephoneFilledText(),
					telephone.substring(3,telephone.length()));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ContactInformationStepDefinition.contactInformationPostalAddressDataTable.get(0).get("Phone"));
		}
		
		try {
			Assert.assertEquals("The Particular of Parent Title is not matching",
					ApplicationSummaryPage.getParticularOfParentTitleFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Title").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Title"));
		}
		
		try {
			Assert.assertEquals("The Particular of Parent SurName is not matching",
					ApplicationSummaryPage.getParticularOfParentSurNameFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("SurName").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("SurName"));
		}
		
		try {
			Assert.assertEquals("The Particular of Parent FirstName is not matching",
					ApplicationSummaryPage.getParticularOfParentFirstNameFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("FirstName").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("FirstName"));
		}
		
		try {
			Assert.assertEquals("The Particular of Parent MiddleName is not matching",
					ApplicationSummaryPage.getParticularOfParentMiddleNameFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("MiddleName").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("MiddleName"));
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
			errorList.add(ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Relationship"));
		}
		
		try {
			Assert.assertEquals("The Particular of Parent Company is not matching",
					ApplicationSummaryPage.getParticularOfParentCompanyFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Company").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Company"));
		}
		try {
			Assert.assertEquals("The Particular of Parent Occupation is not matching",
					ApplicationSummaryPage.getParticularOfParentOccupationFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Occupation").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Occupation"));
		}
		
		try {
			Assert.assertEquals("The Particular of Parent Address1 is not matching",
					ApplicationSummaryPage.getParticularOfParentAddres1FilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Address1").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Address1"));
		}
		
		try {
			Assert.assertEquals("The Particular of Parent Address2 is not matching",
					ApplicationSummaryPage.getParticularOfParentAddress2FilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Address2").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Address2"));
		}
		
		try {
			Assert.assertEquals("The Particular of Parent Country is not matching",
					ApplicationSummaryPage.getParticularOfParentCountryFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Country").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Country"));
		}
		try {
			Assert.assertEquals("The Particular of Parent CityTown is not matching",
					ApplicationSummaryPage.getParticularOfParentCityFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("CityTown").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("CityTown"));
		}
		
		try {
			Assert.assertEquals("The Particular of Parent State is not matching",
					ApplicationSummaryPage.getParticularOfParentStateFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("State").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("State"));
		}
		
		try {
			Assert.assertEquals("The Particular of Parent Mobile is not matching",
					ApplicationSummaryPage.getParticularOfParentMobileFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Mobile"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Mobile"));
		}
		
		try {
			Assert.assertEquals("The Particular of Parent Telephone is not matching",
					ApplicationSummaryPage.getParticularOfParentTelephoneFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Telephone"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Telephone"));
		}
		
		
		
		try {
			Assert.assertEquals("The Particular of Parent Email is not matching",
					ApplicationSummaryPage.getParticularOfParentEmailFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Email"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("Email"));
		}
		
		try {
			Assert.assertEquals("The Particular of Parent PostalCode is not matching",
					ApplicationSummaryPage.getParticularOfParentPostalCodeFilledText(),
					ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("PostalCode"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ParentDetailsStepDefinition.parentDetailsDataTable.get(0).get("PostalCode"));
		}
		
		try {
			Assert.assertEquals("The programme type is not matching",
					ApplicationSummaryPage.getProgrammeTypeFilledText(),
					ProgrameSelectionStepDefinition.programeSelectionDataTable.get(0).get("ProgrammeType").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ProgrameSelectionStepDefinition.programeSelectionDataTable.get(0).get("ProgrammeType"));
		}
		
		try {
			Assert.assertEquals("The programme title is not matching",
					ApplicationSummaryPage.getProgrammeTitleFilledText(),
					ProgrameSelectionStepDefinition.programeSelectionDataTable.get(0).get("ProgrammeTitle").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ProgrameSelectionStepDefinition.programeSelectionDataTable.get(0).get("ProgrammeTitle"));
		}
		
		try {
			Assert.assertEquals("The Education Background current institute is not matching",
					ApplicationSummaryPage.getEducationBackGroundCurrentInstituteFilledText(),
					EducationalBackGround.educationalBackGroundDataTable.get(0).get("RecentInstitution").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(EducationalBackGround.educationalBackGroundDataTable.get(0).get("RecentInstitution"));
		}
		
		try {
			Assert.assertEquals("The Education Background city is not matching",
					ApplicationSummaryPage.getEducationBackGroundCityFilledText(),
					EducationalBackGround.educationalBackGroundDataTable.get(0).get("City").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(EducationalBackGround.educationalBackGroundDataTable.get(0).get("City"));
		}
		
		try {
			Assert.assertEquals("The Education Background Country is not matching",
					ApplicationSummaryPage.getEducationBackGroundCountryFilledText(),
					EducationalBackGround.educationalBackGroundDataTable.get(0).get("Country").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(EducationalBackGround.educationalBackGroundDataTable.get(0).get("Country"));
		}
		
		try {
			String[] yearOfEntry = EducationalBackGround.educationalBackGroundDataTable.get(0).get("YearOfEntry").split("/");
			Assert.assertEquals("The Education Background YearOfEntry is not matching",
					ApplicationSummaryPage.getEducationBackGroundYearOfEntryFilledText(),
					yearOfEntry[2] + "-0" + yearOfEntry[1] + "-" + yearOfEntry[0]);
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(EducationalBackGround.educationalBackGroundDataTable.get(0).get("YearOfEntry"));
		}
		
		
		try {
			String[] yearOfCompletion = EducationalBackGround.educationalBackGroundDataTable.get(0).get("YearOfCompletion").split("/");
			Assert.assertEquals("The Education Background YearOfCompletion is not matching",
					ApplicationSummaryPage.getEducationBackGroundYearOfCompletionFilledText(),
					yearOfCompletion[2] + "-0" + yearOfCompletion[1] + "-" + yearOfCompletion[0]);
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(EducationalBackGround.educationalBackGroundDataTable.get(0).get("YearOfCompletion"));
		}
		
		try {
			Assert.assertEquals("The Education Background Qualification is not matching",
					ApplicationSummaryPage.getEducationBackGroundQualificationFilledText(),
					EducationalBackGround.educationalBackGroundDataTable.get(0).get("Qualification").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(EducationalBackGround.educationalBackGroundDataTable.get(0).get("Qualification"));
		}
		
		try {
			Assert.assertEquals("The Education Background OtherQualification is not matching",
					ApplicationSummaryPage.getEducationBackGroundOtherQualificationFilledText(),
					EducationalBackGround.educationalBackGroundDataTable.get(0).get("OtherQualification").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(EducationalBackGround.educationalBackGroundDataTable.get(0).get("OtherQualification"));
		}
		
		try {
			Assert.assertEquals("The Examination Taken exam type is not matching",
					ApplicationSummaryPage.getExaminationTakenExamTypeFilledText(),
					ExaminationStepDefinition.examinationTakenDataTable.get(0).get("ExaminationType").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ExaminationStepDefinition.examinationTakenDataTable.get(0).get("ExaminationType"));
		}
		
		try {
			Assert.assertEquals("The Examination Taken IndexNumber is not matching",
					ApplicationSummaryPage.getExaminationTakenIndexNumberFilledText(),
					ExaminationStepDefinition.examinationTakenDataTable.get(0).get("IndexNumber"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ExaminationStepDefinition.examinationTakenDataTable.get(0).get("IndexNumber"));
		}
		
		try {
			String[] dateOfExamination = ExaminationStepDefinition.examinationTakenDataTable.get(0).get("DateOfExamination").split("/");
			Assert.assertEquals("The Examination Taken DateOfExamination is not matching",
					ApplicationSummaryPage.getExaminationTakenDateOfExaminationFilledText(),
					dateOfExamination[2] + "-0" + dateOfExamination[1] + "-" + dateOfExamination[0]);
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ExaminationStepDefinition.examinationTakenDataTable.get(0).get("DateOfExamination"));
		}
		
		try {
			Assert.assertEquals("The Examination Taken UploadResultSlip is not matching",
					ApplicationSummaryPage.getExaminationTakenResultSlipFilledText(),
					ExaminationStepDefinition.examinationTakenDataTable.get(0).get("UploadResultSlip"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ExaminationStepDefinition.examinationTakenDataTable.get(0).get("UploadResultSlip"));
		}
		
		try {
			Assert.assertEquals("The Examination Subject Subject1 is not matching",
					ApplicationSummaryPage.getExaminationSubject1FilledText(),
					"English Language".toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add("English Language");
		}
		
		
		try {
			Assert.assertEquals("The Examination Subject grade1 is not matching",
					ApplicationSummaryPage.getExaminationGrade1FilledText(),
					ExaminationSubjectStepDefinition.examinationSubjectDataTable.get(0).get("Grade1"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ExaminationSubjectStepDefinition.examinationSubjectDataTable.get(0).get("Grade1"));
		}
		try {
			Assert.assertEquals("The Examination Subject Subject2 is not matching",
					ApplicationSummaryPage.getExaminationSubject2FilledText(),
					"Mathematics".toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add("Mathematics");
		}
		
		try {
			Assert.assertEquals("The Examination Subject grade2 is not matching",
					ApplicationSummaryPage.getExaminationGrade2FilledText(),
					ExaminationSubjectStepDefinition.examinationSubjectDataTable.get(0).get("Grade2"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ExaminationSubjectStepDefinition.examinationSubjectDataTable.get(0).get("Grade2"));
		}
		
		try {
			Assert.assertEquals("The Examination Subject Subject3 is not matching",
					ApplicationSummaryPage.getExaminationSubject3FilledText(),
					ExaminationSubjectStepDefinition.examinationSubjectDataTable.get(0).get("Subject3").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ExaminationSubjectStepDefinition.examinationSubjectDataTable.get(0).get("Subject3"));
		}
		
		try {
			Assert.assertEquals("The Examination Subject grade3 is not matching",
					ApplicationSummaryPage.getExaminationGrade3FilledText(),
					ExaminationSubjectStepDefinition.examinationSubjectDataTable.get(0).get("Grade3"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ExaminationSubjectStepDefinition.examinationSubjectDataTable.get(0).get("Grade3"));
		}
		
		try {
			Assert.assertEquals("The Examination Subject Subject4 is not matching",
					ApplicationSummaryPage.getExaminationSubject4FilledText(),
					ExaminationSubjectStepDefinition.examinationSubjectDataTable.get(0).get("Subject4").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ExaminationSubjectStepDefinition.examinationSubjectDataTable.get(0).get("Subject4"));
		}
		
		try {
			Assert.assertEquals("The Examination Subject grade4 is not matching",
					ApplicationSummaryPage.getExaminationGrade4FilledText(),
					ExaminationSubjectStepDefinition.examinationSubjectDataTable.get(0).get("Grade4"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ExaminationSubjectStepDefinition.examinationSubjectDataTable.get(0).get("Grade4"));
		}
		try {
			Assert.assertEquals("The Examination Subject Subject5 is not matching",
					ApplicationSummaryPage.getExaminationSubject5FilledText(),
					ExaminationSubjectStepDefinition.examinationSubjectDataTable.get(0).get("Subject5").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ExaminationSubjectStepDefinition.examinationSubjectDataTable.get(0).get("Subject5"));
		}
		
		try {
			Assert.assertEquals("The Examination Subject grade5 is not matching",
					ApplicationSummaryPage.getExaminationGrade5FilledText(),
					ExaminationSubjectStepDefinition.examinationSubjectDataTable.get(0).get("Grade5"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ExaminationSubjectStepDefinition.examinationSubjectDataTable.get(0).get("Grade5"));
		}
		
		try {
			Assert.assertEquals("The Examination Subject Subject6 is not matching",
					ApplicationSummaryPage.getExaminationSubject6FilledText(),
					ExaminationSubjectStepDefinition.examinationSubjectDataTable.get(0).get("Subject6").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ExaminationSubjectStepDefinition.examinationSubjectDataTable.get(0).get("Subject6"));
		}
		
		try {
			Assert.assertEquals("The Examination Subject grade6 is not matching",
					ApplicationSummaryPage.getExaminationGrade6FilledText(),
					ExaminationSubjectStepDefinition.examinationSubjectDataTable.get(0).get("Grade6"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(ExaminationSubjectStepDefinition.examinationSubjectDataTable.get(0).get("Grade6"));
		}
		
		
		try {
			Assert.assertEquals("The Financing Study how not matching",
					ApplicationSummaryPage.getFinancingStudyHowFilledText(),
					FinancingYourStudyStepDefinition.financingYourStudyDataTable.get(0).get("IntendToFinance").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(FinancingYourStudyStepDefinition.financingYourStudyDataTable.get(0).get("IntendToFinance"));
		}
		
		try {
			Assert.assertEquals("The Financing Study other not matching",
					ApplicationSummaryPage.getFinancingStudyOtherFilledText(),
					FinancingYourStudyStepDefinition.financingYourStudyDataTable.get(0).get("Other"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(FinancingYourStudyStepDefinition.financingYourStudyDataTable.get(0).get("Other"));
		}
		
		try {
			Assert.assertEquals("The Referee title not matching",
					ApplicationSummaryPage.getRefereeTitleFilledText(),
					RefereeStepDefinition.refereeDataTable.get(0).get("Title").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(RefereeStepDefinition.refereeDataTable.get(0).get("Title"));
		}
		
		try {
			Assert.assertEquals("The Referee Position not matching",
					ApplicationSummaryPage.getRefereePositionFilledText(),
					RefereeStepDefinition.refereeDataTable.get(0).get("Position").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(RefereeStepDefinition.refereeDataTable.get(0).get("Position"));
		}
		
		try {
			Assert.assertEquals("The Referee FullName not matching",
					ApplicationSummaryPage.getRefereeFullNameFilledText(),
					RefereeStepDefinition.refereeDataTable.get(0).get("FullName").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(RefereeStepDefinition.refereeDataTable.get(0).get("FullName"));
		}
		
		try {
			Assert.assertEquals("The Referee Email not matching",
					ApplicationSummaryPage.getRefereeEmailAddressFilledText(),
					RefereeStepDefinition.refereeDataTable.get(0).get("Email").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(RefereeStepDefinition.refereeDataTable.get(0).get("Email"));
		}
		
		try {
			Assert.assertEquals("The Referee Occupation not matching",
					ApplicationSummaryPage.getRefereeOccupationFilledText(),
					RefereeStepDefinition.refereeDataTable.get(0).get("Occupation").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(RefereeStepDefinition.refereeDataTable.get(0).get("Occupation"));
		}
		
		try {
			
			String[] date = RefereeStepDefinition.refereeDataTable.get(0).get("Date").split("/");
			
			Assert.assertEquals("The Referee Date not matching",
					ApplicationSummaryPage.getRefereeDateFilledText(),
					date[2] + "-0" + date[1] + "-" + date[0]);
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(RefereeStepDefinition.refereeDataTable.get(0).get("Date"));
		}
		
		try {
			Assert.assertEquals("The Referee Signature not matching",
					ApplicationSummaryPage.getRefereeApplicationSignatureFilledText(),
					RefereeStepDefinition.refereeDataTable.get(0).get("Signature"));
		} catch (AssertionError e) {
			e.printStackTrace();
			errorList.add(RefereeStepDefinition.refereeDataTable.get(0).get("Signature"));
		}
		 LOGGER.error("Error List"+errorList);
		Assert.assertFalse("The fields data is not matching in Application Summary page for following fields"+errorList, errorList.size()>0);
     
	}

	 @When("^user click on submit button$")
	 public void submitApplication(){
		 ApplicationSummaryPage.clickSubmitButton();
		 
	 }
	 
	 @Then("^verify that application submit successfully$")
	 public void verifyAplicationNumber(){
		 ApplicationSummaryPage.validateApplicationCongratulationTitle();
		 ApplicationSummaryPage.validateApplicationNo();
	 }
	 
	 @When("^user click on login menu$")
	 public void userClickLoginMenu(){
		 ApplicationSummaryPage.clickLoginMenu();
		 
	 }
	 
	 @When("^user click on previous button in Application Summary page$")
	 public void clickPreviousButtonInApplicationSummaryPage(){
		 ApplicationSummaryPage.ClickPreviousButton();
	 }
	
}
