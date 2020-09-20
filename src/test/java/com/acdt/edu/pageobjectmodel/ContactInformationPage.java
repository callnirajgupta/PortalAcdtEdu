package com.acdt.edu.pageobjectmodel;

import java.io.File;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import com.acdt.edu.util.SeleniumUtil;


public class ContactInformationPage {
	private static final Logger LOGGER = LogManager.getLogger(ContactInformationPage.class);
	public static final String CONTACT_INORMATION_TITLE_XPATH = "//h3[text()='Contact Information']";
	public static final String POSTAL_ADDRESS1_NAME = "postalAddress1";
	public static final String POSTAL_ADDRESS2_NAME = "postalAddress2";
	public static final String POSTAL_CITY_NAME = "postalCityTown";
	public static final String POSTAL_STATE_NAME = "postalState";
	public static final String POSTAL_COUNTRY_XPATH = "(//div[label[text()='Country']]//div[@class='c-btn'])[1]";
	public static final String POSTAL_CODE_NAME = "postalPostcode";
	public static final String POSTAL_TELEPHONE_NAME = "telephone";
	public static final String SEARCH_XPATH = "(//input[@placeholder='Search'])[index]";
	public static final String POSTAL_SAME_PERMANENT_XPATH = "//label[@class='form-check-label']";
	public static final String PERMANENT_ADDRESS1_NAME = "permanentAddress1";
	public static final String PERMANENT_ADDRESS2_NAME = "permanentAddress2";
	public static final String PERMANENT_CITY_NAME = "permanentCityTown";
	public static final String PERMANENT_STATE_NAME = "permanentState";
	public static final String PERMANENT_CODE_NAME = "permanentPostcode";
	public static final String PERMANENT_TELEPHONE_NAME = "mobile";
	public static final String PERMANENT_COUNTRY_XPATH = "(//div[label[text()='Country']]//div[@class='c-btn'])[2]";
	public static final String PERMANENT_COUNTRY_SELCTED_TEXT_XPATH="//div[label[text()='Country']]//div/span/span";
	public static final String NEXT_BUTTON_XPATH = "//a[text()='Next']";
	public static final String POSTAL_COUNTRY_SELECT_LABEL_XPATH = "(//div[label[text()='Country']]//label[text()='selectText'])[1]";
	public static final String PERMANENT_COUNTRY_SELECT_LABEL_XPATH = "(//div[label[text()='Country']]//label[text()='selectText'])[2]";
	public static final String ERROR_MESSAGE_XPATH = "//div[@class='error-msg']";

	public static void validatePersonalDetailsTitle() {
		LOGGER.info("Inside validateHomePageTitle Method");
		SeleniumUtil.validateWebElementVisible(By.xpath(CONTACT_INORMATION_TITLE_XPATH),
				SeleniumUtil.waitWebElementSync);
	}

	public static void postalAddressFilling(String address1, String address2, String city, String state, String country,
			String postCode, String phone) throws Throwable {
         Thread.sleep(2000);
		if (!("".equals(address1))) {

			SeleniumUtil.getWebElement(By.name(POSTAL_ADDRESS1_NAME)).sendKeys(address1);
		}
		if (!("".equals(address2))) {
			SeleniumUtil.getWebElement(By.name(POSTAL_ADDRESS2_NAME)).sendKeys(address2);
		}
		if (!("".equals(city))) {
			SeleniumUtil.getWebElement(By.name(POSTAL_CITY_NAME)).sendKeys(city);
		}
		if (!("".equals(state))) {
			SeleniumUtil.getWebElement(By.name(POSTAL_STATE_NAME)).sendKeys(state);
		}
		if (!("".equals(country))) {
			SeleniumUtil.scrollToWebElement(By.xpath(POSTAL_COUNTRY_XPATH));
			Thread.sleep(1000);
			SeleniumUtil.getWebElement(By.xpath(POSTAL_COUNTRY_XPATH)).click();
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "1"))).sendKeys(country);
			
			SeleniumUtil.getWebElement(By.xpath(POSTAL_COUNTRY_SELECT_LABEL_XPATH.replace("selectText", country)))
					.click();
		}

		if (!("".equals(postCode))) {
			SeleniumUtil.getWebElement(By.name(POSTAL_CODE_NAME)).sendKeys(postCode);
		}

		if (!("".equals(phone))) {
			SeleniumUtil.getWebElement(By.name(POSTAL_TELEPHONE_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(POSTAL_TELEPHONE_NAME)).sendKeys(phone);
		} else {
			System.out.println("clear text field");
			SeleniumUtil.getWebElement(By.name(POSTAL_TELEPHONE_NAME)).clear();
		}

	}

	public static void clickCheckBoxPostalSamePermanent() {
		SeleniumUtil.scrollToWebElement(By.xpath(POSTAL_SAME_PERMANENT_XPATH));
		SeleniumUtil.getWebElement(By.xpath(POSTAL_SAME_PERMANENT_XPATH)).click();

	}

	public static void clickNextButton() {
		SeleniumUtil.getWebElement(By.xpath(NEXT_BUTTON_XPATH)).click();
	}

	public static void permanentAddressFilling(String address1, String address2, String city, String state,
			String country, String postCode, String phone) throws Throwable {

		if (!("".equals(address1))) {

			SeleniumUtil.getWebElement(By.name(PERMANENT_ADDRESS1_NAME)).sendKeys(address1);
		}else{
			SeleniumUtil.getWebElement(By.name(PERMANENT_ADDRESS1_NAME)).clear();
		}
		if (!("".equals(address2))) {
			SeleniumUtil.getWebElement(By.name(PERMANENT_ADDRESS2_NAME)).sendKeys(address2);
		}else{
			SeleniumUtil.getWebElement(By.name(PERMANENT_ADDRESS2_NAME)).clear();
		}
		if (!("".equals(city))) {
			SeleniumUtil.getWebElement(By.name(PERMANENT_CITY_NAME)).sendKeys(city);
		}else{
			SeleniumUtil.getWebElement(By.name(PERMANENT_CITY_NAME)).clear();
		}
		if (!("".equals(state))) {
			SeleniumUtil.getWebElement(By.name(PERMANENT_STATE_NAME)).sendKeys(state);
		}else{
			SeleniumUtil.getWebElement(By.name(PERMANENT_STATE_NAME)).clear();
		}
		if (!("".equals(country))) {
			SeleniumUtil.getWebElement(By.xpath(PERMANENT_COUNTRY_XPATH)).click();
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "2"))).sendKeys(country);
			SeleniumUtil.getWebElement(By.xpath(PERMANENT_COUNTRY_SELECT_LABEL_XPATH.replace("selectText", country)))
					.click();
		}else{
			
		String getCountry = SeleniumUtil.getWebElement(By.xpath(PERMANENT_COUNTRY_SELCTED_TEXT_XPATH)).getText();
			SeleniumUtil.getWebElement(By.xpath(PERMANENT_COUNTRY_XPATH)).click();
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "2"))).sendKeys(getCountry);
			SeleniumUtil.getWebElement(By.xpath(PERMANENT_COUNTRY_SELECT_LABEL_XPATH.replace("selectText", getCountry)))
					.click();
		}

		if (!("".equals(postCode))) {
			SeleniumUtil.getWebElement(By.name(PERMANENT_CODE_NAME)).sendKeys(postCode);
		}else{
			SeleniumUtil.getWebElement(By.name(PERMANENT_CODE_NAME)).clear();
		}

		if (!("".equals(phone))) {
			SeleniumUtil.getWebElement(By.name(PERMANENT_TELEPHONE_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(PERMANENT_TELEPHONE_NAME)).sendKeys(phone);
		} else {
			SeleniumUtil.getWebElement(By.name(PERMANENT_TELEPHONE_NAME)).clear();
		}

	}

	public static void validatePostalAddressSamePermanentAddress(String address1, String address2, String city, String state,
			String country, String postCode, String phone) throws InterruptedException {
		  Thread.sleep(1000);
		  Assert.assertEquals("", address1, SeleniumUtil.getWebElement(By.name(PERMANENT_ADDRESS1_NAME)).getAttribute("value"));
		  Assert.assertEquals("", address2, SeleniumUtil.getWebElement(By.name(PERMANENT_ADDRESS2_NAME)).getAttribute("value"));
		  Assert.assertEquals("", city, SeleniumUtil.getWebElement(By.name(PERMANENT_CITY_NAME)).getAttribute("value"));
		  Assert.assertEquals("", state, SeleniumUtil.getWebElement(By.name(PERMANENT_STATE_NAME)).getAttribute("value"));
		  Assert.assertEquals("", country, SeleniumUtil.getWebElement(By.xpath(PERMANENT_COUNTRY_SELCTED_TEXT_XPATH)).getText());
		  Assert.assertEquals("", postCode, SeleniumUtil.getWebElement(By.name(PERMANENT_CODE_NAME)).getAttribute("value"));
		  Assert.assertEquals("", phone, SeleniumUtil.getWebElement(By.name(PERMANENT_TELEPHONE_NAME)).getAttribute("value"));
				
	}

	public static String getErrorMessage() {
		SeleniumUtil.wait(2000);
		return SeleniumUtil.getWebElement(By.xpath(ERROR_MESSAGE_XPATH)).getText().trim();
		// Assert.assertEquals("The personal Details Error message is not
		// matching", message,
		// SeleniumUtil.getWebElement(By.xpath(ERROR_MESSAGE_XPATH)).getText().trim());
	}

}
