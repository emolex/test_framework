import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TestRunner extends TestCases {


    @Test (groups = {})
    @Description("Test with warning status and wrong assertion")
    public void testWithWarnings_TEST () {
       testWithWarnings(); }

    @Test (groups = {"login, test"})
    @Description("Test with error where test cant find webElement")
    public void testWithError_TEST () {
        testWithError(); }

    @Test(groups = "login")
    @Description ("Test regular logIn case")
    public void logIn_TEST() {
        logIn();
    }

    @Test(groups = "password")
    @Description ("Test with reset password")
    public void resetPassword_TEST() {
        resetPassword();
    }
}
