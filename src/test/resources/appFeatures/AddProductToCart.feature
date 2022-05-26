Feature: Add a Product to Cart

Background: Login to Application
Given User is on Home Page
#When User Logs in
When User logs in with "bunty@gmail.com" and "abc@123"
Then User is on My Account Page

Scenario: Add product to cart
Given User Searches for Item
When User adds Product to Cart
Then Item must be added to Cart
