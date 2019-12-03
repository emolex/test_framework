package settings;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;



public class AssertLogic extends AbstractAssert<AssertLogic, WebElement> {

    public Logger logger = LogManager.getLogger(AssertLogic.class);

    public AssertLogic(WebElement webElement) {
        super(webElement, AssertLogic.class);
    }

    public static AssertLogic assertThat (WebElement element) {
        return  new AssertLogic(element);
    }

    public AssertLogic isVisible() {
        logger.info("Check if element is visible");
        isNotNull();

        if(!actual.isDisplayed()){
            failWithMessage("Element was not displayed!");
        }
        logger.info("WebElement was displayed!");
        return this;
    }

    public AssertLogic checkText(String expectedText){
        logger.info("Checking if WebElement has text: " + expectedText);
        isNotNull();

        String actualElementText = actual.getText();
        if(!actualElementText.equals(expectedText)){
            failWithMessage("Element text was <%s> expecting to be <%s>!", actualElementText, expectedText);
        }

        logger.info("WebElement had expected text!");
        return this;
    }


}
