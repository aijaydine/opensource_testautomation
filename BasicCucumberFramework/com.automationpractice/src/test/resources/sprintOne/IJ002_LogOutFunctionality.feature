@Regression 
Feature: Validate log out functionality in the web application
  As a customer 
  I would like to log out succesfully from the application
  So I can log back in again

  @nightly
  Scenario: Validate log out functionality in the web application
    Given I am logged in the web application
      | email          | password | log_in message |
      | dine@yahoo.com | 12345abc | Edith Dine     |
    When I log out of the web application
    Then I validate logout message as "Sign in"
