package com.qaportfolio.stepdefinitions;

import com.qaportfolio.pages.LoginPage;
import com.qaportfolio.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {

    private LoginPage loginPage;

    @Before
    public void setUp() {
        DriverManager.getDriver().get("https://parabank.parasoft.com/parabank/index.htm");
        loginPage = new LoginPage();
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }

    @Given("user is on the Parabank login page")
    public void userIsOnParabankLoginPage() {
        String title = DriverManager.getDriver().getTitle();
        Assert.assertTrue(title.contains("ParaBank"), "Page title does not contain ParaBank");
    }

    @When("user enters username {string} and password {string}")
    public void userEntersCredentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("user should be redirected to accounts overview page")
    public void userShouldBeRedirectedToAccountsOverview() {
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("overview"), "URL does not contain overview");
    }

    @Then("user should see error message {string}")
    public void userShouldSeeErrorMessage(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match");
    }
}