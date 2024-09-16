package tests;

import com.citizensfla.app.page_objects.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SignUpNegativeTests {

	WebDriver driver;
	SignUpPage signUpPage;

	@BeforeMethod
	public void setup() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://customer.citizensfla.com/account-management/signup-enrollment");

		signUpPage = new SignUpPage(driver);
	}

	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	// Test case: Submitting without agreeing to Terms and Conditions
	@Test(priority = 1)
	public void testSubmitWithoutAgreeingToTerms() {
		// Fill in the form fields
		signUpPage.enterFirstName("John");
		signUpPage.enterLastName("Doe");
		signUpPage.enterUserName("john_doe");
		signUpPage.enterPolicyNumber("123456789");
		signUpPage.enterEmail("john.doe@example.com");
		signUpPage.enterZipCode("12345");
	
		// Do NOT check the "Agree to Terms" checkbox
		// Do NOT attempt to click the Sign-Up button, since the goal is to test if it remains disabled
	
		// Verify the Sign-Up button is disabled due to unaccepted terms
		Assert.assertTrue(signUpPage.isSignUpButtonDisabled(),
				"Sign-Up button should be disabled if terms are not accepted.");
	}

	// Test case: Invalid email format
	@Test(priority = 2)
	public void testInvalidEmailFormat() {
		signUpPage.enterFirstName("John");
		signUpPage.enterLastName("Doe");
		signUpPage.enterUserName("john_doe");
		signUpPage.enterPolicyNumber("12345678"); // Assuming valid 8-digit policy number
		signUpPage.enterEmail("invalid-email"); // Invalid email format
		signUpPage.enterZipCode("12345");

		// Agree to terms
		signUpPage.agreeToTerms();

		// Check that the "Sign Up" button is disabled (both ways)
		Assert.assertTrue(signUpPage.isSignUpButtonDisabled(),
				"Sign-Up button should be disabled when email format is invalid.");
		Assert.assertTrue(signUpPage.isSignUpButtonDisabledUsingJS(),
				"Sign-Up button should be disabled when email format is invalid (JS Check).");
	}

	// Test case: Invalid ZIP code format
	@Test(priority = 3)
	public void testInvalidZipCode() {
		signUpPage.enterFirstName("John");
		signUpPage.enterLastName("Doe");
		signUpPage.enterUserName("john_doe");
		signUpPage.enterPolicyNumber("12345678");
		signUpPage.enterEmail("john.doe@example.com");
		signUpPage.enterZipCode("abcd"); // Invalid ZIP code format

		// Agree to terms
		signUpPage.agreeToTerms();

		// Check that the "Sign Up" button is disabled (both ways)
		Assert.assertTrue(signUpPage.isSignUpButtonDisabled(),
				"Sign-Up button should be disabled when ZIP code format is invalid.");
		Assert.assertTrue(signUpPage.isSignUpButtonDisabledUsingJS(),
				"Sign-Up button should be disabled when ZIP code format is invalid (JS Check).");
	}

	// Test case: Invalid policy number
	@Test(priority = 4)
	public void testInvalidPolicyNumber() {
		signUpPage.enterFirstName("John");
		signUpPage.enterLastName("Doe");
		signUpPage.enterUserName("john_doe");
		signUpPage.enterPolicyNumber("11111111"); // Invalid Policy Number (assuming invalid)
		signUpPage.enterEmail("john.doe@example.com");
		signUpPage.enterZipCode("12345");

		// Agree to terms
		signUpPage.agreeToTerms();

		// Check that the "Sign Up" button is disabled (both ways)
		Assert.assertTrue(signUpPage.isSignUpButtonDisabled(),
				"Sign-Up button should be disabled when policy number is invalid.");
		Assert.assertTrue(signUpPage.isSignUpButtonDisabledUsingJS(),
				"Sign-Up button should be disabled when policy number is invalid (JS Check).");
	}
}
