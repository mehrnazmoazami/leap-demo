Feature: Profile

  Background:
    Given User is Logged in
    And User added a Book Speeaking Javascript to Collection
    And User is in Profile Page

  Scenario: UserName displayed
    Then UserName displayed

  Scenario: Show Book Detail
    When User clicks on Book Title
    Then Book Detail displayed

  Scenario: Search
    Given User have three Books with Java title in Collection
    When User write Java in Search field
    And User Clicks on Search
    Then Three Books with Java title are displayed in Collection

  Scenario: Search doesn't return any book
    Given User does not have any Book with Apple title in Collection
    When User write Apple in Search field
    And User Clicks on Search
    Then No Book is displayed in Collection

  Scenario: Remove Search
    Given User write Java in Search field
    And  User  clicks on Search button
    When User remove Java from Search field
    Then All Books are displayed in Collection

  Scenario: One Page
    Given User has one Book in Collection
    When User write 2 in Page field
    Then 1 is showed as Page

  Scenario: Pages
    Given User has six Books in Collection
    And User select 5 rows
    When User write 2 in Page field
    Then 1 is showed as Page
    And Page 2 of Book Collection is displayed

  Scenario: Next Page
    Given User has six Books in Collection
    And User select 5 rows
    When User Clicks on Next Button
    Then Page 2 of Book Collection is displayed

  Scenario: Previous Page
    Given User has six Books in Collection
    And User select 5 rows
    And User write 2 in Page field
    When User Clicks on Previous Button
    Then Page 1 of Book Collection is displayed

  Scenario: Back to Profile
    Given User clicks on Book Title
    And Book Detail displayed
    When User click on Back To Book Store
    Then User is in Profile Page

  Scenario: Back to Book Store
    When User clicks on Go To Book Store
    Then User is in Book Store Page

  Scenario: Edit Rows Count
    When User clicks on 10 rows
    Then 10 rows  is displayed in profile

  Scenario: Back to Book Store
    When User clicks on Go To Book Store
    Then User is in Book Store Page

  Scenario: Delete Book form Collection
    Given User has Speaking Javascript Book in Collection
    When User clicks on Delete button of Speakig Javascript Book
    And User gets confirmation to Delete
    And User press OK
    Then Message Book Deleted displayed
    And There is not Speaking Javascript Book in the collection

  Scenario: Cancel Delete Book form Collection
    Given User has Speaking Javascript Book in Collection
    When User clicks on Delete button of Speakig Javascript Book
    And User gets confirmation to Delete
    And User press Cancel
    Then There is Speakig Javascript Book in the collection

  Scenario: Delete All Books form Collection
    Given User has three Books in Collection
    When User clicks on Delete All Books button
    And User gets confirmation to Delete
    And User press OK
    Then Message All Books Deleted displayed
    And There is no Book in the collection

  Scenario: Cancel Delete Book form Collection
    Given User has three Books in Collection
    When User clicks on Delete All Books button
    And User gets confirmation to Delete
    And User press Cancel
    Then Three Books are in the collection

  Scenario: Delete Account
    Given User clicks on Delete Accounts button
    And User gets confirmation to Delete
    When User press ok
    And User is in Login Page
    And User enters same credenttials
    And User clicks on Login button
    Then Message Invalid UserName or Password displayed

  Scenario: Successful LogOut
    When User LogOut from the Application
    Then Message displayed LogOut Successfully
