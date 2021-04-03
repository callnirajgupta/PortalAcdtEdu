package com.acdt.edu.cucumberstepdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import com.acdt.edu.pageobjectmodel.ExaminationSubjectPage;
import com.acdt.edu.commonstep.GlobalStepDefinition;
import com.acdt.edu.pageobjectmodel.ExaminationPage;
import com.acdt.edu.util.SeleniumUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExaminationStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(ExaminationStepDefinition.class);
	public static List<Map<String,String>> examinationTakenDataTable = new ArrayList<Map<String,String>>() ;
	  @When("^user add new examination type$")
	  public void addNewExaminationType(){
		  ExaminationPage.clickaddNewExaminationType();
		  
	  }
	   
	  @And("^user delete added new examination type$")
	  public void deleteAddedNewExaminationType() throws InterruptedException{
		  ExaminationPage.clickDeleteExamType(1);
		  
	  }
	  
	  @When("^user upload result slip$")
	  public void uploadResultSlip() throws Throwable{
		  ExaminationPage.uploadResultSlip("Passport.jpg");
		  ExaminationPage.validateUploadResultSlipSuccess();
	  }
	  @And("^user delete uploaded result slip$")
	  public void deleteUploadedSlip(){
		  ExaminationPage.clickClearUploadedSlip();
		  
	  }
	  
	   
	   @Then("^verify that uploaded result slip is deleted$")
	   public void verifyUploadedResultSlipDeleted(){
		   ExaminationPage.validateDeleteResultSlipSuccess();
		   
	   }
	   
	   @When("^user enter mandatory fields data in examination page and validate error message$")
	   public void EnterMandatoryfieldExaminationPageValidateErrorMessage(List<Map<String, String>> dataTable) throws Throwable{
		   LOGGER.info(
					"user enter mandatory fields data in Educational Background page and validate error message");
			List<String> list = new ArrayList<String>();
			boolean flag = true;
			for (int i = 0; i < dataTable.size(); i++) {
				if(i!=0){
					SeleniumUtil.refreshPage();
				}
				ExaminationPage.enterExaminationDetails(
						dataTable.get(i).get("ExaminationType"), dataTable.get(i).get("IndexNumber"),
						dataTable.get(i).get("DateOfExamination"));
				 ExaminationPage.uploadResultSlip(dataTable.get(i).get("UploadResultSlip"));
				ExaminationPage.clickNextButtonInEducationalBackGround();
				
			
				
				try {
					SeleniumUtil.wait(2000);
					
		            Assert.assertEquals("The Error message is Not matching ", dataTable.get(i).get("Message"), ExaminationPage.getErrorMessage());
					
				} catch (AssertionError e) {
					list.add(dataTable.get(i).get("Message"));
					flag = false;
					LOGGER.error("The Error message is Not displaying  as " + dataTable.get(i).get("Message"));
					SeleniumUtil.failTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), " Error message is not matching");
				    if(SeleniumUtil.getWebElements(By.xpath(ExaminationSubjectPage.EXAMINATION_SUBJECT_HEADER_XPATH)).size()>0){
				    	SeleniumUtil.getDriver().navigate().back();
				    }
				}catch(Exception e){
					flag = false;
					SeleniumUtil.failTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), " Error message is not matching");
					 if(SeleniumUtil.getWebElements(By.xpath(ExaminationSubjectPage.EXAMINATION_SUBJECT_HEADER_XPATH)).size()>0){
					    	SeleniumUtil.getDriver().navigate().back();
					    }
				}
				
			}

			Assert.assertTrue("The error message is not matching for Examination Taken" + list, flag);

	   }

	   
	   @When("^user enter mandatory fields data in examination page$")
	   public void EnterMandatoryfieldExaminationPage(List<Map<String, String>> dataTable) throws Throwable{
		   examinationTakenDataTable=dataTable;
		   ExaminationPage.enterExaminationDetails(
					dataTable.get(0).get("ExaminationType"), dataTable.get(0).get("IndexNumber"),
					dataTable.get(0).get("DateOfExamination"));
		   ExaminationPage.uploadResultSlip(dataTable.get(0).get("UploadResultSlip"));
			ExaminationPage.clickNextButtonInEducationalBackGround();   
	   }
	   
	   @When("^user enter fields data in examination page$")
	   public void EnterfieldExaminationPage(List<Map<String, String>> dataTable) throws Throwable{
		   examinationTakenDataTable=dataTable;
		   ExaminationPage.enterExaminationDetails(
					dataTable.get(0).get("ExaminationType"), dataTable.get(0).get("IndexNumber"),
					dataTable.get(0).get("DateOfExamination"));
		   ExaminationPage.uploadResultSlip(dataTable.get(0).get("UploadResultSlip"));
			  
	   }
	  @Then("^verify that user navigation to Examination Subject page$")
	  public void UserNavigationToAddSubjectExaminationTaken(){
		  ExaminationSubjectPage.validateExaminationSubjectTitle();  
	  }
	  
	  @When("^user click on previous button in Examination page$")
	  public void clickOnPreviousButtonInExaminationPage(){
		  ExaminationPage.clickPreviousButton();
		  
	  }
	  
	  @Then("^validate that Examination page filled data persist$")
	  public void validateThatExaminationPageFilledDataPersist(){
		  boolean flag=false;
			try {
				SeleniumUtil.wait(5000);
				Assert.assertEquals("The ExaminationType is not matching",ExaminationPage.getExaminationTypeFilledText(),
						examinationTakenDataTable.get(0).get("ExaminationType").toUpperCase());
			} catch (AssertionError e) {
				e.printStackTrace();
				flag=true;
			}
			
			try {
				SeleniumUtil.wait(5000);
				Assert.assertEquals("The IndexNumber is not matching",ExaminationPage.getIndexNumberFilledText(),
						examinationTakenDataTable.get(0).get("IndexNumber").toUpperCase());
			} catch (AssertionError e) {
				e.printStackTrace();
				flag=true;
			}
			
			try {
				SeleniumUtil.wait(5000);
				Assert.assertEquals("The DateOfExamination is not matching",ExaminationPage.getDateOfExaminationFilledText(),
						examinationTakenDataTable.get(0).get("DateOfExamination").toUpperCase());
			} catch (AssertionError e) {
				e.printStackTrace();
				flag=true;
			}
			
			try {
				SeleniumUtil.wait(5000);
				Assert.assertEquals("The UploadResultSlip is not matching",ExaminationPage.getUploadResultSlipFilledText(),
						examinationTakenDataTable.get(0).get("UploadResultSlip"));
			} catch (AssertionError e) {
				e.printStackTrace();
				flag=true;
			}
			Assert.assertFalse("The Examination Page filled data is not Matching",flag);
		  
	  }
}
