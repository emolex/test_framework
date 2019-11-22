package Pages.MyOlxPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyOlxSelectors {

    protected WebDriver driver;

    protected MyOlxSelectors(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }




}
