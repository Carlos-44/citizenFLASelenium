package com.citizensfla.app.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for elements
	}

	// Locators
	private By firstNameField = By.id("firstName");
	private By lastNameField = By.id("lastName");
	private By userNameField = By.id("userName");
	private By policyNumberField = By.id("policyNumber");
	private By emailField = By.id("emailAddress");
	private By zipCodeField = By.id("postalCode");
	private By termsCheckbox = By.xpath("//span[@role='checkbox']");
	private By signUpButton = By.xpath("//button[@id='signUpButton']");

	// Added an updated locator for policy number error
	private By policyNumberError = By.xpath("//span[@aria-describedby='policyNumber_1440013438']");

	// Actions

	// Method to enter first name
	public void enterFirstName(String firstName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
	}

	// Method to enter last name
	public void enterLastName(String lastName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys(lastName);
	}

	// Method to enter user name
	public void enterUserName(String userName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField)).sendKeys(userName);
	}

	// Method to enter policy number
	public void enterPolicyNumber(String policyNumber) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(policyNumberField)).sendKeys(policyNumber);
	}

	// Method to enter email
	public void enterEmail(String email) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
	}

	// Method to enter ZIP code
	public void enterZipCode(String zipCode) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(zipCodeField)).sendKeys(zipCode);
	}

	// Method to agree to Terms and Conditions
	public void agreeToTerms() {
		wait.until(ExpectedConditions.elementToBeClickable(termsCheckbox)).click();
	}

	// Method to click the Sign Up button
	public void clickSignUp() {
		wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).click();
	}

	// Updated method to check if the Sign Up button is disabled using the 'disabled' attribute
	public boolean isSignUpButtonDisabled() {
		WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(signUpButton));
		// Explicitly check if the button is disabled using the 'disabled' attribute
		return button.getAttribute("disabled") != null;
	}

	// Method to check if the Sign Up button is enabled using JavaScript execution
	public boolean isSignUpButtonDisabledUsingJS() {
		WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(signUpButton));
		// Using JavaScript to check the disabled state
		return (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].disabled;", button);
	}

	// Method to get validation error messages for specific fields
	public String getValidationErrorMessage(String fieldId) {
		WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(fieldId + "-error")));
		return errorElement.getText();
	}

	// Method to get error message for invalid policy number
	public String getPolicyNumberErrorMessage() {
		WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(policyNumberError));
		return errorMessage.getText();
	}
}
