Feature: GCR Login Functionality

@SmokeTest
Scenario: Verify GCR Admin Login Functionality by passing valid credentials

Given user launch "chrome" browser
Then user enters "http://www.gcrit.com/build3/admin" as url
Then user enters "admin" and "admin@123" as username and password
Then user clicks on login button
Then user directed to homepage
Then user close the browser
