package pages.homePage;

import pages.header.HeaderPageMethods;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static settings.TestMethods.doSomeAction;


public class HomePageMethods extends HomePageSelectors{

    public HomePageMethods(WebDriver driver) {
        super(driver);
    }


    @Step("Check mouse moving between motoryzacja category and moda category.")
    public void moveMouseBetweenCategories() {
    log().info("check mouse moving...");
    doSomeAction(driver).moveToElement(motoryzacja_category).moveToElement(moda_category).build().perform();
    }
}
