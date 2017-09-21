@in-sprint @nightly 
Feature: Validate login functionality in the web application
  As a customer 
  I want to login into the application
  So I can purchase items

  Background: This is for all scenarios
    Given I am on the web application

  @Regression
  Scenario: Validate valid email and valid password
    When I login with email "dine@yahoo.com" and password "12345abc"
    Then I should see "Edith Dine"

  Scenario: Validate invalid email and valid password
    When I login with email "edith@yahoo.com" and password "12345abc"
    Then I should see "Authentication failed."

  Scenario: Validate valid email and invalid password
    When I login with email "dine@yahoo.com" and password "6789ttt"
    Then I should see "Authentication failed."

  @Regression
  Scenario: Validate invalid email and invalid password
    When I login with email "edith@yahoo.com" and password "6789ttt"
    Then I should see "Authentication failed."

  Scenario: Validate no email and no password
    When I login with email "" and password ""
    Then I should see "An email address required."

  Scenario: Validate no email and valid password
    When I login with email "" and password "12345abc"
    Then I should see "An email address required."

  Scenario: Validate valid email and no password
    When I login with email "dine@yahoo.com " and password ""
    Then I should see "Password is required."

  Scenario: Validate no email and invalid password
    When I login with email "" and password "678ttt"
    Then I should see "An email address required."

  Scenario: Validate invalid email and no password
    When I login with email "edith@yahoo.com " and password ""
    Then I should see "Password is required."
