Feature: Search and Place the order for products

@OffersPage
Scenario Outline: Search Experince for the product search in both home and offers page

Given User is on GreenCart Landing page 
When user searched with Shortname <Name> and Extracted actual name of product
Then user searched  for <Name> Shortname in offers page
And Validate product name in offer page matches with Landing Page

Examples: 
| Name  |
| Tom  	|
| Beet  |
