Feature: Admin monitoring and reporting

  Scenario: Admin generates a profit report
    Given the admin is logged in for report
    When the admin generates the profit report
    Then the report should display the total profits for each store

  Scenario: Admin identifies the best-selling store
    Given the admin is logged in for report
    When the admin checks the best-selling store
    Then the best-selling store should be displayed

  Scenario: Admin generates city-based user statistics
    Given the admin is logged in for report
    When the admin generates city statistics
    Then the report should display the number of users in each city
    