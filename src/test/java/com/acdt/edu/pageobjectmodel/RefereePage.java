package com.acdt.edu.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.acdt.edu.util.SeleniumUtil;

public class RefereePage {
	private static final Logger LOGGER = LogManager.getLogger(RefereePage.class);
	public static final String REFEREE_HEADER_XPATH = "//h3[text()='Referee']";

	
	public static void validateRefereeTitle() {
		LOGGER.info("Inside validateRefereeTitle Method");
		SeleniumUtil.validateWebElementVisible(By.xpath(REFEREE_HEADER_XPATH),
				SeleniumUtil.waitWebElementSync);
	}
}
