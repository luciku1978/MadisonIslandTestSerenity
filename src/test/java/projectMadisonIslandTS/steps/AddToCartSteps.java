package projectMadisonIslandTS.steps;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import projectMadisonIslandTS.pages.AddToCartPage;
import projectMadisonIslandTS.pages.ProductsGridPage;
import projectMadisonIslandTS.pages.SearchPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;


public class AddToCartSteps extends ScenarioSteps {

    AddToCartPage addToCartPage;
    ProductsGridPage productsGridPage;
    SearchPage searchPage;

    @Step
    void openHomePage() {
        addToCartPage.open();
    }

    @Step
    void searchByKeyword(String text) {
        addToCartPage.enterSearchKeyword(text);
        addToCartPage.clickSearchSubmit();
    }

    @Step
    void goToDetailsPage() {
        productsGridPage.getProductImagesContainers().get(0).click();
    }

    @Step
    void addValueToQuantity(String quantity){
        addToCartPage.getQuantitySetter().clear();
        addToCartPage.getQuantitySetter().sendKeys(quantity);
    }

    @Step
    void clickAddToCartFromDetailView(){
        addToCartPage.clickAddToCartFromDetailsPage();
    }

    @Step
    void validateAddedProductSuccess() {
        String productName = (String) Serenity.getCurrentSession().get("productName");
        String expectedSuccessMessage = productName + " "
                .concat("was added to your shopping cart.");
        assertThat(addToCartPage.getAddedToCartSuccessMessage(),
                equalToIgnoringCase(expectedSuccessMessage));
    }

    @Step
    void saveFirstNameOfProductInSession(){
        String productName = productsGridPage.getProductNameContainers().get(0).getText();
        Serenity.getCurrentSession().put("productName", productName);
    }

    @StepGroup
    public void addFirstProductToCartAndValidate(String text, String quantity) {
        openHomePage();
        searchByKeyword(text);
        saveFirstNameOfProductInSession();
        goToDetailsPage();
        addValueToQuantity(quantity);
        clickAddToCartFromDetailView();
        validateAddedProductSuccess();
    }

}
