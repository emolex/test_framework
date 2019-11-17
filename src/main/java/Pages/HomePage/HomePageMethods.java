package Pages.HomePage;

import org.openqa.selenium.WebDriver;

import static Settings.TestMethods.doSomeAction;


public class HomePageMethods extends HomePageSelectors{

    public HomePageMethods(WebDriver driver) {
        super(driver);
    }

    public void moveMouseBetweenCategories () {
    doSomeAction(driver).moveToElement(motoryzacja_category).moveToElement(moda_category).build().perform();
    }
}
