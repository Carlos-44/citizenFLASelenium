package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
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

    WebDriver driver;
    HomePage homePage;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
    	WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
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

    // Test clicking the "Terms & Conditions" link
    @Test(priority = 1)
    public void testClickTermsAndConditions() {
        homePage.clickTermsAndConditions();
        wait.until(ExpectedConditions.titleContains("Terms & Conditions"));
        String expectedHeader = "Terms & Conditions";
        Assert.assertTrue(driver.getPageSource().contains(expectedHeader), "Incorrect Terms & Conditions page.");
    }

    // Test clicking the "Privacy Policy" link
    @Test(priority = 2)
    public void testClickPrivacyPolicy() {
        homePage.clickPrivacyPolicy();
        wait.until(ExpectedConditions.titleContains("Privacy Policy"));
        String expectedHeader = "Privacy Policy";
        Assert.assertTrue(driver.getPageSource().contains(expectedHeader), "Incorrect Privacy Policy page.");
    }

    // Test clicking the "Site Map" link
    @Test(priority = 3)
    public void testClickSiteMap() {
        homePage.clickSiteMap();
        wait.until(ExpectedConditions.titleContains("Site Map"));
        String expectedHeader = "Site Map";
        Assert.assertTrue(driver.getPageSource().contains(expectedHeader), "Incorrect Site Map page.");
    }

    // Test clicking the "Accessibility" link
    @Test(priority = 4)
    public void testClickAccessibility() {
        homePage.clickAccessibility();
        wait.until(ExpectedConditions.titleContains("Accessibility"));
        String expectedHeader = "Accessibility";
        Assert.assertTrue(driver.getPageSource().contains(expectedHeader), "Incorrect Accessibility page.");
    }
}
