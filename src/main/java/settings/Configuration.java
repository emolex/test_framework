package settings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import settings.enums.BrowserEnum;
import settings.listeners.WebDriverEventListenerRegister;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static settings.enums.BrowserEnum.FIREFOX;
import static settings.jsonData.Json_Properties.gridUrl;
import static settings.jsonData.Json_Properties.isRemote;

public class Configuration {

    private static WebDriver driver;
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<BrowserEnum> browserTypeThreadLocal = new ThreadLocal<>();

    public Configuration(WebDriver driver) {
        Configuration.driver = driver;
    }

    public static void browserPicker (BrowserEnum browser) throws MalformedURLException {

        if (!isRemote) {
            switch (browser) {
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    webDriverThreadLocal.set(driver = new FirefoxDriver());
                    break;
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    webDriverThreadLocal.set(driver = new ChromeDriver());
                    break;
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                default:
                    System.out.println("U PICKED INVALID BROWSER. PLEASE TYPE: 'FIREFOX', 'CHROME' or 'EDGE'");
            }
        } else {
            switch (browser) {
                case FIREFOX:
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setCapability("browserName", "firefox");
                    /**For more capabilities visit: https://selenium.dev/selenium/docs/api/java/org/openqa/selenium/firefox/FirefoxOptions.html */
                    driver = new RemoteWebDriver(new URL(gridUrl), firefoxOptions);
                    break;
                case CHROME:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setCapability("browserName", "chrome");
                    driver = new RemoteWebDriver(new URL(gridUrl), chromeOptions);
                    break;
                case EDGE:
//                    WebDriverManager.edgedriver().setup();
//                    driver = new EdgeDriver();
                default:
                    System.out.println("U PICKED INVALID BROWSER. PLEASE TYPE: 'FIREFOX', 'CHROME' or 'EDGE'");
            }
        }
        driver = WebDriverEventListenerRegister.registerWebDriverListener(driver);

        browserTypeThreadLocal.set(browser);

        driver.manage().window().maximize();
         webDriverThreadLocal.set(driver);
    }

    public static WebDriver getWebdriver () {
        if (webDriverThreadLocal.get() == null) {
            throw new IllegalStateException("WebDriver Instance was null! Please create instance of WebDriver using setWebDriver!");
        }
        return webDriverThreadLocal.get();
    }

    public void closeRunner() {
        webDriverThreadLocal.get().close();

        if (!browserTypeThreadLocal.get().equals(FIREFOX)) {
            webDriverThreadLocal.get().quit();
        }
        webDriverThreadLocal.remove();
        browserTypeThreadLocal.remove();
    }

    public static WebElement waitForIt(WebElement webElement) {
        Wait<WebDriver> wait = new FluentWait<>(webDriverThreadLocal.get())
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    public static void scroolToTheSomePoint(WebElement element) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", waitForIt(element));
    }

    public static long checkScrolledView () {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        Long value = (Long) executor.executeScript("return window.pageYOffset;");
        System.out.println(value);
        return value;
    }


}
