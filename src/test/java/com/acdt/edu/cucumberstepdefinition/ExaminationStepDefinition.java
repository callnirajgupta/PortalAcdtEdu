package com.acdt.edu.cucumberstepdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.acdt.edu.pageobjectmodel.ExaminationSubject;
import com.acdt.edu.pageobjectmodel.EducationalBackgroundPage;
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
	   public void EnterMandatoryfieldExaminationPageValidateErrorMessage(List<Map<String, String>> dataTable) throws InterruptedException{
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

				ExaminationPage.clickNextButtonInEducationalBackGround();
				try {
					String appError = ExaminationPage.getErrorMessage();
	                 System.out.println("print messaeg**************"+appError);
					if (!appError.equals(dataTable.get(i).get("Message"))) {
						list.add(dataTable.get(i).get("Message"));
						flag = false;
						LOGGER.info("Error message is matching as " + dataTable.get(i).get("Message"));
					} else {
						LOGGER.error("Error message is Not matching as " + dataTable.get(i).get("Message"));
					}
				} catch (Exception e) {
					list.add(dataTable.get(i).get("Message"));
					flag = false;
					LOGGER.error("Error message is Not displayed as " + dataTable.get(i).get("Message"));
				}
				
			}

			Assert.assertTrue("The error message is not matching for Current Educational Background" + list, flag);

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
		  ExaminationSubject.validateExaminationSubjectTitle();  
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
