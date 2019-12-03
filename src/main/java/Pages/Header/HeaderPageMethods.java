package Pages.Header;

import Pages.LoginPage.LoginPageMethods;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static Settings.Configuration.waitForIt;

public class HeaderPageMethods extends HeaderPageSelectors{

    public HeaderPageMethods(WebDriver driver) {
        super(driver);
    }

    @Step("Click on myOlx icon on the top of site before login")
    public LoginPageMethods clickOn_myOlx_before_login() {
        waitForIt(my_olx).click();
        return new LoginPageMethods(driver);
    }

}
