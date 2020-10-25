package com.acdt.edu.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.acdt.edu.util.SeleniumUtil;

public class EducationalBackgroundPage {
	private static final Logger LOGGER = LogManager.getLogger(EducationalBackgroundPage.class);
	public static final String EDUCATIONAl_BACKGROUND_HEADER_XPATH = "//h3[text()='Educational Background']";
	public static final String OTHER_EDUCATIONAl_BACKGROUND_HEADER_XPATH="//h5[text()='Other Educational Background']";
	public static final String PREVIOUS_ATTENDANCEUNIVERSITY_HEADER_XPATH="//h3[text()='Previous Attendance at a University/College']";
	public static final String CURRENT_RECENT_SHS_INSTITUTE_NAME = "recentInstitutionName";
	public static final String CITY_TOWN_NAME = "recentInstitutionCity";
	public static final String COUNTRY_XPATH = "//div[label[text()='Country']]//div[@class='c-btn']/span[1]";
	public static final String DATE_OF_ENTRY_NAME = "selectedItemsYearEntryModel";
	public static final String DATE_OF_COMPLETION_NAME = "selectedItemsEndDateModel";
	public static final String QUALIFICATION_NAME = "//div[label[text()='Qualification']]//div[@class='c-btn']/span[1]";
	public static final String RECENT_OTHER_QUALIFICATION_NAME = "recentOtherQualification";
	public static final String ADD_OTHER_QUALIFICATION_BUTTON_XPATH = "//a[text()=' Add Other Educational Background']";
	public static final String EVER_ENROLLED_UNIVERSITY_XPATH = "//label[@class='form-check-label' and contains(text(),'Yes')]";
	public static final String OLD_INSTITUTION_NAME = "oldInstitutionName";
	public static final String OLD_INSTITUTION_CITY_NAME = "oldInstitutionCity";
	public static final String OLD_INSTITUTION_COUNTRY_XPATH = "(//div[label[text()='Country']]//div[@class='c-btn']/span)[4]";
	public static final String OLD_INSTITUTION_DATE_OF_ENTRY_NAME = "selectedItemsOtherStartDateModel";
	public static final String OLD_INSTITUTION_DATE_OF_COMPLETION_NAME = "selectedItemsOtherEndDateModel";
	public static final String OLD_INSTITUTION_QUALIFICATION_XPATH = "(//div[label[text()='Qualification']]//div[@class='c-btn']/span)[4]";
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
    public static final String CALENDAR_DATE_XPATH="//div[@class='btn-light' and text()='date']";
    public static final String NEXT_BUTTON_XPATH="//a[text()='Next']";
	
	public static void validateEducationalBackgroundTitle() {
		LOGGER.info("Inside validateEducationalBackgroundTitle Method");
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
	
	
	public static void enterCurrentEducationalBackGroundDetails(String recentInstitution, String city, String country, String yearOfEntry, String yearOfCompletion, String qualification ) throws InterruptedException{
		LOGGER.info("Inside enterCurrentEducationalBackGroundDetails Method");
		
		if(!("".equals(recentInstitution))){
			SeleniumUtil.getWebElement(By.name(CURRENT_RECENT_SHS_INSTITUTE_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(CURRENT_RECENT_SHS_INSTITUTE_NAME)).sendKeys(recentInstitution);	
		}
		
		if(!("".equals(city))){
			SeleniumUtil.getWebElement(By.name(CITY_TOWN_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(CITY_TOWN_NAME)).sendKeys(city);	
		}
		
		if(!("".equals(country))){
			SeleniumUtil.getWebElement(By.xpath(COUNTRY_XPATH)).click();
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "1"))).sendKeys(country);
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", country))).click();
				
		}
		
		if(!("".equals(yearOfEntry))){
			 String[] dobsplit=yearOfEntry.split("/");
		    SeleniumUtil.getWebElement(By.name(DATE_OF_ENTRY_NAME)).click();
		    Thread.sleep(1000);
			SeleniumUtil.selectWebList(By.xpath(CALENDAR_YEAR_XPATH), dobsplit[2], "selectByVisibleText");
			Thread.sleep(1000);
			SeleniumUtil.selectWebList(By.xpath(CALENDAR_MONTH_XPATH), dobsplit[1], "SelectByvalue");
			Thread.sleep(1000);
			SeleniumUtil.getWebElement(By.xpath(CALENDAR_DATE_XPATH.replace("date", dobsplit[0]))).click();
			Thread.sleep(2000);	
			
		}
		
		if(!("".equals(yearOfCompletion))){
			 String[] dobsplit=yearOfCompletion.split("/");
		    SeleniumUtil.getWebElement(By.name(DATE_OF_COMPLETION_NAME)).click();
		    Thread.sleep(1000);
			SeleniumUtil.selectWebList(By.xpath(CALENDAR_YEAR_XPATH), dobsplit[2], "selectByVisibleText");
			Thread.sleep(1000);
			SeleniumUtil.selectWebList(By.xpath(CALENDAR_MONTH_XPATH), dobsplit[1], "SelectByvalue");
			Thread.sleep(1000);
			SeleniumUtil.getWebElement(By.xpath(CALENDAR_DATE_XPATH.replace("date", dobsplit[0]))).click();
			Thread.sleep(2000);	
			
		}
		
		if(!("".equals(qualification))){
			SeleniumUtil.getWebElement(By.xpath(QUALIFICATION_NAME)).click();
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "2"))).sendKeys(qualification);
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", qualification))).click();
				
		}
	}
	
	public static void enterPreviousEducationalBackGroundDetails(String recentInstitution, String city, String country, String yearOfEntry, String yearOfCompletion, String qualification ) throws InterruptedException{
		LOGGER.info("Inside enterOtherEducationalBackGroundDetails Method");
		
		if(!("".equals(recentInstitution))){
			SeleniumUtil.getWebElement(By.name(OLD_INSTITUTION_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(OLD_INSTITUTION_NAME)).sendKeys(recentInstitution);	
		}
		
		if(!("".equals(city))){
			SeleniumUtil.getWebElement(By.name(OLD_INSTITUTION_CITY_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(OLD_INSTITUTION_CITY_NAME)).sendKeys(city);	
		}
		
		if(!("".equals(country))){
			SeleniumUtil.getWebElement(By.xpath(OLD_INSTITUTION_COUNTRY_XPATH )).click();
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "3"))).sendKeys(country);
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", country))).click();
				
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
			Thread.sleep(2000);	
			
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
			Thread.sleep(2000);	
			
		}
		
		if(!("".equals(qualification))){
			SeleniumUtil.getWebElement(By.xpath(OLD_INSTITUTION_QUALIFICATION_XPATH)).click();
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "4"))).sendKeys(qualification);
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", qualification))).click();
				
		}
	}
	
	public static void enterOtherEducationalBackGroundDetails(String recentInstitution, String city, String country, String yearOfEntry, String yearOfCompletion, String qualification ) throws InterruptedException{
		LOGGER.info("Inside enterOtherEducationalBackGroundDetails Method");
		
		if(!("".equals(recentInstitution))){
			SeleniumUtil.getWebElement(By.name(OLD_INSTITUTION_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(OLD_INSTITUTION_NAME)).sendKeys(recentInstitution);	
		}
		
		if(!("".equals(city))){
			SeleniumUtil.getWebElement(By.name(OLD_INSTITUTION_CITY_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(OLD_INSTITUTION_CITY_NAME)).sendKeys(city);	
		}
		
		if(!("".equals(country))){
			SeleniumUtil.getWebElement(By.xpath(OLD_INSTITUTION_COUNTRY_XPATH )).click();
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "3"))).sendKeys(country);
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", country))).click();
				
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
			Thread.sleep(2000);	
			
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
			Thread.sleep(2000);	
			
		}
		
		if(!("".equals(qualification))){
			SeleniumUtil.getWebElement(By.xpath(OLD_INSTITUTION_QUALIFICATION_XPATH)).click();
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "4"))).sendKeys(qualification);
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", qualification))).click();
				
		}
	}
	
	
	public static void clickNextButtonInEducationalBackGround(){
		SeleniumUtil.getWebElement(By.xpath(NEXT_BUTTON_XPATH)).click();
	}
	public static void clickOtherEducationalBackGroundButton(){
		SeleniumUtil.getWebElement(By.xpath(ADD_OTHER_QUALIFICATION_BUTTON_XPATH)).click();
		SeleniumUtil.getWebElement(By.xpath(ADD_OTHER_QUALIFICATION_BUTTON_XPATH)).click();
	}
	public static void clickDeleteSectionOtherEducationalBackGroundButton(){
		SeleniumUtil.getWebElement(By.xpath(OLD_INSTITUTION_DELETE_BUTTON_XPATH)).click();
	}
	
	public static void clickYesNoRadioButton(String yesNo){
		if("yes".equalsIgnoreCase(yesNo)){
		SeleniumUtil.getWebElement(By.xpath(OLD_INSTITUTION_DELETE_BUTTON_XPATH)).click();
		}else{
			SeleniumUtil.getWebElement(By.xpath(OLD_INSTITUTION_DELETE_BUTTON_XPATH)).click();
		}
	}
	
	
	public static void clickYesNoDeleteOtherEducationalConfirmation(String yesNo){
		
		if("yes".equalsIgnoreCase(yesNo)){
			SeleniumUtil.waitWebElementClickable(By.xpath(OLD_INSTITUTION_DELETE_YES_XPATH), 30);
			SeleniumUtil.getWebElement(By.xpath(OLD_INSTITUTION_DELETE_YES_XPATH)).click();	
		}else {
			SeleniumUtil.waitWebElementClickable(By.xpath(OLD_INSTITUTION_DELETE_NO_XPATH), 30);
			SeleniumUtil.getWebElement(By.xpath(OLD_INSTITUTION_DELETE_NO_XPATH)).click();
		}
		
	}
	
	public static String getErrorMessage(){
		SeleniumUtil.wait(2000);
		 return SeleniumUtil.getWebElement(By.xpath(ERROR_MESSAGE_XPATH)).getText().trim();
		
	}
}
