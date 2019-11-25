package Pages.ResetPasswordPage;

import org.openqa.selenium.WebDriver;

import static Settings.Configuration.waitForIt;

public class ResetPasswordPageMethods extends ResetPasswordSelectors {

    public ResetPasswordPageMethods(WebDriver driver) {
        super(driver);
    }

    public ResetPasswordPageMethods resetPassword_typeEmail(String email) {
        waitForIt(reset_email).sendKeys(email);
        return this;
    }

    public ResetPasswordPageMethods resetPassword_submitButton() {
        waitForIt(reset_submit).click();
        return this;
    }

    public ResetPasswordPageMethods resetPassword_sendNewCode() {
        waitForIt(reset_resendNewCode).click();
        return this;
    }

    public ResetPasswordPageMethods resetPassword_typeNewCode (String newCode) {
        waitForIt(reset_code).click();
        return this;
    }

    public ResetPasswordPageMethods resetPassword_newPassword (String newPassword) {
        waitForIt(reset_newPassword).click();
        return this;
    }


}
