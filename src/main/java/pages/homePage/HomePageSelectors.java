package pages.homePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageSelectors {

    protected WebDriver driver;

    protected HomePageSelectors(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-id='5']")
    protected WebElement motoryzacja_category;

    @FindBy(xpath = "//a[@data-id='87']")
    protected WebElement moda_category;

}
