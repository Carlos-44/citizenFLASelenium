package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class FooterLinksSteps {

    @When("I click the {string} footer link")
    public void iClickTheFooterLink(String linkName) {
        switch (linkName) {
            case "Terms & Conditions":
                CucumberDriverContext.getHomePage().clickTermsAndConditions();
                break;
            case "Privacy Policy":
                CucumberDriverContext.getHomePage().clickPrivacyPolicy();
                break;
            case "Site Map":
                CucumberDriverContext.getHomePage().clickSiteMap();
                break;
            case "Accessibility":
                CucumberDriverContext.getHomePage().clickAccessibility();
                break;
            default:
                throw new IllegalArgumentException("Unknown footer link: " + linkName);
        }
    }

    @Then("the page title should contain {string}")
    public void thePageTitleShouldContain(String expectedTitle) {
        WebDriverWait wait = new WebDriverWait(CucumberDriverContext.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.titleContains(expectedTitle));
        Assert.assertTrue(
            CucumberDriverContext.getDriver().getTitle().contains(expectedTitle),
            "Expected page title to contain '" + expectedTitle + "' but was: "
                + CucumberDriverContext.getDriver().getTitle()
        );
    }

    @And("the page source should contain {string}")
    public void thePageSourceShouldContain(String expectedText) {
        Assert.assertTrue(
            CucumberDriverContext.getDriver().getPageSource().contains(expectedText),
            "Expected page source to contain '" + expectedText + "'"
        );
    }
}
