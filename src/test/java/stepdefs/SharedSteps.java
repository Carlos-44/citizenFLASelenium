package stepdefs;

import io.cucumber.java.en.Given;

/**
 * Shared step definitions used across multiple feature files.
 * Cucumber's glue path picks up all step classes in the stepdefs package,
 * so a step defined once here is available to every scenario.
 */
public class SharedSteps {

    @Given("I am on the Citizens Florida home page")
    public void iAmOnTheCitizensFloridaHomePage() {
        CucumberDriverContext.getDriver().get("https://www.citizensfla.com/");
    }
}
