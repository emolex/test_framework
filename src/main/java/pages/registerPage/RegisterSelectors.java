package pages.registerPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegisterSelectors {

    protected WebDriver driver;

    RegisterSelectors (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
