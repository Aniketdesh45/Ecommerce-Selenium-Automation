package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class E2ECheckoutTest extends BaseTest {

    private final String username = "standard_user";
    private final String password = "secret_sauce";

    private final String product1 = "Sauce Labs Backpack";
    private final String product2 = "Sauce Labs Bike Light";

    private void loginStandardUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(username, password);
    }

    // 🔹 TC-01: Valid Login
    @Test
    public void testValidLoginNavigatesToProductsPage() {
        loginStandardUser();

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getTitle(), "Products",
                "User is not on Products page after login!");
    }

    // 🔹 TC-02: Invalid Login
    @Test
    public void testInvalidLoginShowsErrorMessage() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("wrong_password");
        loginPage.clickLogin();

        String errorText = loginPage.getErrorMessage();
        Assert.assertTrue(errorText.contains("Epic sadface"),
                "Error message not shown for invalid login!");
    }

    // 🔹 TC-03: Add Multiple Products & Verify Cart
    @Test
    public void testAddMultipleProductsToCart() {
        loginStandardUser();

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getTitle(), "Products",
                "User is not on Products page!");

        // Add two products
        productsPage.addProductToCart(product1);
        productsPage.addProductToCart(product2);

        // Verify cart badge
        Assert.assertEquals(productsPage.getCartBadgeCount(), "2",
                "Cart badge count is not 2!");

        // Open cart
        productsPage.openCart();
        CartPage cartPage = new CartPage(driver);

        // Verify two items present
        Assert.assertEquals(cartPage.getItemsCount(), 2,
                "Cart does not have exactly 2 items!");

        Assert.assertTrue(cartPage.isProductInCart(product1),
                product1 + " not found in cart!");
        Assert.assertTrue(cartPage.isProductInCart(product2),
                product2 + " not found in cart!");
    }

    // 🔹 TC-04: Remove Item from Cart
    @Test
    public void testRemoveItemFromCart() {
        loginStandardUser();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addProductToCart(product1);
        productsPage.addProductToCart(product2);

        // Open cart
        productsPage.openCart();
        CartPage cartPage = new CartPage(driver);

        // Remove one product
        cartPage.removeProduct(product2);

        // Verify only 1 item remains and the removed one is gone
        Assert.assertEquals(cartPage.getItemsCount(), 1,
                "Cart should have 1 item after removal!");
        Assert.assertFalse(cartPage.isProductInCart(product2),
                product2 + " should have been removed from cart!");
        Assert.assertTrue(cartPage.isProductInCart(product1),
                product1 + " should still be in cart!");
    }

    // 🔹 TC-05: Complete Checkout Flow (E2E)
    @Test
    public void testSuccessfulCheckoutFlow() {
        loginStandardUser();

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getTitle(), "Products",
                "User did not land on Products page!");

        // Add product to cart
        productsPage.addProductToCart(product1);
        Assert.assertEquals(productsPage.getCartBadgeCount(), "1",
                "Cart badge count is not 1!");

        // Go to cart
        productsPage.openCart();

        // Verify cart details
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getItemsCount(), 1,
                "Cart does not contain exactly 1 item!");
        Assert.assertTrue(cartPage.isProductInCart(product1),
                product1 + " is not present in cart!");

        // Checkout
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterFirstName("Aniket");
        checkoutPage.enterLastName("Deshmukh");
        checkoutPage.enterPostalCode("416003");
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();

        // Assert success
        String successText = checkoutPage.getSuccessMessage();
        Assert.assertEquals(successText, "Thank you for your order!",
                "Order completion message not displayed!");
    }
}