package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.InventoryPage;
import utilities.TestContextSetup;

public class SauceDemoInventorySteps {

	public WebDriver driver;
	TestContextSetup testContextSetup;
	InventoryPage inventoryPage;

	public SauceDemoInventorySteps(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.inventoryPage = testContextSetup.pageObjectManager.getInventoryPage();
	}

	@When("^the user selects a product \"(.*?)\"$")
	public void the_user_selects_a_product(String productName) {
		inventoryPage.DoClickOnProductLink(productName);
	}

	@When("^the user navigates to cart page$")
	public void the_user_navigates_to_cart_page() {
		inventoryPage.DoNavigateToCartPage();
	}

	@When("^the user clicks on Add to Cart button$")
	public void the_user_clicks_on_Add_to_Cart_button() {
		inventoryPage.DoClickOnAddToCartButton();
	}

	@Then("^the user navigated to the InventoryPage$")
	public void the_user_navigated_to_the_InventoryPage() {
		inventoryPage.VerifyUserOnInvertoryPage();
	}
}
