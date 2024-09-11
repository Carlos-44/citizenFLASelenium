package com.citizensfla.app.page_objects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
	}

	// Locators
	private By usernameField = By.id("j_username");
	private By passwordField = By.id("j_password");
	private By loginButton = By.id("loginAction");
	private By submitButton = By.xpath("//input[@value='Submit']");

	// Actions

	// Method to enter the username
	public void enterUsername(String username) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
	}

	// Method to enter the password
	public void enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
	}

	// Method to click on the login button with explicit wait
	public void clickLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
	}

	// Method to click the Submit button with explicit wait
	public void clickSubmit() {
		wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
	}
}
