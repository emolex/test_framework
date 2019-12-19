package pages.header;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import pages.BasePage;

public class HeaderPageSelectors extends BasePage {


    @FindBy (id = "topLoginLink") WebElement my_olx;

    @FindBy(id = "userEmail") public static WebElement logIn_emailInput;


    public HeaderPageSelectors(WebDriver driver) {
        super(driver);
    }
}
