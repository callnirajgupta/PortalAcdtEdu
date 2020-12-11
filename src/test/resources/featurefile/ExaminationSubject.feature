@ExaminationSubject @Regression
Feature: Add Subject for The Examination Page functionality checking

  @ExaminationSubject1
  Scenario: validate That click on follow this link For more information on admission requirements navigate to Instruction page
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
    Then verify that user navigation to Examination Subject page
    When user click on follow this link For more information on admission requirements
    Then verify that user navigate to Instruction page in new tab

  @ExaminationSubject2
  Scenario: validate default subject is displayed
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
    Then verify that user navigation to Examination Subject page
    #Defect
    And verify that default subject is displayed as "English Language" and "Mathematics"

  @ExaminationSubject3
  Scenario: Verify  mandatory fields validation message in Examination Subject taken
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
    Then verify that user navigation to Examination Subject page
    When user enter mandatory fields data in Examination Subject Page and validate error message
      | Grade1 | Grade2 | Subject3    | Grade3 | Subject4 | Grade4 | Subject5 | Grade5 | Subject6 | Grade6 | Message                                                                    |
      |        |      2 | lifeScience |      3 | French   |      4 | Physic   |      5 | Social   |      6 | Please fill in the required field(s): Grade for English Language in WASSCE |
      |      1 |        | lifeScience |      3 | French   |      4 | Physic   |      5 | Social   |      6 | Please fill in the required field(s): Grade for Mathematics in WASSCE      |
      |      1 |      2 |             |      3 | French   |      4 | Physic   |      5 | Social   |      6 | Please fill in the required field(s): Subject in examination WASSCE        |
      |      1 |      2 | lifeScience |        | French   |      4 | Physic   |      5 | Social   |      6 | Please fill in the required field(s): Grade for lifeScience in WASSCE      |
      |      1 |      2 | lifeScience |      3 |          |      4 | Physic   |      5 | Social   |      6 | Please fill in the required field(s): Subject in examination WASSCE        |
      |      1 |      2 | lifeScience |      3 | French   |        | Physic   |      5 | Social   |      6 | Please fill in the required field(s): Grade for French in WASSCE      |
      |      1 |      2 | lifeScience |      3 | French   |      4 |          |      5 | Social   |      6 | Please fill in the required field(s): Subject in examination WASSCE        |
      |      1 |      2 | lifeScience |      3 | French   |      4 | Physic   |        | Social   |      6 | Please fill in the required field(s): Grade for Physic in WASSCE      |
      |      1 |      2 | lifeScience |      3 | French   |      4 | Physic   |      5 |    |      6 | Please fill in the required field(s): Subject in examination WASSCE        |
      |      1 |      2 | lifeScience |      3  | French   |      4 | Physic   |      5 | Social   |       | Please fill in the required field(s): Grade for Social in WASSCE      |

  @ExaminationSubject4
  Scenario: Examination Subject page field data filling and navigation to Financing Your Study page
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
    Then verify that user navigation to Examination Subject page
    When user enter mandatory fields data in Examination Subject Page
      | Grade1 | Grade2 | Subject3    | Grade3 | Subject4 | Grade4 | Subject5 | Grade5 | Subject6 | Grade6 |
      |      1 |      2 | lifeScience |      3 | French   |      4 | Physic   |      5 | Social   |      6 |
    And user click next button
    Then verify that user navigation to Financing Your Study page
    
    @ExaminationSubject5
  Scenario: Examination page filled data persist when user click on previous button in Examination Subject page
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
    Then verify that user navigation to Examination Subject page
    When user enter mandatory fields data in Examination Subject Page
      | Grade1 | Grade2 | Subject3    | Grade3 | Subject4 | Grade4 | Subject5 | Grade5 | Subject6 | Grade6 |
      |      1 |      2 | lifeScience |      3 | French   |      4 | Physic   |      5 | Social   |      6 |
    And user click on previous button in Examination Subject page
    Then verify that user navigation to Examination page
    And validate that Examination page filled data persist 
    
    
