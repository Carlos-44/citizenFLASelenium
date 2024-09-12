package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.citizensfla.app.page_objects.HomePage;
import com.citizensfla.app.page_objects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class LoginTest {

	WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;

	// Initialize the WebDriver, HomePage, and LoginPage before each test
	@BeforeMethod
	public void setup() {
		WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();

		// Maximize the browser window to fill the screen
		driver.manage().window().maximize();

		// Clear cookies before running the tests
		driver.manage().deleteAllCookies();

		// Navigate to the website
		driver.get("https://www.citizensfla.com/");

		// Initialize page objects
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);

		// Wait for and click on the login button before each test
		homePage.clickLogin(); // Uses the updated clickLogin with explicit wait
	}

	// Clean up after each test by quitting the browser
	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test(priority = 1)
	public void testInvalidLogin() {
		loginPage.enterUsername("invalidUser");
		loginPage.enterPassword("invalidPassword");
		loginPage.clickSubmit();

		// Wait for the "Username or password is incorrect" error message to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement errorMessageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//font[contains(text(),'Username or password is incorrect')]")));

		// Assertion: Check if the error message is correct
		String actualErrorMessage = errorMessageElement.getText();
		String expectedErrorMessage = "Username or password is incorrect.";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message for invalid login is incorrect");
	}

	@Test(priority = 2)
	public void testEmptyUsername() {
		loginPage.enterPassword("validPassword");
		loginPage.clickSubmit();

		// Wait for the "Username required" error message to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement errorMessageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//font[contains(text(),'Username required')]")));

		// Assertion: Check if the error message is correct
		String actualErrorMessage = errorMessageElement.getText();
		String expectedErrorMessage = "Username required. Your username may be your first initial and last name, with no spaces. In some cases, additional numbers may follow your last name.";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
				"Error message for missing username is incorrect");
	}

	@Test(priority = 3)
	public void testEmptyPassword() {
		loginPage.enterUsername("validUser");
		loginPage.clickSubmit();

		// Wait for the error message to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement errorMessageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//font[normalize-space()='Password required.']")));

		// Assertion: Check if the error message is correct
		String actualErrorMessage = errorMessageElement.getText();
		String expectedErrorMessage = "Password required.";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
				"Error message for missing password is incorrect");
	}

	@Test(priority = 4)
	public void testEmptyUsernameAndPassword() {
		loginPage.clickSubmit();

		// Assertion for empty username and password
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//font[normalize-space()='Enter username and password to log in.']")));

		String actualErrorMessage = errorMessageElement.getText();
		String expectedErrorMessage = "Enter username and password to log in.";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message for empty fields is incorrect");
	}
}
