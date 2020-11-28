
@login @Regression
Feature: Mandatory field validation of login page
 
@login1
Scenario: Field validation of email address as null and password as null in login page
Given user navigates to home page
When user click on login menu
Then verify user navigate to login page
When user enter email and password and click login button
Then user should navigate to personal details page



