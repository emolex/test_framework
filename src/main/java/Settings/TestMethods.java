package Settings;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Random;

public class TestMethods {

    private  WebDriver driver;
    static Configuration configuration;

    public static String generateRandomString (int length) {
        String text = RandomStringUtils.randomAlphanumeric(length).toUpperCase();
        return text;
    }

    public static String generateRandomNumber (int length) {
        String number = (RandomStringUtils.randomNumeric(length));
        return number;
    }

    public static String generateRandomEmail() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        return (generateRandomString(10)+ randomInt +"@zztest.com");
    }

    public static void checkNotify (WebElement webElement, String text) {
        String webText = configuration.waitForIt(webElement).getText();
        Assert.assertEquals(webText, text);
    }

    public static int generate_random_from_to(int from, int to) {
        Random rand = new Random();
        int n = rand.nextInt(to-from+1);
        return n+from;
    }

    public static Select chooseSelect (WebElement element) {
        Select getElement = new Select(element);
        return getElement;
        /**E.g.   chooseSelect(my_olx).selectByValue("selector_1"); */
    }

    public static Actions doSomeAction(WebDriver driver) {

        Actions action = new Actions(driver);
        return action;
    }

}
