package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.WDListener;

import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Method;

public class AppManager {
    private WebDriver driver;
    public Logger logger = LoggerFactory.getLogger(AppManager.class);
    static String browser = System.getProperty("browser", Browser.CHROME.browserName());

    public WebDriver getDriver() {
        return driver;
    }

//    @BeforeMethod
//    public void setup(Method method) {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        logger.info("Start test --> " + method.getName());
//    }

    @BeforeMethod(alwaysRun = true)
    public void setup() {

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("translate.enabled", false);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--lang=en-US");

      //  driver = new ChromeDriver(options);
        if(browser.equals(Browser.CHROME.browserName())){
            driver = new ChromeDriver();
        } else if (browser.equals(Browser.FIREFOX.browserName())) {
            driver = new FirefoxDriver();
        } else if(browser.equals(Browser.EDGE.browserName())){
            driver = new EdgeDriver();
        };

        driver.manage().window().maximize();

        WebDriverListener webDriverListener = new WDListener();
        driver = new EventFiringDecorator<>(webDriverListener).decorate(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(Method method) {
       if (driver != null)
           driver.quit();
        logger.info("Stop test --> " + method.getName());
    }
}