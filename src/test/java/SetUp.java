import Pages.Header.HeaderPageMethods;
import Pages.HomePage.HomePageMethods;
import Pages.ResetPasswordPage.ResetPasswordPageMethods;
import Settings.Configuration;
import Settings.Enums.BrowserEnum;
import Settings.JsonData.Json_Properties;
import Settings.TestMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;

import static Settings.Configuration.browserPicker;
import static Settings.StaticData.HOST;

public class SetUp {

    private Json_Properties json_properties;
    protected WebDriver driver;
    protected static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    private TestMethods testMethods;
    private Configuration configuration;
    public static HeaderPageMethods headerPageMethods;
    public static HomePageMethods homePageMethods;
    public static ResetPasswordPageMethods resetPasswordPageMethods;


    @Parameters("browser")
    @BeforeTest(alwaysRun = true)
    public void setUp (@Optional BrowserEnum browser) throws MalformedURLException {
        json_properties = new Json_Properties();
        json_properties.parseJson();
        driver = browserPicker(browser);
        testMethods = new TestMethods();
        configuration = new Configuration(driver);
        homePageMethods = new HomePageMethods(driver);
        headerPageMethods = new HeaderPageMethods(driver);
        resetPasswordPageMethods = new ResetPasswordPageMethods(driver);

    }
    @BeforeMethod (alwaysRun = true)
    public void startNewSession () {
        driver.get(HOST);
    }

    @AfterMethod(alwaysRun = true)
    protected void cleanUp() {
        webDriverThreadLocal.remove();
        System.out.printf("TEST CASE CLOSING....");
    }

    @AfterClass (alwaysRun = true)
    protected void closeTestCase () {
        configuration.closeRunner();
    }

}
