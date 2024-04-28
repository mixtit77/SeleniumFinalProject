Feature: User login to the Store website

  Rule: Login is allowed with correct credentials and not allowed with incorrect credentials

    Scenario: User login with correct credentials
      Given I open Tesco website
      And I accept privacy policy
      When the User goes to the sign in section
      And the User enters his correct login 'mixtit77@gmail.com'
      And the User enters his correct password 'dummyPAssword123'
      And the User clicks the sign in button
      Then the User is successfully authenticated
      And the user redirected to the main page
      And the User sees his name at the top of the page

    Scenario: User login with incorrect credentials
      Given I open Tesco website
      And I accept privacy policy
      When the User goes to the sign in section
      And the User enters his correct login 'mixtit77@gmail.com'
      And the User enters incorrect password 'Password'
      And the User clicks the sign in button
      Then the User sees warning message "Unfortunately we do not recognise those details."
