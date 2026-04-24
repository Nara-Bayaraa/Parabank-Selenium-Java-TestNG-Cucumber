package com.qaportfolio.pages;

import com.qaportfolio.utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@class='button']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[@class='error']")
    private WebElement errorMessage;

    @FindBy(xpath = "//a[text()='Register']")
    private WebElement registerLinkButton;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void enterUsername(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(
            DriverManager.getDriver(), Duration.ofSeconds(10)
        );
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }

    public void clickRegisterLink() {
        registerLinkButton.click();
    }

    public boolean isRegisterLinkVisible() {
        WebDriverWait wait = new WebDriverWait(
            DriverManager.getDriver(), Duration.ofSeconds(10)
        );
        wait.until(ExpectedConditions.visibilityOf(registerLinkButton));
        return registerLinkButton.isDisplayed();
    }

    public String getCurrentUrl() {
        return DriverManager.getDriver().getCurrentUrl();
    }
}