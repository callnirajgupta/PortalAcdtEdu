package com.acdt.edu.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.acdt.edu.util.SeleniumUtil;

public class EducationalBackgroundPage {
	private static final Logger LOGGER = LogManager.getLogger(EducationalBackgroundPage.class);
	public static final String EDUCATIONAl_BACKGROUND_HEADER_XPATH = "//h3[text()='Educational Background']";
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
	
	public static void validateEducationalBackgroundTitle() {
		LOGGER.info("Inside validateEducationalBackgroundTitle Method");
		SeleniumUtil.validateWebElementVisible(By.xpath(EDUCATIONAl_BACKGROUND_HEADER_XPATH),
				SeleniumUtil.waitWebElementSync);
	}
}
