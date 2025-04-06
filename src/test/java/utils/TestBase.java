package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import io.cucumber.java.Scenario;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    private static Properties prop;

    public WebDriver WebDriverManager() throws IOException {
        if (threadDriver.get() == null) {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Global.properties");
            prop = new Properties();
            prop.load(fis);

            String browser = prop.getProperty("browser");
            String url = prop.getProperty("QAUrl");

            switch (browser.toLowerCase()) {
                case "chrome":
                    threadDriver.set(new ChromeDriver());
                    break;
                case "firefox":
                    threadDriver.set(new FirefoxDriver());
                    break;
                case "edge":
                    threadDriver.set(new EdgeDriver());
                    break;
                default:
                    throw new RuntimeException("Unsupported browser: " + browser);
            }

            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            getDriver().manage().window().maximize();
            getDriver().get(url);
        }

        return getDriver();
    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            threadDriver.remove();
        }
    }

    public void takeScreenshot(Scenario scenario) throws IOException {
        if (getDriver() != null) {
            File sourcePath = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", scenario.getName());
        }
    }
}
