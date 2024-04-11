package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage {

    public WebDriver driver;
    // Locators
    private By _removeButton = By.xpath("//div[@id='cart_contents_container']//div//button[text()='Remove']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void VerifyProductOnCartPage(String productName, Boolean isNotDisplayed) {
        By productLocator = By.xpath("//div[@id='cart_contents_container']//a//div[text()='" + productName + "']");
        int isDisplayed = driver.findElements(productLocator).size();
        if (isDisplayed == 0) {
            Assert.assertTrue(isNotDisplayed, "Added product is not displayed in the cart page");
        } else {
            Assert.assertFalse(isNotDisplayed, "Added product is displayed in the cart page");
        }
    }

    public void DoClickOnRemoveButton() {
        driver.findElement(_removeButton).click();
    }
}
