package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * TestNG entry point for Cucumber BDD tests.
 *
 * Extend AbstractTestNGCucumberTests so that TestNG discovers and runs every
 * Cucumber scenario as an individual TestNG test method.
 *
 * Options:
 *   features  — path to the .feature files
 *   glue      — package(s) containing step definitions and hooks
 *   plugin    — reporting plugins (pretty console, HTML report, JSON for CI)
 */
@CucumberOptions(
    features = "src/test/resources/features",
    glue     = { "stepdefs" },
    plugin   = {
        "pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json"
    },
    monochrome = true
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
