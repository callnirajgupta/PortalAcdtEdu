package com.acdt.edu.pageobjectmodel;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

import com.acdt.edu.commonstep.GlobalStepDefinition;
import com.acdt.edu.util.SeleniumUtil;

public class LoginPage {
	private static final Logger LOGGER = LogManager.getLogger(LoginPage.class);
	public static final String LOGIN_TITLE = "Login | ISAPS";
	
	public static void validateLoginPageTitle() throws IOException {
		LOGGER.info("Inside validateLoginPageTitle Method");
		Assert.assertEquals("The expected title is not matching with actual ", LOGIN_TITLE,
				SeleniumUtil.getDriver().getTitle());
		
	}

	
}
