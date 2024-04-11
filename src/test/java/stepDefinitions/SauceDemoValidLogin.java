package stepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.TestContextSetup;
import static org.hamcrest.CoreMatchers.containsString;

public class SauceDemoValidLogin {
	public WebDriver driver;
	/*
	 * TestContextSetup testContextSetup; LoginPage loginPage;
	 */

	/*
	 * public SauceDemoValidLogin(TestContextSetup testContextSetup) {
	 * this.testContextSetup = testContextSetup; this.loginPage =
	 * testContextSetup.pageObjectManager.getLoginPage(); }
	 */
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");

	}

	@Given("^User is on the Login Page$")
	public void the_user_is_on_SauceDemo_application() throws Throwable {
		System.out.println(driver.getTitle());
		
	}

	@When("^User enters Credentials:$")

	public void entersValidCredential(DataTable dataTable) throws InterruptedException {

		System.out.println("Credentials Entered");
		List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> credential : credentials) {
			String username = credential.get("Username");
			String password = credential.get("Password");
			driver.findElement(By.id("user-name")).sendKeys(username);
			Thread.sleep(3000);
			driver.findElement(By.id("password")).sendKeys(password);
			Thread.sleep(3000);

			driver.findElement(By.id("login-button")).click();
			String text = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
			System.out.println(text);
			Thread.sleep(3000);
			
		}


	}

	@Then("^User should see the swaglabs page$")
	public void the_user_navigates_to_swaglabs_page() {
		
		driver.close();

	}

}
