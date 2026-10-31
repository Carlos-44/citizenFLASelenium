package stepdefs;

import com.citizensfla.app.page_objects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

/**
 * Thread-local WebDriver context shared across all Cucumber step definition
 * classes for a given scenario. A single driver instance is created via
 * {@link #init()} and torn down via {@link #quit()}, called from the
 * {@link CucumberHooks} class (@Before / @After).
 */
public class CucumberDriverContext {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    private static final ThreadLocal<HomePage> HOME_PAGE = new ThreadLocal<>();

    public static void init() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments(
            "--headless",
            "--disable-gpu",
            "--window-size=1920x1080",
            "--no-sandbox",
            "--disable-dev-shm-usage",
            "--remote-allow-origins=*"
        );
        WebDriver driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DRIVER.set(driver);
        HOME_PAGE.set(new HomePage(driver));
    }

    public static WebDriver getDriver() {
        return DRIVER.get();
    }

    public static HomePage getHomePage() {
        return HOME_PAGE.get();
    }

    public static void quit() {
        WebDriver driver = DRIVER.get();
        if (driver != null) {
            driver.quit();
            DRIVER.remove();
            HOME_PAGE.remove();
        }
    }
}
