package projectMadisonIslandTS.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import projectMadisonIslandTS.BaseTest;
import projectMadisonIslandTS.steps.AddToCartSteps;

@RunWith(SerenityRunner.class)
public class AddToCart extends BaseTest {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    AddToCartSteps addToCartSteps;

    @Test
    public void addToCart() {
        addToCartSteps.addFirstProductToCartAndValidate("glass", "1");
    }

}
