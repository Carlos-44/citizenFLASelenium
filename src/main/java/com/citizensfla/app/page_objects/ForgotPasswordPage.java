package com.citizensfla.app.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class ForgotPasswordPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor to initialize driver and wait
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Use explicit wait
    }

    // Locators
    private By usernameField = By.cssSelector("#username");
    private By emailField = By.cssSelector("#email");
    private By submitButton = By.cssSelector("#saveButton");
    private By sectionHeader = By.cssSelector(".sectionHeader");

    // Actions
    public void enterUsername(String username) {
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        usernameInput.sendKeys(username);
    }

    public void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailInput.sendKeys(email);
    }

    public void clickSubmit() {
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitBtn.click();
    }

    public void verifyPageHeader() {
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(sectionHeader));
        String headerText = header.getText();
        if (!headerText.contains("Forgot Username/Password")) {
            throw new AssertionError("Page header does not contain 'Forgot Username/Password'. Actual header: " + headerText);
        }
    }
}
