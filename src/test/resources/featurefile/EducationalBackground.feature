@EducationalBackground
Feature: Verify the Educational Background page functionality

  @EducationalBackground1
  Scenario: Educational Background page mandatory field validation
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
    When user enter mandatory fields data in Educational Background page and validate error message
      | RecentInstitution     | City     | Country     | YearOfEntry | YearOfCompletion | Qualification | OtherQualification     | Message                                                                       |
      |                       | TestCity | Afghanistan | 10/6/1999   | 10/6/1999        | WASSCE        | TestOtherQualification | Please fill the required field(s): Current or most recent SHS/Institution     |
      | TestRecentInstitution |          | Afghanistan | 10/6/1999   | 10/6/1999        | WASSCE        | TestOtherQualification | Please fill the required field(s): Educational Background City/Town           |
      | TestRecentInstitution | TestCity |             | 10/6/1999   | 10/6/1999        | WASSCE        | TestOtherQualification | Please fill the required field(s): Educational Background Country             |
      | TestRecentInstitution | TestCity | Afghanistan |             | 10/6/1999        | WASSCE        | TestOtherQualification | Please fill the required field(s): Educational Background Year of Entry       |
      | TestRecentInstitution | TestCity | Afghanistan | 10/6/1999   |                  | WASSCE        | TestOtherQualification | Please fill the required field(s): Educational Background Year of Completion  |
      | TestRecentInstitution | TestCity | Afghanistan | 10/6/1999   | 10/6/1999        |               | TestOtherQualification | Please fill the required field(s): Educational Background Other Qualification |

  @EducationalBackground2
  Scenario: Verify that appliction display Other Educational background when user click Add Other Educational Background
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
    When user click Add Other Educational Background button
    Then verify that Other Educational Background section should display
    When user click on delete section button
    And user click on "no" on confirmation popup
    Then verify that Other Educational Background section should display
    When user click on delete section button
    And user click on "yes" on confirmation popup
    Then verify that Other Educational Background section should not display
    When user click on "yes" radio button for Have you ever enrolled in a university
    Then verify that Previous Attendance at a University section should display
    When user click on "No" radio button for Have you ever enrolled in a university
    Then verify that Previous Attendance at a University section should not display

  @EducationalBackground3
  Scenario: Educational Background page mandatory field validation for other Educational background
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
    When user enter mandatory fields data for Other Education Background in Educational Background page and validate error message
      | OtherInstitution | City     | Country     | YearOfEntry | YearOfCompletion | Qualification | OtherQualification     | Message                                                                   |
      |                  | TestCity | Afghanistan | 10/6/1999   | 10/6/1999        | WASSCE        | TestOtherQualification | Please fill the required field(s): Name of other SHS/Institution attended |

  #| TestotherInstitution |          | Afghanistan | 10/6/1999   | 10/6/1999         | WASSCE        | TestOtherQualification|Please fill the required field(s): Other Educational Background City/Town|
  #| TestotherInstitution | TestCity |             | 10/6/1999   | 10/6/1999         | WASSCE        | TestOtherQualification|Please fill the required field(s): Other Educational Background Country|
  #| TestotherInstitution | TestCity | Afghanistan |             | 10/6/1999         | WASSCE        | TestOtherQualification|Please fill the required field(s): Other Educational Background Year of Entry|
  #| TestotherInstitution | TestCity | Afghanistan | 10/6/1999   |                   | WASSCE        | TestOtherQualification|Please fill the required field(s): Other Educational Background Year of Completion|
  #| TestotherInstitution | TestCity | Afghanistan | 10/6/1999   | 10/6/1999         |               | TestOtherQualification|Please fill the required field(s): Other Educational Background Country|
  
  
  @EducationalBackground4
  Scenario: Educational Background page mandatory field validation for previous Educational background
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
    When user enter mandatory fields data for Previous Education Background in Educational Background page and validate error message
      | PreviousInstitute    | NameUsed     | DateOfAddmission | Hostel     | ProgrammeOfStudy     | LastYearStudy | ReasonOfLeaving     | Message                                                                            |
      | TestPreviousInstitut | TestNameUsed | 10/6/1999        | TestHostel | TestProgrammeOfStudy | 10/6/1999     | TestReasonOfLeaving | Please fill the required field(s): Name of other SHS/Institution attended          |
      #| TestPreviousInstitut | TestNameUsed             | 10/6/1999        | TestHostel | TestProgrammeOfStudy | 10/6/1999     | TestReasonOfLeaving | Please fill the required field(s): Other Educational Background City/Town          |
      #| TestPreviousInstitut | TestNameUsed    | 10/6/1999        | TestHostel | TestProgrammeOfStudy | 10/6/1999     | TestReasonOfLeaving | Please fill the required field(s): Other Educational Background Country            |
      #| TestPreviousInstitut | TestNameUsed    | 10/6/1999        | TestHostel | TestProgrammeOfStudy | 10/6/1999     | TestReasonOfLeaving | Please fill the required field(s): Other Educational Background Year of Entry      |
      #| TestPreviousInstitut | TestNameUsed     | 10/6/1999        | TestHostel | TestProgrammeOfStudy | 10/6/1999     | TestReasonOfLeaving | Please fill the required field(s): Other Educational Background Year of Completion |
      #| TestPreviousInstitut | TestNameUsed     | 10/6/1999        | TestHostel | TestProgrammeOfStudy | 10/6/1999     | TestReasonOfLeaving | Please fill the required field(s): Other Educational Background Country            |


@EducationalBackground5
  Scenario: Educational Background filling data and navigating to Examination page 
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
      | RecentInstitution     | City     | Country     | YearOfEntry | YearOfCompletion | Qualification | OtherQualification     | 
      |   TestRecentInstinute | TestCity | Afghanistan | 10/6/1999   | 10/6/1999        | WASSCE        | TestOtherQualification | 
   And user click next button
   Then verify that user navigation to Examination page

   @EducationalBackground6
  Scenario: Educational Background page field filling with other educational background and Navigate to Examination page
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
      | RecentInstitution     | City     | Country     | YearOfEntry | YearOfCompletion | Qualification | OtherQualification     | 
      |   TestRecentInstinute | TestCity | Afghanistan | 10/6/1999   | 10/6/1999        | WASSCE        | TestOtherQualification |
    When user click Add Other Educational Background button
    Then verify that Other Educational Background section should display
    And user enter fields data for other Educational background  
      | OtherInstitution | City     | Country     | YearOfEntry | YearOfCompletion | Qualification | OtherQualification     | 
      | TestOtherInstitution| TestCity | Afghanistan | 10/6/1999   | 10/6/1999        | WASSCE        | TestOtherQualification | 
    And user click next button
    Then verify that user navigation to Examination page
    
    
    @EducationalBackground7
  Scenario: Educational Background page field filling with previous educational background and Navigate to Examination page
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
      | RecentInstitution     | City     | Country     | YearOfEntry | YearOfCompletion | Qualification | OtherQualification     | 
      |   TestRecentInstinute | TestCity | Afghanistan | 10/6/1999   | 10/6/1999        | WASSCE        | TestOtherQualification |
    When user click on "yes" radio button for Have you ever enrolled in a university
    Then verify that Previous Attendance at a University section should display
    When user enter fields data for previous Educational background
      | PreviousInstitute    | NameUsed     | DateOfAddmission | Hostel     | ProgrammeOfStudy     | LastYearStudy | ReasonOfLeaving     | Message                                                                            |
      | TestPreviousInstitut | TestNameUsed | 10/6/1999        | TestHostel | TestProgrammeOfStudy | 10/6/1999     | TestReasonOfLeaving | Please fill the required field(s): Name of other SHS/Institution attended          |  
     And user click next button
    Then verify that user navigation to Examination page 
    
     @EducationalBackground8
  Scenario: Educational Background page field filling with  other and previous educational background and Navigate to Examination page
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
      | RecentInstitution     | City     | Country     | YearOfEntry | YearOfCompletion | Qualification | OtherQualification     | 
      |   TestRecentInstinute | TestCity | Afghanistan | 10/6/1999   | 10/6/1999        | WASSCE        | TestOtherQualification |
    When user click Add Other Educational Background button
    Then verify that Other Educational Background section should display
    And user enter fields data for other Educational background  
      | OtherInstitution | City     | Country     | YearOfEntry | YearOfCompletion | Qualification | OtherQualification     | 
      | TestOtherInstitution| TestCity | Afghanistan | 10/6/1999   | 10/6/1999        | WASSCE        | TestOtherQualification |
    When user click on "yes" radio button for Have you ever enrolled in a university
    Then verify that Previous Attendance at a University section should display
    When user enter fields data for previous Educational background
      | PreviousInstitute    | NameUsed     | DateOfAddmission | Hostel     | ProgrammeOfStudy     | LastYearStudy | ReasonOfLeaving     | Message                                                                            |
      | TestPreviousInstitut | TestNameUsed | 10/6/1999        | TestHostel | TestProgrammeOfStudy | 10/6/1999     | TestReasonOfLeaving | Please fill the required field(s): Name of other SHS/Institution attended          |  
     And user click next button
    Then verify that user navigation to Examination page 