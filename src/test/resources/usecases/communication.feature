Feature: Communication and notification for store owners and suppliers

  Scenario: Store owner sends a message to a supplier
    Given the store owner is logged in for communication
    When the store owner sends a message to the supplier
    Then the supplier should receive the message

  Scenario: Store owner receives a notification for a special request
    Given the store owner is logged in for notifications
    When a notification is sent
    Then the store owner should receive the notification
