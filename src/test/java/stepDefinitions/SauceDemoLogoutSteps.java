package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import utilities.TestContextSetup;

public class SauceDemoLogoutSteps {
	public WebDriver driver;
	TestContextSetup testContextSetup;
	LoginPage loginPage;

	public SauceDemoLogoutSteps(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.loginPage = testContextSetup.pageObjectManager.getLoginPage();
	}

	@Given("^the user is on Saucedemo application$")
	public void the_user_is_on_Saucedemo_application() throws Throwable {
		loginPage.DoLogin("standard_user", "secret_sauce");
		Assert.assertTrue(loginPage.getLandingPage().contains("Swag Labs"));
	}
	
	@Then("^the user clicks on logout button$")
	public void the_user_clicks_on_logout_button() {
		loginPage.DoLogOut();
	    
	}
	
	@Then("^the user navigates to swaglabs page$")
	public void the_user_navigates_to_swaglabs_page() {
		Assert.assertTrue(loginPage.getLandingPage().contains("Swag Labs"));
	    
	}
	
}
