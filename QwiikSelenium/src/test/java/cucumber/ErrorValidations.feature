
@tag
Feature: Error Validation
  I want to use this template for my feature file

#  @
  @Tag2
  Scenario Outline: Invalid login credentials
    Given I landed on ecommerce page
    When I login with email <email> and password <password>
    Then "Epic sadface: Username and password do not match any user in this service" message is displayed


    Examples:
      | email         | password   |
      | izi@gmail.com | Testing890 | 
    

