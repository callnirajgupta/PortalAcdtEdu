package com.acdt.edu.cucumberstepdefinition;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.acdt.edu.pageobjectmodel.FaqsPage;
import com.acdt.edu.pageobjectmodel.HomePage;
import com.acdt.edu.pageobjectmodel.InstructionPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InstructionFAQsStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(InstructionFAQsStepDefinition.class);
	@When("^user click Instruction tab$")
	public void userClickInstructionTab() throws IOException{
		HomePage.clickInstructionTab();
		
	}
	
    @Then("^verify that user navigate to Instruction page$")
    public void verifyThatUserNavigateToInstructionPage(){
    	InstructionPage.validateInstructionTitle();
    }
    
    @When("^user click FAQS button$")
    public void userClickFAQSButton(){
    	InstructionPage.clickFAQSButton();
    }
    
    @Then("^verify that user navigate to FAQ page$")
    public void verifyThatUserNavigateToFAQPage(){
    	FaqsPage.validateFaqsTitle();
    }
    
    @When("^user click on Back Home button$")
    public void userClickOnBackHomeButton(){
    	FaqsPage.clickBackHomeButton();
    }
    @Then("^verify that user navigate to Home page$")
    public void verifyThatUserNavigateToHomePage(){
    	HomePage.validateHomePageTitle();
    }
    
    @When("^user click FAQs tab$")
    public void userClickFAQsTab() throws IOException{
    	HomePage.clickFAQsTab();
    }
    
    @When("^user click Instruction button$")
    public void userClickInstructionButton(){
    	FaqsPage.clickInstructionButton();
    }
}
