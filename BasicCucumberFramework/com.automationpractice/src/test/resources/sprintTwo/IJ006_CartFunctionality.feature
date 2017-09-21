@Regression 
Feature: Validate the cart functionality in the web application
  As a user 
  I would like to view the shopping cart
  So I can add items to my cart

  Scenario: Validate the cart functionality in the application
    Given I am on my Home Page
    When I open the shopping cart
    Then I would see "Your shopping cart is empty."
