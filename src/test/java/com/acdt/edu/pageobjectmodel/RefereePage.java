package com.acdt.edu.pageobjectmodel;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.acdt.edu.util.SeleniumUtil;

public class RefereePage {
	private static final Logger LOGGER = LogManager.getLogger(RefereePage.class);
	public static final String REFEREE_HEADER_XPATH = "//h4[text()='Referee']";
	public static final String TITLE_XPATH = "//div[label[text()='Title']]//div[@class='c-btn']/span[1]";
	public static final String TITLE_GETTEXT_XPATH = "//div[label[text()='Title']]//div[@class='c-btn']/span/span";
	public static final String POSITION_XPATH = "//div[label[text()='Position']]//input";
	public static final String FULL_NAME_XPATH = "//div[label[text()='Full Name']]//input";
	public static final String EMAIL_ADDRESS_XPATH = "//div[label[text()='Email address']]//input";
	public static final String OCCUPATION_XPATH = "//div[label[text()='Occupation']]//input";
	public static final String DATE_XPATH = "//div[label[text()='Date']]//input";
	public static final String PREVIEW_BUTTON_XPATH = "//a[text()='Preview']";
	public static final String SEARCH_XPATH = "(//input[@placeholder='Search'])[1]";
	public static final String SELECT_OPTION_XPATH = "//label[text()='selectText']";
	public static final String CALENDAR_MONTH_XPATH = "//select[@title='Select month']";
	public static final String CALENDAR_YEAR_XPATH = "//select[@title='Select year']";
	public static final String CALENDAR_DATE_XPATH = "//div[@class='btn-light' and text()='date']";
	public static final String CALENDAR_CURRENT_DATE_XPATH = "(//div[text()='date'])[1]";
	public static final String ERROR_MESSAGE_XPATH = "//div[@class='errorMessage']";
	public static final String SIGNATURE_NAME = "applicantSignature";
	public static final String PREVIOUS_XPATH = "//a[text()='Previous']";
	
	public static void validateRefereeTitle() {
		LOGGER.info("Inside validateRefereeTitle Method");
		SeleniumUtil.wait(5000);
		SeleniumUtil.validateWebElementVisible(By.xpath(REFEREE_HEADER_XPATH), SeleniumUtil.waitWebElementSync);
	}

	public static void fillingDataInRefereePage(String title, String position, String fullName, String email,
			String occupation, String date,String signature) {
		LOGGER.info("Inside fillingDataInReferencePage Method");
		if (!("".equals(title))) {
			SeleniumUtil.wait(5000);
			if(!title.equals(SeleniumUtil.getWebElement(By.xpath(TITLE_XPATH)).getText().trim())){
			SeleniumUtil.validateWebElementVisible(By.xpath(TITLE_XPATH), SeleniumUtil.waitWebElementSync);
			SeleniumUtil.wait(1000);
			SeleniumUtil.getWebElement(By.xpath(TITLE_XPATH)).click();
			SeleniumUtil.wait(1000);
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "1"))).sendKeys(title);
			SeleniumUtil.wait(1000);
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "1"))).click();
			SeleniumUtil.wait(1000);
			//SeleniumUtil.getWebElement(By.xpath(SELECT_OPTION_XPATH.replace("selectText", title))).click();
			SeleniumUtil.javascriptClickElement(By.xpath(SELECT_OPTION_XPATH.replace("selectText", title)));
			}
			}

		if (!("".equals(position))) {
			SeleniumUtil.getWebElement(By.xpath(POSITION_XPATH)).clear();
			SeleniumUtil.getWebElement(By.xpath(POSITION_XPATH)).sendKeys(position);
		}

		if (!("".equals(fullName))) {
			SeleniumUtil.getWebElement(By.xpath(FULL_NAME_XPATH)).clear();
			SeleniumUtil.getWebElement(By.xpath(FULL_NAME_XPATH)).sendKeys(fullName);
		}

		if (!("".equals(email))) {
			SeleniumUtil.wait(2000);
			SeleniumUtil.getWebElement(By.xpath(EMAIL_ADDRESS_XPATH)).clear();
			SeleniumUtil.getWebElement(By.xpath(EMAIL_ADDRESS_XPATH)).sendKeys(email);
			SeleniumUtil.wait(3000);
			SeleniumUtil.getWebElement(By.xpath(EMAIL_ADDRESS_XPATH)).click();
			
		}

		if (!("".equals(occupation))) {
			SeleniumUtil.getWebElement(By.xpath(OCCUPATION_XPATH)).clear();
			SeleniumUtil.getWebElement(By.xpath(OCCUPATION_XPATH)).sendKeys(occupation);
		}

		if (!("".equals(date))) {
			String[] dobsplit = date.split("/");
			SeleniumUtil.getWebElement(By.xpath(DATE_XPATH)).click();
			SeleniumUtil.wait(1000);
			SeleniumUtil.selectWebList(By.xpath(CALENDAR_YEAR_XPATH), dobsplit[2], "selectByVisibleText");
			SeleniumUtil.wait(1000);
			SeleniumUtil.selectWebList(By.xpath(CALENDAR_MONTH_XPATH), dobsplit[1], "SelectByvalue");
			SeleniumUtil.wait(1000);
			SeleniumUtil.getWebElement(By.xpath(CALENDAR_DATE_XPATH.replace("date", dobsplit[0]))).click();
		}else{
			Format f = new SimpleDateFormat("dd/MM/yyyy");
			String strDate = f.format(new Date());
			String[] dobsplit = strDate.split("/");
			SeleniumUtil.getWebElement(By.xpath(DATE_XPATH)).click();
			SeleniumUtil.wait(1000);
			SeleniumUtil.selectWebList(By.xpath(CALENDAR_YEAR_XPATH), dobsplit[2], "selectByVisibleText");
			SeleniumUtil.wait(1000);
			SeleniumUtil.selectWebList(By.xpath(CALENDAR_MONTH_XPATH), dobsplit[1].substring(1), "SelectByvalue");
			SeleniumUtil.wait(2000);
			System.out.println("today date"+dobsplit[0]);
			String futureDate=String.valueOf(Integer.parseInt(dobsplit[0])+1);
			System.out.println("print Future date"+futureDate);
			SeleniumUtil.getWebElement(By.xpath(CALENDAR_CURRENT_DATE_XPATH.replace("date", futureDate))).click();
		}
		
		if (!("".equals(signature))) {
			SeleniumUtil.getWebElement(By.name(SIGNATURE_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(SIGNATURE_NAME)).sendKeys(signature);
		}
	}

	public static String getErrorMessage() {
		SeleniumUtil.wait(2000);
		return SeleniumUtil.getWebElement(By.xpath(ERROR_MESSAGE_XPATH)).getText().trim();

	}

	public static void clickPreviewButton() {
		SeleniumUtil.getWebElement(By.xpath(PREVIEW_BUTTON_XPATH)).click();
	}
	
	public static void clickPreviousButton() {
		SeleniumUtil.getWebElement(By.xpath(PREVIOUS_XPATH)).click();
	}
	
	public static String  getTitleFilledText(){
		return SeleniumUtil.getWebElement(By.xpath(TITLE_GETTEXT_XPATH)).getText();	
	}
	
	public static String  getPositionFilledText(){
		return SeleniumUtil.getWebElement(By.xpath(POSITION_XPATH)).getAttribute("value");	
	}
	
	public static String  getFullNameFilledText(){
		return SeleniumUtil.getWebElement(By.xpath(FULL_NAME_XPATH)).getAttribute("value");	
	}
	
	public static String  getEmailFilledText(){
		return SeleniumUtil.getWebElement(By.xpath(EMAIL_ADDRESS_XPATH)).getAttribute("value");	
	}
	
	public static String  getOccupationFilledText(){
		return SeleniumUtil.getWebElement(By.xpath(OCCUPATION_XPATH)).getAttribute("value");	
	}
	
	public static String  getDateFilledText(){
		return SeleniumUtil.getWebElement(By.xpath(DATE_XPATH)).getAttribute("value");	
	}
	
	public static String  getSignatureFilledText(){
		return SeleniumUtil.getWebElement(By.name(SIGNATURE_NAME)).getAttribute("value");	
	}

}
