package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;

    private By firstNameInput = By.id("first-name");
    private By lastNameInput  = By.id("last-name");
    private By postalCodeInput = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton   = By.id("finish");
    private By successMessage = By.cssSelector("h2.complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {
        driver.findElement(postalCodeInput).sendKeys(postalCode);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void clickFinish() {
        driver.findElement(finishButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}