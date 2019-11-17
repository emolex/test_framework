import org.testng.annotations.Test;

import static Settings.StaticData.*;

public class TestRunner extends TestCases {

//    @BeforeMethod(alwaysRun = true)
    public void loadUrl(String url) {
        driver.get(url);
    }

    @Test
    public void testHomePage_TEST () {
       testHomePage(); }

    @Test
    public void registerUser_TEST () {
        loadUrl(LOGIN_PAGE);
        registerUser(); }
}
