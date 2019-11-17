import org.openqa.selenium.support.PageFactory;

public class TestCases extends SetUp {

    TestCases () {
        PageFactory.initElements(driver, this);
    }

    public static void testHomePage() {
        homePageMethods.moveMouseBetweenCategories();
        headerPageMethods.clickOn_MyOlx();
    }

    public static void registerUser() {
        headerPageMethods.clickOn_MyOlx();
    }
}
