@Contactinformation @Regression
Feature: Contact Infomation page fields validation

  @Contactinformation11
  Scenario: contact information page validation of postal address same as  permanent address
    Given user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data field in signup page
      | FirstName     | LastName     | MiddleName     | ProgrammeType | Gender | CountryOfResidence | MobileNumber  | EmailAddress | Password | ConfirmPassword | Captcha |
      | TestFirstName | TestLastName | TestMiddleName | Diploma       | M      | India              | +919241521992 | auto         | password | password        | yes     |
    Then user should navigate to personal details page
    When user enter mandatory data in personal details page for following fields
      | Image        | Title | FirstName     | MiddleName     | LastName     | OtherName     | Gender | DOB       | CountryOfBirth | CityOfBirth | Nationality | Religion | HomeTown | Region  | SpecialNeed | Comment |
      | Passport.jpg | Miss  | TestFirstName | TestMiddleName | TestLastName | TestOtherName | M      | 10/6/1999 | India          | city        | Afghanistan | Buddhism | hometown | Ashanti | Yes         | comment |
    When user enter data in contact information page for postal address
      | Address1     | Address2    | City     | State    | Country     | PostalCode | Phone         |
      | TestAddress1 | TesAddress2 | TestCity | TesState | Afghanistan |    1313124 | +919241521992 |
    And user click check as postal address is same as permanent address
    Then verify that postal address is matching permanent address

  @Contactinformation1 
  Scenario: contact information page validation of mandatory fields for postal address
    Given user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data field in signup page
      | FirstName     | LastName     | MiddleName     | ProgrammeType | Gender | CountryOfResidence | MobileNumber  | EmailAddress | Password | ConfirmPassword | Captcha |
      | TestFirstName | TestLastName | TestMiddleName | Diploma       | F      | Ghana              | +919241521992 | auto         | password | password        | yes     |
    Then user should navigate to personal details page
    When user enter mandatory data in personal details page for following fields
      | Image        | Title | FirstName     | MiddleName     | LastName     | OtherName     | Gender | DOB       | CountryOfBirth | CityOfBirth | Nationality | Religion | HomeTown | Region  | SpecialNeed | Comment |
      | Passport.jpg | Miss  | TestFirstName | TestMiddleName | TestLastName | TestOtherName | F     | 10/6/1999 | Ghana          | city        | Ghana | Buddhism | hometown | Ashanti | Yes         | comment |
    When user enter  mandatory fields data in contact information page for postal address and validate error message
      | Address1     | Address2     | City     | State     | Country     | PostalCode | Phone         | Message                                                          |
      |              | TestAddress2 | Testcity | TestState | Afghanistan |    1313124 | +919241521992 | Please fill in the required field(s): Postal Address Address 1   |
      | TestAddress1 | TestAddress2 |          | TestState | Afghanistan |    1313124 | +919241521992 | Please fill in the required field(s): Postal Address City/Town   |
      | TestAddress1 | TestAddress2 | Testcity | TestState |             |    1313124 | +919241521992 | Please fill in the required field(s): Postal Address Country     |
      | TestAddress1 | TestAddress2 | Testcity | TestState | Afghanistan |            | +919241521992 | Please fill in the required field(s): Postal Address Postal Code |
      #| TestAddress1 | TestAddress2 | Testcity | TestState | Afghanistan |    1313124 | +91           | Please fill in the required field(s): Invalid Postal Address Telephone |
  
  @Contactinformation2 
  Scenario: contact information page validation of mandatory fields for permanent address
    Given user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data field in signup page
      | FirstName     | LastName     | MiddleName     | ProgrammeType | Gender | CountryOfResidence | MobileNumber  | EmailAddress | Password | ConfirmPassword | Captcha |
      | TestFirstName | TestLastName | TestMiddleName | Diploma       | F      | Ghana              | +919241521992 | auto         | password | password        | yes     |
    Then user should navigate to personal details page
    When user enter mandatory data in personal details page for following fields
      | Image        | Title | FirstName  | MiddleName | LastName | OtherName | Gender | DOB       | CountryOfBirth | CityOfBirth | Nationality | Religion | HomeTown | Region  | SpecialNeed | Comment |
      | Passport.jpg | Miss  | Automation | Middle     |          | asd       | F      | 10/6/1999 | Ghana          | city        | Ghana | Buddhism | hometown | Ashanti | Yes         | comment |
    When user enter  mandatory fields data in contact information page for permanent address and validate error message
      | Address1     | Address2 | City     | State | Country     | PostalCode | Phone         | Message                                                             |
      |              |          | Testcity |       | Afghanistan |    1313124 | +919241521992 | Please fill in the required field(s): Permanent Address Address 1   |
      | TestAddress1 |          |          |       | Afghanistan |    1313124 | +913241521992 | Please fill in the required field(s): Permanent Address City/Town   |
      | TestAddress1 |          | Testcity |       |             |    1313124 | +913241521992 | Please fill in the required field(s): Permanent Address Country    |
      | TestAddress1 |          | Testcity |       | Afghanistan |            | +913241521992 | Please fill in the required field(s): Permanent Address Postal Code |
      | TestAddress1 |          | Testcity |       | Afghanistan |    1313124 |  +91             | Please fill in the required field(s): Invalid Permanent Address Telephone |

  @Contactinformation3 
  Scenario: contact information page mandatory field validation and navigation to particular of parent
    Given user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data field in signup page
      | FirstName     | LastName     | MiddleName     | ProgrammeType | Gender | CountryOfResidence | MobileNumber  | EmailAddress | Password | ConfirmPassword | Captcha |
      | TestFirstName | TestLastName | TestMiddleName | Diploma       | F      | Ghana              | +919241521992 | auto         | password | password        | yes     |
    Then user should navigate to personal details page
    When user enter mandatory data in personal details page for following fields
      | Image        | Title | FirstName     | MiddleName     | LastName     | OtherName     | Gender | DOB       | CountryOfBirth | CityOfBirth | Nationality | Religion | HomeTown | Region  | SpecialNeed | Comment     |
      | Passport.jpg | Miss  | TestFirstName | TestMiddleName | TestLastName | TestOtherName | F      | 10/6/1999 | Ghana          | city        | Ghana | Buddhism | hometown | Ashanti | Yes         | Testcomment |
    When user enter data in contact information page for postal address
      | Address1     | Address2     | City     | State     | Country     | PostalCode | Phone         |
      | TestAddress1 | TestAddress2 | TestCity | TestState | Afghanistan |    1313124 | +919241521992 |
    And user click check as postal address is same as permanent address
    And user click next button
    Then verify that user navigate to particular of parent page

  @Contactinformation4 
  Scenario: Validate personal details filled data persist when user click on previous button in contact information page
    Given user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data field in signup page
      | FirstName     | LastName     | MiddleName     | ProgrammeType | Gender | CountryOfResidence | MobileNumber  | EmailAddress | Password | ConfirmPassword | Captcha |
      | TestFirstName | TestLastName | TestMiddleName | Diploma       | M      | India              | +919241521992 | auto         | password | password        | yes     |
    Then user should navigate to personal details page
    When user enter mandatory data in personal details page for following fields
      | Image        | Title | FirstName     | MiddleName     | LastName     | OtherName     | Gender | DOB       | CountryOfBirth | CityOfBirth | Nationality | Religion | HomeTown | Region  | SpecialNeed | Comment     |
      | Passport.jpg | Miss  | TestFirstName | TestMiddleName | TestLastName | TestOtherName | M      | 10/6/1999 | India          | city        | Afghanistan | Buddhism | hometown | Ashanti | Yes         | Testcomment |
    When user enter data in contact information page for postal address
      | Address1     | Address2     | City     | State     | Country     | PostalCode | Phone         |
      | TestAddress1 | TestAddress2 | TestCity | TestState | Afghanistan |    1313124 | +919241521992 |
    And user click check as postal address is same as permanent address
    And user click on previous button in Contact Information page
    Then user should navigate to personal details page
    And validate that personal details filled data persist
