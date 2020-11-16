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
    
    
	public static void validateApplicationSummaryTitle() {
		LOGGER.info("Inside validateFinancingYourStudyTitle Method");
		SeleniumUtil.validateWebElementVisible(APPLICATION_SUMMARY_HEADER_XPATH,
				SeleniumUtil.waitWebElementSync);
	}
	
}
