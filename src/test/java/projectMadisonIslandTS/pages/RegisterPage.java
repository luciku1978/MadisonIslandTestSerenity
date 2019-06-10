package projectMadisonIslandTS.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@DefaultUrl("https://fasttrackit.org/selenium-test/")
public class RegisterPage extends PageObject {

    @FindBy(className = "skip-account")
    private WebElement accountButton;

    @FindBy(xpath = "//div[@class='links']//a[@title='Register']")
    private WebElement registerFromDropdown;

    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "middlename")
    private WebElement middleName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "email_address")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "confirmation")
    private WebElement confirmPasword;

    @FindBy(id = "is_subscribed")
    private WebElement signUpForNewsletter;

    @FindBy(xpath = "//div[@class='buttons-set']//button[@title='Register']")
    private WebElement register;

    @FindBy(className = "welcome-msg")
    private WebElement successRegistrationMessage;

    @FindBy(id = "advice-required-entry-email_address")
    private WebElement adviceContainer;


    public void clickAccount() {
        accountButton.click();
    }

    public void clickRegisterFromDropdown() {
        registerFromDropdown.click();
    }

    public void inputFirstname(String text) {
        firstName.sendKeys(text);
    }

    public void inputMiddlename(String text) {
        middleName.sendKeys(text);
    }

    public void inputLastname(String text) {
        lastName.sendKeys(text);
    }

    public void inputEmail(String text) {
        email.sendKeys(text);
    }

    public void inputPassword(String text) {
        password.sendKeys(text);
    }

    public void inputPasswordConfirmation(String text) {
        confirmPasword.sendKeys(text);
    }

    public void clickSignUpForNewsletter() {
        signUpForNewsletter.click();
    }

    public void clickRegister() {
        register.click();
    }

    public String getSuccessRegistrationMessage() {
        return successRegistrationMessage.getText().toLowerCase();
    }

    public String getValidationAdviceMessage() {
        return  adviceContainer.getText();
    }
}



