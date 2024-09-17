package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.citizensfla.app.page_objects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class FooterLinksTest {

    private WebDriver driver;
    private HomePage homePage;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        WebDriverManager.edgedriver().setup();

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920x1080", "--no-sandbox", "--disable-dev-shm-usage", "--remote-allow-origins=*");

        driver = new EdgeDriver(options);
        driver.manage().deleteAllCookies();
        driver.get("https://www.citizensfla.com/");
        homePage = new HomePage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1)
    public void testClickTermsAndConditions() {
        homePage.clickTermsAndConditions();
        wait.until(ExpectedConditions.titleContains("Terms & Conditions"));
        String expectedHeader = "Terms & Conditions";
        Assert.assertTrue(driver.getPageSource().contains(expectedHeader),
            "Terms & Conditions page did not load as expected.");
    }

    @Test(priority = 2)
    public void testClickPrivacyPolicy() {
        homePage.clickPrivacyPolicy();
        wait.until(ExpectedConditions.titleContains("Privacy Policy"));
        String expectedHeader = "Privacy Policy";
        Assert.assertTrue(driver.getPageSource().contains(expectedHeader),
            "Privacy Policy page did not load as expected.");
    }

    @Test(priority = 3)
    public void testClickSiteMap() {
        homePage.clickSiteMap();
        wait.until(ExpectedConditions.titleContains("Site Map"));
        String expectedHeader = "Site Map";
        Assert.assertTrue(driver.getPageSource().contains(expectedHeader),
            "Site Map page did not load as expected.");
    }

    @Test(priority = 4)
    public void testClickAccessibility() {
        homePage.clickAccessibility();
        wait.until(ExpectedConditions.titleContains("Accessibility"));
        String expectedHeader = "Accessibility";
        Assert.assertTrue(driver.getPageSource().contains(expectedHeader),
            "Accessibility page did not load as expected.");
    }
}
