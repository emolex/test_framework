package pages.loginPage;

import org.openqa.selenium.WebDriver;
import pages.homePage.HomePageMethods;
import pages.resetPasswordPage.ResetPasswordPageMethods;

import static settings.Configuration.waitForIt;

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

    public ResetPasswordPageMethods remindPasswordButton () {
        waitForIt(logIn_remindPassword).click();
        return new ResetPasswordPageMethods(driver);
    }

}
