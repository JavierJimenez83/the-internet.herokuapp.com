package testspackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tests {

	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Training/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void suceeded() {
		driver.get("http://the-internet.herokuapp.com/login");
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector("button")).click();
		assertTrue("Success message not present", driver.findElement(By.cssSelector(".flash.success")).isDisplayed());
	}

	@After
	public void teardown() {
		driver.quit();
	}
}
