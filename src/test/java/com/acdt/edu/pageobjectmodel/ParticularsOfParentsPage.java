package com.acdt.edu.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.acdt.edu.util.SeleniumUtil;

public class ParticularsOfParentsPage {
	private static final Logger LOGGER = LogManager.getLogger(ParticularsOfParentsPage.class);
	public static final String PARTICULAR_OF_PARENT_TITLE_XPATH ="//h4[text()='Particulars of Parents/Guardians/Sponsor']";
	
	public static void validateParticularsOfParentsTitle() {
		LOGGER.info("Inside validateParticularsOfParentsTitle  Method");
		SeleniumUtil.validateWebElementVisible(By.xpath(PARTICULAR_OF_PARENT_TITLE_XPATH),SeleniumUtil.waitWebElementSync);
	}


}
