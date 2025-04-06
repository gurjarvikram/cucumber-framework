package utils;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;

public class TestContextSetup {

    public WebDriver driver;
    public String landingPageProductName;

    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;

    public TestContextSetup() throws IOException {
    	
        testBase = new TestBase();
        driver = testBase.WebDriverManager();
        pageObjectManager = new PageObjectManager(driver);
        genericUtils = new GenericUtils(driver);
    }
}
