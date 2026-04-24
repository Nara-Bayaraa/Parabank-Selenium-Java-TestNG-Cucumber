package com.qaportfolio.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


  @CucumberOptions(
    features = "@target/failedTests.txt",
    glue = {"com.qaportfolio.stepdefinitions"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports/rerun-report.html"
    },
    monochrome = true
)
public class ReRunner extends AbstractTestNGCucumberTests {
}  
    

