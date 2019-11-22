import org.openqa.selenium.support.PageFactory;

public class TestCases extends SetUp {

    TestCases () {
        PageFactory.initElements(driver, this);
    }

    public static void test1() {
        homePageMethods.moveMouseBetweenCategories();
        headerPageMethods.clickOn_myOlx_before_login();
    }

    public static void test2() {
        headerPageMethods.clickOn_myOlx_before_login();
    }

    public static void logIn() {
        headerPageMethods
                .clickOn_myOlx_before_login()
                .login("emil.czerski@l4a-soft.com", "Tester123");
    }

    public static void resetPassword () {
        resetPasswordMethods
                .resetPassword_sendNewCode()
                .resetPassword_submitButton()
                .resetPassword_typeEmail("dasdas");
    }
}
