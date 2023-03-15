Feature: Search and Place the order for products

@PlaceOrder
Scenario Outline: Search Experince for the product search in both home and offers page

Given User is on GreenCart Landing page 
When user searched with Shortname <Name> and Extracted actual name of product
And Added "3" items of the selected product to cart
Then user proceed to Checkout and validate the <Name> items in checkout page
And verify user has abilty to enter promo code and place the order

Examples: 
| Name  |
| Tom  	|

