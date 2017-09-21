@Regression 
Feature: Validate search functionality in the web application
  As a customer
  I want to be able to search for an item
  So I can see the item

  Scenario Outline: Validate the search functionality in the application
    Given I am on the home page
    When I search for : "<Item>"
    Then I should see : "<Page Title>","<Page Url>", "<Item Names>" and "<Message>"

    Examples: 
      | Item                  | Page Title        | Page Url                                                                                                                                   | Item Names                            | Message                    |
      | Printed Chiffon Dress | Search - My Store | http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=Printed+Chiffon+Dress&submit_search= | Printed Chiffon Dress                 | 2 results have been found  |
      | Blouse                | Search - My Store | http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=Blouse&submit_search=                | Blouse                                | 1 result has been found.   |
      | T-Shirts              | Search - My Store | http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=T-Shirts&submit_search=              | Faded Short Sleeve T-shirts           | 1 result has been found.   |
      | Scarf                 | Search - My Store | http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=Scarf&submit_search=                 | No results were found for your search | 0 results have been found. |
