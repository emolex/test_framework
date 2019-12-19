package pages.loginPage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import pages.BasePage;

public class LoginPageSelectors extends BasePage {

    @FindBy(id = "login_tab")
    protected WebElement logIn_Tab;

    @FindBy(id = "register_tab")
    protected WebElement registerTab;

    @FindBy(id = "userEmail")
    public static WebElement logIn_emailInput;

    @FindBy(id = "userPass")
    protected WebElement logIn_passwordInput;

    @FindBy(id = "se_userLogin")
    protected WebElement logIn_LogInButton;

    @FindBy(xpath = "//*[@href='https://www.olx.pl/konto/forgotpassword/']")
    protected WebElement logIn_remindPassword;

    @FindBy(xpath = "//*[@for='userEmail']")
    public static WebElement login_error_login;

    public LoginPageSelectors(WebDriver driver) {
        super(driver);
    }
}
