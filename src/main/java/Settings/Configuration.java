package Settings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Configuration {

    private static WebDriver driver;

    public Configuration(WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriver browserPicker (BrowserEnum browser) {
            switch (browser) {
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                default:
                    System.out.println("U PICKED INVALID BROWSER. PLEASE TYPE: 'FIREFOX', 'CHROME' or 'EDGE'");
            }
        driver.manage().window().maximize(); //ZOBACZYC CZYM JEST fullscreen()
        return driver;
    }

    public static WebElement waitForIt(WebElement webElement) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return element;
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
