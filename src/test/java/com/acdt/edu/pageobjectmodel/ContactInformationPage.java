package com.acdt.edu.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.acdt.edu.util.SeleniumUtil;

public class ContactInformationPage {
	private static final Logger LOGGER = LogManager.getLogger(ContactInformationPage.class);
	public static final String CONTACT_INORMATION_TITLE_XPATH = "//h3[text()='Contact Information']";
	public static void validatePersonalDetailsTitle() {
		LOGGER.info("Inside validateHomePageTitle Method");
		SeleniumUtil.validateWebElementVisible(By.xpath(CONTACT_INORMATION_TITLE_XPATH), SeleniumUtil.waitWebElementSync);
	}

}
