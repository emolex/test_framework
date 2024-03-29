package pages.resetPasswordPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ResetPasswordSelectors extends BasePage {

    @FindBy(id = "code")
    protected WebElement reset_code;

    @FindBy(id = "password")
    protected WebElement reset_newPassword;

    @FindBy(id = "se_userSignIn")
    protected WebElement reset_submit;

    @FindBy(id = "resend-code-button")
    protected WebElement reset_resendNewCode;

    @FindBy(xpath = "//*[@title='E-mail']")
    public WebElement reset_email;

    @FindBy(xpath = "//*[@for='code']")
    public static WebElement reset_error_code;

    public ResetPasswordSelectors(WebDriver driver) {
        super(driver);
    }
}
