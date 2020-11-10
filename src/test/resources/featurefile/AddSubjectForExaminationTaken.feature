@AddSubjectExamination @Regression
Feature: Title of your feature
  I want to use this template for my feature file

  @AddSubjectExamination1
  Scenario: Add Subject and delete
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
    When user add new subject
    And user delete the newly added subject
    Then verify that default subject is not deleted

  @AddSubjectExamination2
  Scenario: Verify  mandatory fields validation message in Add Subject For Examination taken
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
    When user enter mandatory fields data in Add Subject for Examination Taken Page and validate error message
      | Subject1 | Grade1 | Subject2 | Grade2 | Message                                                                    |
      |          |        |          | A1     | Please fill in the required field(s): Grade for English Language in WASSCE |
      |          | A1     |          |        | Please fill in the required field(s): Grade for Mathematics in WASSCE      |
      | Physic   |        | Biology  | A1     | Please fill in the required field(s): Grade for Physic in WASSCE           |
      | Physic   | A1     | Biology  |        | Please fill in the required field(s): Grade for Biology in WASSCE          |
    
    
    
    
    @AddSubjectExamination3
  Scenario: Verify validation message new Subject in Add Subject For Examination taken
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
    And user validate error message for New Subject
      | Grade1 | Grade2 | Subject3    | Grade3 | Message                                                               |
      | A1     | A1     |             | A1     | Subject can't be left empty                                           |
      | A1     | A1     | New Subject |        | Please fill in the required field(s): Grade for New Subject in WASSCE |
   

  @AddSubjectExamination4
  Scenario: Add Subject for Examination taken page field data filling and navigation to Financing Your Study page
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
      |  English        |   A1     | Math         | A1     |
    And user click next button
    Then verify that user navigation to Financing Your Study page