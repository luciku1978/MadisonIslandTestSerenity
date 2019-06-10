package projectMadisonIslandTS.steps;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import projectMadisonIslandTS.factory.UserFactory;
import projectMadisonIslandTS.pages.RegisterPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class RegisterSteps extends ScenarioSteps {
    RegisterPage registerPage;

    @Step
    void openHomePage() {
        registerPage.open();
    }

    @Step
    void registerUntilInput() {
        registerPage.clickAccount();
        registerPage.clickRegisterFromDropdown();
    }

    @Step
    void enterGoodRegistrationInfoWithNewsletter(String firstname, String middlename, String lastname,
                                                 String email, String password) {
        registerPage.inputFirstname(firstname);
        registerPage.inputMiddlename(middlename);
        registerPage.inputLastname(lastname);
        registerPage.inputEmail(email);
        registerPage.inputPassword(password);
        registerPage.inputPasswordConfirmation(password);
        registerPage.clickSignUpForNewsletter();
        registerPage.clickRegister();
    }

    @Step
    void validateGoodRegistration() {
        UserFactory reg = (UserFactory) Serenity.getCurrentSession().get("randomRegistration");
        String expectedWelcomeMessage = "welcome, "
                .concat(reg.getFirstname())
                .concat(" ")
                .concat(reg.getMiddlename())
                .concat(" ")
                .concat(reg.getLastname() + "!");
        assertThat(registerPage.getSuccessRegistrationMessage(), equalToIgnoringCase(expectedWelcomeMessage));
    }

    @StepGroup
    public void goodRegistration(UserFactory rc) {
        openHomePage();
        registerUntilInput();
        enterGoodRegistrationInfoWithNewsletter(rc.getFirstname(), rc.getMiddlename(), rc.getLastname(),
                rc.getEmail(), rc.getPassword());
        validateGoodRegistration();
    }

    @Step
    void enterBadRegistrationInfoWithoutEmail(String firstname, String middlename, String lastname, String password) {

        registerPage.inputFirstname(firstname);
        registerPage.inputMiddlename(middlename);
        registerPage.inputLastname(lastname);
        registerPage.inputPassword(password);
        registerPage.inputPasswordConfirmation(password);
        registerPage.clickSignUpForNewsletter();
        registerPage.clickRegister();
    }

    @Step
    void validateBadRegistrationWithoutEmail() {
        String expectedValidationMessage = "This is a required field.";
        assertThat(registerPage.getValidationAdviceMessage(), equalToIgnoringCase(expectedValidationMessage));
    }

    @StepGroup
    public void badRegistration(UserFactory rc) {
        openHomePage();
        registerUntilInput();
        enterBadRegistrationInfoWithoutEmail(rc.getFirstname(), rc.getMiddlename(), rc.getLastname(), rc.getPassword());
        validateBadRegistrationWithoutEmail();
    }
}
