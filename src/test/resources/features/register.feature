Feature: Parabank Register Functionality

  Background:
    Given user navigates to the register page

  @smoke @regression 
  Scenario: Successful registration with valid data
    When user fills in all registration fields with valid data
    And user submits the registration form
    Then user should see welcome message after registration

  @regression 
  Scenario: Registration fails when first name is empty
    When user fills registration form with empty first name
    And user submits the registration form
    Then user should see first name required error

  @regression 
  Scenario: Registration fails when last name is empty
    When user fills registration form with empty last name
    And user submits the registration form
    Then user should see last name required error

  @regression 
  Scenario: Registration fails when username already exists
    When user fills registration form with existing username
    And user submits the registration form
    Then user should see username already exists error

   