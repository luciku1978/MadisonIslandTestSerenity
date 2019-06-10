package projectMadisonIslandTS;

import net.thucydides.core.pages.PageObject;
import org.junit.After;
import org.junit.Before;

public class BaseTest extends PageObject {

    @Before
    public void maximize() {
        getDriver().manage().window().maximize();
    }

    @After
    public void quit(){
        getDriver().quit();
    }
}
