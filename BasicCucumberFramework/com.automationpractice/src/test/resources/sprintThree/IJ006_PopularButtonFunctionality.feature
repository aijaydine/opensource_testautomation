@Regression 
Feature: Validate Popular functionality in the web application
  As a customer
  I would like to see the popular items on the web application
  So that I can view these popular items

  Scenario Outline: Validate the popular button functionality
    Given I am on the home page
    When I view the popular items
    Then I should see the following: "<Items>","<Amount>"

    Examples: Data for execution
      | Items                       | Amount |
      | Faded Short Sleeve T-shirts | $16.51 |
      | Blouse                      | $27.00 |
      | Printed Dress               | $26.00 |
      | Printed Dress               | $50.99 |
      | Printed Chiffon Dress       | $16.40 |
      | Printed Summer Dress        | $28.98 |
      | Printed Summer Dress        | $30.50 |
