Feature: Login

  Background:
    Given User is in Login page

  Scenario: Successful Registration
    Given  User clicks on New User
    When User enters valid First Name and Last Name and new UserName and valid Password
    And User select CAPTCHA correctly
    And User clicks on Register
    Then Message displayed User Register Successfully

  Scenario: Unsuccessful Registration with invalid Password
    Given  User clicks on New User
    When User enters valid First Name and Last Name and new UserName
    And User enters invalid Password
    And User select CAPTCHA correctly
    And User clicks on Register
    Then Message displayed Passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer.

  Scenario: Successful Login with Valid Credential
    Given User enters  valid UserName and Password
    When User clicks on Login
    Then User is in Profile Page
    And UserName is Displayed

  Scenario Outline: Unsuccessful Login  with invalid credentials
    Given User enters <userName> as UserName and <password> as Password
    When User clicks on Login
    Then Message displayed Invalid username or password!

    Examples:
      | userName | password |
      |          |          |
      |   test1  |   test1  |

  Scenario: Successful LogOut
    Given User is Logged in
    When User LogOut from the Application
    Then Message displayed LogOut Successfully

  Scenario: logout
    Given User is Logged out
    When User goes to Profile Page
    Then Message displayed Currently you are not logged into the Book Store application, please visit the login page to enter or register page to register yourself.
