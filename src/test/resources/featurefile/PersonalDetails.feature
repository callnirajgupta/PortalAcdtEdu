@Personal @Regression
Feature: personal details page fields validation

  @Personal2
  Scenario Outline: Pre filled fields in personal details page  from signup page validation
    Given user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data for field "<First Name>" and "<Middle Name>" and "<Last Name>" and "<Programme Type>" and "<Gender>" and "<Country of Residence>" and "<Mobile Number>" and "<Email address>" and "<Password>" and "<Confirm Password>" and "<Captcha>"
    And user click start application button
    Then user should navigate to personal details page
    And verify that fields "<First Name>" and "<Last Name>" and "<Gender>" and "<Country of Residence>" are prefilled from Signup page

    Examples: 
      | First Name    | Middle Name | Last Name    | Programme Type | Gender | Country of Residence | Mobile Number | Email address | Password | Confirm Password | Captcha |
      | TestFirstName |             | TestLastName | Diploma        | M      | India                | +919241521992 | auto          | password | password         | yes     |

  @Personal3
  Scenario: personal details page fields validation
    Given user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data field in signup page
      | FirstName     | LastName     | MiddleName     | ProgrammeType | Gender | CountryOfResidence | MobileNumber  | EmailAddress | Password | ConfirmPassword | Captcha |
      | TestFirstName | TestLastName | TestMiddleName | Diploma       | M      | India              | +919241521992 | auto         | password | password        | yes     |
    Then user should navigate to personal details page
    When user enter mandatory data in personal details page for following fields and validate error message
      | Image        | Title | FirstName     | MiddleName     | LastName     | OtherName     | Gender | DOB       | CountryOfBirth | CityOfBirth | Nationality | Religion | HomeTown | Region  | SpecialNeed | Comment | Message                                                          |
      |              | Miss  | TestFirstName | Middle         | testLastName       | TestOtherName          | M      | 11/6/1999 | India          | city        | Afghanistan | Buddhism | hometown | Ashanti | Yes         | comment | Please fill in the required field(s): Photo       |
      | Passport.jpg |       | TestFirstName | TestMiddleName | testLastName | TestOtherName           | M      | 12/6/1999 | India          | city        | Afghanistan | Buddhism | hometown | Ashanti | Yes         | comment | Please fill in the required field(s): Title            |
      #Defect| Passport.jpg | Miss  | TestFirstName | TestMiddleName |              | TestOtherName | M      | 10/6/1999 | India          | city        | Afghanistan | Buddhism | hometown | Ashanti | Yes         | comment | Please fill in the required field(s): Surname                    |
      #Defect| Passport.jpg | Miss  |               | TestMiddleName | TestLastName | TestOtherName | M      | 12/6/1999 | India          | city        | Afghanistan | Buddhism | hometown | Ashanti | Yes         | comment | Please fill in the required field(s): First Name                 |
      | Passport.jpg | Miss  | TestFirstName | TestMiddleName | TestLastName | TestOtherName |        | 11/6/1999 | India          | city        | Afghanistan | Buddhism | hometown | Ashanti | Yes         | comment | Please fill in the required field(s): Gender                     |
      | Passport.jpg | Miss  | TestFirstName | TestMiddleName | TestLastName | TestOtherName | M      |           | India          | city        | Afghanistan | Buddhism | hometown | Ashanti | Yes         | comment | Please fill in the required field(s): Date of Birth              |
      | Passport.jpg | Miss  | TestFirstName | TestMiddleName | TestLastName | TestOtherName | M      | 12/6/1999  |                | city        | Afghanistan | Buddhism | hometown | Ashanti | Yes         | comment | Please fill in the required field(s): Country of Birth           |
      | Passport.jpg | Miss  | TestFirstName | TestMiddleName | TestLastName | TestOtherName | M      | 11/6/1999 | India          |             | Afghanistan | Buddhism | hometown | Ashanti | Yes         | comment | Please fill in the required field(s): City of Birth              |
      #Defect| Passport.jpg | Miss  | TestFirstName | TestMiddleName | TestLastName | TestOtherName | M      | 13/6/1999 | India          | city        |   PLEASE SELECT        | Buddhism | hometown | Ashanti | Yes         | comment | Please fill in the required field(s): Nationality                |
      | Passport.jpg | Miss  | TestFirstName | TestMiddleName | TestLastName | TestOtherName | M      | 12/6/1999 | India          | city        | Afghanistan | Buddhism |          | Ashanti | Yes         | comment | Please fill in the required field(s): Hometown                   |
      #Defect| Passport.jpg | Miss  | TestFirstName | TestMiddleName | TestLastName | TestOtherName | M      | 13/6/1999 | India          | city        | Afghanistan | Buddhism | hometown |         | Yes         | comment | Please fill in the required field(s): Region                     |
      | Passport.jpg | Miss  | TestFirstName | TestMiddleName | TestLastName | TestOtherName | M      | 11/6/1999 | India          | city        | Afghanistan | Buddhism | hometown |         | Yes         |  | Please fill in the required field(s): Special Need Status Reason |

  @Personal4
  Scenario: personal details page navigation to contact information navigation
    Given user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data field in signup page
      | FirstName     | LastName     | MiddleName     | ProgrammeType | Gender | CountryOfResidence | MobileNumber  | EmailAddress | Password | ConfirmPassword | Captcha |
      | TestFirstName | TestLastName | TestMiddleName | Diploma       | F      | Ghana              | +919241521992 | auto         | password | password        | yes     |
    Then user should navigate to personal details page
    When user enter mandatory data in personal details page for following fields
      | Image        | Title | FirstName     | MiddleName     | LastName | OtherName | Gender | DOB       | CountryOfBirth | CityOfBirth | Nationality | Religion | HomeTown | Region  | SpecialNeed | Comment |
      | Passport.jpg | Miss  | TestFirstName | TestMiddleName |          | asd       | F      | 10/6/1999 | Ghana          | city        | Ghana | Buddhism | hometown | Ashanti | Yes         | comment |
    Then User should navigate to contact information page

  @Personal5
  Scenario: personal details page navigation to Home page afet click of Logout button
    Given user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data field in signup page
      | FirstName     | LastName     | MiddleName     | ProgrammeType | Gender | CountryOfResidence | MobileNumber  | EmailAddress | Password | ConfirmPassword | Captcha |
      | TestFirstName | TestLastName | TestMiddleName | Diploma       | F      | Ghana             | +919241521992 | auto         | password | password        | yes     |
    Then user should navigate to personal details page
    When user enter fields data in personal details page for following fields
      | Image        | Title | FirstName     | MiddleName     | LastName      | OtherName | Gender | DOB       | CountryOfBirth | CityOfBirth | Nationality | Religion | HomeTown | Region  | SpecialNeed | Comment |
      | Passport.jpg | Miss  | TestFirstName | TestMiddleName | TestOtherName | asd       | F      | 10/6/1999 | Ghana          | city        | Ghana | Buddhism | hometown | Ashanti | Yes         | comment |
    And user click on logout buttton
    Then user navigates to home page
