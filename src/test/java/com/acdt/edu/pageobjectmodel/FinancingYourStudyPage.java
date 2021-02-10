package com.acdt.edu.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.acdt.edu.util.SeleniumUtil;

public class FinancingYourStudyPage {
	private static final Logger LOGGER = LogManager.getLogger(FinancingYourStudyPage.class);
	public static final String FINANCING_YOUR_STUDY_HEADER_XPATH = "//h3[text()='Financing your Study']";
	public static final String FINANCING_YOUR_STUDY_XPATH = "//div[label[text()='How do you intend to finance your study in ACDT?']]//div[@class='c-btn']/span";
	public static final String FINANCING_YOUR_STUDY_GETTEXT_XPATH = "//div[label[text()='How do you intend to finance your study in ACDT?']]//div[@class='c-btn']/span/span";
	public static final String FINANCING_YOUR_STUDY_OTHER_XPATH = "//div[label[text()='If others, please specify']]//textarea";
	public static final String SEARCH_XPATH = "(//input[@placeholder='Search'])[1]";
	public static final String SELECT_OPTION_XPATH = "//label[text()='selectText']";
	public static final String ERROR_MESSAGE1_XPATH ="//div[@class='errorMessage']";
	public static final String ERROR_MESSAGE2_XPATH ="//div[@class='errorMessage']/p";
	public static final String NEXT_BUTTON_XPATH="//a[text()='Next']";
	public static final String PREVIOUS_XPATH = "//a[text()='Previous']";
	
	public static void validateFinancingYourStudyTitle() {
		LOGGER.info("Inside validateFinancingYourStudyTitle Method");
		SeleniumUtil.wait(3000);
		SeleniumUtil.validateWebElementVisible(By.xpath(FINANCING_YOUR_STUDY_HEADER_XPATH),
				SeleniumUtil.waitWebElementSync);
	}
	
	public static void enterDataInFinancingYourStudyDetails(String intendToFinance,String other){
		if (!("".equals(intendToFinance))) {
			SeleniumUtil.wait(3000);
			SeleniumUtil.validateWebElementVisible(By.xpath(FINANCING_YOUR_STUDY_XPATH), SeleniumUtil.waitWebElementSync);
			SeleniumUtil.wait(1000);
			if(!intendToFinance.equals(SeleniumUtil.getWebElement(By.xpath(FINANCING_YOUR_STUDY_XPATH)).getText().trim())){
			SeleniumUtil.getWebElement(By.xpath(FINANCING_YOUR_STUDY_XPATH)).click();
			SeleniumUtil.wait(1000);
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "1"))).sendKeys(intendToFinance);
			SeleniumUtil.wait(1000);
			SeleniumUtil.getWebElement(By.xpath(SELECT_OPTION_XPATH.replace("selectText", intendToFinance)))
					.click();
			}
		}

		if (!("".equals(other))) {
			SeleniumUtil.getWebElement(By.xpath(FINANCING_YOUR_STUDY_OTHER_XPATH)).clear();
			SeleniumUtil.getWebElement(By.xpath(FINANCING_YOUR_STUDY_OTHER_XPATH)).sendKeys(other);
		}
	}
	
	public static String getErrorMessage1(){
		SeleniumUtil.wait(2000);
		 return SeleniumUtil.getWebElement(By.xpath(ERROR_MESSAGE1_XPATH)).getText().trim();
		
	}
	public static String getErrorMessage2(){
		SeleniumUtil.wait(2000);
		 return SeleniumUtil.getWebElement(By.xpath(ERROR_MESSAGE2_XPATH)).getText().trim();
		
	}
	
	public static void clickNextButton(){
		SeleniumUtil.getWebElement(By.xpath(NEXT_BUTTON_XPATH)).click();
	}
	
	public static void clickPreviousButton(){
		SeleniumUtil.getWebElement(By.xpath(PREVIOUS_XPATH)).click();
	}
	
	public static String  getIntendToFinanceFilledText(){
		return SeleniumUtil.getWebElement(By.xpath(FINANCING_YOUR_STUDY_GETTEXT_XPATH)).getText();	
	}
	public static String  getIntendToFinanceOtherFilledText(){
		return SeleniumUtil.getWebElement(By.xpath(FINANCING_YOUR_STUDY_OTHER_XPATH)).getAttribute("value");	
	}
	
	
	
}
