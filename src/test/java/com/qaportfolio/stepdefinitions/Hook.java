package com.qaportfolio.stepdefinitions;

import com.qaportfolio.utils.BrowserUtils;
import com.qaportfolio.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {

    @Before
    public void setUp() {
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().deleteAllCookies();
    }

    @After
    public void tearDown(Scenario scenario) {
        BrowserUtils.getScreenShotWithCucumber(DriverManager.getDriver(), scenario);
        DriverManager.quitDriver();
    }

}