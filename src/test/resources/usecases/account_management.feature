Feature: Account management for store owners and suppliers

  Scenario: Store owner updates business information
    Given the store owner is logged in for account management
    When the store owner updates the business information
    Then the business information should be updated successfully

  Scenario: Supplier updates business information
    Given the supplier is logged in for account management
    When the supplier updates the business information
    Then the business information should be updated successfully
