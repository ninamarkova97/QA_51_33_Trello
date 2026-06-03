package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Method;

public class AppManager {
    private WebDriver driver;
    public Logger logger = LoggerFactory.getLogger(AppManager.class);

    public WebDriver getDriver() {
        return driver;
    }

//    @BeforeMethod
//    public void setup(Method method) {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        logger.info("Start test --> " + method.getName());
//    }

    @BeforeMethod
    public void setup() {

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("translate.enabled", false);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--lang=en-US");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterMethod(enabled = false)
    public void tearDown(Method method) {
        if (driver != null)
            driver.quit();
        logger.info("Stop test --> " + method.getName());
    }
}