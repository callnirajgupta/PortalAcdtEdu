@Signup @Regression
Feature: Signup page functionality

  @Signup1
  Scenario Outline: verify mandatory field validation of signup page
    Given user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data for field "<First Name>" and "<Middle Name>" and "<Last Name>" and "<Programme Type>" and "<Gender>" and "<Country of Residence>" and "<Mobile Number>" and "<Email address>" and "<Password>" and "<Confirm Password>" and "<Captcha>"
    Then verify application display error message "<Message>"

    Examples: 
      | First Name | Middle Name | Last Name | Programme Type | Gender | Country of Residence | Mobile Number | Email address            | Password | Confirm Password | Captcha | Message |
      |            | test        | tester    | Diploma        | M      | India                | +919241521992    | callnirajgupta@gmail.com | password | password         | yes     | First Name is blank.|
      #| niraj      | test        |           | Diploma        | M      | India                | +919241521992    | callnirajgupta@gmail.com | password | password         | yes     | Last Name is blank.    |
      #| niraj      | test        | tester    |                | M      | India                | +919241521992    | callnirajgupta@gmail.com | password | password         | yes     | Select a Programme type.   |
      #| niraj      | test        | tester    | Diploma        |        | India                | +919241521992    | callnirajgupta@gmail.com | password | password         | yes     | Select your gender.    |
      #| niraj      | test        | tester    | Diploma        | M      |                      | +919241521992    | callnirajgupta@gmail.com | password | password         | yes     | Select your country of residence.   |
      #| niraj      | test        | tester    | Diploma        | M      | India                |                  | callnirajgupta@gmail.com | password | password         | yes     | Mobile no is blank.    |
      #| niraj      | test        | tester    | Diploma        | M      | India                | +919241521992    |                          | password | password         | yes     | Email is blank.   |
      #| niraj      | test        | tester    | Diploma        | M      | India                | +919241521992    | callnirajgupta@gmail.com | password | password         | yes     | Applicant with callnirajgupta@gmail.com already exist  |
      #| niraj      | test        | tester    | Diploma        | M      | India                | +919241521992    | callnirajgupta@gmail.com |          | password         | yes     | Password is blank.Reconfirm your password.   |
      #| niraj      | test        | tester    | Diploma        | M      | India                | +919241521992    | callnirajgupta@gmail.com | password |                  | yes     | Reconfirm your password.   |
      #| niraj      | test        | tester    | Diploma        | M      | India                | +919241521992    | callnirajgupta@gmail.com |          |                  | yes     | Password is blank.   |
      | niraj      | test        | tester    | Diploma        | M      | India                | +919241521992    | callnirajgupta@gmail.com | password | password         |         | Please confirm if you are not a Robot|
  
  @Signup2
  Scenario: Validate selection of country and country code
    Given user navigates to home page
    When user click on start application button in home page
    Then user select the all country and country code one by one successfully
    
    
    
  
  
  Scenario: Field validation of signup page
    Given user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data for field "<First Name>" and "<Middle Name>" and "<Last Name>" and "<Programme Type>" and "<Gender>" and "<Mobile Number>" and "<Country of Residence>" and "<Email address>" and "<Password>" and "<Confirm Password>" and "<Captcha>"
    Then User should navigate to personal details page
