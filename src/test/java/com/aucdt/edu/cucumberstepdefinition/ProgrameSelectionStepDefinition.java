package com.aucdt.edu.cucumberstepdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.aucdt.edu.commonstep.GlobalStepDefinition;
import com.aucdt.edu.pageobjectmodel.EducationalBackgroundPage;
import com.aucdt.edu.pageobjectmodel.ProgrammeSelectionPage;
import com.aucdt.edu.util.SeleniumUtil;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProgrameSelectionStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(ProgrameSelectionStepDefinition.class);
	public static List<Map<String, String>> programeSelectionDataTable = new ArrayList<Map<String, String>>();

	@When("^user enter mandatory fields data in programme selection page and validate error message$")
	public void enterMandatoryfieldsInProgrammeSelectionAndErrorValidation(List<Map<String, String>> dataTable)
			throws Throwable {
		List<String> list = new ArrayList<String>();
		boolean flag = true;
		for (int i = 0; i < dataTable.size(); i++) {
			if (i != 0) {
				SeleniumUtil.refreshPage();
			}
			ProgrammeSelectionPage.programmeSelectionDetailsFilling(dataTable.get(i).get("ProgrammeType"),
					dataTable.get(i).get("ProgrammeTitle"));
			ProgrammeSelectionPage.clickNextButton();
			/*
			 * String appError=ProgrammeSelectionPage.getErrorMessage();
			 * 
			 * if(!appError.equals(dataTable.get(i).get("Message"))){
			 * list.add(appError); flag=false; }
			 */

			///
			try {
				SeleniumUtil.wait(2000);
				LOGGER.info("Validating error message as " + dataTable.get(i).get("Message"));
				Assert.assertEquals("The Error message is Not matching ", dataTable.get(i).get("Message"),
						ProgrammeSelectionPage.getErrorMessage());
				System.out.println("ASSERTION PASS");
			} catch (AssertionError e) {
				list.add(dataTable.get(i).get("Message"));
				flag = false;
				LOGGER.error("The Error message is Not displaying  as " + dataTable.get(i).get("Message"));
				SeleniumUtil.failTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(),
						" Error message is not matching");
				if (SeleniumUtil.getWebElements(By.xpath(EducationalBackgroundPage.EDUCATIONAl_BACKGROUND_HEADER_XPATH))
						.size() > 0) {
					SeleniumUtil.getDriver().navigate().back();
				}
			} catch (Exception e) {
				flag = false;
				list.add(dataTable.get(i).get("Message"));
				SeleniumUtil.failTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(),
						" Error message is not matching");
				LOGGER.error("The Error message is Not displaying  as " + dataTable.get(i).get("Message"));
				if (SeleniumUtil.getWebElements(By.xpath(EducationalBackgroundPage.EDUCATIONAl_BACKGROUND_HEADER_XPATH))
						.size() > 0) {
					SeleniumUtil.getDriver().navigate().back();
				}

			}
		}

		Assert.assertTrue("The error message is not matching for programme selection" + list, flag);
	}

	@When("^user enter mandatory fields data in programme selection page$")
	public void enterMandatoryFieldsDataInProgrammeSelectionPage(List<Map<String, String>> dataTable)
			throws InterruptedException {
		programeSelectionDataTable = dataTable;
		ProgrammeSelectionPage.programmeSelectionDetailsFilling(dataTable.get(0).get("ProgrammeType"),
				dataTable.get(0).get("ProgrammeTitle"));

	}

	@Then("^verify that user navigation to Educational Background page$")
	public void userNavigationToEducationalBackground() {
		EducationalBackgroundPage.validateEducationalBackgroundTitle();
	}

	@When("^user click on previous button in programme selection page$")
	public void click_on_previous_button_in_programme_selection_page() {
		ProgrammeSelectionPage.clickPreviousButton();

	}

	@When("^validate that programme selection filled data persist$")
	public void validate_that_programme_selection_filled_data_persist() {
		boolean flag = false;
		try {
			SeleniumUtil.wait(5000);
			Assert.assertEquals("The Address1 is not matching", ProgrammeSelectionPage.getProgrammeTypeFilledText(),
					programeSelectionDataTable.get(0).get("ProgrammeType").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			flag = true;
		}

		try {
			Assert.assertEquals("The ProgrammeTitle PostalCode is not matching",
					ProgrammeSelectionPage.getProgrammeTitleFilledText(),
					programeSelectionDataTable.get(0).get("ProgrammeTitle").toUpperCase());
		} catch (AssertionError e) {
			e.printStackTrace();
			flag = true;
		}

		Assert.assertFalse("The Programme Selection Page filled data is not Matching", flag);
	}

}
