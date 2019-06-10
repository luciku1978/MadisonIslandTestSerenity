package projectMadisonIslandTS.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import projectMadisonIslandTS.BaseTest;
import projectMadisonIslandTS.steps.SearchSteps;

@RunWith(SerenityRunner.class)
public class SearchProduct extends BaseTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    SearchSteps searchSteps;

    @Test
    public void searchProductByKeyword() {
        searchSteps.search("glass");
    }
}
