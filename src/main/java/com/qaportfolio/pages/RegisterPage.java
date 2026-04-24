package com.qaportfolio.pages;

import com.qaportfolio.utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPage {

    @FindBy(name = "customer.firstName")
    private WebElement firstNameInput;

    @FindBy(name = "customer.lastName")
    private WebElement lastNameInput;

    @FindBy(name = "customer.address.street")
    private WebElement addressInput;

    @FindBy(name = "customer.address.city")
    private WebElement cityInput;

    @FindBy(name = "customer.address.state")
    private WebElement stateInput;

    @FindBy(name = "customer.address.zipCode")
    private WebElement zipCodeInput;

    @FindBy(name = "customer.phoneNumber")
    private WebElement phoneInput;

    @FindBy(name = "customer.ssn")
    private WebElement ssnInput;

    @FindBy(name = "customer.username")
    private WebElement usernameInput;

    @FindBy(name = "customer.password")
    private WebElement passwordInput;

    @FindBy(name = "repeatedPassword")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//input[@value='Register']")
    private WebElement registerFormButton;

    @FindBy(xpath = "//h1[@class='title' and contains(text(), 'Welcome')]")
    private WebElement welcomeTitle;

    @FindBy(id = "customer.firstName.errors")
    private WebElement firstNameError;

    @FindBy(id = "customer.lastName.errors")
    private WebElement lastNameError;

    @FindBy(id = "customer.username.errors")
    private WebElement usernameError;

    public RegisterPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void enterFirstName(String firstName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void enterAddress(String address) {
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    public void enterCity(String city) {
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void enterState(String state) {
        stateInput.clear();
        stateInput.sendKeys(state);
    }

    public void enterZipCode(String zipCode) {
        zipCodeInput.clear();
        zipCodeInput.sendKeys(zipCode);
    }

    public void enterPhone(String phone) {
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void enterSSN(String ssn) {
        ssnInput.clear();
        ssnInput.sendKeys(ssn);
    }

    public void enterUsername(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void enterConfirmPassword(String password) {
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(password);
    }

    public void clickRegisterFormButton() {
        registerFormButton.click();
    }

    public void fillRegistrationForm(
            String firstName, String lastName,
            String address, String city, String state,
            String zipCode, String phone, String ssn,
            String username, String password,
            String confirmPassword) {

        enterFirstName(firstName);
        enterLastName(lastName);
        enterAddress(address);
        enterCity(city);
        enterState(state);
        enterZipCode(zipCode);
        enterPhone(phone);
        enterSSN(ssn);
        enterUsername(username);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
    }

    public String getWelcomeTitle() {
        WebDriverWait wait = new WebDriverWait(
            DriverManager.getDriver(), Duration.ofSeconds(10)
        );
        wait.until(ExpectedConditions.visibilityOf(welcomeTitle));
        return welcomeTitle.getText();
    }

    public String getFirstNameError() {
        WebDriverWait wait = new WebDriverWait(
            DriverManager.getDriver(), Duration.ofSeconds(10)
        );
        wait.until(ExpectedConditions.visibilityOf(firstNameError));
        return firstNameError.getText();
    }

    public String getLastNameError() {
        WebDriverWait wait = new WebDriverWait(
            DriverManager.getDriver(), Duration.ofSeconds(10)
        );
        wait.until(ExpectedConditions.visibilityOf(lastNameError));
        return lastNameError.getText();
    }

    public String getUsernameError() {
        WebDriverWait wait = new WebDriverWait(
            DriverManager.getDriver(), Duration.ofSeconds(10)
        );
        wait.until(ExpectedConditions.visibilityOf(usernameError));
        return usernameError.getText();
    }
}