Feature: Trip Planner

  Scenario:
    Given I open GO website
    And I accept privacy policy
    When I fill From field with 'Keleti railway station'
    And I fill To field with 'Nyugati railway station'
    And I click on Plan button
    Then the trip is planned
    #Then I should see some results


