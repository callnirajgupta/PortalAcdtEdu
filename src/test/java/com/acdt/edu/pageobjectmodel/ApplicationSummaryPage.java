package com.acdt.edu.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.acdt.edu.util.SeleniumUtil;

public class ApplicationSummaryPage {
	private static final Logger LOGGER = LogManager.getLogger(ApplicationSummaryPage.class);
	
	public static final By APPLICATION_SUMMARY_HEADER_XPATH =By.xpath("//h3[text()='Application Summary']");
	public static final By SUBMIT_XPATH = By.xpath("//a[text()='submit']");
	public static final By DOWNLOAD_XPATH = By.xpath("//a[text()='Download']");
	public static final By PREVIOUS_XPATH = By.xpath("//a[text()='Previous']");
	public static final By PERSONAL_TITLE = By.xpath("//div[label[text()='Title']]/p");
	public static final By PERSONAL_SURNAME = By.xpath("//div[label[text()='Surname']]//div/p");
	public static final By PERSONAL_FIRST_NAME = By.xpath("//div[label[text()='First Name']]//div/p");
	public static final By PERSONAL_MIDDLE_NAME = By.xpath("//div[label[text()='Middle Name']]//div/p");
	public static final By PERSONAL_OTHER_NAMES = By.xpath("//div[label[text()='Other Name(s)']]//div/p");
	public static final By PERSONAL_GENDER = By.xpath("//div[label[text()='Gender']]//p");
	public static final By PERSONAL_DATE_OF_BIRTH = By.xpath("//div[label[text()='Date of Birth']]//p");
	public static final By PERSONAL_COUNTRY = By.xpath("//div[label[text()='Country of Birth']]//p");
	public static final By PERSONAL_CITY_OF_BIRTH = By.xpath("//div[label[text()='City/Town of Birth']]//p");
	public static final By PERSONAL_NATIONALITY = By.xpath("//div[label[text()='Nationality']]//p");
	public static final By PERSONAL_RELIGION = By.xpath("//div[label[text()='Religion']]//p");
	public static final By PERSONAL_HOMETOWN = By.xpath("//div[label[text()='Hometown']]//p");
	public static final By PERSONAL_REGION = By.xpath("//div[label[text()='Region']]//p");
    public static final By PERSONAL_EMAIL = By.xpath("//div[label[text()='Email']]//p");
    public static final By PERSONAL_SPECIAL_NEED_YES_TEXTAREA = By.xpath("//div[label[text()='If yes, please specify']]//textarea");
    public static final By PERSONAL_SPECIAL_NEED_YES_RADIO = By.id("exampleRadios1");
    public static final By PERSONAL_SPECIAL_NEED_NO_RADIO = By.id("exampleRadios2");
    public static final By CONTACT_INFORMATION_POSTAL_ADDRESS1 = By.xpath("(//div[label[text()='Address 1']]//p)[1]");
    public static final By CONTACT_INFORMATION_POSTAL_ADDRESS2 = By.xpath("(//div[label[text()='Address 2']]//p)[1]");
    public static final By CONTACT_INFORMATION_POSTAL_CITY = By.xpath("(//div[label[text()='City/Town']]//p)[1]");
    public static final By CONTACT_INFORMATION_POSTAL_STATE = By.xpath("(//div[label[text()='State']]//p)[1]");
    public static final By CONTACT_INFORMATION_POSTAL_COUNTRY = By.xpath("(//div[label[text()='Country']]//p)[1]");
    public static final By CONTACT_INFORMATION_POSTAL_POSTAL_CODE = By.xpath("(//div[label[text()='Postal Code']]//p)[1]");
    public static final By CONTACT_INFORMATION_POSTAL_TELEPHONE = By.xpath("(//div[label[text()='Telephone']]//p)[1]");
    public static final By CONTACT_INFORMATION_PERMANENT_ADDRESS1 = By.xpath("(//div[label[text()='Address 1']]//p)[2]");
    public static final By CONTACT_INFORMATION_PERMANENT_ADDRESS2 = By.xpath("(//div[label[text()='Address 2']]//p)[2]");
    public static final By CONTACT_INFORMATION_PERMANENT_CITY = By.xpath("(//div[label[text()='City/Town']]//p)[2]");
    public static final By CONTACT_INFORMATION_PERMANENT_STATE = By.xpath("(//div[label[text()='State']]//p)[2]");
    public static final By CONTACT_INFORMATION_PERMANENT_COUNTRY = By.xpath("(//div[label[text()='Country']]//p)[2]");
    public static final By CONTACT_INFORMATION_PERMANENT_POSTAL_CODE = By.xpath("(//div[label[text()='Postal Code']]//p)[2]");
    public static final By CONTACT_INFORMATION_PERMANENT_TELEPHONE = By.xpath("(//div[label[text()='Telephone']]//p)[2]");
    public static final By PARTICULAR_OF_PARENT_TITLE = By.xpath("//div[label[text()='Title']]//div/p");
    public static final By PARTICULAR_OF_PARENT_SURNAME = By.xpath("//div[label[text()='Surname']]/p");
    public static final By PARTICULAR_OF_PARENT_FIRST_NAME = By.xpath("//div[label[text()='First Name']]/p");
    public static final By PARTICULAR_OF_PARENT_MIDDLE_NAME = By.xpath("//div[label[text()='Middle Name']]/p");
    public static final By PARTICULAR_OF_PARENT_RELATIONSHIP_PARENT = By.id("exampleRadiosInline1");
    public static final By PARTICULAR_OF_PARENT_RELATIONSHIP_GUARDIAN = By.id("exampleRadiosInline2");
    public static final By PARTICULAR_OF_PARENT_RELATIONSHIP_SPONSOR = By.id("exampleRadiosInline3");
    public static final By PARTICULAR_OF_PARENT_COMPANY = By.xpath("//div[label[contains(text(),'Company')]]//p");
    public static final By PARTICULAR_OF_PARENT_OCCUPATION = By.xpath("(//div[label[text()='Occupation']]//p)[1]");
    public static final By PARTICULAR_OF_PARENT_ADDRESS1 = By.xpath("(//div[label[text()='Address 1']]//p)[3]"); 
    public static final By PARTICULAR_OF_PARENT_ADDRESS2 = By.xpath("(//div[label[text()='Address 2']]//p)[3]");
    public static final By PARTICULAR_OF_PARENT_COUNTRY = By.xpath("(//div[label[text()='Country']]//p)[3]");
    public static final By PARTICULAR_OF_PARENT_CITY = By.xpath("(//div[label[text()='City/Town']]//p)[3]");
    public static final By PARTICULAR_OF_PARENT_STATE = By.xpath("(//div[label[text()='State']]//p)[3]");
    public static final By PARTICULAR_OF_PARENT_MOBILE_NUMBER = By.xpath("//div[label[text()='Mobile Number']]//p");
    public static final By PARTICULAR_OF_PARENT_TELEPHONE = By.xpath("(//div[label[text()='Telephone']]//p)[3]");
    public static final By PARTICULAR_OF_PARENT_EMAIL = By.xpath("(//div[label[text()='Email address']]//p)[1]");
    public static final By PARTICULAR_OF_PARENT_POSTAL_CODE = By.xpath("(//div[label[text()='Postal Code']]//p)[3]");
    public static final By PROGRAMME_SELECTION_PROGRAMME_TYPE = By.xpath("//div[label[text()='Programme Type']]//p");
    public static final By PROGRAMME_SELECTION_PROGRAMME_TITLE = By.xpath("//div[label[text()='Programme Title']]//p");
    public static final By EDUCATIONAL_BACKGROUND_CURRENT_INSTITUTE = By.xpath("//div[label[text()='Current or most recent SHS/Institution']]//p");
    public static final By EDUCATIONAL_BACKGROUND_CITY = By.xpath("(//div[label[text()='City/Town']]//div/p)[4]");
    public static final By EDUCATIONAL_BACKGROUND_COUNTRY = By.xpath("(//div[label[text()='Country']]//div/p)[4]");
    public static final By EDUCATIONAL_BACKGROUND_YEAR_OF_ENTRY = By.xpath("//div[label[text()='Year of Entry']]//div/p");
    public static final By EDUCATIONAL_BACKGROUND_YEAR_OF_COMPLETION = By.xpath("//div[label[text()='Year of Completion']]//div/p");
    public static final By EDUCATIONAL_BACKGROUND_QUALIFICATION = By.xpath("//div[label[text()='Qualification']]//div/p");
    public static final By EDUCATIONAL_BACKGROUND_OTHER_QUALIFICATION = By.xpath("//div[label[text()='If Others, enter Qualification here']]//div/p");
    public static final By EXAMINATION_TAKEN_EXAM_TYPE = By.xpath("//div[label[text()='Exam Type']]//div/p");
    public static final By EXAMINATION_TAKEN_INDEX_NUMBER = By.xpath("//div[label[text()='Index Number']]//div/p");
    public static final By EXAMINATION_TAKEN_DATE_OF_EXAMINATION = By.xpath("//div[label[text()='Date of Examination']]//div/p");
    public static final By EXAMINATION_TAKEN_RESULT_SLIP = By.xpath("//div[label[text()='Result Slip']]//div/p");
    public static final By EXAMINATION_SUBJECT1 = By.xpath("(//div[label[text()='Subject']]//div/p)[1]");
    public static final By EXAMINATION_GRADE1 = By.xpath("(//div[label[text()='Grade']]//div/p)[1]");
    public static final By EXAMINATION_SUBJECT2 = By.xpath("(//div[label[text()='Subject']]//div/p)[2]");
    public static final By EXAMINATION_GRADE2 = By.xpath("(//div[label[text()='Grade']]//div/p)[2]");
    public static final By EXAMINATION_SUBJECT3 = By.xpath("(//div[label[text()='Subject']]//div/p)[3]");
    public static final By EXAMINATION_GRADE3 = By.xpath("(//div[label[text()='Grade']]//div/p)[3]");
    public static final By EXAMINATION_SUBJECT4 = By.xpath("(//div[label[text()='Subject']]//div/p)[4]");
    public static final By EXAMINATION_GRADE4 = By.xpath("(//div[label[text()='Grade']]//div/p)[4]");
    public static final By EXAMINATION_SUBJECT5 = By.xpath("(//div[label[text()='Subject']]//div/p)[5]");
    public static final By EXAMINATION_GRADE5 = By.xpath("(//div[label[text()='Grade']]//div/p)[5]");
    public static final By EXAMINATION_SUBJECT6 = By.xpath("(//div[label[text()='Subject']]//div/p)[6]");
    public static final By EXAMINATION_GRADE6 = By.xpath("(//div[label[text()='Grade']]//div/p)[6]");
    public static final By FINANCING_STUDY_HOW = By.xpath("//div[label[text()='How do you intend to finance your study in ACDT?']]//div/p");
    public static final By FINANCING_STUDY_OTHER = By.name("others");
    public static final By REFEREE_TITLE = By.xpath("(//div[label[text()='Title']]//div/p)[2]");
    public static final By REFEREE_POSITION = By.xpath("//div[label[text()='Position']]//div/p");
    public static final By REFEREE_FULLNAME = By.xpath("//div[label[text()='Full Name']]//div/p");
    public static final By REFEREE_EMAIl_ADDRESS = By.xpath("//div[label[text()='Email address']]//div/p");
    public static final By REFEREE_OCCUPATION = By.xpath("//div[label[text()='Occupation']]//div/p");
    public static final By REFEREE_DATE = By.xpath("//div[label[text()='Date']]//div/p");
    public static final By REFEREE_APPLICATION_SIGNATURE = By.name("applicantSignature");
    public static final By APPLICATION_CONGRATULATION = By.xpath("//h2[text()='Congratulations!']");
    public static final By APPLICATION_NO = By.xpath("//p[contains(text(),'Application No:')]");
    public static final By APPLICATION_LOGIN_MENU = By.xpath("//span/a[contains(text(),'Login')]");
    
  
    
    public static void validateApplicationSummaryTitle() {
		LOGGER.info("Inside validateFinancingYourStudyTitle Method");
		SeleniumUtil.validateWebElementVisible(APPLICATION_SUMMARY_HEADER_XPATH,
				SeleniumUtil.waitWebElementSync);
	}
    
    public static void validateApplicationCongratulationTitle() {
		LOGGER.info("Inside validateApplicationCongratulationTitle Method");
		SeleniumUtil.validateWebElementVisible(APPLICATION_CONGRATULATION,
				SeleniumUtil.waitWebElementSync);
	}
    
    public static void validateApplicationNo() {
		LOGGER.info("Inside validateApplicationNo Method");
		SeleniumUtil.validateWebElementVisible(APPLICATION_NO,SeleniumUtil.waitWebElementSync);
	}
    
	public static String getPersonalTitleFilledText(){
		LOGGER.info("Inside getPersonalTitleFilledText Method");
		SeleniumUtil.validateWebElementVisible(PERSONAL_TITLE, SeleniumUtil.waitWebElementSync);
		SeleniumUtil.wait(5000);
		return SeleniumUtil.getWebElement(PERSONAL_TITLE).getText();
	}
	
	public static String getPersonalSurNameFilledText(){
		LOGGER.info("Inside getPersonalSurNameFilledText Method");
		return SeleniumUtil.getWebElement(PERSONAL_SURNAME).getText();
	}
	
	public static String getPersonalFirstNameFilledText(){
		LOGGER.info("Inside getPersonalFirstNameFilledText Method");
		return SeleniumUtil.getWebElement(PERSONAL_FIRST_NAME).getText();
	}
	
	public static String getPersonalMiddleNameFilledText(){
		LOGGER.info("Inside getPersonalMiddleNameFilledText Method");
		return SeleniumUtil.getWebElement(PERSONAL_MIDDLE_NAME).getText();
	}
	
	public static String getPersonalOtherNameFilledText(){
		LOGGER.info("Inside getPersonalOtherNameFilledText Method");
		return SeleniumUtil.getWebElement(PERSONAL_OTHER_NAMES).getText();
	}
	
	public static String getPersonalGenderFilledText(){
		LOGGER.info("Inside getPersonalGenderFilledText Method");
		return SeleniumUtil.getWebElement(PERSONAL_GENDER).getText();
	}
	
	public static String getPersonalDateOfBirthFilledText(){
		LOGGER.info("Inside getPersonalDateOfBirthFilledText Method");
		return SeleniumUtil.getWebElement(PERSONAL_DATE_OF_BIRTH).getText();
	}
	
	public static String getPersonalCountryFilledText(){
		LOGGER.info("Inside getPersonalCountryFilledText Method");
		return SeleniumUtil.getWebElement(PERSONAL_COUNTRY).getText();
	}
	
	public static String getPersonalCityOfBirthFilledText(){
		LOGGER.info("Inside getPersonalCityOfBirthFilledText Method");
		return SeleniumUtil.getWebElement(PERSONAL_CITY_OF_BIRTH).getText();
	}
	
	public static String getPersonalNationalityFilledText(){
		LOGGER.info("Inside getPersonalNationalityFilledText Method");
		return SeleniumUtil.getWebElement(PERSONAL_NATIONALITY).getText();
	}
	
	public static String getPersonalReligionFilledText(){
		LOGGER.info("Inside getPersonalReligionFilledText Method");
		return SeleniumUtil.getWebElement(PERSONAL_RELIGION).getText();
	}
	
	public static String getPersonalHomeTownFilledText(){
		LOGGER.info("Inside getPersonalHomeTownFilledText Method");
		return SeleniumUtil.getWebElement(PERSONAL_HOMETOWN).getText();
	}
	
	public static String getPersonalRegionFilledText(){
		LOGGER.info("Inside getPersonalRegionFilledText Method");
		return SeleniumUtil.getWebElement(PERSONAL_REGION).getText();
	}
	
	public static String getPersonalEmailFilledText(){
		LOGGER.info("Inside getPersonalRegionFilledText Method");
		return SeleniumUtil.getWebElement(PERSONAL_EMAIL).getText();
	}
	
	public static String getPersonalSpecialNeedYesFilledText(){
		LOGGER.info("Inside getPersonalSpecialNeedYesFilledText Method");
		return SeleniumUtil.getWebElement(PERSONAL_SPECIAL_NEED_YES_TEXTAREA).getText();
	}
	
	public static String getPersonalSpecialNeedYesRadioFilledText(){
		LOGGER.info("Inside getPersonalSpecialNeedYesRadioFilledText Method");
		boolean flag=SeleniumUtil.getWebElement(PERSONAL_SPECIAL_NEED_YES_RADIO).isSelected();
		
		if(flag){
			return "Yes";
		}else{
			return "No";
		}
		
	}
	
	public static String getPersonalSpecialNeedNoRadioFilledText(){
		LOGGER.info("Inside getPersonalSpecialNeedNoRadioFilledText Method");
		return SeleniumUtil.getWebElement(PERSONAL_SPECIAL_NEED_NO_RADIO).getAttribute("checked");
	}
	
	
	public static String getContactInformationPostalAddress1FilledText(){
		LOGGER.info("Inside getContactInformationPostalAddress1FilledText Method");
		return SeleniumUtil.getWebElement(CONTACT_INFORMATION_POSTAL_ADDRESS1 ).getText();
	}
	
	public static String getContactInformationPostalAddress2FilledText(){
		LOGGER.info("Inside getContactInformationPostalAddress2FilledText Method");
		return SeleniumUtil.getWebElement(CONTACT_INFORMATION_POSTAL_ADDRESS2  ).getText();
	}
	
	public static String getContactInformationPostalCityFilledText(){
		LOGGER.info("Inside getContactInformationPostalCityFilledText Method");
		return SeleniumUtil.getWebElement(CONTACT_INFORMATION_POSTAL_CITY).getText();
	}
	
	public static String getContactInformationPostalStateFilledText(){
		LOGGER.info("Inside getContactInformationPostalStateFilledText Method");
		return SeleniumUtil.getWebElement(CONTACT_INFORMATION_POSTAL_STATE).getText();
	}
	
	public static String getContactInformationPostalCountryFilledText(){
		LOGGER.info("Inside getContactInformationPostalCountryFilledText Method");
		return SeleniumUtil.getWebElement(CONTACT_INFORMATION_POSTAL_COUNTRY ).getText();
	}
	
	public static String getContactInformationPostalPostalCodeFilledText(){
		LOGGER.info("Inside getContactInformationPostalPostalCodeFilledText Method");
		return SeleniumUtil.getWebElement(CONTACT_INFORMATION_POSTAL_POSTAL_CODE  ).getText();
	}
	
	public static String getContactInformationPostalTelephoneFilledText(){
		LOGGER.info("Inside getContactInformationPostalTelephoneFilledText Method");
		return SeleniumUtil.getWebElement(CONTACT_INFORMATION_POSTAL_TELEPHONE  ).getText();
	}
	
	
	public static String getContactInformationPermanentAddress1FilledText(){
		LOGGER.info("Inside getContactInformationPermanentAddress1FilledText Method");
		return SeleniumUtil.getWebElement(CONTACT_INFORMATION_PERMANENT_ADDRESS1  ).getText();
	}
	
	public static String getContactInformationPermanentAddress2FilledText(){
		LOGGER.info("Inside getContactInformationPermanentAddress2FilledText Method");
		return SeleniumUtil.getWebElement(CONTACT_INFORMATION_PERMANENT_ADDRESS2   ).getText();
	}
	
	public static String getContactInformationPermanentCityFilledText(){
		LOGGER.info("Inside getContactInformationPermanentCityFilledText Method");
		return SeleniumUtil.getWebElement(CONTACT_INFORMATION_PERMANENT_CITY ).getText();
	}
	
	public static String getContactInformationPermanentStateFilledText(){
		LOGGER.info("Inside getContactInformationPermanentStateFilledText Method");
		return SeleniumUtil.getWebElement(CONTACT_INFORMATION_PERMANENT_STATE ).getText();
	}
	
	public static String getContactInformationPermanentCountryFilledText(){
		LOGGER.info("Inside getContactInformationPermanentCountryFilledText Method");
		return SeleniumUtil.getWebElement(CONTACT_INFORMATION_PERMANENT_COUNTRY).getText();
	}
	
	public static String getContactInformationPermanentPostalCodeFilledText(){
		LOGGER.info("Inside getContactInformationPermanentPostalCodeFilledText Method");
		return SeleniumUtil.getWebElement(CONTACT_INFORMATION_PERMANENT_POSTAL_CODE).getText();
	}
	
	public static String getContactInformationPermanentTelephoneFilledText(){
		LOGGER.info("Inside getContactInformationPermanentTelephoneFilledText Method");
		return SeleniumUtil.getWebElement(CONTACT_INFORMATION_PERMANENT_TELEPHONE).getText();
	}
	
	
	public static String getParticularOfParentTitleFilledText(){
		LOGGER.info("Inside getParticularOfParentTitleFilledText Method");
		SeleniumUtil.scrollToWebElement(PARTICULAR_OF_PARENT_TITLE);
		return SeleniumUtil.getWebElement(PARTICULAR_OF_PARENT_TITLE).getText();
	}
	public static String getParticularOfParentSurNameFilledText(){
		LOGGER.info("Inside getParticularOfParentSurNameFilledText Method");
		return SeleniumUtil.getWebElement(PARTICULAR_OF_PARENT_SURNAME).getText();
	}
	
	public static String getParticularOfParentFirstNameFilledText(){
		LOGGER.info("Inside getParticularOfParentFirstNameFilledText Method");
		return SeleniumUtil.getWebElement(PARTICULAR_OF_PARENT_FIRST_NAME ).getText();
	}
	
	public static String getParticularOfParentMiddleNameFilledText(){
		LOGGER.info("Inside getParticularOfParentMiddleNameFilledText Method");
		return SeleniumUtil.getWebElement(PARTICULAR_OF_PARENT_MIDDLE_NAME ).getText();
	}
	public static String getParticularOfParentRelatioshipParentFilledText(){
		LOGGER.info("Inside getParticularOfParentRelatioshipParentFilledText Method");
		boolean flag=SeleniumUtil.getWebElement(PARTICULAR_OF_PARENT_RELATIONSHIP_PARENT ).isSelected();
	    if(flag){
	    	return "Parent";
	    }else{
	    	return "Guardian";
	    }
	}
	public static String getParticularOfParentRelatioshipGuardianFilledText(){
		LOGGER.info("Inside getParticularOfParentRelatioshipGuardianFilledText Method");
		boolean flag = SeleniumUtil.getWebElement(PARTICULAR_OF_PARENT_RELATIONSHIP_GUARDIAN ).isSelected();
		if(flag){
	    	return "Guardian";
	    }else{
	    	return "Parent";
	    }
	
	}
	public static String getParticularOfParentRelatioshipSponsorFilledText(){
		LOGGER.info("Inside getParticularOfParentRelatioshipSponsorFilledText Method");
		boolean flag= SeleniumUtil.getWebElement(PARTICULAR_OF_PARENT_RELATIONSHIP_SPONSOR ).isSelected();
		if(flag){
	    	return "Sponsor";
	    }else{
	    	return "Parent";
	    }
	}
	public static String getParticularOfParentCompanyFilledText(){
		LOGGER.info("Inside getParticularOfParentCompanyFilledText Method");
		return SeleniumUtil.getWebElement(PARTICULAR_OF_PARENT_COMPANY ).getText();
	}
	public static String getParticularOfParentOccupationFilledText(){
		LOGGER.info("Inside getParticularOfParentOccupationFilledText Method");
		return SeleniumUtil.getWebElement(PARTICULAR_OF_PARENT_OCCUPATION  ).getText();
	}
	public static String getParticularOfParentAddres1FilledText(){
		LOGGER.info("Inside getParticularOfParentAddres1FilledText Method");
		return SeleniumUtil.getWebElement(PARTICULAR_OF_PARENT_ADDRESS1 ).getText();
	}
	public static String getParticularOfParentAddress2FilledText(){
		LOGGER.info("Inside getParticularOfParentAddress2FilledText Method");
		return SeleniumUtil.getWebElement(PARTICULAR_OF_PARENT_ADDRESS2 ).getText();
	}
	public static String getParticularOfParentCountryFilledText(){
		LOGGER.info("Inside getParticularOfParentCountryFilledText Method");
		SeleniumUtil.scrollToWebElement(PARTICULAR_OF_PARENT_COUNTRY);
		return SeleniumUtil.getWebElement(PARTICULAR_OF_PARENT_COUNTRY ).getText();
	}
	public static String getParticularOfParentCityFilledText(){
		LOGGER.info("Inside getParticularOfParentCityFilledText Method");
		SeleniumUtil.scrollToWebElement(PARTICULAR_OF_PARENT_CITY);
		return SeleniumUtil.getWebElement(PARTICULAR_OF_PARENT_CITY ).getText();
	}
	public static String getParticularOfParentStateFilledText(){
		LOGGER.info("Inside getParticularOfParentStateFilledText Method");
		return SeleniumUtil.getWebElement(PARTICULAR_OF_PARENT_STATE ).getText();
	}
	public static String getParticularOfParentMobileFilledText(){
		LOGGER.info("Inside getParticularOfParentMobileFilledText Method");
		return SeleniumUtil.getWebElement(PARTICULAR_OF_PARENT_MOBILE_NUMBER ).getText();
	}
	public static String getParticularOfParentTelephoneFilledText(){
		LOGGER.info("Inside getParticularOfParentTelephoneFilledText Method");
		return SeleniumUtil.getWebElement(PARTICULAR_OF_PARENT_TELEPHONE ).getText();
	}
	public static String getParticularOfParentEmailFilledText(){
		LOGGER.info("Inside getParticularOfParentParentEmailFilledText Method");
		SeleniumUtil.scrollToWebElement(PARTICULAR_OF_PARENT_EMAIL);
		return SeleniumUtil.getWebElement(PARTICULAR_OF_PARENT_EMAIL ).getText();
	}
	public static String getParticularOfParentPostalCodeFilledText(){
		LOGGER.info("Inside getParticularOfParentPostalCodeFilledText Method");
		return SeleniumUtil.getWebElement(PARTICULAR_OF_PARENT_POSTAL_CODE ).getText();
	}
	public static String getProgrammeTypeFilledText(){
		LOGGER.info("Inside getProgrammeTypeFilledText Method");
		return SeleniumUtil.getWebElement(PROGRAMME_SELECTION_PROGRAMME_TYPE ).getText();
	}
	public static String getProgrammeTitleFilledText(){
		LOGGER.info("Inside getProgrammeTitleFilledText Method");
		return SeleniumUtil.getWebElement(PROGRAMME_SELECTION_PROGRAMME_TITLE ).getText();
	}
    
	public static String getEducationBackGroundCurrentInstituteFilledText(){
		LOGGER.info("Inside getEducationBackGroundCurrentInstituteFilledText Method");
		return SeleniumUtil.getWebElement(EDUCATIONAL_BACKGROUND_CURRENT_INSTITUTE).getText();
	}
	
	public static String getEducationBackGroundCityFilledText(){
		LOGGER.info("Inside getEducationBackGroundCityFilledText Method");
		return SeleniumUtil.getWebElement(EDUCATIONAL_BACKGROUND_CITY ).getText();
	}
	
	public static String getEducationBackGroundCountryFilledText(){
		LOGGER.info("Inside getEducationBackGroundCountryFilledText Method");
		return SeleniumUtil.getWebElement(EDUCATIONAL_BACKGROUND_COUNTRY).getText();
	}
	
	public static String getEducationBackGroundYearOfEntryFilledText(){
		LOGGER.info("Inside getEducationBackGroundYearOfEntryFilledText Method");
		return SeleniumUtil.getWebElement(EDUCATIONAL_BACKGROUND_YEAR_OF_ENTRY ).getText();
	}
	
	public static String getEducationBackGroundYearOfCompletionFilledText(){
		LOGGER.info("Inside getEducationBackGroundYearOfCompletionFilledText Method");
		return SeleniumUtil.getWebElement(EDUCATIONAL_BACKGROUND_YEAR_OF_COMPLETION).getText();
	}
	
	public static String getEducationBackGroundQualificationFilledText(){
		LOGGER.info("Inside getEducationBackGroundQualificationFilledText Method");
		return SeleniumUtil.getWebElement(EDUCATIONAL_BACKGROUND_QUALIFICATION ).getText();
	}
	public static String getEducationBackGroundOtherQualificationFilledText(){
		LOGGER.info("Inside getEducationBackGroundOtherQualificationFilledText Method");
		return SeleniumUtil.getWebElement(EDUCATIONAL_BACKGROUND_OTHER_QUALIFICATION  ).getText();
	}
	
	public static String getExaminationTakenExamTypeFilledText(){
		LOGGER.info("Inside getExaminationTakenExamTypeFilledText Method");
		return SeleniumUtil.getWebElement(EXAMINATION_TAKEN_EXAM_TYPE).getText();
	}
	
	public static String getExaminationTakenIndexNumberFilledText(){
		LOGGER.info("Inside getExaminationTakenIndexNumberFilledText Method");
		return SeleniumUtil.getWebElement(EXAMINATION_TAKEN_INDEX_NUMBER ).getText();
	}
	
	public static String getExaminationTakenDateOfExaminationFilledText(){
		LOGGER.info("Inside getExaminationTakenDateOfExaminationFilledText Method");
		return SeleniumUtil.getWebElement(EXAMINATION_TAKEN_DATE_OF_EXAMINATION  ).getText();
	}
	
	public static String getExaminationTakenResultSlipFilledText(){
		LOGGER.info("Inside getExaminationTakenResultSlipFilledText Method");
		return SeleniumUtil.getWebElement(EXAMINATION_TAKEN_RESULT_SLIP).getText();
	}
	
	public static String getExaminationSubject1FilledText(){
		LOGGER.info("Inside getExaminationSubject1FilledText Method");
		return SeleniumUtil.getWebElement(EXAMINATION_SUBJECT1).getText();
	}
	
	public static String getExaminationSubject2FilledText(){
		LOGGER.info("Inside getExaminationSubject2FilledText Method");
		return SeleniumUtil.getWebElement(EXAMINATION_SUBJECT2).getText();
	}
	public static String getExaminationSubject3FilledText(){
		LOGGER.info("Inside getExaminationSubject3FilledText Method");
		return SeleniumUtil.getWebElement(EXAMINATION_SUBJECT3).getText();
	}
	public static String getExaminationSubject4FilledText(){
		LOGGER.info("Inside getExaminationSubject4FilledText Method");
		return SeleniumUtil.getWebElement(EXAMINATION_SUBJECT4).getText();
	}
	public static String getExaminationSubject5FilledText(){
		LOGGER.info("Inside getExaminationSubject5FilledText Method");
		return SeleniumUtil.getWebElement(EXAMINATION_SUBJECT5).getText();
	}
	
	public static String getExaminationSubject6FilledText(){
		LOGGER.info("Inside getExaminationSubject6FilledText Method");
		return SeleniumUtil.getWebElement(EXAMINATION_SUBJECT6).getText();
	}
	
	public static String getExaminationGrade1FilledText(){
		LOGGER.info("Inside getExaminationGrade1FilledText Method");
		return SeleniumUtil.getWebElement(EXAMINATION_GRADE1).getText();
	}
	public static String getExaminationGrade2FilledText(){
		LOGGER.info("Inside getExaminationGrade2FilledText Method");
		return SeleniumUtil.getWebElement(EXAMINATION_GRADE2).getText();
	}
	public static String getExaminationGrade3FilledText(){
		LOGGER.info("Inside getExaminationGrade3FilledText Method");
		return SeleniumUtil.getWebElement(EXAMINATION_GRADE3).getText();
	}
	public static String getExaminationGrade4FilledText(){
		LOGGER.info("Inside getExaminationGrade4FilledText Method");
		return SeleniumUtil.getWebElement(EXAMINATION_GRADE4).getText();
	}
	public static String getExaminationGrade5FilledText(){
		LOGGER.info("Inside getExaminationGrade5FilledText Method");
		return SeleniumUtil.getWebElement(EXAMINATION_GRADE5).getText();
	}
	public static String getExaminationGrade6FilledText(){
		LOGGER.info("Inside getExaminationGrade6FilledText Method");
		return SeleniumUtil.getWebElement(EXAMINATION_GRADE6).getText();
	}
	
	public static String getFinancingStudyHowFilledText(){
		LOGGER.info("Inside getFinancingStudyHowFilledText Method");
		return SeleniumUtil.getWebElement(FINANCING_STUDY_HOW).getText();
	}
	
	public static String getFinancingStudyOtherFilledText(){
		LOGGER.info("Inside getFinancingStudyOtherFilledText Method");
		return SeleniumUtil.getWebElement(FINANCING_STUDY_OTHER).getText();
	}
	public static String getRefereeTitleFilledText(){
		LOGGER.info("Inside getRefereeTitleFilledText Method");
		return SeleniumUtil.getWebElement(REFEREE_TITLE).getText();
	}
	public static String getRefereePositionFilledText(){
		LOGGER.info("Inside getRefereePositionFilledText Method");
		return SeleniumUtil.getWebElement(REFEREE_POSITION).getText();
	}
	
	public static String getRefereeFullNameFilledText(){
		LOGGER.info("Inside getRefereeFullNameFilledText Method");
		return SeleniumUtil.getWebElement(REFEREE_FULLNAME).getText();
	}
	
	public static String getRefereeEmailAddressFilledText(){
		LOGGER.info("Inside getRefereeEmailAddressFilledText Method");
		return SeleniumUtil.getWebElement(REFEREE_EMAIl_ADDRESS).getText();
	}
	
	public static String getRefereeOccupationFilledText(){
		LOGGER.info("Inside getRefereeOccupationFilledText Method");
		return SeleniumUtil.getWebElement(REFEREE_OCCUPATION).getText();
	}
	
	public static String getRefereeDateFilledText(){
		LOGGER.info("Inside getRefereeDateFilledText Method");
		return SeleniumUtil.getWebElement(REFEREE_DATE).getText();
	}
	
	public static String getRefereeApplicationSignatureFilledText(){
		LOGGER.info("Inside getRefereeApplicationSignatureFilledText Method");
		return SeleniumUtil.getWebElement(REFEREE_APPLICATION_SIGNATURE ).getText();
	}
	
	public static void clickSubmitButton(){
		SeleniumUtil.getWebElement(SUBMIT_XPATH).click();
	}
	
	public static void clickLoginMenu(){
		SeleniumUtil.getWebElement(APPLICATION_LOGIN_MENU).click();
	}
	
}
