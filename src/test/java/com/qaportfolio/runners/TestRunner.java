package com.qaportfolio.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.qaportfolio.stepdefinitions"},
    tags = "@smoke or @regression",
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json",
        "rerun:target/failedTests.txt"
    },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}