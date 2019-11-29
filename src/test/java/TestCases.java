import io.qameta.allure.Description;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TestCases extends SetUp {

    TestCases () {
        PageFactory.initElements(driver, this);
    }

    @Description("Test with warning status and wrong assertion")
    public static void testWithWarnings() {
        homePageMethods.moveMouseBetweenCategories();
        headerPageMethods.clickOn_myOlx_before_login();
        boolean isTrue = true;
        Assert.assertEquals(isTrue, false);
    }

    @Description ("Test with error where test cant find webElement")
    public static void testWithError() {
        headerPageMethods.clickOn_myOlx_before_login();
        resetPasswordPageMethods.resetPassword_typeEmail("Emil");
    }

    @Description ("Test regular logIn case")
    public static void logIn() {
        headerPageMethods
                .clickOn_myOlx_before_login()
                .login("emil.czerski@l4a-soft.com", "Tester123");
    }

    @Description ("Test with reset password")
    public static void resetPassword () { //Check why cant build longer chain only by "headerPageMethods" I got NullPointer
        headerPageMethods.clickOn_myOlx_before_login()
                .remindPasswordButton();
        resetPasswordPageMethods.resetPassword_typeEmail("emil.czerski@l4a-soft.com")
                .resetPassword_submitButton()
                .resetPassword_typeNewCode("1231")
                .resetPassword_newPassword("Tester123!")
                .resetPassword_submitButton();
    }
}
