Feature: Communication and feedback for beneficiaries

  Scenario: User communicates with store owner
    Given the user is logged in for communication
    When the user sends a message to the store owner
    Then the message should be sent successfully

  Scenario: User leaves feedback on a purchased product
    Given the user has purchased a product for feedback
    When the user leaves feedback for the product
    Then the feedback should be recorded successfully
