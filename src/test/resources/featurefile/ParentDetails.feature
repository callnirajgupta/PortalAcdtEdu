@ParentDetails
Feature: Particular of parner page fields validation

  @ParentDetails1
  Scenario: parent details page mandatory field validation
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
      | Address1 | Address2 | City | State | Country     | PostalCode | Phone         |
      | Address1 | Address2 | City | State | Afghanistan |    1313124 | +919241521992 |
    And user click check as postal address is same as permanent address
    And user click next button
    Then verify that user navigate to particular of parent page
    When user enter mandatory fields data in parent details page and validate error message
      | Title | SurName  | FirstName | MiddleName | Relationship | Company     | Occupation | Address1 | Address2 | Country | CityTown | State | Mobile       | Telephone  | Email                | PostalCode | Message                                                                    |
      |       | surename | firstname | middle     | Parent       | ABC company | service    | address1 | address2 | Albania | cityTown | state | 235434587687 | 3535348788 | Automation@gmail.com |       4646 | Please fill in the required field(s): Title                                |
      | Miss  |          | firstname | middle     | Parent       | ABC company | service    | address1 | address2 | Albania | cityTown | state | 235434587687 | 3535348788 | Automation@gmail.com |       4646 | Please fill in the required field(s): Surname                              |
      | Miss  | surename |           | middle     | Parent       | ABC company | service    | address1 | address2 | Albania | cityTown | state | 235434587687 | 3535348788 | Automation@gmail.com |       4646 | Please fill in the required field(s): First Name                           |
      | Miss  | surename | firstname | middle     |              | ABC company | service    | address1 | address2 | Albania | cityTown | state | 235434587687 | 3535348788 | Automation@gmail.com |       4646 | Please fill in the required field(s): Relationship to Applicant            |
      | Miss  | surename | firstname | middle     | Parent       | ABC company |            | address1 | address2 | Albania | cityTown | state | 235434587687 | 3535348788 | Automation@gmail.com |       4646 | Please fill in the required field(s): Occupation                           |
      | Miss  | surename | firstname | middle     | Parent       | ABC company | service    |          | address2 | Albania | cityTown | state | 235434587687 | 3535348788 | Automation@gmail.com |       4646 | Please fill in the required field(s): Address 1                            |
      #| Miss  | surename | firstname | middle     | Parent       | ABC company | service    | address1 | address2 |         | cityTown | state | 235434587687 | 3535348788 | Automation@gmail.com |       4646 | Please fill in the required field(s): Country                 |
      | Miss  | surename | firstname | middle     | Parent       | ABC company | service    | address1 | address2 | Albania |          | state | 235434587687 | 3535348788 | Automation@gmail.com |       4646 | Please fill in the required field(s): City/Town                            |
      | Miss  | surename | firstname | middle     | Parent       | ABC company | service    | address1 | address2 | Albania | cityTown | state |              | 3535348788 | Automation@gmail.com |       4646 | Please fill in the required field(s): Mobile Number, Invalid Mobile Number |
      | Miss  | surename | firstname | middle     | Parent       | ABC company | service    | address1 | address2 | Albania | cityTown | state | 235434587687 |            | Automation@gmail.com |       4646 | Please fill in the required field(s): Telephone, Invalid Telephone Number  |
      | Miss  | surename | firstname | middle     | Parent       | ABC company | service    | address1 | address2 | Albania | cityTown | state | 235434587687 | 3535348788 | Automation@gmail.com |            | Please fill in the required field(s): Postal Code                          |

  @ParentDetails2
  Scenario: parent details page mandatory field validation and navigation to next page
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
      | Address1 | Address2 | City | State | Country     | PostalCode | Phone         |
      | Address1 | Address2 | City | State | Afghanistan |    1313124 | +919241521992 |
    And user click check as postal address is same as permanent address
    And user click next button
    Then verify that user navigate to particular of parent page
    When user enter mandatory fields data in parent details page and navigation to
      | Title | SurName  | FirstName | MiddleName | Relationship | Company     | Occupation | Address1 | Address2 | Country | CityTown | State | Mobile       | Telephone  | Email                | PostalCode | Message                                     |
      | Mr.   | surename | firstname | middle     | Parent       | ABC company | service    | address1 | address2 | Albania | cityTown | state | 235434587687 | 3535348788 | Automation@gmail.com |       4646 | Please fill in the required field(s): Title |
