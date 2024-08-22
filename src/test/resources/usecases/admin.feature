Feature: Admin management

  Scenario: Admin logs in
    Given the admin is on the login page
    When the admin enters valid credentials
    Then the admin should be logged in successfully
