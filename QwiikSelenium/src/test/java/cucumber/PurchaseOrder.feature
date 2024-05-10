#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
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
      
      
      
      