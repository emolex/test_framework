package pages.header;

import pages.loginPage.LoginPageMethods;
import io.qameta.allure.Step;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import static settings.Configuration.waitForIt;

public class HeaderPageMethods extends HeaderPageSelectors{

    private Logger logger = LogManager.getLogger(HeaderPageMethods.class);

    public HeaderPageMethods(WebDriver driver) {
        super(driver);
    }

    @Step("Click on myOlx icon on the top of site before login")
    public LoginPageMethods clickOn_myOlx_before_login() {
        waitForIt(my_olx).click();
        logger.info("clicking on 'MyOlx' ");
        return new LoginPageMethods(driver);
    }

}
