@login @Regression
Feature: Mandatory field validation of login page

  @login1
  Scenario Outline: Field validation of email address  and password and captcha in login page
    Given user navigates to home page
    When user click on login menu
    Then verify user navigate to login page
    When user enter email "<Email>" and password "<Password>" and captcha "<Captcha>" and click login button
    Then verify login display error message "<Message>"

    Examples: 
      | Email   | Password |Captcha  | Message                                    |
      | email   | password |unchecked| Please confirm you are not a robot.        |
      |         | password |checked  | *E-mail address is required.               |
      | email   |          |checked  | *Password is required.                     |
      | invalid | invalid  |checked  | *Invalid E-mail and password provided.     |
      |         |          |checked | *E-mail address and Password are required. |
