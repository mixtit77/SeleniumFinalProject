Feature: User login to the Store website

  Background:
    Given The user open Tesco website
    And the user accept privacy policy
    And the User goes to the sign in section

  Rule: Login is not allowed with incorrect credentials

    Scenario: User login with incorrect credentials
      When the User enters his correct login 'mixtit77@gmail.com'
      And the User enters incorrect password 'Password'
      And the User clicks the sign in button
      Then the User sees warning message "Unfortunately we do not recognise those details."
