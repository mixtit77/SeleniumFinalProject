Feature: User login to the Store website

  Background:
    Given The user open Tesco website
    And the user accept privacy policy
    And the User goes to the sign in section

  Rule: Login is allowed with correct credentials and not allowed with incorrect credentials

    Scenario: User login with correct credentials
      When the User enters his correct login 'mixtit77@gmail.com'
      And the User enters his correct password 'NewPaword123'
      And the User clicks the sign in button
      Then the User is successfully authenticated
      And the user redirected to the main page
      And the User sees 'Hello' at the top of the page
      Then the User clicks on the Sign out button
      And the User sees Sign in button

    Scenario: User login with incorrect credentials
      When the User enters his correct login 'mixtit77@gmail.com'
      And the User enters incorrect password 'Password'
      And the User clicks the sign in button
      Then the User sees warning message "Unfortunately we do not recognise those details."