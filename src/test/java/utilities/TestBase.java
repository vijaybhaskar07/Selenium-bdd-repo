package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/global.properties");
		Properties prop = new Properties();
		prop.load(fis);

		if (driver == null) {
			switch (prop.getProperty("browser").toLowerCase()) {
				case "chrome":
					WebDriverManager.chromedriver().clearDriverCache().setup();
					WebDriverManager.chromedriver().setup();				
					driver = new ChromeDriver();
					break;
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new ChromeDriver();
					break;
				case "headless":
				default:
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--headless");
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver(options);
					break;
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(prop.getProperty("URL"));
			
		}
		return driver;
	}
}
