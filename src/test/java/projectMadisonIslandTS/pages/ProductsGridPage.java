package projectMadisonIslandTS.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsGridPage extends PageObject {

    @FindBy(css = ".product-name > a")
    private List<WebElement> productNameContainers;

    public List<WebElement> getProductNameContainers() {
        return productNameContainers;
    }

    @FindBy(className = "product-image")
    private List<WebElement> productImagesContainers;

    public List<WebElement> getProductImagesContainers() {
        return productImagesContainers;
    }

    @FindBy(className = "link-compare")
    private List<WebElement> addToCompareLinks;

    public List<WebElement> getAddToCompareLinks() {
        return addToCompareLinks;
    }

    public WebElement getAddToCartButton(String productName, WebDriver driver) {
        return driver.findElement(By.xpath(
                "//div[@class='product-info' and .//a[text()='"
                        + productName + "']]//button[@title='Add to Cart']"));
    }

    public void addProductToCart(String productName, WebDriver driver) {
        getAddToCartButton(productName, driver).click();

    }
}