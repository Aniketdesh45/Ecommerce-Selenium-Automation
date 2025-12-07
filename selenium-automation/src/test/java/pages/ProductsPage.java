package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private WebDriver driver;

    private By titleLabel = By.cssSelector("span.title");
    private By cartBadge  = By.cssSelector("span.shopping_cart_badge");
    private By cartIcon   = By.id("shopping_cart_container");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(titleLabel).getText();
    }

    public void addProductToCart(String productName) {
        // Button id pattern: add-to-cart-sauce-labs-backpack
        String id = "add-to-cart-" + productName.toLowerCase()
                .replace(" ", "-");
        By addButton = By.id(id);
        driver.findElement(addButton).click();
    }

    public String getCartBadgeCount() {
        return driver.findElement(cartBadge).getText();
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }
}