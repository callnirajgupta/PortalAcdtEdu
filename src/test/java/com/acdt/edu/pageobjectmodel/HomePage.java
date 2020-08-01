package com.acdt.edu.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.acdt.edu.util.SeleniumUtil;

public class HomePage {
	private static final Logger LOGGER = LogManager.getLogger(HomePage.class);
	public static final String HOME_TITLE = "ACDT Online Application";
	public static final String START_APPLICATION_BUTTON="//a[text()='Start Application']";

	public static void validateHomePageTitle() {
		LOGGER.info("Inside validateHomePageTitle Method");
		Assert.assertEquals("The expected title is not matching with actual ", HOME_TITLE,
				SeleniumUtil.getDriver().getTitle());
	}
    
	public static void clickStartApplication(){
		LOGGER.info("Inside validateHomePageTitle Method");
		SeleniumUtil.validateWebElementVisible(By.xpath(START_APPLICATION_BUTTON), SeleniumUtil.waitWebElementSync);
		SeleniumUtil.waitWebElementClickable(By.xpath(START_APPLICATION_BUTTON), SeleniumUtil.waitWebElementSync);
		SeleniumUtil.clickWebElement(By.xpath(START_APPLICATION_BUTTON), SeleniumUtil.waitWebElementSync);
		
	}

}
