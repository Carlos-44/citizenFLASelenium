package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ClaimsSectionSteps {

    @And("I have opened the Claims navigation menu")
    public void iHaveOpenedTheClaimsNavigationMenu() {
        CucumberDriverContext.getHomePage().clickClaims();
    }

    @When("I click the {string} menu item")
    public void iClickTheMenuItem(String menuItem) {
        switch (menuItem) {
            case "Report a Claim":
                CucumberDriverContext.getHomePage().clickReportAClaim();
                break;
            case "Sinkhole Claims":
                CucumberDriverContext.getHomePage().clickSinkholeClaims();
                break;
            case "Loss Inspection":
                CucumberDriverContext.getHomePage().clickLossInspection();
                break;
            case "Insurance Fraud":
                CucumberDriverContext.getHomePage().clickInsuranceFraud();
                break;
            case "Contact Citizens First":
                CucumberDriverContext.getHomePage().clickContactCitizensFirst();
                break;
            default:
                throw new IllegalArgumentException("Unknown menu item: " + menuItem);
        }
    }

    @Then("the current URL should be {string}")
    public void theCurrentURLShouldBe(String expectedUrl) {
        Assert.assertEquals(
            CucumberDriverContext.getDriver().getCurrentUrl(),
            expectedUrl,
            "URL did not match — expected: " + expectedUrl
        );
    }
}
