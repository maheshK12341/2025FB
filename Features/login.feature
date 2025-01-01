
Feature: Validate login feature
I want to Validate Login feature


  Scenario Outline: To Validate that user is able to login with multiple login details
   Given user is on login page
   When user enters valid username"<username>"
   And user enters valid password"<password>"
   And clicks on submit


 Examples: 
      | username  | password |
      | Testing@gmail.com |P234222 |
      | Selenium@gmail.com |P3vvvd34 |
   