package com.acdt.edu.pageobjectmodel;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.acdt.edu.commonstep.GlobalStepDefinition;
import com.acdt.edu.util.SeleniumUtil;

public class LoginPage {
	private static final Logger LOGGER = LogManager.getLogger(LoginPage.class);
	public static final By LOGIN_TITLE = By.xpath("//h3[text()='Returning Applicant']");
	public static final By LOGIN_EMAIL = By.name("usermail");
	public static final By LOGIN_PASSWORD = By.name("password");
	public static final By LOGIN_CAPTCHA = By.xpath("//span[@id='recaptcha-anchor']/div[1]");
	public static final By LOGIN_BUTTON = By.xpath("//a[text()='Login']");
	
	
	public static void validateLoginTitle() {
		LOGGER.info("Inside validateLoginTitle Method");
		SeleniumUtil.wait(2000);
		SeleniumUtil.validateWebElementVisible(LOGIN_TITLE,
				SeleniumUtil.waitWebElementSync);
	}

	
	public static void enterEmailAndPassword(String email,String password){
		LOGGER.info("Inside enterEmailAndPassword Method");
		if (!("".equals(email))) {
			SeleniumUtil.getWebElement(LOGIN_EMAIL).clear();
			SeleniumUtil.getWebElement(LOGIN_EMAIL).sendKeys(email);
		}
		
		if (!("".equals(password))) {
			
			SeleniumUtil.getWebElement(LOGIN_PASSWORD).clear();
			SeleniumUtil.getWebElement(LOGIN_PASSWORD).sendKeys(password);
		}
		
	}
	
	public static void clickCaptchaCheckBox(){
		SeleniumUtil.wait(2000);
		SeleniumUtil.getDriver().switchTo().frame(0);
		SeleniumUtil.getWebElement(LOGIN_CAPTCHA).click();
		SeleniumUtil.switchToDefaultContent();
		SeleniumUtil.wait(2000);
	}
	
	public static void clickLoginButton(){
		
		SeleniumUtil.getWebElement(LOGIN_BUTTON).click();
	
	}
	
}
