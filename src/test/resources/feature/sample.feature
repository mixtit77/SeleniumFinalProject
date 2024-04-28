Feature: Sample test to demo Cucumber

  Scenario: Positive number of cucumber remaining
    Given I have 20 cucumbers
    When I eat 5 cucumbers
    Then I have 15 cucumbers remaining
    And I am 'happy'

  Scenario Outline: Number of cucumbers remaining
    Given I have <start> cucumbers
    When I eat <eaten> cucumbers
    Then I have <remaining> cucumbers remaining

    Examples:
      | start | eaten | remaining |
      | 20    | 5     | 12        |
      | 5     | 5     | 0         |
      | 2     | 5     | -3        |