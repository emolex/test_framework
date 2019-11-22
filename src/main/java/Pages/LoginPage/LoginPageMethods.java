package Pages.LoginPage;

import Pages.HomePage.HomePageMethods;
import org.openqa.selenium.WebDriver;

import static Settings.Configuration.waitForIt;

public class LoginPageMethods extends LoginPageSelectors{


    public LoginPageMethods(WebDriver driver) {
        super(driver);
    }

    public HomePageMethods login (String email, String pass) {
        waitForIt(logIn_emailInput).sendKeys(email);
        waitForIt(logIn_passwordInput).sendKeys(pass);
        waitForIt(logIn_LogInButton).click();

        return new HomePageMethods(driver);
    }

}
