Feature: Promotions section and sorting by price

  Background:
    Given The user open Tesco website
    And the user accept privacy policy
    And the User goes to the Promotions section on the main page
    And the User goes to any suggested section on the promotion page

  Rule: Sort by price high to low and price low to high

    Scenario: Product search by name
      When the User clicks on dropdown list sort by high to low
      Then the User sees the results which sorted by price high to low

    Scenario: Product search by name
      When the User clicks on dropdown list sort by low to high
      Then the User sees the results which sorted by price low to high