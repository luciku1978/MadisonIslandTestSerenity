package projectMadisonIslandTS.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("https://fasttrackit.org/selenium-test/")
public class WishlistPage extends PageObject {

    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(className = "search-button")
    private WebElement searchButton;

    @FindBy(className = "product-image")
    private List<WebElement> productImages;

    @FindBy(css = ".product-name > a")
    private List<WebElement> productNames;

    @FindBy(className = "link-wishlist")
    private List<WebElement> addToWishlistLinks;

    @FindBy(className = "success-msg")
    private WebElement successMessage;

    @FindBy(id = "wishlist-table")
    private WebElement masterWishlistTable;

    public void enter_keyword(String keyword) {
        searchField.sendKeys(keyword);
    }

    public void setSearchButton() {
        searchButton.click();
    }

    public void clickAddToWishlist() {
        addToWishlistLinks.get(0).click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public List<WebElement> getProductImages() {
        return productImages;
    }

    public List<WebElement> getProductNames() {
        return productNames;
    }

    public WebElement getMasterWishlistTable() {
        return masterWishlistTable.findElement(By.tagName("tbody"));
    }

    public List<String> getProductNamesInWishlist() {
        List<String> names = new ArrayList<>();
        List<WebElement> productNames = getMasterWishlistTable().findElements(By.className("product-name"));
        productNames.forEach(s -> names.add(s.getText()));
        return names;
    }

}
