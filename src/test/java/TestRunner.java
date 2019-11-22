import org.testng.annotations.Test;

import static Settings.StaticData.LOGIN_PAGE;

public class TestRunner extends TestCases {

//    @BeforeMethod(alwaysRun = true)
    public void loadUrl(String url) {
        driver.get(url);
    }

    @Test
    public void test1_TEST () {
       test1(); }

    @Test
    public void test2_TEST () {
        loadUrl(LOGIN_PAGE);
        test2(); }

    @Test
    public void LogIn_TEST() {
        logIn();
    }



}
