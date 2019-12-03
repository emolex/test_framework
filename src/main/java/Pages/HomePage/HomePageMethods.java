package Pages.HomePage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static Settings.TestMethods.doSomeAction;


public class HomePageMethods extends HomePageSelectors{

    public HomePageMethods(WebDriver driver) {
        super(driver);
    }

    @Step("Check mouse moving between motoryzacja category and moda category.")
    public void moveMouseBetweenCategories () {
    doSomeAction(driver).moveToElement(motoryzacja_category).moveToElement(moda_category).build().perform();
    }
}
