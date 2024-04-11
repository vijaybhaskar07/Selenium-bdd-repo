package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(id = "user-name")
	public WebElement userName;
	@FindBy(id = "password")
	public WebElement password;

	// Locators
	private By _loginButton = By.xpath("//input[@type='submit']");
	private By _passwordInput = By.xpath("//input[@id='password']");
	private By _usernameInput = By.xpath("//input[@id='user-name']");
	private By _burgerMenuButton = By.xpath("//button[@id='react-burger-menu-btn']");
	private By _logoutButton = By.xpath("//a[@id='logout_sidebar_link']");

	public void DoLogin(String userName, String password) throws IOException {
		driver.findElement(_usernameInput).clear();
		driver.findElement(_usernameInput).sendKeys(userName);
		driver.findElement(_passwordInput).clear();
		driver.findElement(_passwordInput).sendKeys(password);
		driver.findElement(_loginButton).click();
		System.out.println(driver.getTitle());
	}
	
	public void DoLogOut(){
		driver.findElement(_burgerMenuButton).click();
		driver.findElement(_logoutButton).click();
		
	}
	
	public void validLogin(){
		driver.findElement(By.name("user-name")).sendKeys(null);
		driver.findElement(_logoutButton).click();
		
	}
	
	
	

	public String getLandingPage() {
		return driver.getTitle();
	}
}
