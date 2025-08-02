@All
Feature: Rapido booking feature
  @Smoke
  Scenario: Booking bike 1
    Given user wants to select bike type from rapido
    When user select bike "pulsar" and pickup point "shop" to drop point "station"
    Then Driver starts the journey
    And user reached the station
    Then user pays "100" INR

    @Regression
  Scenario: Booking bike 2
    Given user wants to select bike type from rapido
    When user select bike "Activa" and pickup point "shop" to drop point "station"
    Then Driver starts the journey
    And user reached the station
    Then user pays "100" INR

    @Uat
  Scenario: Booking bike 3
    Given user wants to select bike type from rapido
    When user select bike "RoyalEnfield" and pickup point "shop" to drop point "station"
    Then Driver starts the journey
    And user reached the station
    Then user pays "100" INR