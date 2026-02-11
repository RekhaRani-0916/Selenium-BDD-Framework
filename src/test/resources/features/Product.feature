Feature: To verify product functionality

  Scenario: User adds a product to the cart and verifies it
    Given user is on AutomationExercise home page
    And Product page is initialized
    When user navigates to the Products page
    And user selects a product from the list
    And user adds the product to the cart
    Then the cart page should be displayed
    And the selected product should be listed in the cart

  Scenario: User proceeds to checkout and registers/logs in
    Given user is on AutomationExercise home page
    And Product page is initialized
    When user navigates to the Products page
    And user selects a product from the list
    And user adds the product to the cart
    And user proceeds to checkout
    And user chooses to register or login
    Then user should be able to complete signup or login
     

  Scenario: User searches for a product
    Given user is on AutomationExercise home page
    And Product page is initialized
    When user navigates to the Products page
    And user enters "T-Shirt" in the search box
    And user clicks on search button
    Then search results related to "T-Shirt" should be displayed
