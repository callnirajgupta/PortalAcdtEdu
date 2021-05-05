package com.aucdt.edu.pageobjectmodel;

import java.io.File;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aucdt.edu.util.SeleniumUtil;



public class ExaminationPage {
	private static final Logger LOGGER = LogManager.getLogger(ExaminationPage.class);
	public static final String EXAMINATION_HEADER_XPATH = "//h3[text()='Examinations']";
	public static final String EXAMINATION_TYPE_XPATH = "//div[label[text()='Examination Type']]//div[@class='c-btn']/span[1]";
	public static final String EXAMINATION_TYPE_GETTEXT_XPATH = "//div[label[text()='Examination Type']]//div[@class='c-btn']/span/span";
	public static final String INDEX_NUMBER_XPATH = "//div[label[text()='Index Number']]//input";
	public static final String DATE_OF_EXAMINATION_XPATH = "//div[label[text()='Date of Examination']]//input";
	public static final String UPLOAD_RESULT_SLIP_BUTTON_XPATH ="//span[text()='Upload Result slip']";
	public static final String DELETE_EXAM_TYPE_XPATH = "//span[text()='Delete Exam Type']";
	public static final String CLEAR_RESULT_SLIP_XPATH="//span[text()='Clear Result slip']";
	public static final String ADD_NEW_EXAMINATION_TYPE_XPATH = "//a[text()=' Add New Examination Type']";
	public static final String UPLOAD_RESULT_SLIP_DETAILS_XPATH="//div[@class='text-left']/p[contains(text(),'.jpg')]";
	public static final String SEARCH_XPATH="(//input[@placeholder='Search'])[index]";
    public static final String SELECT_LABEL_XPATH="//label[text()='selectText']";
    public static final String CALENDAR_MONTH_XPATH="//select[@title='Select month']";
    public static final String CALENDAR_YEAR_XPATH="//select[@title='Select year']";
    public static final String CALENDAR_DATE_XPATH="//div[@class='btn-light' and text()='date']";
    public static final String ERROR_MESSAGE1_XPATH ="(//div[@class='errorMessage']/p)[1]";
    public static final String ERROR_MESSAGE2_XPATH ="(//div[@class='errorMessage']/p)[2]";
    public static final String NEXT_BUTTON_XPATH="//a[text()='Next']";
    public static final String PREVIOUS_XPATH = "//a[text()='Previous']";
    
    public static void validateExaminationTitle() {
		LOGGER.info("Inside validateExaminationTitle Method");
		SeleniumUtil.wait(1000);
		SeleniumUtil.validateWebElementVisible(By.xpath(EXAMINATION_HEADER_XPATH),
				SeleniumUtil.waitWebElementSync);
	}
		
		public static void clickaddNewExaminationType(){
			LOGGER.info("Inside clickaddNewExaminationType Method");
			SeleniumUtil.validateWebElementVisible(By.xpath(ADD_NEW_EXAMINATION_TYPE_XPATH),
				SeleniumUtil.waitWebElementSync);
			
			SeleniumUtil.getWebElement(By.xpath(ADD_NEW_EXAMINATION_TYPE_XPATH)).click();
		}
		
		public static void clickDeleteExamType(int deleteIndex) throws InterruptedException{
			LOGGER.info("Inside clickDeleteExamType Method");
			Thread.sleep(1000);
			SeleniumUtil.getWebElements(By.xpath(DELETE_EXAM_TYPE_XPATH)).get(deleteIndex).click();
		}
		
		public static void uploadResultSlip(String resultSlip) throws Throwable{
			SeleniumUtil.scrollToWebElement(By.xpath(UPLOAD_RESULT_SLIP_BUTTON_XPATH));
			if(!("".equals(resultSlip))){
			SeleniumUtil.getWebElement(By.xpath(UPLOAD_RESULT_SLIP_BUTTON_XPATH)).click();
			File file = new File("src/test/resources/Upload/"+resultSlip);
			String path = file.getAbsolutePath();
			//String path="https://aucdt.edu.gh/img/AUCDT-Logo-for-Website.png";
			System.out.println("path of file "+path);
			Thread.sleep(4000);
			SeleniumUtil.robotUploadFile(path);
			Thread.sleep(5000);
			}
		}
		
		public static void clickClearUploadedSlip(){
			SeleniumUtil.validateWebElementVisible(By.xpath(CLEAR_RESULT_SLIP_XPATH), SeleniumUtil.waitWebElementSync);
			SeleniumUtil.wait(1000);
			SeleniumUtil.getWebElement(By.xpath(CLEAR_RESULT_SLIP_XPATH)).click();
		}
		
		public static void validateUploadResultSlipSuccess(){
			List<WebElement> lisElement=SeleniumUtil.getWebElements(By.xpath(UPLOAD_RESULT_SLIP_DETAILS_XPATH));
			Assert.assertTrue("The Result slip is not uploaded", lisElement.size()>0);
		}
		public static void validateDeleteResultSlipSuccess(){
			List<WebElement> listElement=SeleniumUtil.getWebElements(By.xpath(UPLOAD_RESULT_SLIP_DETAILS_XPATH));
			Assert.assertTrue("The Result slip is not deleted", listElement.size()==0);
		}
		
		public static void enterExaminationDetails(String examinationType,String indexNumber,String dateOfExamination) throws Throwable{
			LOGGER.info("Inside enterExaminationDetails Method");
			
			
			if(!("".equals(examinationType))){
				SeleniumUtil.validateWebElementVisible(By.xpath(EXAMINATION_TYPE_XPATH), SeleniumUtil.waitWebElementSync);
				if(!examinationType.equals(SeleniumUtil.getWebElement(By.xpath(EXAMINATION_TYPE_XPATH)).getText().trim())){
				SeleniumUtil.getWebElement(By.xpath(EXAMINATION_TYPE_XPATH)).click();
				//SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "1"))).sendKeys(country);
				SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", examinationType))).click();
				}	
			}
			if(!("".equals(indexNumber))){
				SeleniumUtil.validateWebElementVisible(By.xpath(INDEX_NUMBER_XPATH), SeleniumUtil.waitWebElementSync);
				SeleniumUtil.getWebElement(By.xpath(INDEX_NUMBER_XPATH)).clear();
				SeleniumUtil.getWebElement(By.xpath(INDEX_NUMBER_XPATH)).sendKeys(indexNumber);	
			}
			
			if(!("".equals(dateOfExamination))){
				SeleniumUtil.scrollToWebElement(By.xpath(DATE_OF_EXAMINATION_XPATH));
				 String[] dobsplit=dateOfExamination.split("/");
			    SeleniumUtil.getWebElement(By.xpath(DATE_OF_EXAMINATION_XPATH)).click();
			    Thread.sleep(1000);
				SeleniumUtil.selectWebList(By.xpath(CALENDAR_YEAR_XPATH), dobsplit[2], "selectByVisibleText");
				Thread.sleep(1000);
				SeleniumUtil.selectWebList(By.xpath(CALENDAR_MONTH_XPATH), dobsplit[1], "SelectByvalue");
				Thread.sleep(1000);
				SeleniumUtil.getWebElement(By.xpath(CALENDAR_DATE_XPATH.replace("date", dobsplit[0]))).click();
				//Thread.sleep(2000);	
				
			}
			
			
					
		}
		
		public static String getErrorMessage(){
			SeleniumUtil.wait(2000);
			SeleniumUtil.scrollToWebElement(By.xpath(ERROR_MESSAGE1_XPATH));
			String errorMessage1=SeleniumUtil.getWebElement(By.xpath(ERROR_MESSAGE1_XPATH)).getText().trim();
			 String errorMessage2=SeleniumUtil.getWebElement(By.xpath(ERROR_MESSAGE2_XPATH)).getText().trim();
			System.out.println("print the message"+errorMessage1+errorMessage2);
			 return errorMessage1+errorMessage2;
		}
		
		public static void clickNextButtonInEducationalBackGround(){
			SeleniumUtil.scrollToWebElement(By.xpath(NEXT_BUTTON_XPATH));
			SeleniumUtil.getWebElement(By.xpath(NEXT_BUTTON_XPATH)).click();
		}
		
		public static void clickPreviousButton(){
			SeleniumUtil.scrollToWebElement(By.xpath(PREVIOUS_XPATH));
			SeleniumUtil.getWebElement(By.xpath(PREVIOUS_XPATH)).click();
			
		}
		
		public static String  getExaminationTypeFilledText(){
			return SeleniumUtil.getWebElement(By.xpath(EXAMINATION_TYPE_GETTEXT_XPATH)).getText();	
		}
		
		public static String  getIndexNumberFilledText(){
			return SeleniumUtil.getWebElement(By.xpath(INDEX_NUMBER_XPATH)).getAttribute("value");	
		}
		
		public static String  getDateOfExaminationFilledText(){
			SeleniumUtil.scrollToWebElement(By.xpath(DATE_OF_EXAMINATION_XPATH));
			return SeleniumUtil.getWebElement(By.xpath(DATE_OF_EXAMINATION_XPATH)).getAttribute("value");	
		}
		public static String  getUploadResultSlipFilledText(){
			return SeleniumUtil.getWebElement(By.xpath(UPLOAD_RESULT_SLIP_DETAILS_XPATH)).getText();	
		}
}
