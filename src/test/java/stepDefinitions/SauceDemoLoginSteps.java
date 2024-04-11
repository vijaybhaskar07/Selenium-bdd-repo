package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import pages.LoginPage;
import utilities.TestContextSetup;

public class SauceDemoLoginSteps {
	public WebDriver driver;
	TestContextSetup testContextSetup;
	LoginPage loginPage;

	public SauceDemoLoginSteps(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.loginPage = testContextSetup.pageObjectManager.getLoginPage();
	}

	@Given("^the user is on SauceDemo application$")
	public void the_user_is_on_SauceDemo_application() throws Throwable {

		loginPage.DoLogin("standard_user", "secret_sauce");
		Assert.assertTrue(loginPage.getLandingPage().contains("Swag Labs"));
	}
	
	
}
