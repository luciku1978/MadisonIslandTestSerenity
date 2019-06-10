package projectMadisonIslandTS.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://fasttrackit.org/selenium-test/")
public class SearchPage extends PageObject {

    @FindBy(id = "search")
    private WebElementFacade searchField;

    @FindBy(className = "search-button")
    private WebElementFacade searchButton;

    @FindBy(className = "page-title")
    private WebElement searchResultTitle;

    @FindBy(id = "product-collection-image-337")
    private WebElementFacade productButon;

    @FindBy(css = "#product_addtocart_form > div.add-to-cart-wrapper > div > ul.add-to-links > li:nth-child(1) > a")
    private WebElementFacade wishlistButton;

    @FindBy(css = "#email")
    private WebElementFacade usernamefield;

    @FindBy(css = "#pass")
    private WebElementFacade passwordfield;

    @FindBy(css = "#send2 > span > span")
    private WebElementFacade loginbutton;

    public void enter_keyword(String keyword) {
        searchField.typeAndEnter(keyword);
    }
    public void setSearchButton() {
        searchButton.click();
    }
    public void setProductButon() {
        productButon.click();
    }
    public void setWishlistButton() {
        wishlistButton.click();
    }

    public String getSearchResultTitleText(){
        return searchResultTitle.getText();
    }

}
