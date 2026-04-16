
Feature: Parabank Login Functionality 

  Background:
    Given user is on the Parabank login page

@smoke
Scenario: Successful login with valid credentials
    When user enters username "john" and password "demo"
    Then user should be redirected to accounts overview page

@smoke
Scenario: Failed login with invalid credentials
    When user enters username "" and password ""
   Then user should see error message "Please enter a username and password."

 @regression
  Scenario: Failed login with empty username
    When user enters username "" and password "demo"
    Then user should see error message "Please enter a username and password."

  @regression
  Scenario: Failed login with empty password
    When user enters username "john" and password ""
    Then user should see error message "Please enter a username and password."