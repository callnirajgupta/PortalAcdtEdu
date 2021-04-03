package com.aucdt.edu.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.aucdt.edu.util.SeleniumUtil;

public class ParentDetailsPage {
	private static final Logger LOGGER = LogManager.getLogger(ParentDetailsPage.class);
	public static final String PARENT_DETAILS_TITLE_XPATH = "//h3[text()='Particulars']";
	public static final String TITLE_XPATH = "//span[text()='Select title']";
	public static final String TITLE_GETTEXT_XPATH="//div[label[text()='Title']]//div/span/span";
	public static final String SEARCH_XPATH = "(//input[@placeholder='Search'])[index]";
	public static final String SELECT_LABEL_XPATH = "//label[text()='selectText']";
	public static final String SURNAME_NAME = "surname";
	public static final String FIRSTNAME_NAME = "firstName";
	public static final String MIDDLENAME_NAME = "middleName";
	public static final String PARENT_RADIO_BUTTON_XPATH = "//label[input[@name='exampleRadiosInline1']]";
	public static final String GUARDIAN_RADIO_BUTTON_XPATH = "//label[input[@name='exampleRadiosInline2']]";
	public static final String SPONSOR_RADIO_BUTTON_XPATH = "//label[input[@name='exampleRadiosInline2']]";
	public static final String COMPANY_NAME = "company";
	public static final String OCCUPATION_NAME = "occupation";
	public static final String ADDRESS1_NAME = "address1";
	public static final String ADDRESS2_NAME = "address2";
	public static final String COUNTRY_XPATH = "//div[label[text()='Country']]//div[@class='c-btn']";
	public static final String COUNTRY_GETTEXT_XPATH = "//div[label[text()='Country']]//div[@class='c-btn']/span/span";
	public static final String CITY_NAME = "city";
	public static final String STATE_NAME = "state";
	public static final String MOBILE_NAME = "mobileno";
	public static final String TELEPHONE_NAME = "telephone";
	public static final String EMAIL_NAME = "email";
	public static final String POSTALCODE_NAME = "postalcode";
	public static final String NEXT_BUTTON_XPATH = "//a[text()='Next']";
	public static final String ERROR_MESSAGE_XPATH = "//div[@class='section form-content']/div[3]";
    public static final String EMAIL_MOBILE_PHONE_ERROR_XPATH="//div[@class='errorMessage']";
    public static final String PREVIOUS_XPATH = "//a[text()='Previous']";
    
    public static void validateParentDetailsTitle() {
		LOGGER.info("Inside validateParentDetailsTitle Method");
		SeleniumUtil.wait(5000);
		SeleniumUtil.validateWebElementVisible(By.xpath(PARENT_DETAILS_TITLE_XPATH), SeleniumUtil.waitWebElementSync);
	}

	public static void parentDetailFilling(String title, String firstName, String middleName, String surname,
			String relationship, String company, String occupation, String address1, String address2, String country,
			String city, String state, String mobile, String telephone, String email, String postalCode)
			throws Throwable {

		if (!("".equals(title))) {
			Thread.sleep(5000);
			SeleniumUtil.scrollToWebElement(By.xpath(TITLE_XPATH));
		    if(SeleniumUtil.getWebElements(By.xpath(TITLE_XPATH)).size()>0){
		    SeleniumUtil.getWebElement(By.xpath(TITLE_XPATH)).click();
			Thread.sleep(1000);
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "1"))).sendKeys(title);
			Thread.sleep(1000);
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "1"))).click();
			Thread.sleep(1000);
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", title))).click();
			/*
			 * if(SeleniumUtil.getWebElements(By.xpath(TITLE_XPATH)).size()>0){
			 * SeleniumUtil.getWebElement(By.xpath(TITLE_XPATH)).click();
			 * Thread.sleep(1000);
			 * SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index",
			 * "1"))).sendKeys(title); Thread.sleep(1000);
			 * SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index",
			 * "1"))).click(); Thread.sleep(1000);
			 * SeleniumUtil.javascriptClickElement(By.xpath(SELECT_LABEL_XPATH.replace(
			 * "selectText", title)));
			 * //SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace(
			 * "selectText", title))).click(); }
			 */
			}

		}
		if (!("".equals(firstName))) {
			SeleniumUtil.getWebElement(By.name(FIRSTNAME_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(FIRSTNAME_NAME)).sendKeys(firstName);
		}else{
			SeleniumUtil.getWebElement(By.name(FIRSTNAME_NAME)).clear();
		}
		if (!("".equals(middleName))) {
			SeleniumUtil.getWebElement(By.name(MIDDLENAME_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(MIDDLENAME_NAME)).sendKeys(middleName);
		}else{
			SeleniumUtil.getWebElement(By.name(MIDDLENAME_NAME)).clear();	
		}
		if (!("".equals(surname))) {
			SeleniumUtil.scrollToWebElement(By.name(SURNAME_NAME));
			SeleniumUtil.getWebElement(By.name(SURNAME_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(SURNAME_NAME)).sendKeys(surname);
		}else{
			SeleniumUtil.getWebElement(By.name(SURNAME_NAME)).clear();
		}

		if (!("".equals(relationship))) {
			SeleniumUtil.scrollToWebElement(By.xpath(PARENT_RADIO_BUTTON_XPATH));
			if ("parent".equalsIgnoreCase(relationship)) {
				SeleniumUtil.scrollToWebElement(By.xpath(PARENT_RADIO_BUTTON_XPATH));
				SeleniumUtil.getWebElement(By.xpath(PARENT_RADIO_BUTTON_XPATH)).click();
			} else if ("guardian".equalsIgnoreCase(relationship)) {
				SeleniumUtil.scrollToWebElement(By.xpath(GUARDIAN_RADIO_BUTTON_XPATH));
				SeleniumUtil.getWebElement(By.xpath(GUARDIAN_RADIO_BUTTON_XPATH)).click();
			} else if ("sponsor".equalsIgnoreCase(relationship)) {
				SeleniumUtil.scrollToWebElement(By.xpath(PARENT_RADIO_BUTTON_XPATH));
				SeleniumUtil.getWebElement(By.xpath(GUARDIAN_RADIO_BUTTON_XPATH)).click();
			}

		}

		if (!("".equals(company))) {
			SeleniumUtil.getWebElement(By.name(COMPANY_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(COMPANY_NAME)).sendKeys(company);
		}else{
			SeleniumUtil.getWebElement(By.name(COMPANY_NAME)).clear();
		}

		if (!("".equals(occupation))) {
			SeleniumUtil.getWebElement(By.name(OCCUPATION_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(OCCUPATION_NAME)).sendKeys(occupation);
			
		}else{
			SeleniumUtil.getWebElement(By.name(OCCUPATION_NAME)).clear();
		}
		
		if (!("".equals(address1))) {
			SeleniumUtil.scrollToWebElement(By.name(ADDRESS1_NAME));
			SeleniumUtil.getWebElement(By.name(ADDRESS1_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(ADDRESS1_NAME)).sendKeys(address1);
		}else{
			SeleniumUtil.getWebElement(By.name(ADDRESS1_NAME)).clear();	
		}
		
		if (!("".equals(address2))) {
			SeleniumUtil.getWebElement(By.name(ADDRESS2_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(ADDRESS2_NAME)).sendKeys(address2);
		}else{
			SeleniumUtil.getWebElement(By.name(ADDRESS2_NAME)).clear();	
		}
		
		if(!("".equals(country))){
			SeleniumUtil.scrollToWebElement(By.xpath(COUNTRY_XPATH));
			if(!(country.equals(SeleniumUtil.getWebElement(By.xpath(COUNTRY_XPATH)).getText().trim()))){
			SeleniumUtil.getWebElement(By.xpath(COUNTRY_XPATH)).click();
			SeleniumUtil.wait(2000);
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "2"))).sendKeys(country);
			SeleniumUtil.wait(1000);
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "2"))).click();
			SeleniumUtil.wait(1000);
			
			SeleniumUtil.javascriptClickElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", country)));
			}	
		}else{
			SeleniumUtil.getWebElement(By.xpath(COUNTRY_XPATH)).click();
			SeleniumUtil.wait(2000);
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "2"))).sendKeys("Please Select");
			SeleniumUtil.wait(5000);
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", "Please Select"))).click();
		}
		if (!("".equals(city))) {
			SeleniumUtil.getWebElement(By.name(CITY_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(CITY_NAME)).sendKeys(city);
		}else{
			SeleniumUtil.getWebElement(By.name(CITY_NAME)).clear();
		}
		if (!("".equals(state))) {
			SeleniumUtil.getWebElement(By.name(STATE_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(STATE_NAME)).sendKeys(state);
		}else{
			SeleniumUtil.getWebElement(By.name(STATE_NAME)).clear();
		}
		if (!("".equals(mobile))) {
			SeleniumUtil.getWebElement(By.name(MOBILE_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(MOBILE_NAME)).sendKeys(mobile);
		}else{
			SeleniumUtil.getWebElement(By.name(MOBILE_NAME)).clear();
		}
		if (!("".equals(telephone))) {
			SeleniumUtil.scrollToWebElement(By.name(TELEPHONE_NAME));
			SeleniumUtil.getWebElement(By.name(TELEPHONE_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(TELEPHONE_NAME)).sendKeys(telephone);
		}else{
			SeleniumUtil.getWebElement(By.name(TELEPHONE_NAME)).clear();
		}
		if (!("".equals(email))) {
			SeleniumUtil.getWebElement(By.name(EMAIL_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(EMAIL_NAME)).sendKeys(email);
		}else{
			SeleniumUtil.getWebElement(By.name(EMAIL_NAME)).clear();
		}
		if (!("".equals(postalCode.trim()))) {
			SeleniumUtil.scrollToWebElement(By.name(POSTALCODE_NAME));
			SeleniumUtil.getWebElement(By.name(POSTALCODE_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(POSTALCODE_NAME)).sendKeys(postalCode);
		}else{
			SeleniumUtil.getWebElement(By.name(POSTALCODE_NAME)).clear();
		}

	}

	public static void clickNextButton() {
		SeleniumUtil.scrollToWebElement(By.xpath(NEXT_BUTTON_XPATH));
		//SeleniumUtil.getWebElement(By.xpath(NEXT_BUTTON_XPATH)).click();
		SeleniumUtil.javascriptClickElement(By.xpath(NEXT_BUTTON_XPATH));
	}

	public static String getErrorMessage() {
		SeleniumUtil.wait(2000);
		SeleniumUtil.scrollToWebElement(By.xpath(ERROR_MESSAGE_XPATH));
		return SeleniumUtil.getWebElement(By.xpath(ERROR_MESSAGE_XPATH)).getText().trim();

	}
	
	public static String getFieldValidationErrorMessage(){
		SeleniumUtil.wait(1000);
		SeleniumUtil.scrollToWebElement(By.xpath(EMAIL_MOBILE_PHONE_ERROR_XPATH));
		return SeleniumUtil.getWebElement(By.xpath(EMAIL_MOBILE_PHONE_ERROR_XPATH)).getText().trim();
	}

	public static void clickPreviousButton(){
		SeleniumUtil.scrollToWebElement(By.xpath(PREVIOUS_XPATH));
		SeleniumUtil.getWebElement(By.xpath(PREVIOUS_XPATH)).click();
		
	}
	
	public static String getTitleFilledText(){
		return SeleniumUtil.getWebElement(By.xpath(TITLE_GETTEXT_XPATH)).getText();
		
	}
	
	public static String getSurNameFilledText(){
		return SeleniumUtil.getWebElement(By.name(SURNAME_NAME)).getAttribute("value");
		
	}
	public static String getFirstNameFilledText(){
		return SeleniumUtil.getWebElement(By.name(FIRSTNAME_NAME)).getAttribute("value");
		
	}
	
	public static String getMiddleNameFilledText(){
		return SeleniumUtil.getWebElement(By.name(MIDDLENAME_NAME)).getAttribute("value");
		
	}
	
	public static String getRelationshipFilledText(String relationship){
		SeleniumUtil.scrollToWebElement(By.xpath(PARENT_RADIO_BUTTON_XPATH));
		if("Parent".equalsIgnoreCase(relationship)){
			return SeleniumUtil.getWebElement(By.xpath(PARENT_RADIO_BUTTON_XPATH)).getText();
		}else if("Guardian".equalsIgnoreCase(relationship)){
			return SeleniumUtil.getWebElement(By.xpath(GUARDIAN_RADIO_BUTTON_XPATH)).getText();	
		}else{
			return SeleniumUtil.getWebElement(By.xpath(SPONSOR_RADIO_BUTTON_XPATH)).getText();
		}
	}
	
	public static String getCompanyFilledText(){
		
			return SeleniumUtil.getWebElement(By.name(COMPANY_NAME)).getAttribute("value");
		
	}
	public static String getOccupationFilledText(){
		
		return SeleniumUtil.getWebElement(By.name(OCCUPATION_NAME)).getAttribute("value");
	
}
public static String getAddress1FilledText(){
		
		return SeleniumUtil.getWebElement(By.name(ADDRESS1_NAME)).getAttribute("value");
	
}
public static String getAddress2FilledText(){
	
	return SeleniumUtil.getWebElement(By.name(ADDRESS2_NAME)).getAttribute("value");

}

public static String getCountryFilledText(){
	SeleniumUtil.scrollToWebElement(By.xpath(COUNTRY_GETTEXT_XPATH));
	return SeleniumUtil.getWebElement(By.xpath(COUNTRY_GETTEXT_XPATH)).getText();

}
public static String getCityFilledText(){
	
	return SeleniumUtil.getWebElement(By.name(CITY_NAME)).getAttribute("value");

}

public static String getStateFilledText(){
	SeleniumUtil.scrollToWebElement(By.name(STATE_NAME));
	return SeleniumUtil.getWebElement(By.name(STATE_NAME)).getAttribute("value");

}

public static String getMobileFilledText(){
	
	return SeleniumUtil.getWebElement(By.name(MOBILE_NAME)).getAttribute("value");

}

public static String getTelephoneFilledText(){
	
	return SeleniumUtil.getWebElement(By.name(TELEPHONE_NAME)).getAttribute("value");

}

public static String getEmailFilledText(){
	
	return SeleniumUtil.getWebElement(By.name(EMAIL_NAME)).getAttribute("value");

}

public static String getPostalCodeFilledText(){
	SeleniumUtil.scrollToWebElement(By.name(POSTALCODE_NAME));
	return SeleniumUtil.getWebElement(By.name(POSTALCODE_NAME)).getAttribute("value");

}
}
