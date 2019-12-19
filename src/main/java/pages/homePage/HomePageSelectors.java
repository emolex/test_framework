package pages.homePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class HomePageSelectors extends BasePage {


    @FindBy(xpath = "//a[@data-id='5']")
    protected WebElement motoryzacja_category;

    @FindBy(xpath = "//a[@data-id='87']")
    protected WebElement moda_category;

    @FindBy (id = "headerLogo")
    public static WebElement mainAnnounceModal;

    public HomePageSelectors(WebDriver driver) {
        super(driver);
    }
}
