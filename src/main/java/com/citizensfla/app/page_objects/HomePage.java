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
    private By lossInspectionButton = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/header[1]/div[1]/div[1]/div[2]/div[2]/nav[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[5]/ul[1]/li[1]/a[1]/span[1]");
    private By insuranceFraudButton = By.xpath("//a[@class='menu-level-1']//span[contains(text(),'Insurance Fraud')]");
    private By contactCitizensFirstButton = By.xpath("//a[@class='menu-level-1']//span[contains(text(),'Contact Citizens First')]");
    private By termsAndConditionsLink = By.xpath("//span[normalize-space()='Terms & Conditions']");
    private By privacyPolicyLink = By.xpath("//span[normalize-space()='Privacy Policy']");
    private By siteMapLink = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/footer[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[3]/span[1]");
    private By accessibilityLink = By.xpath("//span[normalize-space()='Accessibility']");
    private By loginButton = By.xpath("//a[normalize-space()='Login']");

    
    // Method to click on the claims button
    public void clickClaims() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(claimsButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(claimsButton)).click();
        System.out.println("Claims button clicked successfully.");
    }

    // Method to click on the report a claim button
    public void clickReportAClaim() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(reportAClaimButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element); // Using JS to force click
        System.out.println("Report A Claim button clicked successfully.");
    }


    // Method to click on the sinkhole claims button
    public void clickSinkholeClaims() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(sinkholeClaimsButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(sinkholeClaimsButton)).click();
        System.out.println("Sinkhole Claims button clicked successfully.");
    }

    // Method to click on the loss inspection button
    public void clickLossInspection() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(lossInspectionButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(lossInspectionButton)).click();
        System.out.println("Loss Inspection button clicked successfully.");
    }

    // Method to click on the insurance fraud button
    public void clickInsuranceFraud() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(insuranceFraudButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(insuranceFraudButton)).click();
        System.out.println("Insurance Fraud button clicked successfully.");
    }

    // Method to click on the contact citizens first button
    public void clickContactCitizensFirst() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(contactCitizensFirstButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(contactCitizensFirstButton)).click();
        System.out.println("Contact Citizens First button clicked successfully.");
    }

    // Method to click on the terms and conditions link
    public void clickTermsAndConditions() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(termsAndConditionsLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(termsAndConditionsLink)).click();
        System.out.println("Terms and Conditions link clicked successfully.");
    }

    // Method to click on the privacy policy link
    public void clickPrivacyPolicy() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(privacyPolicyLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(privacyPolicyLink)).click();
        System.out.println("Privacy Policy link clicked successfully.");
    }

    // Method to click on the site map link
    public void clickSiteMap() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(siteMapLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(siteMapLink)).click();
        System.out.println("Site Map link clicked successfully.");
    }

    // Method to click on the accessibility link
    public void clickAccessibility() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(accessibilityLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(accessibilityLink)).click();
        System.out.println("Accessibility link clicked successfully.");
    }

    // Method to click on the login button
    public void clickLogin() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        System.out.println("Login button clicked successfully.");
    }

    // Verify headers
    public boolean isReportAClaimPage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(reportAClaimButton)).isDisplayed();
    }

    public boolean isSinkholeClaimsPage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(sinkholeClaimsButton)).isDisplayed();
    }

    public boolean isLossInspectionPage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lossInspectionButton)).isDisplayed();
    }

    public boolean isInsuranceFraudPage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(insuranceFraudButton)).isDisplayed();
    }

    public boolean isContactCitizensFirstPage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(contactCitizensFirstButton)).isDisplayed();
    }
}
