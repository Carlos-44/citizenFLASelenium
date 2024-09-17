package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
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

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        WebDriverManager.edgedriver().setup();

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920x1080", "--no-sandbox", "--disable-dev-shm-usage", "--remote-allow-origins=*");

        driver = new EdgeDriver(options);
        driver.manage().deleteAllCookies();
        driver.get("https://www.citizensfla.com/");

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        homePage.clickLogin();
    }

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

        WebElement errorMessageElement = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//font[contains(text(),'Username or password is incorrect')]")));

        String actualErrorMessage = errorMessageElement.getText();
        String expectedErrorMessage = "Username or password is incorrect.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
                "Error message for invalid login is incorrect.");
    }

    @Test(priority = 2)
    public void testEmptyUsername() {
        loginPage.enterPassword("validPassword");
        loginPage.clickSubmit();

        WebElement errorMessageElement = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//font[contains(text(),'Username required')]")));

        String actualErrorMessage = errorMessageElement.getText();
        String expectedErrorMessage = "Username required. Your username may be your first initial and last name, with no spaces. In some cases, additional numbers may follow your last name.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
                "Error message for missing username is incorrect.");
    }

    @Test(priority = 3)
    public void testEmptyPassword() {
        loginPage.enterUsername("validUser");
        loginPage.clickSubmit();

        WebElement errorMessageElement = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//font[normalize-space()='Password required.']")));

        String actualErrorMessage = errorMessageElement.getText();
        String expectedErrorMessage = "Password required.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
                "Error message for missing password is incorrect.");
    }

    @Test(priority = 4)
    public void testEmptyUsernameAndPassword() {
        loginPage.clickSubmit();

        WebElement errorMessageElement = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//font[normalize-space()='Enter username and password to log in.']")));

        String actualErrorMessage = errorMessageElement.getText();
        String expectedErrorMessage = "Enter username and password to log in.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
                "Error message for missing username and password is incorrect.");
    }
}
