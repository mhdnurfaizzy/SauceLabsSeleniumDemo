

@tag
Feature: User Login and Place Order

  Background:
    Given I landed on ecommerce page

  Scenario: User logs in with valid credentials
    Given I am on the Sauce Labs login page
    When I enter valid username "<valid_username>" and password "<valid_password>"
    And I click on the login button
    Then I should be logged in successfully
    And I should be on the Sauce Labs products page

  Scenario: User logs in with invalid credentials
    Given I am on the Sauce Labs login page
    When I enter invalid username "<invalid_username>" and password "<invalid_password>"
    And I click on the login button
    Then I should see an error message indicating login failure

  Scenario: User adds a product to the cart and proceeds to checkout
    Given I am logged in to the Sauce Labs website
    When I select a product and add it to the cart
    And I proceed to checkout
    Then I should see the checkout page

  Scenario: User enters shipping details and payment information
    Given I am on the checkout page
    When I enter shipping details and payment information
    And I confirm the order
    Then I should see a confirmation message
    And my order should be placed successfully

  Scenario: User logs out of the website
    Given I am logged in to the Sauce Labs website
    When I click on the logout button
    Then I should be logged out successfully
