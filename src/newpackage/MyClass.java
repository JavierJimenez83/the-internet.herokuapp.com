package newpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MyClass {
	static WebDriver driver;
    static Wait<WebDriver> wait;

    public static void main(String[] args) {
    	
    	
    	
		
    }

    
    private static void form1() {
    	System.setProperty("webdriver.chrome.driver", "C:/Users/Training/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lehigh.edu/~inwww/form-test.html");

    	driver.findElement(By.name("input-text")).clear();
    	driver.findElement(By.xpath("//input[@type='TEXT']")).sendKeys("Text1");
    	driver.findElement(By.name("input-password")).clear();
    	driver.findElement(By.name("input-password")).sendKeys("Password2");
    	driver.findElement(By.name("textarea")).sendKeys("This is a text area... sladhvb");
    	driver.findElement(By.name("input-checkbox")).click();
    	driver.findElement(By.xpath("//input[@name='input-radio' and @value='unchecked']")).click();
    	driver.findElement(By.xpath("//select[@name='select-pop-up']/option[@value='value 4']")).click();
    	driver.findElement(By.xpath("//select[@name='select-list']/option[@value='value 1']")).click();
    	driver.findElement(By.xpath("//select[@name='select-list']/option[@value='value 2']")).click();
	}

    private static void form2() {
    	System.setProperty("webdriver.chrome.driver", "C:/Users/Training/Desktop/chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.get("https://www.roboform.com/filling-test-custom-fields");
    	
    	driver.findElement(By.xpath("//select[@name='ttl_select']/option[@value='Dr']")).click();
        driver.findElement(By.name("field1")).sendKeys("text1");   
    	driver.findElement(By.xpath("//input[@name='ttl' and @value='Dr']")).click();
        
    	driver.close();
        System.exit(1);
    }
    
    private static void insideFrame() {
    	System.setProperty("webdriver.chrome.driver", "C:/Users/Training/Desktop/chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.get("http://demo.guru99.com/selenium/deprecated.html");
        
    	driver.switchTo().frame("classFrame");
    	driver.findElement(By.linkText("Deprecated")).click();
    }
    
    private static void alertBox()
    {
    	System.setProperty("webdriver.chrome.driver", "C:/Users/Training/Desktop/chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.get("http://output.jsbin.com/usidix/1");

    	driver.findElement(By.xpath("//input[@type='button' and @value='Go!']")).click();
    	System.out.println(driver.switchTo().alert().getText());
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	driver.switchTo().alert().accept(); 
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
    }
    
    private static void checkAllLinks(){
    	System.setProperty("webdriver.chrome.driver", "C:/Users/Training/Desktop/chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.get("http://newtours.demoaut.com/");
  	
    	List<WebElement> linkElements = driver.findElements(By.tagName("a"));
    	String[] linkTexts = new String[linkElements.size()];
        int i = 0;

        //extract the link texts of each link element
        for (WebElement e : linkElements) {
            linkTexts[i] = e.getText();
            i++;
        }

        //test each link
        for (String t : linkTexts) {
            driver.findElement(By.linkText(t)).click();
            if (driver.getTitle().equals("Under Construction: Mercury Tours")) {
                System.out.println("\"" + t + "\""
                        + " is under construction.");
            } else {
                System.out.println("\"" + t + "\""
                        + " is working.");
            }
            driver.navigate().back();
        }
        driver.quit();
    }
        
    private static void getPokemonNames(){
    	System.setProperty("webdriver.chrome.driver", "C:/Users/Training/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://bulbapedia.bulbagarden.net/wiki/List_of_Pok%C3%A9mon_by_National_Pok%C3%A9dex_number");
    			
		List<WebElement> listTable;
		List<WebElement> listElement;
		String table;
		String namePokemon = "";
		try {
			table = "//table";
			listTable = driver.findElements(By.xpath(table));
			int limitTable = listTable.size();
			for(int j = 2; j < limitTable; j++)
	    	{
				try 
				{
					table = "//table[" + j + "]/tbody/tr";
					listElement = driver.findElements(By.xpath(table));
					int limitElement = listElement.size() + 1;
					for(int i = 2; i < limitElement; i++)
			    	{
						String cell = "//table[" + j + "]/tbody/tr[" + i + "]/td[4]";
						String newName = driver.findElement(By.xpath(cell)).getText();
						if (newName != namePokemon)
						{
				    		System.out.println(newName);
						}
						namePokemon = newName;
			    	}
				}								
				catch(NoSuchElementException nsee)
				{
		            //System.out.println(nsee.toString());
		        }
	    	}
		}
		catch(NoSuchElementException nsee)
		{
            //System.out.println(nsee.toString());
        }
    }
}
