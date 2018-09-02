package Tests;

import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.*;
import static Tests.Config.*;

public class Base {

	protected WebDriver driver;
	
	@Rule
	public ExternalResource resource = new ExternalResource() {
		
		@Override
		protected void before() throws Throwable {			
			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:/Users/Training/Desktop/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equals("ie")) {
				System.setProperty("webdriver.ie.driver", "C:/Users/Training/Desktop/Windows7-KB2990999-x64.msu");
				driver = new InternetExplorerDriver();
			}				
		}
		
		@Override
		protected void after() {
			driver.quit();
		}
	};
	
}
