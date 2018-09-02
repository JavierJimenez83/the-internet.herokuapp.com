package pageobjects;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Base {

	By loginFormLocator = By.id("login");
	By userNameLocator = By.id("username");
	By passwordLocator = By.id("password");
	By submitButton = By.cssSelector("button");
	By successMessageLocator = By.cssSelector(".flash.success");
	By failMessageLocator = By.cssSelector(".flash.error");
	
	public Login(WebDriver driver)
	{
		super(driver);
		visit("/login");	
		assertTrue("The login form is not present", isDisplayed(loginFormLocator));		
	}
	
	public void with(String username, String password)
	{
		type(username, userNameLocator);
		type(password, passwordLocator);
		click(submitButton);		
	}
	
	public Boolean successMessagePresent() {
		return isDisplayed(successMessageLocator);
	}
	
	public Boolean failMessagePresent() {
		return isDisplayed(successMessageLocator);
	}
}
