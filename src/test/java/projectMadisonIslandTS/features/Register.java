package projectMadisonIslandTS.features;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import projectMadisonIslandTS.BaseTest;
import projectMadisonIslandTS.factory.UserFactory;
import projectMadisonIslandTS.steps.RegisterSteps;

@RunWith(SerenityRunner.class)
public class Register extends BaseTest {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    RegisterSteps registerStep;

    @Steps
    UserFactory registerCredentials;

    @Test
    public void incorrectRegister() {
        registerCredentials = new UserFactory();
        Serenity.getCurrentSession().put("randomRegistration", registerCredentials);
        registerStep.badRegistration(registerCredentials);
    }

    @Test
    public void correctRegister() {
        registerCredentials = new UserFactory();
        Serenity.getCurrentSession().put("randomRegistration", registerCredentials);
        registerStep.goodRegistration(registerCredentials);
    }
}
