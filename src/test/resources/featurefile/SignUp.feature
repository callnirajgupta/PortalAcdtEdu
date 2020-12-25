@Signup @Regression
Feature: Signup page functionality

  @Signup1
  Scenario Outline: verify mandatory field validation of signup page
    Given user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data for field "<First Name>" and "<Middle Name>" and "<Last Name>" and "<Programme Type>" and "<Gender>" and "<Nationality>" and "<Mobile Number>" and "<Email address>" and "<Password>" and "<Confirm Password>" and "<Captcha>"
    And user click start application button
    Then verify application display error message "<Message>"

    Examples: 
      | First Name    | Middle Name    | Last Name    | Programme Type | Gender | Nationality | Mobile Number | Email address | Password | Confirm Password | Captcha | Message                                                                    |
      |               | TestMiddleName | TestLastName | Diploma        | M      | India                | +919241521992 | auto          | password | password         | yes     | Please fill in the required field(s): First Name                           |
      | TestFirstName | TestMiddleName |              | Diploma        | M      | India                | +919241521992 | auto          | password | password         | yes     | Please fill in the required field(s): Last Name                            |
      | TestFirstName | TestMiddleName | TestLastName |                | M      | India                | +919241521992 | auto          | password | password         | yes     | Please fill in the required field(s): Programme type                       |
      | TestFirstName | TestMiddleName | TestLastName | Diploma        |        | India                | +919241521992 | auto          | password | password         | yes     | Please fill in the required field(s): Gender                               |
      | TestFirstName | TestMiddleName | TestLastName | Diploma        | M      |                      | +919241521992 | auto          | password | password         | yes     | Please fill in the required field(s): Nationality                 |
      | TestFirstName | TestMiddleName | TestLastName | Diploma        | M      | India                |               | auto          | password | password         | yes     | Please fill in the required field(s): Mobile number, Invalid Mobile Number |
      | TestFirstName | TestMiddleName | TestLastName | Diploma        | M      | India                | +919241521992 |               | password | password         | yes     | Please fill in the required field(s): Email address                        |
      #| TestFirstName | TestMiddleName | TestLastName    | Diploma        | M      | India                | +919241521992    | callnirajgupta@gmail.com | password | password         | yes     | Please fill in the required field(s): Email address already exist  |
      | TestFirstName | TestMiddleName | TestLastName | Diploma        | M      | India                | +919241521992 | auto          |          | password         | yes     | Please fill in the required field(s): Password, Reconfirm your password    |
      | TestFirstName | TestMiddleName | TestLastName | Diploma        | M      | India                | +919241521992 | auto          | password |                  | yes     | Please fill in the required field(s): Reconfirm your password              |
      | TestFirstName | TestMiddleName | TestLastName | Diploma        | M      | India                | +919241521992 | auto          |          |                  | yes     | Please fill in the required field(s): Password                             |
      | TestFirstName | TestMiddleName | TestLastName | Diploma        | M      | India                | +919241521992 | auto          | password | password         |         | Please confirm you are not a robot.                                        |

  #@Signup2 
  #Scenario: Validate selection of country
   # Given user navigates to home page
    #When user click on start application button in home page
    #Then user select the all country one by one successfully

  @Signup3
  Scenario Outline: verify user is able to move to personal details page after filling mandatory fields
    Given user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data for field "<First Name>" and "<Middle Name>" and "<Last Name>" and "<Programme Type>" and "<Gender>" and "<Nationality>" and "<Mobile Number>" and "<Email address>" and "<Password>" and "<Confirm Password>" and "<Captcha>"
    And user click start application button
    Then user should navigate to personal details page

    Examples: 
      | First Name    | Middle Name    | Last Name    | Programme Type | Gender | Nationality | Mobile Number | Email address | Password | Confirm Password | Captcha |
      | testFirstName | testMiddleName | TestLastName | Diploma        | M      | India                | +919241521992 | auto          | password | password         | yes     |
      | testFirstName | testMiddleName | TestLastName | Diploma        | F      | India                | +919241521992 | auto          | password | password         | yes     |
      | testFirstName | testMiddleName | TestLastName | Degree         | M      | India                | +919241521992 | auto          | password | password         | yes     |
      | testFirstName | testMiddleName | TestLastName | Degree         | F      | India                | +919241521992 | auto          | password | password         | yes     |
      | testFirstName | testMiddleName | TestLastName | Certificate    | M      | India                | +919241521992 | auto          | password | password         | yes     |
      | testFirstName | testMiddleName | TestLastName | Certificate    | F      | India                | +919241521992 | auto          | password | password         | yes     |

  @Signup4
  Scenario Outline: Verify the validation error message for email address.
    Given user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data for field "<First Name>" and "<Middle Name>" and "<Last Name>" and "<Programme Type>" and "<Gender>" and "<Nationality>" and "<Mobile Number>" and "<Email address>" and "<Password>" and "<Confirm Password>" and "<Captcha>"
    Then verify application display error message "<Message>"

    Examples: 
      | First Name    | Middle Name    | Last Name    | Programme Type | Gender | Nationality | Mobile Number | Email address        | Password | Confirm Password | Captcha | Message                   |
      | TestFirstName | TestMiddleName | TestLastName | Diploma        | M      | India                | +919241521992 | callnirajgupta       | password | password         | yes     | Email format is not valid |
      | TestFirstName | TestMiddleName | TestLastName | Diploma        | M      | India                | +919241521992 | callnirajgupta@gmail | password | password         | yes     | Email format is not valid |
      | TestFirstName | TestMiddleName | TestLastName | Diploma        | M      | India                | +919241521992 | callnirajgupta.com   | password | password         | yes     | Email format is not valid |
