import Pages.Header.HeaderPageMethods;
import Pages.HomePage.HomePageMethods;
import Pages.ResetPasswordPage.ResetPasswordPageMethods;
import Settings.Configuration;
import Settings.TestMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;

import static Settings.BrowserEnum.*;
import static Settings.Configuration.browserPicker;
import static Settings.StaticData.HOST;

public class SetUp {

    protected WebDriver driver;
    private TestMethods testMethods;
    private Configuration configuration;
    public static HeaderPageMethods headerPageMethods;
    public static HomePageMethods homePageMethods;
    public static ResetPasswordPageMethods resetPasswordPageMethods;

    @BeforeClass(alwaysRun = true)
    public void setUp () throws MalformedURLException {
        driver = browserPicker(CHROME);
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
