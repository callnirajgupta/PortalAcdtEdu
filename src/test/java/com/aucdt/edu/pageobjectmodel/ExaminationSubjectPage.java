package com.aucdt.edu.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.aucdt.edu.util.SeleniumUtil;



public class ExaminationSubjectPage {
	private static final Logger LOGGER = LogManager.getLogger(ExaminationSubjectPage.class);
	public static final String EXAMINATION_SUBJECT_HEADER_XPATH = "//h3[text()='Examination Subjects']";
	public static final String SUBJECT1_XPATH = "//div[label[text()='Subject 1']]//input";
	public static final String SUBJECT2_XPATH = "//div[label[text()='Subject 2']]//input";
	public static final String SUBJECT3_XPATH = "//div[label[text()='Subject 3']]//input";
	public static final String SUBJECT4_XPATH = "//div[label[text()='Subject 4']]//input";
	public static final String SUBJECT5_XPATH = "//div[label[text()='Subject 5']]//input";
	public static final String SUBJECT6_XPATH = "//div[label[text()='Subject 6']]//input";
	public static final String GRADE_XPATH = "//div[label[text()='Grade']]//input";
	//public static final String DELETE_XPATH = "//div[label[text()='Delete']]//button";
	public static final String ERROR_MESSAGE_XPATH ="//div[@class='errorMessage']";
	public static final String NEXT_BUTTON_XPATH="//a[text()='Next']";
	public static final String PREVIOUS_BUTTON_XPATH="//a[text()='Previous']";
    public static final String INSTRUCTION_LINK_XPATH="//a[text()='link']";
    public static final String PREVIOUS_XPATH = "//a[text()='Previous']";
	
	//public static final String ADD_SUBJECT_BUTTON_XPATH = "//a[contains(text(),'Add Subject')]";
	   
	
	public static void validateExaminationSubjectTitle() {
		LOGGER.info("Inside validateAddSubjectForExaminationTitle Method");
		SeleniumUtil.wait(1000);
		SeleniumUtil.validateWebElementVisible(By.xpath(EXAMINATION_SUBJECT_HEADER_XPATH),
				SeleniumUtil.waitWebElementSync);
	}
    
	
	public static void validateDefaultSubjectDisplay(String subject1,String subject2){
		
		SeleniumUtil.validateWebElementVisible(By.xpath(SUBJECT1_XPATH),
				SeleniumUtil.waitWebElementSync);
		Assert.assertEquals("Default subject "+subject1 +" is not  displaying", subject1,SeleniumUtil.getWebElement(By.xpath(SUBJECT1_XPATH)).getAttribute("value"));
		Assert.assertEquals("Default subject "+subject2 +" is not  displaying", subject2,SeleniumUtil.getWebElement(By.xpath(SUBJECT2_XPATH)).getAttribute("value"));
	}
	
	public static void enterMandatoryFieldForExaminationSubjectTaken(String grade1,String grade2,String subject3,String grade3,String subject4,String grade4,String subject5,String grade5 ,String subject6,String grade6){
		
		if(!("".equals(grade1))){
			SeleniumUtil.wait(1000);
			SeleniumUtil.scrollToWebElement(By.xpath(GRADE_XPATH));
			SeleniumUtil.getWebElements(By.xpath(GRADE_XPATH)).get(0).clear();
			SeleniumUtil.getWebElements(By.xpath(GRADE_XPATH)).get(0).sendKeys(grade1);	
		}
		
		if(!("".equals(grade2))){
			SeleniumUtil.getWebElements(By.xpath(GRADE_XPATH)).get(1).clear();
			SeleniumUtil.getWebElements(By.xpath(GRADE_XPATH)).get(1).sendKeys(grade2);	
		}
		
		if(!("".equals(subject3))){
			SeleniumUtil.scrollToWebElement(By.xpath(SUBJECT3_XPATH));
			SeleniumUtil.validateWebElementVisible(By.xpath(SUBJECT3_XPATH), SeleniumUtil.waitWebElementSync);
			SeleniumUtil.getWebElement(By.xpath(SUBJECT3_XPATH)).clear();
			SeleniumUtil.getWebElement(By.xpath(SUBJECT3_XPATH)).sendKeys(subject3);	
		}
		
		if(!("".equals(grade3))){
			SeleniumUtil.getWebElements(By.xpath(GRADE_XPATH)).get(2).clear();
			SeleniumUtil.getWebElements(By.xpath(GRADE_XPATH)).get(2).sendKeys(grade3);	
		}
		
		if(!("".equals(subject4))){
			SeleniumUtil.scrollToWebElement(By.xpath(SUBJECT4_XPATH));
			SeleniumUtil.validateWebElementVisible(By.xpath(SUBJECT4_XPATH), SeleniumUtil.waitWebElementSync);
			SeleniumUtil.getWebElement(By.xpath(SUBJECT4_XPATH)).clear();
			SeleniumUtil.getWebElement(By.xpath(SUBJECT4_XPATH)).sendKeys(subject4);	
		}
		if(!("".equals(grade4))){
			SeleniumUtil.getWebElements(By.xpath(GRADE_XPATH)).get(3).clear();
			SeleniumUtil.getWebElements(By.xpath(GRADE_XPATH)).get(3).sendKeys(grade4);	
		}
		
		if(!("".equals(subject5))){
			SeleniumUtil.validateWebElementVisible(By.xpath(SUBJECT5_XPATH), SeleniumUtil.waitWebElementSync);
			SeleniumUtil.getWebElement(By.xpath(SUBJECT5_XPATH)).clear();
			SeleniumUtil.getWebElement(By.xpath(SUBJECT5_XPATH)).sendKeys(subject5);	
		}
		if(!("".equals(grade5))){
			SeleniumUtil.getWebElements(By.xpath(GRADE_XPATH)).get(4).sendKeys(grade5);	
		}
		if(!("".equals(subject6))){
			SeleniumUtil.validateWebElementVisible(By.xpath(SUBJECT6_XPATH), SeleniumUtil.waitWebElementSync);
			SeleniumUtil.getWebElement(By.xpath(SUBJECT6_XPATH)).clear();
			SeleniumUtil.getWebElement(By.xpath(SUBJECT6_XPATH)).sendKeys(subject6);	
		}
		if(!("".equals(grade6))){
			SeleniumUtil.getWebElements(By.xpath(GRADE_XPATH)).get(5).clear();
			SeleniumUtil.getWebElements(By.xpath(GRADE_XPATH)).get(5).sendKeys(grade6);	
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
			SeleniumUtil.scrollToWebElement(By.xpath(SUBJECT1_XPATH));
			SeleniumUtil.validateWebElementVisible(By.xpath(SUBJECT1_XPATH), SeleniumUtil.waitWebElementSync);
			SeleniumUtil.getWebElements(By.xpath(SUBJECT1_XPATH)).get(2).clear();
			SeleniumUtil.getWebElements(By.xpath(SUBJECT1_XPATH)).get(2).sendKeys(subject3);	
		}
		if(!("".equals(grade3))){
			SeleniumUtil.getWebElements(By.xpath(GRADE_XPATH)).get(2).sendKeys(grade3);	
		}
	
	}
	public static String getErrorMessage(){
		SeleniumUtil.wait(1000);
		SeleniumUtil.scrollToWebElement(By.xpath(ERROR_MESSAGE_XPATH));
		 return SeleniumUtil.getWebElement(By.xpath(ERROR_MESSAGE_XPATH)).getText().trim();
		
	}
	
	public static void clickNextButton(){
		SeleniumUtil.scrollToWebElement(By.xpath(NEXT_BUTTON_XPATH));
		SeleniumUtil.getWebElement(By.xpath(NEXT_BUTTON_XPATH)).click();
	}
	
	public static void clickPreviousButton(){
		SeleniumUtil.scrollToWebElement(By.xpath(PREVIOUS_XPATH));
		SeleniumUtil.getWebElement(By.xpath(PREVIOUS_XPATH)).click();
	}
	public static void clickInstructionLink(){
		SeleniumUtil.getWebElement(By.xpath(INSTRUCTION_LINK_XPATH)).click();
	}
	
	public static String  getSubject1FilledText(){
		return SeleniumUtil.getWebElement(By.xpath(SUBJECT1_XPATH)).getAttribute("value");	
	}
	
	public static String  getSubject2FilledText(){
		return SeleniumUtil.getWebElement(By.xpath(SUBJECT2_XPATH)).getAttribute("value");	
	}
	public static String  getSubject3FilledText(){
		SeleniumUtil.scrollToWebElement(By.xpath(SUBJECT3_XPATH));
		return SeleniumUtil.getWebElement(By.xpath(SUBJECT3_XPATH)).getAttribute("value");	
	}
	public static String  getSubject4FilledText(){
		return SeleniumUtil.getWebElement(By.xpath(SUBJECT4_XPATH)).getAttribute("value");	
	}
	public static String  getSubject5FilledText(){
		return SeleniumUtil.getWebElement(By.xpath(SUBJECT5_XPATH)).getAttribute("value");	
	}
	public static String  getSubject6FilledText(){
		SeleniumUtil.scrollToWebElement(By.xpath(SUBJECT6_XPATH));
		return SeleniumUtil.getWebElement(By.xpath(SUBJECT6_XPATH)).getAttribute("value");	
	}
	public static String  getGrade1FilledText(){
		return SeleniumUtil.getWebElements(By.xpath(GRADE_XPATH)).get(0).getAttribute("value");	
	}
	public static String  getGrade2FilledText(){
		return SeleniumUtil.getWebElements(By.xpath(GRADE_XPATH)).get(1).getAttribute("value");	
	}
	public static String  getGrade3FilledText(){
		return SeleniumUtil.getWebElements(By.xpath(GRADE_XPATH)).get(2).getAttribute("value");	
	}
	public static String  getGrade4FilledText(){
		return SeleniumUtil.getWebElements(By.xpath(GRADE_XPATH)).get(3).getAttribute("value");	
	}
	public static String  getGrade5FilledText(){
		return SeleniumUtil.getWebElements(By.xpath(GRADE_XPATH)).get(4).getAttribute("value");	
	}
	public static String  getGrade6FilledText(){
		SeleniumUtil.scrollToWebElement(By.xpath(GRADE_XPATH));
		return SeleniumUtil.getWebElements(By.xpath(GRADE_XPATH)).get(5).getAttribute("value");	
	}
	
	
}
