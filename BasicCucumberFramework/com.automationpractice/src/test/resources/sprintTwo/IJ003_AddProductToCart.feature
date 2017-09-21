@Troubleshooting
Feature: Validate add item to cart functionality in the web application
  As a customer 
  I want to add item 
  So I can see the item in cart

  Scenario Outline: Validate add item to cart functionality
    Given I am logged in the web application
      | email          | password |
      | dine@yahoo.com | 12345abc |
    When I add the following items:"<Casual dresses>"&"<Evening dresses>"
    Then the following should exist in the cart:"<Total Amount>"

    Examples: 
      | Casual dresses | Evening dresses | Total Amount |
      | Printed Dress  | Printed Dress   | $78.99       |
