@Reference @Regression
Feature: Add Subject for The Examination Page functionality checking

  @Reference1
  Scenario: Verify mandatory field and validation of error message
    Given user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data field in signup page
      | FirstName     | LastName     | MiddleName     | ProgrammeType | Gender | CountryOfResidence | MobileNumber  | EmailAddress | Password | ConfirmPassword | Captcha |
      | TestFirstName | TestLastName | TestMiddleName | Diploma       | M      | India              | +919241521992 | auto         | password | password        | yes     |
    Then User should navigate to personal details page
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
      | Mr.   | Testsurename | Testfirstname | TestMiddleName | Parent       | Test company | service    | Testaddress1 | address2 | Albania | cityTown | state | 235434587687 | 3535348788 | testAutomation@gmail.com |     464656 | Please fill in the required field(s): Title |
    And user click next button
    Then verify that user navigation to programme selection page
    When user enter mandatory fields data in programme selection page
      | ProgrammeType | ProgrammeTitle              |
      | Diploma       | Jewellery Design Technology |
    And user click next button
    Then verify that user navigation to Educational Background page
    When user enter fields data in Educational Background page
      | RecentInstitution   | City     | Country     | YearOfEntry | YearOfCompletion | Qualification | OtherQualification     |
      | TestRecentInstinute | TestCity | Afghanistan | 10/6/1999   | 10/6/1999        | WASSCE        | TestOtherQualification |
    And user click next button
    Then verify that user navigation to Examination page
    When user enter mandatory fields data in examination page
      | ExaminationType | IndexNumber | DateOfExamination | UploadResultSlip |
      | WASSCE          |           8 | 10/6/1999         | Passport.jpg     |
    Then verify that user navigation to Add Subject for Examination taken page
    When user enter mandatory fields data in Add Subject for Examination Taken Page
      | Subject1 | Grade1 | Subject2 | Grade2 |
      | English  | A1     | Math     | A1     |
    And user click next button
    Then verify that user navigation to Financing Your Study page
    When user enter mandatory fields data in Financing Your Study page
      | IntendToFinance | Other        |
      | Other           | Father Money |
    And user click next button
    Then verify that user navigation to Referee page
    When user enter mandatory fields data in Referee page and validate error message
      | Title | Position     | FullName     | Email                   | Occupation  | Date      | Message                                                   |
      |       | TestPosition | TestFullName | TestAutomation@acdt.edu | Testservice | 10/6/2015 | Please fill in the required field(s): Title               |
      | Miss  |              | TestFullName | TestAutomation@acdt.edu | Testservice | 10/6/2015 | Please fill in the required field(s): Position            |
      | Miss  | TestPosition |              | TestAutomation@acdt.edu | Testservice | 10/6/2015 | Please fill in the required field(s): Name                |
      | Miss  | TestPosition | TestFullName |                         | Testservice | 10/6/2015 | Please fill in the required field(s): Email Address       |
      | Miss  | TestPosition | TestFullName | TestAutomation@acdt.edu |             | 10/6/2015 | Please fill in the required field(s): Occupation          |
      | Miss  | TestPosition | TestFullName | TestAutomation@acdt.edu | Testservice |           | Please fill in the required field(s): , Date is in future |

  @Reference2
  Scenario: Verify that user navigate to Application Summary page after filling all mandatory fields.
    Given user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data field in signup page
      | FirstName     | LastName     | MiddleName     | ProgrammeType | Gender | CountryOfResidence | MobileNumber  | EmailAddress | Password | ConfirmPassword | Captcha |
      | TestFirstName | TestLastName | TestMiddleName | Diploma       | M      | India              | +919241521992 | auto         | password | password        | yes     |
    Then User should navigate to personal details page
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
      | Mr.   | Testsurename | Testfirstname | TestMiddleName | Parent       | Test company | service    | Testaddress1 | address2 | Albania | cityTown | state | 235434587687 | 3535348788 | testAutomation@gmail.com |     464656 | Please fill in the required field(s): Title |
    And user click next button
    Then verify that user navigation to programme selection page
    When user enter mandatory fields data in programme selection page
      | ProgrammeType | ProgrammeTitle              |
      | Diploma       | Jewellery Design Technology |
    And user click next button
    Then verify that user navigation to Educational Background page
    When user enter fields data in Educational Background page
      | RecentInstitution   | City     | Country     | YearOfEntry | YearOfCompletion | Qualification | OtherQualification     |
      | TestRecentInstinute | TestCity | Afghanistan | 10/6/1999   | 10/6/1999        | WASSCE        | TestOtherQualification |
    And user click next button
    Then verify that user navigation to Examination page
    When user enter mandatory fields data in examination page
      | ExaminationType | IndexNumber | DateOfExamination | UploadResultSlip |
      | WASSCE          |           8 | 10/6/1999         | Passport.jpg     |
    Then verify that user navigation to Add Subject for Examination taken page
    When user enter mandatory fields data in Add Subject for Examination Taken Page
      | Subject1 | Grade1 | Subject2 | Grade2 |
      | English  | A1     | Math     | A1     |
    And user click next button
    Then verify that user navigation to Financing Your Study page
    When user enter mandatory fields data in Financing Your Study page
      | IntendToFinance | Other        |
      | Other           | Father Money |
    And user click next button
    Then verify that user navigation to Referee page
    When user enter mandatory fields data in Referee page
      | Title | Position     | FullName     | Email                   | Occupation  | Date      |
      | Miss  | TestPosition | TestFullName | TestAutomation@acdt.edu | Testservice | 10/6/2015 |
    And user click Preview button
    Then verify that user navigation to Application Summary page
