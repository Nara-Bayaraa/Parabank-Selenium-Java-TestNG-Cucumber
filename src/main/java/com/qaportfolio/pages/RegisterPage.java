package com.qaportfolio.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qaportfolio.utils.DriverManager;

import net.datafaker.Faker;

public class RegisterPage {

     private Faker faker = new Faker();

@FindBy(xpath = "//a[text()='Register']")
private WebElement registerButton;

@FindBy(id = "customer.firstName")
private WebElement firstNameInput;

@FindBy(id = "customer.lastName")
private WebElement LastNameInput;

@FindBy(id = "customer.address.street")
private WebElement addressInput;

@FindBy(id = "customer.address.city")
private WebElement cityInput;

@FindBy(id = "customer.address.state")
private WebElement stateInput;

@FindBy(id = "customer.address.zipCode")
private WebElement zipCodeInput;

@FindBy(id = "customer.phoneNumber")
private WebElement phoneNumberInput;

@FindBy(id = "customer.ssn")
private WebElement ssnInput;

@FindBy(id = "customer.username")
private WebElement usernameInput;

@FindBy(id = "customer.password")
private WebElement passwordInput;

@FindBy(id = "repeatedPassword")
private WebElement confirmPassInput;

@FindBy(xpath = "//input[@value='Register']")
private WebElement registerFormButton;



public RegisterPage(){
    PageFactory.initElements(DriverManager.getDriver(), this);
}
public void clickRegisterButton(){
    registerButton.click();
}


    
}
