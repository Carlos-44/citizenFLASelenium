package com.citizensfla.app.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased wait time to 20 seconds
	}

	// Locators
	private By claimsButton = By.id("siteNavModalBtn_menu_2");
	private By reportAClaimButton = By.xpath("//a[@class='menu-level-1']//span[contains(text(),'Report a Claim')]");
	private By sinkholeClaimsButton = By.xpath("//a[@class='menu-level-1']//span[contains(text(),'Sinkhole Claims')]");
	private By lossInspectionButton = By.xpath("//a[@class='menu-level-1']//span[contains(text(),'Loss Inspection')]");
	private By insuranceFraudButton = By.xpath("//a[@class='menu-level-1']//span[contains(text(),'Insurance Fraud')]");
	private By contactCitizensFirstButton = By
			.xpath("//a[@class='menu-level-1']//span[contains(text(),'Contact Citizens First')]");
	private By termsAndConditionsLink = By.cssSelector("a[href*='terms-and-conditions']");
	private By privacyPolicyLink = By.cssSelector("a[href*='privacy-policy']");
	private By siteMapLink = By.cssSelector("a[href*='site-map']");
	private By accessibilityLink = By.cssSelector("a[href*='accessibility']");
	private By loginButton = By.id("loginAction");

	// Generalized method to scroll, wait for visibility, and click on the element
	private void clickElementWithScroll(By locator) {
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); // Scroll to
																										// element
			wait.until(ExpectedConditions.elementToBeClickable(locator)).click(); // Wait for the element to be
																					// clickable and click
			System.out.println("Successfully clicked the element: " + locator);
		} catch (Exception e) {
			System.err.println("Failed to click the element: " + locator);
			e.printStackTrace();
		}
	}

	// Actions
	public void clickClaims() {
		clickElementWithScroll(claimsButton);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(), 'Claims')]"))); // Ensure
																													// the
																													// section
																													// is
																													// loaded
		System.out.println("Claims section loaded successfully.");
	}

	public void clickReportAClaim() {
		clickElementWithScroll(reportAClaimButton);
	}

	public void clickSinkholeClaims() {
		clickElementWithScroll(sinkholeClaimsButton);
	}

	public void clickLossInspection() {
		clickElementWithScroll(lossInspectionButton);
	}

	public void clickInsuranceFraud() {
		clickElementWithScroll(insuranceFraudButton);
	}

	public void clickContactCitizensFirst() {
		clickElementWithScroll(contactCitizensFirstButton);
	}

	// Footer links actions
	public void clickTermsAndConditions() {
		clickElementWithScroll(termsAndConditionsLink);
	}

	public void clickPrivacyPolicy() {
		clickElementWithScroll(privacyPolicyLink);
	}

	public void clickSiteMap() {
		clickElementWithScroll(siteMapLink);
	}

	public void clickAccessibility() {
		clickElementWithScroll(accessibilityLink);
	}

	// Method to click on the login button
	public void clickLogin() {
		clickElementWithScroll(loginButton);
		System.out.println("Login button clicked successfully.");
	}
}
