package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {

    private WebDriver driver;

    private By cartItem = By.className("cart_item");
    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstItemName() {
        return driver.findElement(cartItem)
                .findElement(By.className("inventory_item_name"))
                .getText();
    }

    public int getItemsCount() {
        return driver.findElements(cartItem).size();
    }

    public boolean isProductInCart(String productName) {
        List<WebElement> items = driver.findElements(
                By.className("inventory_item_name")
        );
        for (WebElement item : items) {
            if (item.getText().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void removeProduct(String productName) {
        // Button id pattern: remove-sauce-labs-backpack
        String id = "remove-" + productName.toLowerCase().replace(" ", "-");
        driver.findElement(By.id(id)).click();
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
}