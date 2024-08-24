Feature: Order management for store owners and suppliers

  Scenario: Store owner processes an order
    Given the store owner has received an order
    When the store owner updates the order status to shipped
    Then the order status should be updated successfully

  Scenario: Store owner completes an order
    Given the store owner has received an order
    When the store owner updates the order status to completed
    Then the order status should be updated successfully
