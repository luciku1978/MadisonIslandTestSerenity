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
import projectMadisonIslandTS.steps.WishlistSteps;

@RunWith(SerenityRunner.class)
public class AddToWishlist extends BaseTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    WishlistSteps wishlistSteps;

    @Steps
    LoginSteps loginStep;

    @Test
    public void runWishlistBeforeLogin() {
        wishlistSteps.addToWishlistBeforeLogin("glass");
    }

    @Test
    public void runWishlistTest() {
        loginStep.fullLogin(Constants.EMAIL, Constants.PASSWORD, "LUCIAN MANIU");
        wishlistSteps.addToWishlist("glass");
    }

    @Test
    public void removeFromWishlist() {
        loginStep.fullLogin(Constants.EMAIL, Constants.PASSWORD, "LUCIAN MANIU");
        wishlistSteps.removeFromWishlist("car");
    }


}
