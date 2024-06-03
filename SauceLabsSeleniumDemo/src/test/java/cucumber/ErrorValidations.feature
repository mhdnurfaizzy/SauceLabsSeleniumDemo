
@tag
Feature: Error Validation
  This feature to check error validation on login page with invalid cred

#  @
  @Tag2
  Scenario Outline: Invalid login credentials
    Given I landed on ecommerce page
    When I login with email <email> and password <password>
    Then "Epic sadface: Username and password do not match any user in this service" message is displayed


    Examples:
      | email         | password   |
      | izi@gmail.com | Testing890 | 
    

