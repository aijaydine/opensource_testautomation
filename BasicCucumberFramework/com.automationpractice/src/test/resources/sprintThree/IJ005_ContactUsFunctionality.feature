@Regression
Feature: Validate Contact Us functionality in the web application
  As a customer
  I would like to use the contact us feature 
  So I can get information on products available

  Scenario Outline: Validate Contact Us functionality
    Given I am on the home page
    When I add the following: "<Subject Heading>","<Email address>" ,"<Order reference>" and "<Message>"
    Then I should see the following: "<Confirmatory Message>", "<Confirmatory Page>"

    Examples: Data for test execution
      | Subject Heading  | Email address  | Order reference | Message               | Confirmatory Message                                 | Confirmatory Page             |
      | Customer service | dine@yahoo.com | Printed Dress   | I want to buy a dress | Your message has been successfully sent to our team. | Customer service - Contact us |
      | Webmaster        | dine@yahoo.com | Printed Dress   | I want to buy a dress | Your message has been successfully sent to our team. | Customer service - Contact us |
      | Choose           | dine@yahoo.com | Printed Dress   | I want to buy a dress |                                                      | Customer service - Contact us |
      | Customer service |                | Printed Dress   | I want to buy a dress | Invalid email address.                               | Customer service - Contact us |
      | Customer service | dine@yahoo.com |                 | I want to buy a dress | Your message has been successfully sent to our team. | Customer service - Contact us |
      | Customer service | dine@yahoo.com | Printed Dress   |                       | The message cannot be blank                          | Customer service - Contact us |
