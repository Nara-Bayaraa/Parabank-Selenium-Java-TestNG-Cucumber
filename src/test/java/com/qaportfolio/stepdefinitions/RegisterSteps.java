package com.qaportfolio.stepdefinitions;

import com.qaportfolio.pages.RegisterPage;
import com.qaportfolio.utils.ConfigReader;
import com.qaportfolio.utils.DriverManager;
import com.qaportfolio.utils.TestDataFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class RegisterSteps {

    private RegisterPage registerPage = new RegisterPage();
    private String generatedPassword;

    @Given("user navigates to the register page")
    public void user_navigates_to_the_register_page() {
        DriverManager.getDriver().get(ConfigReader.get("registerUrl"));
        String title = DriverManager.getDriver().getTitle();
        Assert.assertTrue(
            title.contains("ParaBank"),
            "Register page did not load"
        );
    }

    @When("user fills in all registration fields with valid data")
    public void user_fills_in_all_registration_fields_with_valid_data() {
        generatedPassword = TestDataFactory.generatePassword();
        registerPage.fillRegistrationForm(
            TestDataFactory.generateFirstName(),
            TestDataFactory.generateLastName(),
            TestDataFactory.generateAddress(),
            TestDataFactory.generateCity(),
            TestDataFactory.generateState(),
            TestDataFactory.generateZipCode(),
            TestDataFactory.generatePhone(),
            TestDataFactory.generateSSN(),
            TestDataFactory.generateUsername(),
            generatedPassword,
            generatedPassword
        );
    }

    @When("user submits the registration form")
    public void user_submits_the_registration_form() {
        registerPage.clickRegisterFormButton();
    }

    @Then("user should see welcome message after registration")
    public void user_should_see_welcome_message_after_registration() {
        String title = registerPage.getWelcomeTitle();
        Assert.assertTrue(
            title.contains("Welcome"),
            "Welcome message not displayed after registration"
        );
    }

    @When("user fills registration form with empty first name")
    public void user_fills_registration_form_with_empty_first_name() {
        generatedPassword = TestDataFactory.generatePassword();
        registerPage.fillRegistrationForm(
            "",
            TestDataFactory.generateLastName(),
            TestDataFactory.generateAddress(),
            TestDataFactory.generateCity(),
            TestDataFactory.generateState(),
            TestDataFactory.generateZipCode(),
            TestDataFactory.generatePhone(),
            TestDataFactory.generateSSN(),
            TestDataFactory.generateUsername(),
            generatedPassword,
            generatedPassword
        );
    }

    @When("user fills registration form with empty last name")
    public void user_fills_registration_form_with_empty_last_name() {
        generatedPassword = TestDataFactory.generatePassword();
        registerPage.fillRegistrationForm(
            TestDataFactory.generateFirstName(),
            "",
            TestDataFactory.generateAddress(),
            TestDataFactory.generateCity(),
            TestDataFactory.generateState(),
            TestDataFactory.generateZipCode(),
            TestDataFactory.generatePhone(),
            TestDataFactory.generateSSN(),
            TestDataFactory.generateUsername(),
            generatedPassword,
            generatedPassword
        );
    }

    @When("user fills registration form with existing username")
    public void user_fills_registration_form_with_existing_username() {
        generatedPassword = TestDataFactory.generatePassword();
        registerPage.fillRegistrationForm(
            TestDataFactory.generateFirstName(),
            TestDataFactory.generateLastName(),
            TestDataFactory.generateAddress(),
            TestDataFactory.generateCity(),
            TestDataFactory.generateState(),
            TestDataFactory.generateZipCode(),
            TestDataFactory.generatePhone(),
            TestDataFactory.generateSSN(),
            "john",
            generatedPassword,
            generatedPassword
        );
    }

    @Then("user should see first name required error")
    public void user_should_see_first_name_required_error() {
        String expected = ConfigReader.get("error.firstNameRequired");
        String actual = registerPage.getFirstNameError();
        Assert.assertEquals(
            actual,
            expected,
            "First name error does not match"
        );
    }

    @Then("user should see last name required error")
    public void user_should_see_last_name_required_error() {
        String expected = ConfigReader.get("error.lastNameRequired");
        String actual = registerPage.getLastNameError();
        Assert.assertEquals(
            actual,
            expected,
            "Last name error does not match"
        );
    }

    @Then("user should see username already exists error")
    public void user_should_see_username_already_exists_error() {
        String expected = ConfigReader.get("error.usernameExists");
        String actual = registerPage.getUsernameError();
        Assert.assertEquals(
            actual,
            expected,
            "Username error does not match"
        );
    }
}