Feature: Product management for store owners and suppliers

  Scenario: Store owner adds a new product
    Given the store owner is logged in for product management
    When the store owner adds a product
    Then the product should be added successfully

  Scenario: Store owner updates a product
    Given the store owner has a product in the system
    When the store owner updates the product
    Then the product should be updated successfully

  Scenario: Store owner removes a product
    Given the store owner has a product in the system
    When the store owner removes the product
    Then the product should be removed from the system

  Scenario: Store owner identifies the best-selling product
    Given the store owner has sales data
    When the store owner checks the best-selling product
    Then the best-selling product should be displayed
