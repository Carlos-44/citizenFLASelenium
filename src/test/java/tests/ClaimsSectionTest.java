package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.citizensfla.app.page_objects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class ClaimsSectionTest {

    WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void setup() {
        // Setup WebDriver for Edge
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();

        // Browser configuration
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to Citizens website
        driver.get("https://www.citizensfla.com/");

        // Initialize HomePage object
        homePage = new HomePage(driver);
        
        // Open the Claims section before each test
        homePage.clickClaims();
    }

    @AfterMethod
    public void teardown() {
        // Quit the driver after each test
        if (driver != null) {
            driver.quit();
        }
    }

    // Test for "Report A Claim" button - URL Assertion
    @Test(priority = 1)
    public void testClickReportAClaim() {
        // Click Report A Claim button
        homePage.clickReportAClaim();
    
        // Verify the URL is correct
        String expectedUrl = "https://www.citizensfla.com/report-a-claim";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL did not match after clicking 'Report A Claim'!");
    }

    // Test for "Sinkhole Claims" button - URL Assertion
    @Test(priority = 2)
    public void testClickSinkholeClaims() {
        // Click Sinkhole Claims button
        homePage.clickSinkholeClaims();
    
        // Verify the URL is correct
        String expectedUrl = "https://www.citizensfla.com/sinkhole-claims";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL did not match after clicking 'Sinkhole Claims'!");
    }

    // Test for "Loss Inspection" button - URL Assertion
    @Test(priority = 3)
    public void testClickLossInspection() {
        // Click Loss Inspection button
        homePage.clickLossInspection();
    
        // Verify the URL is correct
        String expectedUrl = "https://www.citizensfla.com/loss-inspection";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL did not match after clicking 'Loss Inspection'!");
    }

    // Test for "Insurance Fraud" button - URL Assertion
    @Test(priority = 4)
    public void testClickInsuranceFraud() {
        // Click Insurance Fraud button
        homePage.clickInsuranceFraud();
    
        // Verify the URL is correct
        String expectedUrl = "https://www.citizensfla.com/insurance-fraud";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL did not match after clicking 'Insurance Fraud'!");
    }

    // Test for "Contact Citizens First" button - URL Assertion
    @Test(priority = 5)
    public void testClickContactCitizensFirst() {
        // Click Contact Citizens First button
        homePage.clickContactCitizensFirst();
    
        // Verify the URL is correct
        String expectedUrl = "https://www.citizensfla.com/call-citizens-first";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL did not match after clicking 'Contact Citizens First'!");
    }
}
