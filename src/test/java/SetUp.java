import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.header.HeaderPageMethods;
import pages.homePage.HomePageMethods;
import pages.resetPasswordPage.ResetPasswordPageMethods;
import settings.Configuration;
import settings.TestMethods;
import settings.enums.BrowserEnum;
import settings.jsonData.Json_Properties;
import settings.utils.TestListeners;

import java.net.MalformedURLException;

import static settings.Configuration.browserPicker;
import static settings.Configuration.getWebdriver;
import static settings.StaticData.HOST;
import static settings.jsonData.Json_Properties.parseJson;

public class SetUp {

    public Json_Properties json_properties;
    protected WebDriver driver;
    protected static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    public TestMethods testMethods;
    private Configuration configuration;
    public static HeaderPageMethods headerPageMethods;
    public static HomePageMethods homePageMethods;
    public static ResetPasswordPageMethods resetPasswordPageMethods;
    private static TestListeners testListeners;

    @Parameters("browser")
    @BeforeTest(alwaysRun = true)
    @Step("Set up all objects and implement driver...")
    public void setUp (@Optional BrowserEnum browser) throws MalformedURLException {
        json_properties = new Json_Properties();
        parseJson();
        browserPicker(browser);
        driver = getWebdriver();
        testListeners = new TestListeners();
        testMethods = new TestMethods();
        configuration = new Configuration(driver);
        homePageMethods = new HomePageMethods(driver);
        headerPageMethods = new HeaderPageMethods(driver);
        resetPasswordPageMethods = new ResetPasswordPageMethods(driver);
    }

    @BeforeMethod (alwaysRun = true)
    @Step("Open new sie...")
    public void startNewSession () {
        driver.get(HOST);
    }

    @AfterMethod(alwaysRun = true)
    @Step("Clean all cookies...")
    protected void cleanUp() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass (alwaysRun = true)
    @Step("Close driver and browser, end test runner ...")
    protected void closeTestCase () {
        configuration.closeRunner();
    }

}
