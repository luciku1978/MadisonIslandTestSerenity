package projectMadisonIslandTS.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import projectMadisonIslandTS.factory.Constants;
import projectMadisonIslandTS.pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class LoginSteps extends ScenarioSteps {
    LoginPage loginPage;

    @Step
    void openHomePage() {
        loginPage.open();
    }

    @Step
    void loginUntilCredentials() {
        loginPage.clickAccount();
        loginPage.clickLoginFromDropdown();
    }

    @Step
    void clickLogout(){
        loginPage.clickAccount();
        loginPage.clickLogoutFromDropdown();
    }

    @Step
    public void enterCredentials(String email, String password) {
        loginPage.enterCredentials(email, password);
        loginPage.clickLoginButton();
    }

    @Step
    void verifyLoggedIn(String expectedNameOfUser) {
        assertThat(loginPage.getWelcomeMessageAfterLogin(), containsString(expectedNameOfUser));
    }

    @StepGroup
    public void fullLogin(String email, String password, String expectedNameOfUser) {
        openHomePage();
        loginUntilCredentials();
        enterCredentials(email, password);
        verifyLoggedIn(expectedNameOfUser);

    }

    @Step
    void enterEmptyPassword() {
        loginPage.clearInputFields();
        loginPage.enterCredentials("test@yahoo.com", "");
        loginPage.clickLoginButton();
    }

    @Step
    void enterEmptyEmail() {
        loginPage.clearInputFields();
        loginPage.enterCredentials("", "test@yahoo.com");
        loginPage.clickLoginButton();
    }

    @Step
    void enterNegativeCredentials() {
        loginPage.clearInputFields();
        loginPage.enterCredentials("test@yahoo.com", "lalalalalalalal");
        loginPage.clickLoginButton();
    }

    @Step
    void validateNegativeCredentials() {
        assertThat(loginPage.getInvalidCredentialsError(),
                equalToIgnoringCase("Invalid login or password."));
    }

    @Step
    void validateEmptyUsername() {
        assertThat(loginPage.getEmailRequiredFieldError(),
                equalToIgnoringCase("This is a required field."));
    }

    @Step
    void validateEmptyPassword() {
        assertThat(loginPage.getPasswordRequiredFieldError(),
                equalToIgnoringCase("This is a required field."));
    }

    @StepGroup
    public void negativeLogin() {
        openHomePage();
        loginUntilCredentials();
        enterEmptyEmail();
        validateEmptyUsername();
        enterEmptyPassword();
        validateEmptyPassword();
        enterNegativeCredentials();
        validateNegativeCredentials();
    }

    @Step
    void validateLogout(){
        Assert.assertEquals("Log Out unsuccesfull", "you are now logged out",
                loginPage.getLogoutMessage().toLowerCase());
    }

    @StepGroup
    public void logout(){
        openHomePage();
        loginUntilCredentials();
        enterCredentials(Constants.EMAIL, Constants.PASSWORD);
        clickLogout();
        validateLogout();
    }

}
