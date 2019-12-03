package pages.resetPasswordPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordSelectors {

    protected WebDriver driver;

    ResetPasswordSelectors (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

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
}
