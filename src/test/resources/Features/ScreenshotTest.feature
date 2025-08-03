Feature: Screenshot test

  Scenario: Intentional failure to test screenshot
    Given I open Google
    Then I force a failure to check screenshot
