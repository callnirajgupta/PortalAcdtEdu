package com.acdt.edu.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.acdt.edu.util.SeleniumUtil;



public class AddSubjectForExamination {
	private static final Logger LOGGER = LogManager.getLogger(ExaminationPage.class);
	public static final String EXAMINATION_HEADER_XPATH = "//h3[text()='Add Subjects for Examinations Taken']";
	public static final String SUBJECT_XPATH = "//div[label[text()='Subject']]//input";
	public static final String GRADE_XPATH = "//div[label[text()='Grade']]//input";
	public static final String DELETE_XPATH = "//div[label[text()='Delete']]//button";
	public static final String ERROR_MESSAGE_XPATH ="//div[@class='errorMessage']";
	public static final String NEXT_BUTTON_XPATH="//a[text()='Next']";
	public static final String ADD_SUBJECT_BUTTON_XPATH = "//a[contains(text(),'Add Subject')]";
	   
	
	public static void validateAddSubjectForExaminationTitle() {
		LOGGER.info("Inside validateAddSubjectForExaminationTitle Method");
		SeleniumUtil.validateWebElementVisible(By.xpath(EXAMINATION_HEADER_XPATH),
				SeleniumUtil.waitWebElementSync);
	}
    
	
	public static void clickAddSubject(){
		LOGGER.info("Inside clickAddSubject Method");
		SeleniumUtil.validateWebElementVisible(By.xpath(ADD_SUBJECT_BUTTON_XPATH),
				SeleniumUtil.waitWebElementSync);
		SeleniumUtil.getWebElement(By.xpath(ADD_SUBJECT_BUTTON_XPATH)).click();
		
	}
	
	public static void clickDeleteSubject(int index){
		LOGGER.info("Inside clickAddSubject Method");
		SeleniumUtil.validateWebElementVisible(By.xpath(DELETE_XPATH),
				SeleniumUtil.waitWebElementSync);
		SeleniumUtil.scrollToWebElement(SeleniumUtil.getWebElements(By.xpath(DELETE_XPATH)).get(index));
		SeleniumUtil.getWebElements(By.xpath(DELETE_XPATH)).get(index).click();
	}
	
	public static void validateDefaultSubjectDisplay(){
		
		SeleniumUtil.validateWebElementVisible(By.xpath(SUBJECT_XPATH),
				SeleniumUtil.waitWebElementSync);
		
		Assert.assertTrue("Default subject is not  displayingafter", SeleniumUtil.getWebElements(By.xpath(SUBJECT_XPATH)).size()==2);
	}
}
