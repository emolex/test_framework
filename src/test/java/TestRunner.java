import io.qameta.allure.*;
import org.testng.annotations.*;

import static io.qameta.allure.SeverityLevel.*;

@Flaky
public class TestRunner extends TestCases {


    @TmsLink("EC-816")
    @Test (groups = {})
    @Severity(NORMAL)
    @Description("Test with warning status and wrong assertion")
    public void testWithWarnings_TEST () {
       testWithWarnings(); }

    @Flaky
    @TmsLink("EC-702")
    @Test (groups = {"login, test"})
    @Severity(CRITICAL)
    @Description("Test with error where test cant find webElement")
    public void testWithError_TEST () {
        testWithError(); }

    @TmsLink("EC-788")
    @Test(groups = "login")
    @Severity(BLOCKER)
    @Description ("Test regular logIn case")
    public void logIn_TEST() {
        logIn();
    }

    @TmsLink("EC-816")
    @Test(groups = "password")
    @Severity(MINOR)
    @Description ("Test with reset password")
    public void resetPassword_TEST() {
        resetPassword();
    }
}
