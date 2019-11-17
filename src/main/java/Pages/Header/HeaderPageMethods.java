package Pages.Header;

import org.openqa.selenium.WebDriver;

import static Settings.Configuration.waitForIt;

public class HeaderPageMethods extends HeaderPageSelectors{

    public HeaderPageMethods(WebDriver driver) {
        super(driver);
    }


    public void clickOn_MyOlx () {
        waitForIt(my_olx).click();

    }

}
