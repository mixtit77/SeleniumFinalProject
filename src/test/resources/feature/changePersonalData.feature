Feature: Changing personal data on the Tesco website

  Background:
    Given The user open Tesco website
    And the user accept privacy policy
    And the User goes to the sign in section
    And the User enters his correct login 'mixtit77@gmail.com'
    And the User enters his correct password 'NewPaword123'
    And the User clicks the sign in button
    And the User is successfully authenticated
    And the user redirected to the main page
    And the User sees 'Hello' at the top of the page


  Rule: Changing the user's personal data is allowed

    Scenario: Changing the user's personal data
      When the User goes to the My account section
      And The User clicks on the Edit button in the personal details section
      And the User changes his first name to 'Mama' 'Papa'
      And the User clicks on the Save changes button in the personal details section
      Then the User sees that personal data was successfully updated
      And the User updates page
      And the User sees changed first name at the top of the page