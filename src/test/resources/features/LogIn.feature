Feature: Signup and Login on AutomationExercise

  Scenario: User signs up and logs in successfully
    Given browser is open
    And user is on AutomationExercise home page
    When user clicks on Signup Login Link
    And user enters name and email for signup
    And user clicks on Signup button
    And user fills account details
    And user clicks on Create Account button
    Then account should be created successfully
    And user logs out
    And user logs in with same credentials
    Then user is logged in successfully
