
@tag
Feature: Purchase the order from E-commerce Website

  Background:
  Given I landed on ecommerce page
	
#  @Regression
  @Tag2
  Scenario Outline: Positive case of submiting order 
    Given I login with email <email> and password <password>
    When I added product <productName> to cart
      And I Checkout <productName> and fill overview <firstName> <lastName> <zip> information
    Then Checkout <productName> and submit order
    Then "Thank you for your order!" message is displayed on confirmationPage

    Examples: 
      | email  		  | password     | productName          | firstName | lastName | zip   |
      | standard_user | secret_sauce | Sauce Labs Backpack  | izi       | izi      | 40001 |
      
      
      
      