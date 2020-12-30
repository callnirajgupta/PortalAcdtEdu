@ParentDetails @Regression
Feature: Particular of parner page fields validation

  @ParentDetails1
  Scenario: parent details page mandatory field validation
    Given user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data field in signup page
      | FirstName     | LastName     | MiddleName     | ProgrammeType | Gender | CountryOfResidence | MobileNumber  | EmailAddress | Password | ConfirmPassword | Captcha |
      | TestFirstName | TestLastName | TestMiddleName | Diploma       | M      | India              | +919241521992 | auto         | password | password        | yes     |
    Then user should navigate to personal details page
    When user enter mandatory data in personal details page for following fields
      | Image        | Title | FirstName     | MiddleName     | LastName    | OtherName     | Gender | DOB       | CountryOfBirth | CityOfBirth | Nationality | Religion | HomeTown | Region  | SpecialNeed | Comment     |
      | Passport.jpg | Miss  | TestFirstName | TestMiddleName | TestSurname | TestOtherName | M      | 10/6/1999 | India          | city        | Afghanistan | Buddhism | hometown | Ashanti | Yes         | Testcomment |
    When user enter data in contact information page for postal address
      | Address1         | Address2     | City     | State     | Country     | PostalCode | Phone         |
      | TestTestaddress1 | TestAddress2 | TestCity | TestState | Afghanistan |    1313124 | +919241521992 |
    And user click check as postal address is same as permanent address
    And user click next button
    Then verify that user navigate to particular of parent page
    When user enter mandatory fields data in parent details page and validate error message
      | Title | SurName      | FirstName     | MiddleName | Relationship | Company      | Occupation  | Address1     | Address2     | Country | CityTown | State | Mobile       | Telephone  | Email                | PostalCode | Message                                                                    |
      |       | Testsurename | Testfirstname | Testmiddle | Parent       | Testcompany  | Testservice | Testaddress1 | address2     | Albania | cityTown | state | 235434587687 | 3535348788 | Automation@gmail.com |       4646 | Please fill in the required field(s): Title                                |
      | Miss  |              | Testfirstname | Testmiddle | Parent       | Test company | Testservice | Testaddress1 | address2     | Albania | cityTown | state | 235434587687 | 3535348788 | Automation@gmail.com |       4646 | Please fill in the required field(s): Surname                              |
      | Miss  | Testsurename |               | Testmiddle | Parent       | Test company | Testservice | Testaddress1 | address2     | Albania | cityTown | state | 235434587687 | 3535348788 | Automation@gmail.com |       4646 | Please fill in the required field(s): First Name                           |
      | Miss  | Testsurename | Testfirstname | Testmiddle |              | Test company | Testservice | Testaddress1 | address2     | Albania | cityTown | state | 235434587687 | 3535348788 | Automation@gmail.com |       4646 | Please fill in the required field(s): Relationship to Applicant            |
      | Miss  | Testsurename | Testfirstname | Testmiddle | Parent       | Test company |             | Testaddress1 | address2     | Albania | cityTown | state | 235434587687 | 3535348788 | Automation@gmail.com |       4646 | Please fill in the required field(s): Occupation                           |
      | Miss  | Testsurename | Testfirstname | Testmiddle | Parent       | Test company | Testservice |              | Testaddress2 | Albania | cityTown | state | 235434587687 | 3535348788 | Automation@gmail.com |       4646 | Please fill in the required field(s): Address 1                            |
      | Miss  | Testsurename | Testfirstname | Testmiddle | Parent       | Test company | Testservice | Testaddress1 | address2     |         | cityTown | state | 235434587687 | 3535348788 | Automation@gmail.com |       4646 | Please fill in the required field(s): Country                              |
      | Miss  | Testsurename | Testfirstname | Testmiddle | Parent       | Test company | Testservice | Testaddress1 | address2     | Albania |          | state | 235434587687 | 3535348788 | Automation@gmail.com |       4646 | Please fill in the required field(s): City/Town                            |
      | Miss  | Testsurename | Testfirstname | Testmiddle | Parent       | Test company | Testservice | Testaddress1 | address2     | Albania | cityTown | state |              | 3535348788 | Automation@gmail.com |       4646 | Please fill in the required field(s): Mobile Number, Invalid Mobile Number |
      | Miss  | Testsurename | Testfirstname | Testmiddle | Parent       | Test company | Testservice | Testaddress1 | address2     | Albania | cityTown | state |            1 | 3535348788 | Automation@gmail.com |       4646 | Please fill in the required field(s): Invalid Mobile Number                |
      | Miss  | Testsurename | Testfirstname | middle     | Parent       | Test company | service     | Testaddress1 | address2     | Albania | cityTown | state | 235434587687 |            | Automation@gmail.com |       4646 | Please fill in the required field(s): Telephone, Invalid Telephone Number  |
      | Miss  | Testsurename | Testfirstname | middle     | Parent       | Test company | service     | Testaddress1 | address2     | Albania | cityTown | state | 235434587687 |          1 | Automation@gmail.com |       4646 | Please fill in the required field(s): Invalid Telephone Number             |
      | Miss  | Testsurename | firstname     | middle     | Parent       | Test company | service     | Testaddress1 | address2     | Albania | cityTown | state | 235434587687 | 3535348788 | Automation@gmail.com |            | Please fill in the required field(s): Postal Code                          |

  @ParentDetails2
  Scenario: parent details page mandatory field validation and navigation to next page
    Given user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data field in signup page
      | FirstName     | LastName     | MiddleName     | ProgrammeType | Gender | CountryOfResidence | MobileNumber  | EmailAddress | Password | ConfirmPassword | Captcha |
      | TestFirstName | TestLastName | TestMiddleName | Diploma       | M      | India              | +919241521992 | auto         | password | password        | yes     |
    Then user should navigate to personal details page
    When user enter mandatory data in personal details page for following fields
      | Image        | Title | FirstName     | MiddleName     | LastName    | OtherName     | Gender | DOB       | CountryOfBirth | CityOfBirth | Nationality | Religion | HomeTown | Region  | SpecialNeed | Comment |
      | Passport.jpg | Miss  | TestFirstName | TestMiddleName | testSurName | TestOtherName | M      | 10/6/1999 | India          | city        | Afghanistan | Buddhism | hometown | Ashanti | Yes         | comment |
    When user enter data in contact information page for postal address
      | Address1     | Address2     | City | State | Country     | PostalCode | Phone         |
      | Testaddress1 | TestAddress2 | City | State | Afghanistan |    1313124 | +919241521992 |
    And user click check as postal address is same as permanent address
    And user click next button
    Then verify that user navigate to particular of parent page
    When user enter mandatory fields data in parent details page
      | Title | SurName      | FirstName     | MiddleName     | Relationship | Company      | Occupation | Address1     | Address2 | Country | CityTown | State | Mobile       | Telephone  | Email                    | PostalCode | Message                                     |
      | Mr.   | Testsurename | Testfirstname | TestMiddleName | Parent       | Test company | service    | Testaddress1 | address2 | Albania | cityTown | state | 235434587687 | 3535348788 | TestAutomation@gmail.com |     464656 | Please fill in the required field(s): Title |
    And user click next button
    Then verify that user navigation to programme selection page

  @ParentDetails3
  Scenario: parent details page validate Email and Mobile and Telephone format validation
    Given user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data field in signup page
      | FirstName     | LastName     | MiddleName     | ProgrammeType | Gender | CountryOfResidence | MobileNumber  | EmailAddress | Password | ConfirmPassword | Captcha |
      | TestFirstName | TestLastName | TestMiddleName | Diploma       | M      | India              | +919241521992 | auto         | password | password        | yes     |
    Then user should navigate to personal details page
    When user enter mandatory data in personal details page for following fields
      | Image        | Title | FirstName  | MiddleName | LastName | OtherName | Gender | DOB       | CountryOfBirth | CityOfBirth | Nationality | Religion | HomeTown | Region  | SpecialNeed | Comment |
      | Passport.jpg | Miss  | Automation | Middle     |          | asd       | M      | 10/6/1999 | India          | city        | Afghanistan | Buddhism | hometown | Ashanti | Yes         | comment |
    When user enter data in contact information page for postal address
      | Address1     | Address2     | City | State | Country     | PostalCode | Phone         |
      | Testaddress1 | TestAddress2 | City | State | Afghanistan |    1313124 | +919241521992 |
    And user click check as postal address is same as permanent address
    And user click next button
    Then verify that user navigate to particular of parent page
    When user enter invalid fields data in parent details page and validate error message
      | Title | SurName  | FirstName     | MiddleName | Relationship | Company      | Occupation | Address1     | Address2     | Country | CityTown | State | Mobile       | Telephone  | Email               | PostalCode | Message                   |
      | Miss  | surename | Testfirstname | Testmiddle | Parent       | Test company | service    | TestAddress1 | address2     | Albania | cityTown | state | 235434587687 | 3535348788 | Automation          |       4646 | Email format is not valid |
      | Miss  |          | Testfirstname | Testmiddle | Parent       | Test company | service    | Testaddress1 | Testaddress2 | Albania | cityTown | state | 235434587687 | 3535348788 | Automation@gmail    |       4646 | Email format is not valid |
      | Miss  |          | Testfirstname | Testmiddle | Parent       | Test company | service    | Testaddress1 | Testaddress2 | Albania | cityTown | state | 235434587687 | 3535348788 | Automationgmail.com |       4646 | Email format is not valid |

  @ParentDetails4
  Scenario: Validate contact information filled data persist when user click on previous button in parent details page
    Given user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data field in signup page
      | FirstName     | LastName     | MiddleName     | ProgrammeType | Gender | CountryOfResidence | MobileNumber  | EmailAddress | Password | ConfirmPassword | Captcha |
      | TestFirstName | TestLastName | TestMiddleName | Diploma       | M      | India              | +919241521992 | auto         | password | password        | yes     |
    Then user should navigate to personal details page
    When user enter mandatory data in personal details page for following fields
      | Image        | Title | FirstName     | MiddleName     | LastName    | OtherName     | Gender | DOB       | CountryOfBirth | CityOfBirth | Nationality | Religion | HomeTown | Region  | SpecialNeed | Comment |
      | Passport.jpg | Miss  | TestFirstName | TestMiddleName | testSurName | TestOtherName | M      | 10/6/1999 | India          | city        | Afghanistan | Buddhism | hometown | Ashanti | Yes         | comment |
    When user enter data in contact information page for postal address
      | Address1     | Address2     | City | State | Country     | PostalCode | Phone         |
      | Testaddress1 | TestAddress2 | City | State | Afghanistan |    1313124 | +919241521992 |
    And user click check as postal address is same as permanent address
    And user click next button
    Then verify that user navigate to particular of parent page
    When user enter mandatory fields data in parent details page
      | Title | SurName      | FirstName     | MiddleName     | Relationship | Company      | Occupation | Address1     | Address2 | Country | CityTown | State | Mobile       | Telephone  | Email                    | PostalCode | Message                                     |
      | Mr.   | Testsurename | Testfirstname | TestMiddleName | Parent       | Test company | service    | Testaddress1 | address2 | Albania | cityTown | state | 235434587687 | 3535348788 | TestAutomation@gmail.com |     464656 | Please fill in the required field(s): Title |
    And user click on previous button in parent details page
    Then User should navigate to contact information page
    And validate that contact information filled data persist
