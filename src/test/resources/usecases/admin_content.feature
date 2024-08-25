Feature: Admin content management

  Scenario: Admin approves a recipe
    Given the admin is logged in for content management
    When the admin approves a recipe
    Then the recipe should be marked as approved

  Scenario: Admin rejects a recipe
    Given the admin is logged in for content management
    When the admin rejects a recipe
    Then the recipe should be removed from the system

  Scenario: Admin checks user feedback
    Given the admin is logged in for content management
    When the admin views all feedback
    Then the feedback should be displayed
