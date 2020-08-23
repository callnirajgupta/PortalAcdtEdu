@Personal @Regression
Feature: personal details page fields validation

  @Personal2
  Scenario Outline: personal details page fields validation
    Given user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data for field "<First Name>" and "<Middle Name>" and "<Last Name>" and "<Programme Type>" and "<Gender>" and "<Country of Residence>" and "<Mobile Number>" and "<Email address>" and "<Password>" and "<Confirm Password>" and "<Captcha>"
    Then User should navigate to personal details page
    And verify that fields "<First Name>" and "<Last Name>" and "<Gender>" and "<Country of Residence>" are prefilled from Signup page

    Examples: 
      | First Name | Middle Name | Last Name | Programme Type | Gender | Country of Residence | Mobile Number | Email address        | Password | Confirm Password | Captcha |
      | Niraj      |             | tester    | Diploma        | M      | India                | +919241521992 | test123459@gmail.com | password | password         | yes     |

  @Personal3
  Scenario: personal details page fields validation
    Given user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data field in signup page
      | FirstName          | Automation           |
      | LastName           | Tester               |
      | MiddleName         |                      |
      | ProgrammeType      | Diploma              |
      | Gender             | M                    |
      | CountryOfResidence | India                |
      | MobileNumber       | +919241521992        |
      | EmailAddress       | Automation@gmail.com |
      | Password           | password             |
      | ConfirmPassword    | password             |
      | Captcha            | yes                  |
    Then User should navigate to personal details page
    When user enter mandatory data in personal details page for following fields
      | Image        | Title | FirstName | MiddleName | LastName | OtherName | Gender | DOB       | CountryOfBirth | CityOfBirth | Nationality | Religion | HomeTown | Region  | SpecialNeed | Comment |
      | Passport.jpg | Mr.   | Automation| Middle     |  tester  |  asd         | M   | 10/0/1980| India          | city        | Afghanistan      | Buddhism | hometown | Ashanti | Yes         | comment |
