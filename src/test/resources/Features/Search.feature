Feature: Product Search
  Scenario: Search a Product
    Given I landed on search page
    When I search a product with name "Apple pro mac" and price 1000
    Then  product name "Apple pro mac" should be displayed