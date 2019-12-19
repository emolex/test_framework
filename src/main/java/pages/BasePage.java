package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import settings.Configuration;


public abstract class BasePage {

    protected WebDriver driver;

    private Logger logger = LogManager.getLogger(this.getClass().getName());

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(Configuration.getWebdriver(), this);
    }

    protected Logger log() {
        return logger;
    }

}
