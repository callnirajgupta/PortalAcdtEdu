@InstructionFAQ @Regression
Feature: Add Subject for The Examination Page functionality checking

   @InstructionFAQ1
  Scenario: validate that user navigate to instruction and Faqs and back to home page
    Given user navigates to home page
    When user click Instruction tab
    Then verify that user navigate to Instruction page
    When user click FAQS button
    Then verify that user navigate to FAQ page
    When user click on Back Home button
    Then verify that user navigate to Home page
    
    @InstructionFAQ2
  Scenario: validate that user navigate to Faqs and Instruction and back to home page
    Given user navigates to home page
    When user click FAQs tab
    Then verify that user navigate to FAQ page
    When user click Instruction button
    Then verify that user navigate to Instruction page
    When user click on Back Home button
    Then verify that user navigate to Home page