package Tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import pageobjects.Login;

public class TestLogin extends Base {

	private Login login;
	
	@Before
	public void setUp() {
		login = new Login(driver);
	}
	
	@Test
	public void suceeded() {
		login.with("tomsmith", "SuperSecretPassword!");
		assertTrue("Success message not present", login.successMessagePresent());
	}

	@Test
	public void failed() {
		login.with("tomsm", "WrongPassword?");
		//assertTrue("Failure message not present", login.failMessagePresent());
		assertFalse("Success message present", login.successMessagePresent());
	}	
}
