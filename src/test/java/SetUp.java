import Pages.Header.HeaderPageMethods;
import Pages.HomePage.HomePageMethods;
import Settings.Configuration;
import Settings.TestMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static Settings.BrowserEnum.*;
import static Settings.Configuration.browserPicker;
import static Settings.StaticData.HOST;

public class SetUp {

    protected WebDriver driver;
    private TestMethods testMethods;
    private Configuration configuration;
    public static HeaderPageMethods headerPageMethods;
    public static HomePageMethods homePageMethods;

    @BeforeClass(alwaysRun = true)
    public void setUp () {
        driver = browserPicker(FIREFOX);
        testMethods = new TestMethods();
        configuration = new Configuration(driver);
        homePageMethods = new HomePageMethods(driver);
        headerPageMethods = new HeaderPageMethods(driver);
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
