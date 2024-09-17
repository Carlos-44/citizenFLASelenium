package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportListener implements ITestListener {

    private ExtentSparkReporter spark;
    private ExtentReports extent;
    private ExtentTest test;
    private WebDriver driver;  // Assuming the WebDriver will be set dynamically

    @Override
    public void onStart(ITestContext context) {
        // Generate a dynamic path for reports with timestamp
        String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
        String reportPath = System.getProperty("user.dir") + "/reports/ExtentSparkReport_" + timestamp + ".html";

        spark = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(spark);

        // Set additional information for the report (optional)
        extent.setSystemInfo("Test Suite", context.getSuite().getName());
        extent.setSystemInfo("Test Environment", "Production");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());

        // Log parameters if any
        Object[] params = result.getParameters();
        if (params.length > 0) {
            test.log(Status.INFO, "Test parameters: " + params.toString());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
        test.log(Status.FAIL, result.getThrowable());
    
// Capture screenshot for the failed test
if (driver != null) {
    String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
    test.addScreenCaptureFromPath(screenshotPath);  // No try-catch needed
} else {
    test.log(Status.WARNING, "WebDriver instance was null, could not capture screenshot.");
}

    }
    
    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    // Method to capture screenshot
    public String captureScreenshot(String testName) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
        String screenshotDir = System.getProperty("user.dir") + "/screenshots/";
        String screenshotPath = screenshotDir + testName + "_" + timestamp + ".png";

        // Create the screenshot directory if it doesn't exist
        File dir = new File(screenshotDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshot.toPath(), Paths.get(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }

    // Method to set the WebDriver dynamically
    public void setWebDriver(WebDriver driver) {
        this.driver = driver;
    }
}
