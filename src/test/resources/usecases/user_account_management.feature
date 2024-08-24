Feature: User account management for beneficiaries

  Scenario: User signs up for a new account
    Given the user is on the registration page
    When the user registers with a username and password
    Then the user should be registered successfully

  Scenario: User signs in to the platform
    Given the user has a registered account
    When the user signs in with valid credentials
    Then the user should be logged in successfully

  Scenario: User shares a dessert creation
    Given the user is logged in
    When the user shares a new dessert creation
    Then the dessert creation should be added successfully
