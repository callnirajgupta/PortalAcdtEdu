package com.acdt.edu.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.acdt.edu.util.SeleniumUtil;

public class FinancingYourStudy {
	private static final Logger LOGGER = LogManager.getLogger(FinancingYourStudy.class);
	public static final String FINANCING_YOUR_STUDY_HEADER_XPATH = "//h3[text()='Financing your Study']";
	
	public static void validateFinancingYourStudyTitle() {
		LOGGER.info("Inside validateFinancingYourStudyTitle Method");
		SeleniumUtil.validateWebElementVisible(By.xpath(FINANCING_YOUR_STUDY_HEADER_XPATH),
				SeleniumUtil.waitWebElementSync);
	}
	
	
}
