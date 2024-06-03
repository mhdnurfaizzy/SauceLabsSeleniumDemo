@tag
Feature: Log out from e-commerce page
  This feature to testing logout from e-commerce page


  Scenario Outline: User logs out of the website SauceLabs
    Given I landed on ecommerce page
    When I login with email <email> and password <password>
    And I click on the logout button
    Then I should be log out successfully

    Examples:
      | email         | password     |
      | standard_user | secret_sauce |