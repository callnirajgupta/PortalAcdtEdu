package com.acdt.edu.pageobjectmodel;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.acdt.edu.commonstep.GlobalStepDefinition;
import com.acdt.edu.util.SeleniumUtil;

public class HomePage {
	private static final Logger LOGGER = LogManager.getLogger(HomePage.class);
	public static final String HOME_TITLE_XPATH = "//h2[text()='Welcome to ACDT']";
	public static final String START_APPLICATION_BUTTON="//a[text()='Start Application']";
	public static final String INSTRUCTION_TAB_XPATH="//a[text()=' Instructions']";
	public static final String FAQS_TAB_XPATH="//a[text()=' FAQs']";
	public static void validateHomePageTitle() {
		LOGGER.info("Inside validateHomePageTitle Method");
		SeleniumUtil.wait(3000);
		SeleniumUtil.validateWebElementVisible(By.xpath(HOME_TITLE_XPATH),
				SeleniumUtil.waitWebElementSync);
	}
    
	public static void clickStartApplication() throws IOException{
		LOGGER.info("Inside clickStartApplication Method");
		SeleniumUtil.validateWebElementVisible(By.xpath(START_APPLICATION_BUTTON), SeleniumUtil.waitWebElementSync);
		SeleniumUtil.waitWebElementClickable(By.xpath(START_APPLICATION_BUTTON), SeleniumUtil.waitWebElementSync);
		SeleniumUtil.clickWebElement(By.xpath(START_APPLICATION_BUTTON), SeleniumUtil.waitWebElementSync);
		
	}
	
	public static void clickInstructionTab() throws IOException{
		LOGGER.info("Inside clickInstructionTab Method");
		SeleniumUtil.validateWebElementVisible(By.xpath(INSTRUCTION_TAB_XPATH), SeleniumUtil.waitWebElementSync);
		SeleniumUtil.waitWebElementClickable(By.xpath(INSTRUCTION_TAB_XPATH), SeleniumUtil.waitWebElementSync);
		SeleniumUtil.clickWebElement(By.xpath(INSTRUCTION_TAB_XPATH), SeleniumUtil.waitWebElementSync);
		
	}
	
	public static void clickFAQsTab() throws IOException{
		LOGGER.info("Inside clickFAQsTab Method");
		SeleniumUtil.validateWebElementVisible(By.xpath(FAQS_TAB_XPATH), SeleniumUtil.waitWebElementSync);
		SeleniumUtil.waitWebElementClickable(By.xpath(FAQS_TAB_XPATH), SeleniumUtil.waitWebElementSync);
		SeleniumUtil.clickWebElement(By.xpath(FAQS_TAB_XPATH), SeleniumUtil.waitWebElementSync);
		
	}

}
