package projectMadisonIslandTS.steps;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import projectMadisonIslandTS.factory.Constants;
import projectMadisonIslandTS.pages.ProductsGridPage;
import projectMadisonIslandTS.pages.WishlistPage;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class WishlistSteps extends ScenarioSteps {

    WishlistPage wishlistPage;

    @Step
    void open() {
        wishlistPage.open();
    }

    @Step
    void searchForProduct(String keyword) {
        wishlistPage.enter_keyword(keyword);
        wishlistPage.setSearchButton();
    }

    @Step
    void addTheFirstProductToWishlist() {
        wishlistPage.clickAddToWishlist();
    }

    @Step
    void saveNameOfFirstProduct() {
        String productName = wishlistPage.getProductNames().get(0).getText();
        Serenity.getCurrentSession().put("productName", productName);
    }

    @Step
    void validateName() {
        String productName = (String) Serenity.getCurrentSession().get("productName");
        String expectedSuccessMessage = productName.concat(" has been added to your wishlist.");
        assertThat(wishlistPage.getSuccessMessage(),
                containsString(expectedSuccessMessage));
    }

    @Step
    void validateBeforeLoginURL() {
        assertThat(getDriver().getCurrentUrl(),
                equalToIgnoringCase(Constants.LOGIN_URL));
    }

    @StepGroup
    public void addToWishlistBeforeLogin(String keyword) {
        open();
        searchForProduct(keyword);
        addTheFirstProductToWishlist();
        validateBeforeLoginURL();
    }

    @StepGroup
    public void addToWishlist(String keyword) {
        open();
        searchForProduct(keyword);
        saveNameOfFirstProduct();
        addTheFirstProductToWishlist();
        validateName();
    }

    @Step
    List<WebElement> getProductsInWishlist() {
        WebElement master = wishlistPage.getMasterWishlistTable();
        return master.findElements(By.tagName("tr"));
    }

    @Step
    void removeProductFromWishlist(){
        String productToBeDeleted = (String) Serenity.getCurrentSession().get("productName");
        List<WebElement> products = getProductsInWishlist();
        for (WebElement element: products) {
            WebElement productName = element.findElement(By.className("product-name"));
            if (productName.equals(productToBeDeleted)){
                element.findElement(By.className("btn-remove")).click();
                getDriver().switchTo().alert().accept();
            }
        }
    }

    @Step
    void validateItemIsRemovedFromWishlist(){
        String productToBeDeleted = (String) Serenity.getCurrentSession().get("productName");
        List<String> productNamesInWishlist = wishlistPage.getProductNamesInWishlist();
        Assert.assertFalse("The product was not deleted",
                productNamesInWishlist.contains(productToBeDeleted));
    }

    @StepGroup
    public void removeFromWishlist(String keyword) {
        addToWishlist(keyword);
        getProductsInWishlist();
        removeProductFromWishlist();
        validateItemIsRemovedFromWishlist();
    }
}
