package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;

/**
 * Global Cucumber lifecycle hooks that initialise and tear down the shared
 * WebDriver context for every scenario.
 */
public class CucumberHooks {

    @Before
    public void setUp() {
        CucumberDriverContext.init();
    }

    @After
    public void tearDown() {
        CucumberDriverContext.quit();
    }
}
