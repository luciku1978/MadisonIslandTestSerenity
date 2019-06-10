package projectMadisonIslandTS.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import projectMadisonIslandTS.BaseTest;
import projectMadisonIslandTS.factory.Constants;

@DefaultUrl("https://fasttrackit.org/selenium-test/")
public class LoginPage extends PageObject {

    @FindBy(className = "skip-account")
    private WebElement accountButton;

    @FindBy(linkText = "Log In")
    private WebElement loginFromDropdown;

    @FindBy(xpath = "//div[@class='links']//a[@title='Log Out']")
    private WebElement logoutFromDropdown;

    @FindBy(css = ".page-title h1")
    private WebElement logoutMessage;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "pass")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='send2']")
    private WebElement loginButton;

    @FindBy(xpath = "//span[text()='Create an Account']")
    private WebElement createAnAccountButton;

    @FindBy(className = "welcome-msg")
    private WebElement welcomeMessageAfterLogIn;

    @FindBy(id = "advice-required-entry-email")
    private WebElement requiredEmailFieldError;

    @FindBy(id = "advice-required-entry-pass")
    private WebElement requiredPasswordFieldError;

    @FindBy(className = "error-msg")
    private WebElement invalidCredentialsError;

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getCreateAnAccountButton() {
        return createAnAccountButton;
    }

    public void clickAccount() {
        accountButton.click();
    }

    public void clickLoginFromDropdown() {
        loginFromDropdown.click();
    }

    public void clickLogoutFromDropdown() {
        logoutFromDropdown.click();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void enterCredentials(String email, String pass) {
        emailField.sendKeys(email);
        passwordField.sendKeys(pass);
    }

    public String getWelcomeMessageAfterLogin() {
        return welcomeMessageAfterLogIn.getText();
    }

    public String getEmailRequiredFieldError() {
        waitFor(requiredEmailFieldError);
        return requiredEmailFieldError.getText();
    }

    public String getPasswordRequiredFieldError() {
        waitFor(requiredPasswordFieldError);
        return requiredPasswordFieldError.getText();
    }

    public String getInvalidCredentialsError() {
        waitFor(invalidCredentialsError);
        return invalidCredentialsError.getText();
    }

    public void clearInputFields() {
        emailField.clear();
        passwordField.clear();
    }

    public String getLogoutMessage() {
        return logoutMessage.getText();
    }
}
