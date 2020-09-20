@Contactinformation @Regression
Feature: Contact Infomation page fields validation

  @Contactinformation
  Scenario: contact information page validation of postal address same as  permanent address
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
      | Image        | Title | FirstName  | MiddleName | LastName | OtherName | Gender | DOB       | CountryOfBirth | CityOfBirth | Nationality | Religion | HomeTown | Region  | SpecialNeed | Comment |
      | Passport.jpg | Miss  | Automation | Middle     |          | asd       | M      | 10/6/1999 | India          | city        | Afghanistan | Buddhism | hometown | Ashanti | Yes         | comment |
    When user enter data in contact information page for postal address
      | Address1 | Address2 | City | State | Country     | PostalCode | Phone     |
      | Address1 | Address2 | City | State | Afghanistan |    1313124 | 123456789 |
    And user click check as postal address is same as permanent address
    Then verify that postal address is matching permanent address

  @Contactinformation1
  Scenario: contact information page validation of mandatory fields for postal address
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
      | Image        | Title | FirstName  | MiddleName | LastName | OtherName | Gender | DOB       | CountryOfBirth | CityOfBirth | Nationality | Religion | HomeTown | Region  | SpecialNeed | Comment |
      | Passport.jpg | Miss  | Automation | Middle     |          | asd       | M      | 10/6/1999 | India          | city        | Afghanistan | Buddhism | hometown | Ashanti | Yes         | comment |
    When user enter  mandatory fields data in contact information page for postal address and validate error message
      | Address1 | Address2 | City | State | Country     | PostalCode | Phone     | Message                                                             |
     # |          |          | city |       | Afghanistan |    1313124 | 123456789 | Please fill the required field(s): Postal Address Address 1         |
     # | Address1 |          |      |       | Afghanistan |    1313124 | 123456789 | Please fill the required field(s): Postal Address City/Town         |
     # | Address1 |          | city |       |             |    1313124 | 123456789 | Please fill the required field(s): Postal Address Country           |
      #| Address1 |          | city |       | Afghanistan |            | 123456789 | Please fill the required field(s): Postal Address Postal Code       |
      | Address1 |          | city |       | Afghanistan |    1313124 |           | Please fill the required field(s): Invalid Postal Address Telephone |
