@Troubleshooting @wip
Feature: Validate the Bestseller button functionality in the web application
  As a customer
  I would like to use the bestseller
  So I can buy the best items on the web application

  Scenario Outline: Validate the bestseller functionality
    Given I am on the home page
    When I view items on bestseller
    Then I should see the following: "<Item names>", "<Prices>"

    Examples: Data for execution
      | Item names                  | Prices |
      | Faded Short Sleeve T-shirts | $16.51 |
