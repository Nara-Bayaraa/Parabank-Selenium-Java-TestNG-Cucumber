package com.qaportfolio.stepdefinitions;

import com.qaportfolio.pages.LoginPage;
import com.qaportfolio.utils.ConfigReader;
import com.qaportfolio.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginSteps {

    private LoginPage loginPage = new LoginPage();

    @Given("user is on the Parabank login page")
    public void userIsOnParabankLoginPage() {
        DriverManager.getDriver().get(ConfigReader.get("baseUrl"));
        String title = DriverManager.getDriver().getTitle();
        Assert.assertTrue(
            title.contains("ParaBank"),
            "Page title does not contain ParaBank"
        );
    }

    @When("user enters username {string} and password {string}")
    public void userEntersCredentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("user should be redirected to accounts overview page")
    public void userShouldBeRedirectedToAccountsOverview() {
        WebDriverWait wait = new WebDriverWait(
            DriverManager.getDriver(), Duration.ofSeconds(15)
        );
        wait.until(ExpectedConditions.urlContains("overview"));
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertTrue(
            currentUrl.contains("overview"),
            "URL does not contain overview"
        );
    }

    @Then("user should see the empty credentials error")
    public void userShouldSeeEmptyCredentialsError() {
        String expected = ConfigReader.get("error.emptyCredentials");
        String actual = loginPage.getErrorMessage();
        Assert.assertEquals(
            actual,
            expected,
            "Empty credentials error message does not match"
        );
    }

    @Then("user should see the invalid credentials error")
    public void userShouldSeeInvalidCredentialsError() {
        String expected = ConfigReader.get("error.invalidCredentials");
        String actual = loginPage.getErrorMessage();
        Assert.assertEquals(
            actual,
            expected,
            "Invalid credentials error message does not match"
        );
    }

    @Then("user should see the register link")
    public void userShouldSeeRegisterLink() {
        Assert.assertTrue(
            loginPage.isRegisterLinkVisible(),
            "Register link is not visible"
        );
    }

    @When("user clicks the register link")
    public void userClicksRegisterLink() {
        loginPage.clickRegisterLink();
    }

    @Then("user should be redirected to the register page")
    public void userShouldBeRedirectedToRegisterPage() {
        String url = loginPage.getCurrentUrl();
        Assert.assertTrue(
            url.contains("register"),
            "URL does not contain register"
        );
    }

    @Then("the URL should contain {string}")
    public void urlShouldContain(String expectedUrlPart) {
        String url = loginPage.getCurrentUrl();
        Assert.assertTrue(
            url.contains(expectedUrlPart),
            "URL does not contain " + expectedUrlPart
        );
    }
}