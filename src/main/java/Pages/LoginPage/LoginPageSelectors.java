package Pages.LoginPage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPageSelectors {
    protected WebDriver driver;

    LoginPageSelectors (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "register_tab")
    WebElement register_tab;
}
