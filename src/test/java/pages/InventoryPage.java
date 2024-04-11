package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InventoryPage {

    public WebDriver driver;

    // Locators
    private By _headingLabel = By.xpath("//div[@id='header_container']//div[text()='Swag Labs']");
    private By _addToCartButton = By
            .xpath("//div[@id='inventory_item_container' or 'inventory_container']//div//button[text()='Add to cart']");
    private By _cartIcon = By.xpath("//div[@id='header_container']//div[@id='shopping_cart_container']//a");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void DoClickOnAddToCartButton() {
        driver.findElement(_addToCartButton).click();
    }

    public void DoClickOnProductLink(String productName) {
        By productLocator = By.xpath("//div[@id='inventory_container']//a//div[text()='" + productName + "']");
        driver.findElement(productLocator).click();
    }

    public void DoNavigateToCartPage() {
        driver.findElement(_cartIcon).click();
    }

    public void VerifyUserOnInvertoryPage() {
        Assert.assertTrue(driver.findElement(_headingLabel).isDisplayed(), "User is not in the Inventory page");
    }

}
