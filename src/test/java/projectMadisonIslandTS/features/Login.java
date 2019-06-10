package projectMadisonIslandTS.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import projectMadisonIslandTS.BaseTest;
import projectMadisonIslandTS.factory.Constants;
import projectMadisonIslandTS.steps.LoginSteps;

@RunWith(SerenityRunner.class)
public class Login extends BaseTest {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginSteps loginStep;

    @Test
    public void incorrectLogin() {
        loginStep.negativeLogin();
    }

    @Test
    public void correctLogin() {
        loginStep.fullLogin(Constants.EMAIL, Constants.PASSWORD, "LUCIAN MANIU");
    }

    @Test
    public void logout() {
        loginStep.logout();
    }


}
