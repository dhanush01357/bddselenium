Feature: Search Functianlity
Background: common upcoming lines
Given I login as a guest user
And click on press enter key
But I should not get any other products


Scenario: Verify user is able to search for a product
When I select the books from the search dropdown
Then I should get the book relevant details




Scenario: Verify user is able to search for a product
When I select the shoe from the search dropdown
Then I should get the shoe relevant details

