Feature: Contact Us form functionality

  Scenario: Submit Contact Us form successfully
    Given browser is open
    And user is on AutomationExercise home page
    When user navigates to Contact Us page
    And user fills Name, Email, Subject, Message
    And user clicks Submit
    Then success message should be displayed
