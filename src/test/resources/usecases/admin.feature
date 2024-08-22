Feature: Admin management

  Scenario: Admin logs in
    Given the admin is on the login page
    When the admin enters valid credentials
    Then the admin should be logged in successfully

  Scenario: Admin adds a store owner
    Given the admin is logged in
    When the admin adds a new store owner
    Then the store owner should be added successfully
