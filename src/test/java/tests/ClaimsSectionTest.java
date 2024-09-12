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

    // Test for "Report A Claim" button
    @Test(priority = 1)
    public void testClickReportAClaim() {
        // Click Report A Claim button
        homePage.clickReportAClaim();
        
        // Verify the Report A Claim page is displayed
        Assert.assertTrue(homePage.isReportAClaimPage(), "Failed to verify 'Report a Claim' page.");
    }

    // Test for "Sinkhole Claims" button
    @Test(priority = 2)
    public void testClickSinkholeClaims() {
        // Click Sinkhole Claims button
        homePage.clickSinkholeClaims();
        
        // Verify the Sinkhole Claims page is displayed
        Assert.assertTrue(homePage.isSinkholeClaimsPage(), "Failed to verify 'Sinkhole Claims' page.");
    }

    // Test for "Loss Inspection" button
    @Test(priority = 3)
    public void testClickLossInspection() {
        // Click Loss Inspection button
        homePage.clickLossInspection();
        
        // Verify the Loss Inspection page is displayed
        Assert.assertTrue(homePage.isLossInspectionPage(), "Failed to verify 'Loss Inspection' page.");
    }

    // Test for "Insurance Fraud" button
    @Test(priority = 4)
    public void testClickInsuranceFraud() {
        // Click Insurance Fraud button
        homePage.clickInsuranceFraud();
        
        // Verify the Insurance Fraud page is displayed
        Assert.assertTrue(homePage.isInsuranceFraudPage(), "Failed to verify 'Insurance Fraud' page.");
    }

    // Test for "Contact Citizens First" button
    @Test(priority = 5)
    public void testClickContactCitizensFirst() {
        // Click Contact Citizens First button
        homePage.clickContactCitizensFirst();
        
        // Verify the Contact Citizens First page is displayed
        Assert.assertTrue(homePage.isContactCitizensFirstPage(), "Failed to verify 'Contact Citizens First' page.");
    }
}
