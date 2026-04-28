

```markdown
# Parabank Selenium Java TestNG Cucumber Framework

A hybrid BDD automation framework for testing the Parabank banking application. Built with Selenium 4, TestNG, Cucumber, and the Page Object Model pattern.

Live application under test: https://parabank.parasoft.com/parabank/index.htm

## Why this project

I built this framework to demonstrate enterprise level test automation patterns including scenario level state isolation, externalized configuration, and data driven test generation. It tests real production flows on the Parabank demo banking application including authentication, form validation, and registration.

## Tech stack

| Tool | Version | Purpose |
|---|---|---|
| Java | 17 | Programming language |
| Maven | 3.9 | Build tool |
| Selenium WebDriver | 4.18 | Browser automation |
| TestNG | 7.9 | Test runner |
| Cucumber | 7.15 | BDD framework with Gherkin |
| WebDriverManager | 5.7 | Automatic driver setup |
| DataFaker | 2.1 | Test data generation |
| ExtentReports | 5.1 | HTML reporting |
| Log4j2 | 2.24.3 | Logging |

## Skills demonstrated

- Test automation architecture design
- Page Object Model with Page Factory
- BDD with Cucumber and Gherkin
- Scenario isolation through Cucumber Hooks
- Test data generation with DataFaker
- Tag based test execution for smoke and regression suites
- Failed test rerun mechanism
- HTML reporting with Cucumber and ExtentReports
- Externalized configuration through properties files

## Framework architecture

The framework follows separation of concerns with four core layers.

**Pages layer.** Contains element locators and user interactions for each page. LoginPage and RegisterPage.

**Step definitions layer.** Maps Gherkin steps to Java methods and coordinates test actions. LoginSteps, RegisterSteps, and Hook.

**Utilities layer.** Configuration reading, driver management, test data generation, browser helpers. ConfigReader, DriverManager, TestDataFactory, BrowserUtils.

**Runners layer.** TestNG entry points for Cucumber execution. TestRunner for full suite, ReRunner for failed tests only.

## Key design patterns

**Page Object Model.** Each page is a class with locators and actions, keeping test logic separate from UI implementation.

**Factory Pattern.** TestDataFactory generates realistic test data through static methods, hiding DataFaker behind a clean interface.

**Singleton Driver.** DriverManager creates one WebDriver instance per test session using a static singleton, ensuring consistent driver access across page objects and step definitions.

**Declarative BDD.** Feature files describe behavior in business language, not UI interactions. Expected messages live in a properties file, not the feature file.

**Hooks lifecycle.** Hook class uses Before and After annotations to ensure scenario isolation by clearing cookies, capturing screenshots on failure, and quitting the driver. Prevents test pollution and guarantees reliable results regardless of execution order.

## Test coverage

9 scenarios across 2 feature files.

**Login flows.** Successful login, empty credentials, empty username, empty password, invalid credentials.

**Registration flows.** Successful registration with randomly generated data, empty first name, empty last name, existing username.

**Tags.** `@smoke` for critical paths, `@regression` for full coverage.

## Project structure

```
src/main/java/com/qaportfolio
├── pages
│   ├── LoginPage.java
│   └── RegisterPage.java
└── utils
    ├── ConfigReader.java
    ├── DriverManager.java
    ├── TestDataFactory.java
    └── BrowserUtils.java

src/main/resources
└── configuration.properties

src/test/java/com/qaportfolio
├── runners
│   ├── TestRunner.java
│   └── ReRunner.java
└── stepdefinitions
    ├── Hook.java
    ├── LoginSteps.java
    └── RegisterSteps.java

src/test/resources/features
├── login.feature
└── register.feature
```

## How to run

**Prerequisites:** Java 17 installed, Maven 3.9 or higher, Google Chrome installed.

Clone the repo:

```bash
git clone https://github.com/Nara-Bayaraa/Parabank-Selenium-Java-TestNG-Cucumber.git
cd Parabank-Selenium-Java-TestNG-Cucumber
```

Run all tests:

```bash
mvn clean test
```

Run only smoke tests:

```bash
mvn clean test -Dcucumber.filter.tags="@smoke"
```

Run only regression tests:

```bash
mvn clean test -Dcucumber.filter.tags="@regression"
```

Run with a different browser:

```bash
mvn clean test -Dbrowser=firefox
mvn clean test -Dbrowser=edge
```

Rerun only failed tests from last run:

```bash
mvn test -Dtest=ReRunner
```

## Reports

After a test run, reports are available at:

| Report | Path |
|---|---|
| HTML report | `target/cucumber-reports/cucumber.html` |
| JSON report | `target/cucumber-reports/cucumber.json` |
| Failed scenarios | `target/failedTests.txt` |
| Screenshots | `target/screenshots/` |
| Logs | `logs/test-execution.log` |

## Configuration

Test data, URLs, and expected error messages live in `src/main/resources/configuration.properties`. Update values there to point the tests at a different environment without changing code.

```properties
baseUrl=https://parabank.parasoft.com/parabank/index.htm
browser=chrome
explicitWait=10
```

## Test data management

Realistic test data is generated on the fly using DataFaker through the TestDataFactory utility. Every run uses fresh, unique data for registration flows, preventing test data conflicts on a shared demo environment.

Expected error messages and URLs are externalized to the properties file. This keeps feature files business readable and makes the framework easy to maintain when UI copy changes.

## Author

Nara Bayaraa — QA Automation Engineer based in Chicago, IL

- GitHub: https://github.com/Nara-Bayaraa
- LinkedIn: https://linkedin.com/in/Nara-Bayaraa
- Email: narab.qa@gmail.com

## License

This project is for portfolio and educational purposes.
