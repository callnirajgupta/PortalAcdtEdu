package com.acdt.edu.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.acdt.edu.util.SeleniumUtil;



public class AddSubjectForExamination {
	private static final Logger LOGGER = LogManager.getLogger(AddSubjectForExamination.class);
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
	
	public static void enterMandatoryFieldForAddSubjectForExaminationTaken(String subject1, String grade1,String subject2,String grade2){
		if(!("".equals(subject1))){
			SeleniumUtil.validateWebElementVisible(By.xpath(SUBJECT_XPATH), SeleniumUtil.waitWebElementSync);
			SeleniumUtil.getWebElements(By.xpath(SUBJECT_XPATH)).get(0).clear();
			SeleniumUtil.getWebElements(By.xpath(SUBJECT_XPATH)).get(0).sendKeys(subject1);	
		}
		
		if(!("".equals(grade1))){
			SeleniumUtil.getWebElements(By.xpath(GRADE_XPATH)).get(0).sendKeys(grade1);	
		}
		
		if(!("".equals(subject2))){
			SeleniumUtil.validateWebElementVisible(By.xpath(SUBJECT_XPATH), SeleniumUtil.waitWebElementSync);
			SeleniumUtil.getWebElements(By.xpath(SUBJECT_XPATH)).get(1).clear();
			SeleniumUtil.getWebElements(By.xpath(SUBJECT_XPATH)).get(1).sendKeys(subject2);	
		}
		
		if(!("".equals(grade2))){
			SeleniumUtil.getWebElements(By.xpath(GRADE_XPATH)).get(1).sendKeys(grade2);	
		}
		
	
	}
	
	
	public static void enterNewSubjectFieldsForAddSubjectForExaminationTaken( String grade1,String grade2,String subject3,String grade3){
		
		
		if(!("".equals(grade1))){
			SeleniumUtil.getWebElements(By.xpath(GRADE_XPATH)).get(0).sendKeys(grade1);	
		}
		
		
		
		if(!("".equals(grade2))){
			SeleniumUtil.getWebElements(By.xpath(GRADE_XPATH)).get(1).sendKeys(grade2);	
		}
		
		if(!("".equals(subject3))){
			SeleniumUtil.validateWebElementVisible(By.xpath(SUBJECT_XPATH), SeleniumUtil.waitWebElementSync);
			SeleniumUtil.getWebElements(By.xpath(SUBJECT_XPATH)).get(2).clear();
			SeleniumUtil.getWebElements(By.xpath(SUBJECT_XPATH)).get(2).sendKeys(subject3);	
		}
		if(!("".equals(grade3))){
			SeleniumUtil.getWebElements(By.xpath(GRADE_XPATH)).get(2).sendKeys(grade3);	
		}
	
	}
	public static String getErrorMessage(){
		SeleniumUtil.wait(2000);
		 return SeleniumUtil.getWebElement(By.xpath(ERROR_MESSAGE_XPATH)).getText().trim();
		
	}
	
	public static void clickNextButtonInEducationalBackGround(){
		SeleniumUtil.getWebElement(By.xpath(NEXT_BUTTON_XPATH)).click();
	}
}
