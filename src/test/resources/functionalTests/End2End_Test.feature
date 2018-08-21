Feature: Automated End2End Tests
Description:The purpose of this feature is to test End 2 End Integration.
Scenario: Customer place an order by purchasing an item from search
Given user is on Home Page
When he search for “item”
And choose to buy the first item
And extract details of the product
And close the browser