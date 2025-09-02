Feature: Verify the login fuctionality
 
Scenario: verify login success
 
Given Open the Browser
And Navigate to the url
Then Enter the valid username and password
And Click on Login
Then Verify login success
And Close the browser
 
Scenario: verify login unsuccess
 
Given Open the Browser
And Navigate to the url
Then Enter the invalid username and password
And Click on Login
Then Verify login unsuccess
And Close the browser