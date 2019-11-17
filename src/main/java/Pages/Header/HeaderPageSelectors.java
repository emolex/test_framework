package Pages.Header;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class HeaderPageSelectors {

    protected WebDriver driver;

    protected HeaderPageSelectors(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "topLoginLink") WebElement my_olx;

}
