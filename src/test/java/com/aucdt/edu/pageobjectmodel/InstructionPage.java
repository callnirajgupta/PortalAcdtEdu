package com.aucdt.edu.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.aucdt.edu.util.SeleniumUtil;

public class InstructionPage {
	private static final Logger LOGGER = LogManager.getLogger(InstructionPage.class);
	public static final String INSTRUCTION_TITLE_XPATH = "//h3[text()='Instructions']";
	public static final String FAQS_BUTTON_XPATH = "//a[text()='FAQs' and @class='btn btn-move-right acdt-btn-fill btn-round']";
	public static final String BACK_HOME_BUTTON_XPATH = "//a[text()='Back Home']";
	
	public static void validateInstructionTitle() {
		LOGGER.info("Inside validateInstrictionTitle Method");
		SeleniumUtil.wait(3000);
		SeleniumUtil.validateWebElementVisible(By.xpath(INSTRUCTION_TITLE_XPATH),
				SeleniumUtil.waitWebElementSync);
	}
	
	public static void clickFAQSButton(){
		SeleniumUtil.getWebElement(By.xpath(FAQS_BUTTON_XPATH)).click();
	}
	public static void clickBackHomeButton(){
		SeleniumUtil.getWebElement(By.xpath(BACK_HOME_BUTTON_XPATH)).click();
	}
	
}
