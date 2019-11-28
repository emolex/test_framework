import org.testng.annotations.Test;

import static Settings.StaticData.LOGIN_PAGE;

public class TestRunner extends TestCases {

//    @BeforeMethod(alwaysRun = true)
    public void loadUrl(String url) {
        driver.get(url);
    }

    @Test (groups = {})
    public void test1_TEST () {
       test1(); }

    @Test (groups = {"login, test"})
    public void test2_TEST () {
        loadUrl(LOGIN_PAGE);
        test2(); }

    @Test(groups = "login")
    public void logIn_TEST() {
        logIn();
    }

//    @Test(groups = "password")
//    public void resetPassword_TEST() {
//        resetPassword();
//    }
}
