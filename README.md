# Citizens FLA — Selenium Java Tests

> Selenium WebDriver + TestNG test suite in Java for the public [Citizens Property Insurance](https://www.citizensfla.com) website, covering claims navigation and footer links.

![Tests](https://github.com/Carlos-44/citizenFLASelenium/actions/workflows/test.yml/badge.svg)

## Tech Stack
- **Language:** Java 11+
- **Framework:** Selenium WebDriver 4, TestNG 7
- **Design:** Page Object Model (`src/main/java/.../page_objects/`)
- **Browser:** Microsoft Edge (headless), managed by WebDriverManager
- **Reporting:** ExtentReports (Spark HTML report) through a TestNG listener
- **Build:** Maven
- **CI:** GitHub Actions

## Getting Started

### Prerequisites
- Java 11+ (JDK)
- Maven 3.6+
- Microsoft Edge

### Run Tests
```bash
# Run the full TestNG suite (src/test/java/testng.xml)
mvn test

# Run a single test class
mvn test -Dtest=FooterLinksTest
```

The ExtentReports HTML report is written to `CICD.testReport/`.

## What's Tested
9 tests in 2 classes, run in parallel by class:
- **Claims section** (`ClaimsSectionTest`): Report a Claim, Sinkhole Claims, Loss Inspection, Insurance Fraud and Contact Citizens First each land on the expected URL
- **Footer links** (`FooterLinksTest`): Terms & Conditions, Privacy Policy, Site Map and Accessibility pages load with the expected header

> These tests hit a live third-party website, so content changes or bot protection on the site can cause failures that aren't bugs in the tests.

## CI/CD
Every push and pull request to `main` runs `mvn test` on GitHub Actions (see `.github/workflows/test.yml`):
- Surefire JUnit XML is published as a GitHub Check through [dorny/test-reporter](https://github.com/dorny/test-reporter)
- The Extent HTML report and TestNG output are uploaded as artifacts for 14 days

## Author
Carlos Ozoria — [LinkedIn](https://www.linkedin.com/in/carlos-ozoria-0a292030b)
