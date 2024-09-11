package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// Maximize the browser window
		driver.manage().window().maximize();

		// Clear all cookies before running the tests
		driver.manage().deleteAllCookies();

		// Fallback implicit wait in case elements are slow to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Navigate to the website
		driver.get("https://www.citizensfla.com/");

		// Initialize page object
		homePage = new HomePage(driver);

		// Try to click the Claims button and handle any potential errors
		try {
			homePage.clickClaims();
		} catch (Exception e) {
			System.err.println("Failed to load the Claims section.");
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test(priority = 1)
	public void testClickReportAClaim() throws InterruptedException {
		homePage.clickReportAClaim();
		Assert.assertTrue(driver.getPageSource().contains("Report a Claim"), "Failed to verify 'Report a Claim' page.");
	}

	@Test(priority = 2)
	public void testClickSinkholeClaims() {
		homePage.clickSinkholeClaims();
		Assert.assertTrue(driver.getPageSource().contains("Sinkhole Claims"),
				"Failed to verify 'Sinkhole Claims' page.");
	}

	@Test(priority = 3)
	public void testClickLossInspection() {
		homePage.clickLossInspection();
		Assert.assertTrue(driver.getPageSource().contains("Loss Inspection"),
				"Failed to verify 'Loss Inspection' page.");
	}

	@Test(priority = 4)
	public void testClickInsuranceFraud() {
		homePage.clickInsuranceFraud();
		Assert.assertTrue(driver.getPageSource().contains("Insurance Fraud"),
				"Failed to verify 'Insurance Fraud' page.");
	}

	@Test(priority = 5)
	public void testClickContactCitizensFirst() {
		homePage.clickContactCitizensFirst();
		Assert.assertTrue(driver.getPageSource().contains("Contact Citizens First"),
				"Failed to verify 'Contact Citizens First' page.");
	}
}
