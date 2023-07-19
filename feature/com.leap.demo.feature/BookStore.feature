Feature: BookStore

  Background:
    Given User is Logged in
    And User is in BookStore Page

  Scenario: UserName
    Then UserName displayed

  Scenario: Book Detail
    When User clicks on Book Speaking JavaScript
    Then  Book information displayed

  Scenario: Book Website
    Given User clicks on Book Speaking JavaScript
    And  Book information displayed
    When User clicks on Website
    Then User  is in Book Website


  Scenario: Add To The Collection
    Given User clicks on Book Speaking JavaScript
    And  Book information displayed
    When User clicks on Add To The  Collection
    Then Message displayed Book added to your collection

  Scenario: Add To The Collection when Book already  exists in collection
    Given User clicks on Book Speaking JavaScript
    And  Book information displayed
    When User clicks on Add To The  Collection
    Then Message displayed Book already presents in your collection
    And User goes to Profile Page
    And There is only one Speaking JavaScript Book

  Scenario: Back
    Given User clicks on Book Speaking JavaScript
    And  Book information displayed
    When User clicks on Back To Book Store
    Then User is in BookStore Page


  Scenario: Successful LogOut
    When User LogOut from the Application
    Then Message displayed LogOut Successfully