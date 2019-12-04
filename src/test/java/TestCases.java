import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import settings.AssertLogic;

import static pages.loginPage.LoginPageSelectors.logIn_emailInput;
import static pages.loginPage.LoginPageSelectors.login_error_login;
import static pages.resetPasswordPage.ResetPasswordSelectors.reset_error_code;
import static settings.jsonData.Json_Notifies.resetpassword_wron_code;

public class TestCases extends SetUp {

    private static AssertLogic assertLogic;

    TestCases () {
        PageFactory.initElements(driver, this);
    }


    @Step ("Test checking warning status.")
    public static void testWithWarnings() {
        homePageMethods.moveMouseBetweenCategories();
        headerPageMethods.clickOn_myOlx_before_login();
        AssertLogic.assertThat(logIn_emailInput).checkText("koala123").isVisible();
    }


    @Attachment(value = "testWithError", type = "image/png")
    public static void testWithError() {
        headerPageMethods.clickOn_myOlx_before_login();
        resetPasswordPageMethods.resetPassword_typeEmail("Emil");
    }


    public static void logIn_NO_EMAIL() {
        headerPageMethods
                .clickOn_myOlx_before_login()
                .login("", "Tester123");
        AssertLogic.assertThat(logIn_emailInput).isVisible().checkText("");
        AssertLogic.assertThat(login_error_login).isVisible();
    }


    public static void resetPassword_WRONG_SMS_CODE() { //Check why cant build longer chain only by "headerPageMethods" I got NullPointer
        headerPageMethods.clickOn_myOlx_before_login()
                .remindPasswordButton();
        resetPasswordPageMethods.resetPassword_typeEmail("emil.czerski@l4a-soft.com")
                .resetPassword_submitButton()
                .resetPassword_typeNewCode("1231")
                .resetPassword_newPassword("Tester123!")
                .resetPassword_submitButton();
        AssertLogic.assertThat(reset_error_code).checkText(resetpassword_wron_code);
    }
}