package com.aucdt.edu.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.aucdt.edu.util.SeleniumUtil;

public class EducationalBackgroundPage {
	private static final Logger LOGGER = LogManager.getLogger(EducationalBackgroundPage.class);
	public static final String EDUCATIONAl_BACKGROUND_HEADER_XPATH = "//h3[text()='Educational Background']";
	public static final String OTHER_EDUCATIONAl_BACKGROUND_HEADER_XPATH="//h5[text()='Other Educational Background']";
	public static final String PREVIOUS_ATTENDANCEUNIVERSITY_HEADER_XPATH="//h3[text()='Previous Attendance at a University/College']";
	public static final String CURRENT_RECENT_SHS_INSTITUTE_NAME = "recentInstitutionName";
	public static final String CITY_TOWN_NAME = "recentInstitutionCity";
	public static final String COUNTRY_XPATH = "//div[label[text()='Country']]//div[@class='c-btn']/span[1]";
	public static final String COUNTRY_GETTEXT_XPATH="//div[label[text()='Country']]//div[@class='c-btn']/span/span";
	public static final String DATE_OF_ENTRY_NAME = "selectedItemsYearEntryModel";
	public static final String DATE_OF_COMPLETION_NAME = "selectedItemsEndDateModel";
	public static final String QUALIFICATION_XPATH = "//div[label[text()='Qualification']]//div[@class='c-btn']/span[1]";
	public static final String QUALIFICATION_GETTEXT_XPATH = "//div[label[text()='Qualification']]//div[@class='c-btn']/span/span";
	public static final String RECENT_OTHER_QUALIFICATION_NAME = "recentOtherQualification";
	public static final String ADD_OTHER_QUALIFICATION_BUTTON_XPATH = "//a[text()=' Add Other Educational Background']";
	public static final String EVER_ENROLLED_UNIVERSITY_XPATH = "//label[@class='form-check-label' and contains(text(),'Yes')]";
	public static final String OLD_INSTITUTION_NAME = "oldInstitutionName";
	public static final String OLD_INSTITUTION_CITY_NAME = "oldInstitutionCity";
	public static final String OLD_INSTITUTION_COUNTRY_XPATH = "(//div[label[text()='Country']]//div[@class='c-btn']/span)[3]";
	public static final String OLD_INSTITUTION_DATE_OF_ENTRY_NAME = "selectedItemsOtherStartDateModel";
	public static final String OLD_INSTITUTION_DATE_OF_COMPLETION_NAME = "selectedItemsOtherEndDateModel";
	public static final String OLD_INSTITUTION_QUALIFICATION_XPATH = "(//div[label[text()='Qualification']]//div[@class='c-btn']/span)[3]";
	public static final String OLD_INSTITUTION_OTHER_QUALIFICATION_NAME = "oldOtherQualification";
	public static final String OLD_INSTITUTION_DELETE_BUTTON_XPATH = "//span[text()='Delete Section']";
	public static final String OLD_INSTITUTION_DELETE_NO_XPATH = "//button[text()='No']";
	public static final String OLD_INSTITUTION_DELETE_YES_XPATH = "//button[text()='Yes']";
	public static final String ERROR_MESSAGE_XPATH ="(//div[@class='col-md-12'])[2]";
	public static final String PREVIOUS_UNIVERSITY_NAME = "universityName";
	public static final String PREVIOUS_NAMEUSED_NAME = "namesUsed";
	public static final String PREVIOUS_DATE_OF_ADMISSION_NAME = "admissionYearModel";
	public static final String PREVIOUS_HOSTEL_OF_RESIDENCE_NAME = "residencyName";
	public static final String PREVIOUS_PROGRAMME_OF_STUDY_NAME = "programmeOfStudy";
	public static final String PREVIOUS_LAST_YEAR_OF_STUDY_NAME = "lastYearOfStudyModel";
	public static final String PREVIOUS_REASON_FOR_LEAVING_NAME = "reasonsForLeaving";
	public static final String SEARCH_XPATH="(//input[@placeholder='Search'])[index]";
    public static final String SELECT_LABEL_XPATH="//label[text()='selectText']";
    public static final String CALENDAR_MONTH_XPATH="//select[@title='Select month']";
    public static final String CALENDAR_YEAR_XPATH="//select[@title='Select year']";
    public static final String CALENDAR_DATE_XPATH="(//div[text()='date'])[1]";
    public static final String NEXT_BUTTON_XPATH="//a[text()='Next']";
    public static final String PREVIOUS_ENROLLED_UNIVERSITY_RADIO_YES_XPATH="//label[input[@id='exampleRadios1']]";
    public static final String PREVIOUS_ENROLLED_UNIVERSITY_RADIO_NO_XPATH="//label[input[@id='exampleRadios2']]";
    public static final String PREVIOUS_XPATH = "//a[text()='Previous']";
    public static void validateEducationalBackgroundTitle() {
		LOGGER.info("Inside validateEducationalBackgroundTitle Method");
		SeleniumUtil.wait(1000);
		SeleniumUtil.validateWebElementVisible(By.xpath(EDUCATIONAl_BACKGROUND_HEADER_XPATH),
				SeleniumUtil.waitWebElementSync);
	}
	public static void validateOtherEducationalBackgroundTitle() {
		LOGGER.info("Inside validateOtherEducationalBackgroundTitle Method");
		SeleniumUtil.validateWebElementVisible(By.xpath(OTHER_EDUCATIONAl_BACKGROUND_HEADER_XPATH),
				SeleniumUtil.waitWebElementSync);
	}
	public static void validateOtherEducationalBackgroundNotDisplayedTitle() {
		LOGGER.info("Inside validateOtherEducationalBackgroundTitle Method");
		SeleniumUtil.validateWebElementNotVisible(By.xpath(OTHER_EDUCATIONAl_BACKGROUND_HEADER_XPATH),
				SeleniumUtil.waitWebElementSync);
	}
	
	public static void validatePreviousAttendanceUniversityTitle() {
		LOGGER.info("Inside validatePreviousAttendanceUniversityTitle Method");
		SeleniumUtil.validateWebElementVisible(By.xpath(PREVIOUS_ATTENDANCEUNIVERSITY_HEADER_XPATH),
				SeleniumUtil.waitWebElementSync);
	}
	
	public static void validatePreviousAttendanceUniversityNotDisplayTitle() {
		LOGGER.info("Inside validatePreviousAttendanceUniversityTitle Method");
		SeleniumUtil.validateWebElementNotVisible(By.xpath(PREVIOUS_ATTENDANCEUNIVERSITY_HEADER_XPATH),
				SeleniumUtil.waitWebElementSync);
	}
	
	
	public static void enterCurrentEducationalBackGroundDetails(String recentInstitution, String city, String country, String yearOfEntry, String yearOfCompletion, String qualification ,String otherQualification) throws InterruptedException{
		LOGGER.info("Inside enterCurrentEducationalBackGroundDetails Method");
		
		if(!("".equals(recentInstitution))){
			SeleniumUtil.wait(1000);
			SeleniumUtil.getWebElement(By.name(CURRENT_RECENT_SHS_INSTITUTE_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(CURRENT_RECENT_SHS_INSTITUTE_NAME)).sendKeys(recentInstitution);	
		}else{
			SeleniumUtil.getWebElement(By.name(CURRENT_RECENT_SHS_INSTITUTE_NAME)).clear();
		}
		
		if(!("".equals(city))){
			SeleniumUtil.getWebElement(By.name(CITY_TOWN_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(CITY_TOWN_NAME)).sendKeys(city);	
		}else{
			SeleniumUtil.getWebElement(By.name(CITY_TOWN_NAME)).clear();	
		}
		
		if(!("".equals(country))){
			SeleniumUtil.wait(1000);
			SeleniumUtil.scrollToWebElement(By.xpath(COUNTRY_XPATH));
			if(!country.equals(SeleniumUtil.getWebElement(By.xpath(COUNTRY_XPATH)).getText().trim())){
			SeleniumUtil.getWebElement(By.xpath(COUNTRY_XPATH)).click();
			SeleniumUtil.wait(1000);
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "1"))).sendKeys(country);
			SeleniumUtil.wait(1000);
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "1"))).click();
			SeleniumUtil.wait(1000);
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", country))).click();
			}	
		}else{
			SeleniumUtil.getWebElement(By.xpath(COUNTRY_XPATH)).click();
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "1"))).sendKeys("Please Select");
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", "Please Select"))).click();
		}
		
		if(!("".equals(yearOfEntry))){
			 String[] dobsplit=yearOfEntry.split("/");
			SeleniumUtil.scrollToWebElement(By.name(DATE_OF_ENTRY_NAME));
		    SeleniumUtil.getWebElement(By.name(DATE_OF_ENTRY_NAME)).click();
		    Thread.sleep(1000);
			SeleniumUtil.selectWebList(By.xpath(CALENDAR_YEAR_XPATH), dobsplit[2], "selectByVisibleText");
			Thread.sleep(1000);
			SeleniumUtil.selectWebList(By.xpath(CALENDAR_MONTH_XPATH), dobsplit[1], "SelectByvalue");
			Thread.sleep(1000);
			SeleniumUtil.getWebElement(By.xpath(CALENDAR_DATE_XPATH.replace("date", dobsplit[0]))).click();
			//Thread.sleep(2000);	
			
		}
		
		if(!("".equals(yearOfCompletion))){
			 String[] dobsplit=yearOfCompletion.split("/");
			SeleniumUtil.scrollToWebElement(By.name(DATE_OF_COMPLETION_NAME));
		    SeleniumUtil.getWebElement(By.name(DATE_OF_COMPLETION_NAME)).click();
		    Thread.sleep(1000);
			SeleniumUtil.selectWebList(By.xpath(CALENDAR_YEAR_XPATH), dobsplit[2], "selectByVisibleText");
			Thread.sleep(1000);
			SeleniumUtil.selectWebList(By.xpath(CALENDAR_MONTH_XPATH), dobsplit[1], "SelectByvalue");
			Thread.sleep(1000);
			SeleniumUtil.getWebElement(By.xpath(CALENDAR_DATE_XPATH.replace("date", dobsplit[0]))).click();
			//Thread.sleep(2000);	
			
		}
		
		if(!("".equals(qualification))){
			if(!qualification.equals(SeleniumUtil.getWebElement(By.xpath(QUALIFICATION_XPATH)).getText().trim())){
			SeleniumUtil.getWebElement(By.xpath(QUALIFICATION_XPATH)).click();
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "2"))).sendKeys(qualification);
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", qualification))).click();
			}	
		}/*else{
			SeleniumUtil.getWebElement(By.xpath(QUALIFICATION_XPATH)).click();
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "2"))).sendKeys("Please Select");
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", "Please Select"))).click();
		}*/
		
		if(!("".equals(otherQualification))){
			SeleniumUtil.scrollToWebElement(By.name(RECENT_OTHER_QUALIFICATION_NAME));
			SeleniumUtil.getWebElement(By.name(RECENT_OTHER_QUALIFICATION_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(RECENT_OTHER_QUALIFICATION_NAME)).sendKeys(otherQualification);	
		}else{
			SeleniumUtil.getWebElement(By.name(RECENT_OTHER_QUALIFICATION_NAME)).clear();
		}
	}
	
	public static void enterOtherEducationalBackGroundDetails(String otherInstitution, String city, String country, String yearOfEntry, String yearOfCompletion, String qualification, String otherQualification  ) throws InterruptedException{
		LOGGER.info("Inside enterOtherEducationalBackGroundDetails Method");
		
		if(!("".equals(otherInstitution))){
			SeleniumUtil.getWebElement(By.name(OLD_INSTITUTION_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(OLD_INSTITUTION_NAME)).sendKeys(otherInstitution);	
		}
		
		if(!("".equals(city))){
			SeleniumUtil.getWebElement(By.name(OLD_INSTITUTION_CITY_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(OLD_INSTITUTION_CITY_NAME)).sendKeys(city);	
		}
		
		if(!("".equals(country))){
			Thread.sleep(1000);
			SeleniumUtil.scrollToWebElement(By.xpath(OLD_INSTITUTION_COUNTRY_XPATH));
			SeleniumUtil.getWebElement(By.xpath(OLD_INSTITUTION_COUNTRY_XPATH )).click();
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "3"))).sendKeys(country);
			SeleniumUtil.getWebElements(By.xpath(SELECT_LABEL_XPATH.replace("selectText", country))).get(1).click();
				
		}
		
		if(!("".equals(yearOfEntry))){
			 String[] dobsplit=yearOfEntry.split("/");
		    SeleniumUtil.getWebElement(By.name(OLD_INSTITUTION_DATE_OF_ENTRY_NAME)).click();
		    Thread.sleep(1000);
			SeleniumUtil.selectWebList(By.xpath(CALENDAR_YEAR_XPATH), dobsplit[2], "selectByVisibleText");
			Thread.sleep(1000);
			SeleniumUtil.selectWebList(By.xpath(CALENDAR_MONTH_XPATH), dobsplit[1], "SelectByvalue");
			Thread.sleep(1000);
			SeleniumUtil.getWebElement(By.xpath(CALENDAR_DATE_XPATH.replace("date", dobsplit[0]))).click();
			//Thread.sleep(2000);	
			
		}
		
		if(!("".equals(yearOfCompletion))){
			 String[] dobsplit=yearOfCompletion.split("/");
		    SeleniumUtil.getWebElement(By.name(OLD_INSTITUTION_DATE_OF_COMPLETION_NAME)).click();
		    Thread.sleep(1000);
			SeleniumUtil.selectWebList(By.xpath(CALENDAR_YEAR_XPATH), dobsplit[2], "selectByVisibleText");
			Thread.sleep(1000);
			SeleniumUtil.selectWebList(By.xpath(CALENDAR_MONTH_XPATH), dobsplit[1], "SelectByvalue");
			Thread.sleep(1000);
			SeleniumUtil.getWebElement(By.xpath(CALENDAR_DATE_XPATH.replace("date", dobsplit[0]))).click();
			//Thread.sleep(2000);	
			
		}
		
		if(!("".equals(qualification))){
			SeleniumUtil.scrollToWebElement(By.xpath(OLD_INSTITUTION_QUALIFICATION_XPATH));
			SeleniumUtil.getWebElement(By.xpath(OLD_INSTITUTION_QUALIFICATION_XPATH)).click();
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "4"))).sendKeys(qualification);
			SeleniumUtil.getWebElements(By.xpath(SELECT_LABEL_XPATH.replace("selectText", qualification))).get(1).click();
				
		}
		
		if(!("".equals(otherQualification))){
			SeleniumUtil.getWebElement(By.name(OLD_INSTITUTION_OTHER_QUALIFICATION_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(OLD_INSTITUTION_OTHER_QUALIFICATION_NAME)).sendKeys(otherQualification);	
		}
		
	}
	
	public static void enterPreviousEducationalBackGroundDetails(String previousUniversity, String nameUsed, String dateOfAdmission, String hostel,String programmeOfStudy, String yearOfStudy, String reasonOfLeavingUniversity ) throws InterruptedException{
		LOGGER.info("Inside enterOtherEducationalBackGroundDetails Method");
		
		if(!("".equals(previousUniversity))){
			SeleniumUtil.getWebElement(By.name(PREVIOUS_UNIVERSITY_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(PREVIOUS_UNIVERSITY_NAME)).sendKeys(previousUniversity);	
		}
		
		if(!("".equals(nameUsed))){
			SeleniumUtil.getWebElement(By.name(PREVIOUS_NAMEUSED_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(PREVIOUS_NAMEUSED_NAME)).sendKeys(nameUsed);	
		}
		
		
		
		if(!("".equals(dateOfAdmission))){
			 String[] dobsplit=dateOfAdmission.split("/");
			 SeleniumUtil.scrollToWebElement(By.name(PREVIOUS_DATE_OF_ADMISSION_NAME));
		    SeleniumUtil.getWebElement(By.name(PREVIOUS_DATE_OF_ADMISSION_NAME)).click();
		    Thread.sleep(1000);
			SeleniumUtil.selectWebList(By.xpath(CALENDAR_YEAR_XPATH), dobsplit[2], "selectByVisibleText");
			Thread.sleep(1000);
			SeleniumUtil.selectWebList(By.xpath(CALENDAR_MONTH_XPATH), dobsplit[1], "SelectByvalue");
			Thread.sleep(1000);
			SeleniumUtil.getWebElement(By.xpath(CALENDAR_DATE_XPATH.replace("date", dobsplit[0]))).click();
			//Thread.sleep(2000);	
			
		}
		if(!("".equals(hostel))){
			SeleniumUtil.getWebElement(By.name(PREVIOUS_HOSTEL_OF_RESIDENCE_NAME )).clear();
			
			SeleniumUtil.getWebElement(By.name(PREVIOUS_HOSTEL_OF_RESIDENCE_NAME)).sendKeys(hostel);
				
		}
		if(!("".equals(programmeOfStudy))){
			SeleniumUtil.getWebElement(By.name(PREVIOUS_PROGRAMME_OF_STUDY_NAME )).clear();
			
			SeleniumUtil.getWebElement(By.name(PREVIOUS_PROGRAMME_OF_STUDY_NAME)).sendKeys(programmeOfStudy);
				
		}
		
		
		if(!("".equals(yearOfStudy))){
			SeleniumUtil.scrollToWebElement(By.name(PREVIOUS_LAST_YEAR_OF_STUDY_NAME));
			 String[] dobsplit=yearOfStudy.split("/");
		    SeleniumUtil.getWebElement(By.name(PREVIOUS_LAST_YEAR_OF_STUDY_NAME)).click();
		    Thread.sleep(1000);
			SeleniumUtil.selectWebList(By.xpath(CALENDAR_YEAR_XPATH), dobsplit[2], "selectByVisibleText");
			Thread.sleep(1000);
			SeleniumUtil.selectWebList(By.xpath(CALENDAR_MONTH_XPATH), dobsplit[1], "SelectByvalue");
			Thread.sleep(1000);
			SeleniumUtil.getWebElement(By.xpath(CALENDAR_DATE_XPATH.replace("date", dobsplit[0]))).click();
			//Thread.sleep(2000);	
			
		}
		
		if(!("".equals(reasonOfLeavingUniversity))){
			SeleniumUtil.scrollToWebElement(By.name(PREVIOUS_REASON_FOR_LEAVING_NAME));
			SeleniumUtil.getWebElement(By.name(PREVIOUS_REASON_FOR_LEAVING_NAME )).clear();
			
			SeleniumUtil.getWebElement(By.name(PREVIOUS_REASON_FOR_LEAVING_NAME)).sendKeys(reasonOfLeavingUniversity);
				
		}
		
		
	}
	
	
	public static void clickNextButtonInEducationalBackGround(){
		SeleniumUtil.scrollToWebElement(By.xpath(NEXT_BUTTON_XPATH));
		SeleniumUtil.getWebElement(By.xpath(NEXT_BUTTON_XPATH)).click();
	}
	public static void clickOtherEducationalBackGroundButton() throws InterruptedException{
		Thread.sleep(1000);
		SeleniumUtil.scrollToWebElement(By.xpath(ADD_OTHER_QUALIFICATION_BUTTON_XPATH));
		SeleniumUtil.waitWebElementClickable(By.xpath(ADD_OTHER_QUALIFICATION_BUTTON_XPATH), 20);
		Thread.sleep(1000);
		//SeleniumUtil.doubleClick(By.xpath(ADD_OTHER_QUALIFICATION_BUTTON_XPATH));
		SeleniumUtil.javascriptClickElement(By.xpath(ADD_OTHER_QUALIFICATION_BUTTON_XPATH));
		
		Thread.sleep(1000);
		SeleniumUtil.javascriptClickElement(By.xpath(ADD_OTHER_QUALIFICATION_BUTTON_XPATH));
		Thread.sleep(1000);
		
	}
	public static void clickDeleteSectionOtherEducationalBackGroundButton() throws InterruptedException{
		SeleniumUtil.waitWebElementClickable(By.xpath(OLD_INSTITUTION_DELETE_BUTTON_XPATH), 20);
		Thread.sleep(1000);
		SeleniumUtil.javascriptClickElement(By.xpath(OLD_INSTITUTION_DELETE_BUTTON_XPATH));
		//SeleniumUtil.getWebElement(By.xpath(OLD_INSTITUTION_DELETE_BUTTON_XPATH)).click();
	}
	
	public static void clickYesNoRadioButton(String yesNo) throws InterruptedException{
		if("yes".equalsIgnoreCase(yesNo)){
			SeleniumUtil.scrollToWebElement(By.xpath(PREVIOUS_ENROLLED_UNIVERSITY_RADIO_YES_XPATH));
			Thread.sleep(1000);
			SeleniumUtil.waitWebElementClickable(By.xpath(PREVIOUS_ENROLLED_UNIVERSITY_RADIO_YES_XPATH), 20);
		    SeleniumUtil.getWebElement(By.xpath(PREVIOUS_ENROLLED_UNIVERSITY_RADIO_YES_XPATH)).click();
		}else{
			SeleniumUtil.waitWebElementClickable(By.xpath(PREVIOUS_ENROLLED_UNIVERSITY_RADIO_NO_XPATH), 20);
			SeleniumUtil.getWebElement(By.xpath(PREVIOUS_ENROLLED_UNIVERSITY_RADIO_NO_XPATH)).click();
		}
	}
	
	
	public static void clickYesNoDeleteOtherEducationalConfirmation(String yesNo) throws InterruptedException{
		
		if("yes".equalsIgnoreCase(yesNo)){
			Thread.sleep(1000);
			SeleniumUtil.waitWebElementClickable(By.xpath(OLD_INSTITUTION_DELETE_YES_XPATH), 30);
			SeleniumUtil.getWebElement(By.xpath(OLD_INSTITUTION_DELETE_YES_XPATH)).click();	
		}else {
			Thread.sleep(1000);
			SeleniumUtil.waitWebElementClickable(By.xpath(OLD_INSTITUTION_DELETE_NO_XPATH), 30);
			SeleniumUtil.getWebElement(By.xpath(OLD_INSTITUTION_DELETE_NO_XPATH)).click();
		}
		
	}
	
	public static String getErrorMessage(){
		SeleniumUtil.wait(1000);
		SeleniumUtil.scrollToWebElement(By.xpath(ERROR_MESSAGE_XPATH));
		 return SeleniumUtil.getWebElement(By.xpath(ERROR_MESSAGE_XPATH)).getText().trim();
		
	}
	public static void clickPreviousButton(){
		SeleniumUtil.scrollToWebElement(By.xpath(PREVIOUS_XPATH));
		SeleniumUtil.getWebElement(By.xpath(PREVIOUS_XPATH)).click();
		
	}
	public static String  getRecentInstitutionFilledText(){
		return SeleniumUtil.getWebElement(By.name(CURRENT_RECENT_SHS_INSTITUTE_NAME)).getAttribute("value");	
	}
	
	public static String  getCityFilledText(){
		return SeleniumUtil.getWebElement(By.name(CITY_TOWN_NAME)).getAttribute("value");	
	}
	
	public static String  getCountryFilledText(){
		SeleniumUtil.scrollToWebElement(By.xpath(COUNTRY_GETTEXT_XPATH));
		return SeleniumUtil.getWebElement(By.xpath(COUNTRY_GETTEXT_XPATH)).getText();	
	}
	
	public static String  getYearOfEntryFilledText(){
		return SeleniumUtil.getWebElement(By.name(DATE_OF_ENTRY_NAME)).getAttribute("value");	
	}
	
	public static String  getYearOfCompletionFilledText(){
		return SeleniumUtil.getWebElement(By.name(DATE_OF_COMPLETION_NAME)).getAttribute("value");	
	}
	
	public static String  getQualificationFilledText(){
		return SeleniumUtil.getWebElement(By.xpath(QUALIFICATION_GETTEXT_XPATH)).getText();	
	}
	public static String  getOtherQualificationFilledText(){
		SeleniumUtil.scrollToWebElement(By.name(RECENT_OTHER_QUALIFICATION_NAME));
		return SeleniumUtil.getWebElement(By.name(RECENT_OTHER_QUALIFICATION_NAME)).getAttribute("value");	
	}
}
