package projectMadisonIslandTS.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("https://fasttrackit.org/selenium-test/")
public class AddToCartPage extends PageObject {
    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(className = "search-button")
    private WebElement searchSubmit;

    @FindBy(xpath = "//div[@class='product-info']//button[@title='Add to Cart']")
    private List<WebElement> addToCartButtons;

    @FindBy(className = "name-wrapper")
    private List<WebElement> detailViewNameOfProducts;

    @FindBy(className = "success-msg")
    private WebElement addedToCartSuccessMessage;

    @FindBy(className = "product-name")
    private List<WebElement> productNameInCart;

    @FindBy(className = "product-price")
    private List<WebElement> productPriceInCart;

    @FindBy(css = ".li:nth-child(1)")
    private List<WebElement> searchedItems;

    @FindBy(className = "product-image")
    private WebElement searchedImages;

    @FindBy(className = "add-to-cart-buttons")
    private WebElement detailsPageAddToCart;

    @FindBy(id = "qty")
    private WebElement quantitySetter;


    public void clickSearchSubmit() {
        searchSubmit.click();
    }

    public void enterSearchKeyword(String text) {
        searchField.sendKeys(text);
    }

    public void getFirstProductName() {
        String productName = detailViewNameOfProducts.get(4).getText();
        Serenity.getCurrentSession().put("productName", productName);
    }

    public void goToDetailsPage() {
        searchedImages.click();
    }

    public String getAddedToCartSuccessMessage() {
        return addedToCartSuccessMessage.getText();
    }

    public List<String> getProductsNameInCart() {
        return productNameInCart
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getProductsPriceInCart() {
        return productPriceInCart
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<WebElement> getSearchedItems() {
        return searchedItems;
    }

    public WebElement getQuantitySetter(){
        return quantitySetter;
    }

    public void clickAddToCartFromDetailsPage(){
        detailsPageAddToCart.click();
    }

}
