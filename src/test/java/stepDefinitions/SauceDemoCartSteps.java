package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import utilities.TestContextSetup;

public class SauceDemoCartSteps {

	public WebDriver driver;
	TestContextSetup testContextSetup;
	CartPage cartPage;

	public SauceDemoCartSteps(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.cartPage = testContextSetup.pageObjectManager.getCartPage();
	}

	@When("^the user clicks on Remove button$")
	public void the_user_clicks_on_Remove_button() {
		cartPage.DoClickOnRemoveButton();
	}

	@Then("^the product \"(.*?)\" should not be displayed in the cart$")
	public void the_product_should_not_be_displayed_in_the_cart(String productName) {
		cartPage.VerifyProductOnCartPage(productName, true);
	}

	@Then("^the product \"(.*?)\" should be displayed in the cart$")
	public void the_product_should_be_displayed_in_the_cart(String productName) {
		cartPage.VerifyProductOnCartPage(productName, false);
	}
}
