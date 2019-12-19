package pages.header;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.loginPage.LoginPageMethods;
import settings.AssertLogic;

import static settings.Configuration.waitForIt;

public class HeaderPageMethods extends HeaderPageSelectors{



    public HeaderPageMethods(WebDriver driver) {
        super(driver);
    }

    @Step("Click on myOlx icon on the top of site before login")
    public LoginPageMethods clickOn_myOlx_before_login() {
        waitForIt(my_olx).click();
        log().info("clicking on 'MyOlx' ");
        AssertLogic.assertThat(logIn_emailInput).isVisible();
        return new LoginPageMethods(driver);
    }

}
