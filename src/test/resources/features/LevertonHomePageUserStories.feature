Feature: Leverton Home Page User Stories

Scenario Outline: User clicks various language options
  Given User is on leverton home page
  When  User selects <name> language
  Then  User sees page in <name> language
  Examples:
  |name|
  |Deutsch|
  |Spanish|
  |English|

Scenario: User is not able to login with invalid credentials
 Given User is on leverton home page
 When  User enters invalid credentials
 Then  User is shown error message

