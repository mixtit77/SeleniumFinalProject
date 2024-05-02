Feature: Product search and checking that each result have an add button

  Background:
    Given The user open Tesco website
    And the user accept privacy policy

  Rule: Product search is allowed, each result must have an add button

    Scenario Outline: Product search by name
      Given  the User sees the search field on the main page
      When the User enters "<product>" in the search field
      And the User clicks the search button
      Then the User sees the search results with "<product>"
      And the User sees the add button for each product


      Examples:
        | product  |
        | eggplant |
        | cucumber |
        | potato   |
        | onion    |