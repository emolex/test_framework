package settings.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import settings.Configuration;

public class ScreenShotMaker {

    @Attachment(value = "Page screenshot test failure", type = "image/png")
    public static byte[] makeScreenShot() {
        byte[] screenshotFile = ((TakesScreenshot) Configuration.getWebdriver()).getScreenshotAs(OutputType.BYTES);
        return screenshotFile;
    }


}
