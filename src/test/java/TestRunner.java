import org.testng.annotations.Test;

public class TestRunner extends TestCases {

//    @BeforeMethod(alwaysRun = true)
    public void loadUrl(String url) {
        driver.get(url);
    }


    @Test (groups = {})
    public void testWithWarnings_TEST () {
       testWithWarnings(); }

//    @Test (groups = {"login, test"})
//    public void testWithError_TEST () {
//        loadUrl(LOGIN_PAGE);
//        testWithError(); }

//    @Test(groups = "login")
//    public void logIn_TEST() {
//        logIn();
//    }

    @Test(groups = "password")
    public void resetPassword_TEST() {
        resetPassword();
    }
}
