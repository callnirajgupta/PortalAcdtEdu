package com.aucdt.edu.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.aucdt.edu.util.SeleniumUtil;

public class FaqsPage {
	private static final Logger LOGGER = LogManager.getLogger(FaqsPage.class);
	public static final String FAQS_TITLE_XPATH = "//h3[text()='Frequently Asked Questions']";
	public static final String INSTRUCTION_BUTTON_XPATH = "//a[text()='Instructions' and @class='btn btn-move-right acdt-btn-fill btn-round']";
	public static final String BACK_HOME_BUTTON_XPATH = "//a[text()='Back Home']";
	
	public static void validateFaqsTitle() {
		LOGGER.info("Inside validateFaqsTitle Method");
		SeleniumUtil.wait(3000);
		SeleniumUtil.validateWebElementVisible(By.xpath(FAQS_TITLE_XPATH),
				SeleniumUtil.waitWebElementSync);
	}
	
	public static void clickInstructionButton(){
		SeleniumUtil.getWebElement(By.xpath(INSTRUCTION_BUTTON_XPATH)).click();
	}
	public static void clickBackHomeButton(){
		SeleniumUtil.getWebElement(By.xpath(BACK_HOME_BUTTON_XPATH)).click();
	}
	

}
