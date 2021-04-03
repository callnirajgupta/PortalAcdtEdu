package com.aucdt.edu.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.aucdt.edu.util.SeleniumUtil;

public class ProgrammeSelectionPage {
	private static final Logger LOGGER = LogManager.getLogger(ProgrammeSelectionPage.class);
	public static final String PROGRAMME_SELECTION_HEADER_XPATH = "//h3[text()='Programme Selection']";
	public static final String PROGRAMME_TYPE_XPATH = "//div[label[text()='Programme Type']]//div[@class='c-btn']/span[1]";
	public static final String PROGRAMME_TYPE_GETTEXT_XPATH = "//div[label[text()='Programme Type']]//div[@class='c-btn']/span/span";
	public static final String SEARCH_XPATH="(//input[@placeholder='Search'])[index]";
	public static final String SELECT_LABEL_XPATH="//label[text()='selectText']";
	public static final String PROGRAMME_TITLE_XPATH = "//div[label[text()='Programme Title']]//div[@class='c-btn']/span[1]";
	public static final String PROGRAMME_TITLE_GETTEXT_XPATH = "//div[label[text()='Programme Title']]//div[@class='c-btn']/span/span";
	public static final String ERROR_MESSAGE_XPATH="//div[@class='errorMessage']";
	public static final String NEXT_BUTTON_XPATH="//a[text()='Next']";
	public static final String PREVIOUS_XPATH = "//a[text()='Previous']";
	
	public static void validateProgrammeSelectionTitle() {
		LOGGER.info("Inside validateProgrammeSelectionTitle Method");
		SeleniumUtil.wait(5000);
		SeleniumUtil.validateWebElementVisible(By.xpath(PROGRAMME_SELECTION_HEADER_XPATH),
				SeleniumUtil.waitWebElementSync);
	}
	public static String getErrorMessage(){
		LOGGER.info("Inside getErrorMessage method");
		SeleniumUtil.wait(2000);
		String message = SeleniumUtil.getWebElement(By.xpath(ERROR_MESSAGE_XPATH)).getText().trim();
		  
		System.out.println("print message"+message);
		return message;
	}
	
	public static void programmeSelectionDetailsFilling(String programmeType,String programmeTitle) throws InterruptedException{
		LOGGER.info("Inside programmeSelectionDetailsFilling method");
		
		if(!("".equals(programmeType))){
			Thread.sleep(5000);
			if(!programmeType.equals(SeleniumUtil.getWebElement(By.xpath(PROGRAMME_TYPE_XPATH)).getText().trim())){
			SeleniumUtil.getWebElement(By.xpath(PROGRAMME_TYPE_XPATH)).click();
			Thread.sleep(2000);
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "1"))).sendKeys(programmeType);
			Thread.sleep(3000);
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", programmeType))).click();
			}	
		}
		if(!("".equals(programmeTitle))){
			if(!programmeTitle.equals(SeleniumUtil.getWebElement(By.xpath(PROGRAMME_TITLE_XPATH)).getText().trim())){
			SeleniumUtil.getWebElement(By.xpath(PROGRAMME_TITLE_XPATH)).click();
			Thread.sleep(1000);
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "2"))).sendKeys(programmeTitle);
			Thread.sleep(1000);
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", programmeTitle))).click();
			}	
		}
		
		
	}
	
	public static void clickNextButton() {
		SeleniumUtil.scrollToWebElement(By.xpath(NEXT_BUTTON_XPATH));
		SeleniumUtil.getWebElement(By.xpath(NEXT_BUTTON_XPATH)).click();
	}
	
	public static void clickPreviousButton(){
		SeleniumUtil.scrollToWebElement(By.xpath(PREVIOUS_XPATH));
		SeleniumUtil.getWebElement(By.xpath(PREVIOUS_XPATH)).click();
		
	}
	
	public static String  getProgrammeTypeFilledText(){
		return SeleniumUtil.getWebElement(By.xpath(PROGRAMME_TYPE_GETTEXT_XPATH)).getText();
		
	}
	public static String  getProgrammeTitleFilledText(){
		return SeleniumUtil.getWebElement(By.xpath(PROGRAMME_TITLE_GETTEXT_XPATH)).getText();
		
	}
}
