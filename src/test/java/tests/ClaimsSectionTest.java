package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
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
        // Setup WebDriver for Edge with headless and remote allow origins options
        WebDriverManager.edgedriver().setup();
        
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920x1080", "--no-sandbox", "--disable-dev-shm-usage", "--remote-allow-origins=*");
        
        driver = new EdgeDriver(options);

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

    @Test(priority = 1)
    public void testClickReportAClaim() {
        homePage.clickReportAClaim();
        String expectedUrl = "https://www.citizensfla.com/report-a-claim";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL did not match after clicking 'Report A Claim'!");
    }

    @Test(priority = 2)
    public void testClickSinkholeClaims() {
        homePage.clickSinkholeClaims();
        String expectedUrl = "https://www.citizensfla.com/sinkhole-claims";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL did not match after clicking 'Sinkhole Claims'!");
    }

    @Test(priority = 3)
    public void testClickLossInspection() {
        homePage.clickLossInspection();
        String expectedUrl = "https://www.citizensfla.com/loss-inspection";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL did not match after clicking 'Loss Inspection'!");
    }

    @Test(priority = 4)
    public void testClickInsuranceFraud() {
        homePage.clickInsuranceFraud();
        String expectedUrl = "https://www.citizensfla.com/insurance-fraud";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL did not match after clicking 'Insurance Fraud'!");
    }

    @Test(priority = 5)
    public void testClickContactCitizensFirst() {
        homePage.clickContactCitizensFirst();
        String expectedUrl = "https://www.citizensfla.com/call-citizens-first";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL did not match after clicking 'Contact Citizens First'!");
    }
}
