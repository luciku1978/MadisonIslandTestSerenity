package projectMadisonIslandTS.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import projectMadisonIslandTS.pages.SearchPage;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchSteps extends ScenarioSteps {

    SearchPage searchPage;

    @Step
    void openPage() {
        searchPage.open();
    }

    @Step
    void enters(String keyword) {
        searchPage.enter_keyword(keyword);
    }

    @Step
    void searchbutton() {
        searchPage.setSearchButton();
    }

    @Step
    void productbutton() {
        searchPage.setProductButon();
    }

    @Step
    void wishlistbutton() {
        searchPage.setWishlistButton();
    }

    @Step
    void validateSearchResult(String keyword) {
        String expected = "Search results for '" + keyword + "'";
        assertThat(searchPage.getSearchResultTitleText(),
                equalToIgnoringCase(expected));
    }

    @Step
    void validateUrl(String keyword){
        String url = getDriver().getCurrentUrl();
        assertThat(url, containsString(keyword));
    }

    @StepGroup
    public void search(String keyword) {
        openPage();
        enters(keyword);
        searchbutton();
        validateSearchResult(keyword);
        validateUrl(keyword);
    }
}
