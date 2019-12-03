package settings.listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverEventListenerRegister {

    public synchronized static WebDriver registerWebDriverListener (WebDriver driver) {
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        DriverEventListener driverEventListener = new DriverEventListener();
        return eventFiringWebDriver.register(driverEventListener);
    }

}
