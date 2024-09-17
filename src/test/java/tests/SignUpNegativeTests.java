package tests;

import com.citizensfla.app.page_objects.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
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
        // Setup EdgeDriver with headless options for CI/CD
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920x1080", "--no-sandbox", "--disable-dev-shm-usage", "--remote-allow-origins=*");
        driver = new EdgeDriver(options);

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

    @Test(priority = 1)
    public void testSubmitWithoutAgreeingToTerms() {
        signUpPage.enterFirstName("John");
        signUpPage.enterLastName("Doe");
        signUpPage.enterUserName("john_doe");
        signUpPage.enterPolicyNumber("123456789");
        signUpPage.enterEmail("john.doe@example.com");
        signUpPage.enterZipCode("12345");
    
        // Do NOT check the "Agree to Terms" checkbox
        Assert.assertTrue(signUpPage.isSignUpButtonDisabled(),
                "Sign-Up button should be disabled if terms are not accepted.");
    }

    @Test(priority = 2)
    public void testInvalidEmailFormat() {
        signUpPage.enterFirstName("John");
        signUpPage.enterLastName("Doe");
        signUpPage.enterUserName("john_doe");
        signUpPage.enterPolicyNumber("12345678");
        signUpPage.enterEmail("invalid-email");
        signUpPage.enterZipCode("12345");

        signUpPage.agreeToTerms();

        Assert.assertTrue(signUpPage.isSignUpButtonDisabled(),
                "Sign-Up button should be disabled when email format is invalid.");
        Assert.assertTrue(signUpPage.isSignUpButtonDisabledUsingJS(),
                "Sign-Up button should be disabled when email format is invalid (JS Check).");
    }

    @Test(priority = 3)
    public void testInvalidZipCode() {
        signUpPage.enterFirstName("John");
        signUpPage.enterLastName("Doe");
        signUpPage.enterUserName("john_doe");
        signUpPage.enterPolicyNumber("12345678");
        signUpPage.enterEmail("john.doe@example.com");
        signUpPage.enterZipCode("abcd");

        signUpPage.agreeToTerms();

        Assert.assertTrue(signUpPage.isSignUpButtonDisabled(),
                "Sign-Up button should be disabled when ZIP code format is invalid.");
        Assert.assertTrue(signUpPage.isSignUpButtonDisabledUsingJS(),
                "Sign-Up button should be disabled when ZIP code format is invalid (JS Check).");
    }

    @Test(priority = 4)
    public void testInvalidPolicyNumber() {
        signUpPage.enterFirstName("John");
        signUpPage.enterLastName("Doe");
        signUpPage.enterUserName("john_doe");
        signUpPage.enterPolicyNumber("11111111");
        signUpPage.enterEmail("john.doe@example.com");
        signUpPage.enterZipCode("12345");

        signUpPage.agreeToTerms();

        Assert.assertTrue(signUpPage.isSignUpButtonDisabled(),
                "Sign-Up button should be disabled when policy number is invalid.");
        Assert.assertTrue(signUpPage.isSignUpButtonDisabledUsingJS(),
                "Sign-Up button should be disabled when policy number is invalid (JS Check).");
    }
}
