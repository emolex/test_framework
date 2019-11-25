import Pages.Header.HeaderPageMethods;
import Pages.HomePage.HomePageMethods;
import Pages.ResetPasswordPage.ResetPasswordPageMethods;
import Settings.Configuration;
import Settings.JsonData.Json_Properties;
import Settings.TestMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

import static Settings.Configuration.browserPicker;
import static Settings.Enums.BrowserEnum.FIREFOX;
import static Settings.StaticData.HOST;

public class SetUp {

    private Json_Properties json_properties;
    protected WebDriver driver;
    private TestMethods testMethods;
    private Configuration configuration;
    public static HeaderPageMethods headerPageMethods;
    public static HomePageMethods homePageMethods;
    public static ResetPasswordPageMethods resetPasswordPageMethods;

    @BeforeClass(alwaysRun = true)
    public void setUp () throws MalformedURLException {
        json_properties = new Json_Properties();
        json_properties.parseJson();
        driver = browserPicker(FIREFOX);
        testMethods = new TestMethods();
        configuration = new Configuration(driver);
        homePageMethods = new HomePageMethods(driver);
        headerPageMethods = new HeaderPageMethods(driver);
        resetPasswordPageMethods = new ResetPasswordPageMethods(driver);
    }

    @BeforeMethod (alwaysRun = true)
        protected void openSite(){
            driver.get(HOST);
    }

    @AfterMethod
    protected void cleanUp() {
        driver.get(HOST);
    }

    @AfterClass(alwaysRun = true)
    protected void closeTestCase () {
//        driver.close();
        driver.quit();
        driver=null;
    }


}
