
Feature: Parabank Login Functionality 

  Background:
    Given user is on the Parabank login page

  @regression @debug 
Scenario: Successful login with valid credentials
    When user enters username "john" and password "demo"
    Then user should be redirected to accounts overview page

 @regression @debug 
Scenario: Failed login with invalid credentials
    When user enters username "" and password ""
Then user should see the empty credentials error

 @regression @debug 
  Scenario: Failed login with empty credentials
    When user enters username "" and password "demo"
   Then user should see the empty credentials error

  @regression @debug 
  Scenario: Failed login with empty password
    When user enters username "john" and password ""
 Then user should see the empty credentials error

   @smoke @regression @debug 
  Scenario: Failed login with invalid credentials
    When user enters username "wronguser" and password "wrongpass"
    Then user should see the invalid credentials error

 