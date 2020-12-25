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
	public static final  By ERROR_MESSAGE_XPATH=By.xpath("//div[@class='errorMessage']");
	
	
	public static void validateLoginTitle() {
		LOGGER.info("Inside validateLoginTitle Method");
		SeleniumUtil.wait(2000);
		SeleniumUtil.validateWebElementVisible(LOGIN_TITLE,
				SeleniumUtil.waitWebElementSync);
		
	}

	
	public static void enterEmailAndPassword(String email,String password){
		LOGGER.info("Inside enterEmailAndPassword Method");
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), "Login page Loaded successfully");
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
		LOGGER.info("Inside clickCaptchaCheckBox method");
		SeleniumUtil.wait(3000);
		SeleniumUtil.getDriver().switchTo().frame(0);
		SeleniumUtil.javascriptClickElement(LOGIN_CAPTCHA);
		//SeleniumUtil.getWebElement(LOGIN_CAPTCHA).click();
		SeleniumUtil.switchToDefaultContent();
		SeleniumUtil.wait(2000);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), "Login page Enter data successfully");
	}
	
	public static void clickLoginButton(){
		LOGGER.info("Inside clickLoginButton method");
		SeleniumUtil.getWebElement(LOGIN_BUTTON).click();
	
	}
	
	
	public static String getErrorMessage() {
		LOGGER.info("Inside getErrorMessage method");
		SeleniumUtil.wait(2000);
		
		return SeleniumUtil.getWebElement(ERROR_MESSAGE_XPATH).getText().trim();

	}
}
