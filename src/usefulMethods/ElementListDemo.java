package usefulMethods;
import usefulMethods.GenericMethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementListDemo {
WebDriver driver;
private String baseURL;
public static GenericMethods gm;

public static void main(String[] args) {
	
	// create a webdriver object
	WebDriver driver;
	// set your driver name, driver path, and base URL
	String chromeDriverName, chromeDriverPath, baseURL;
	// NOTE: need to pass the 'http://' with the URL
	baseURL = "http://learn.letskodeit.com/p/practice";
	chromeDriverName = "webdriver.chrome.driver";
	chromeDriverPath = "C:\\Users\\Brandon Mc\\git\\Selenium\\SeleniumPractice\\src\\chromedriver.exe";
	// set the system property so selenium can work with the chromedriver
	System.setProperty(chromeDriverName, chromeDriverPath);
	// set the driver object equal to the chromedriver
	driver = new ChromeDriver();
	
	//create our object to use generic methods
	gm = new GenericMethods(driver);
	// implicitly wait 5 seconds before each action
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// maximize the window
	driver.manage().window().maximize();
	// open the browser and go to the site
	driver.get(baseURL);
	//here we are implementing our generic method to pass in the selector and it's type
	List <WebElement> elementList = gm.getElementList("//input[@type='text']", "xpath");
	int size = elementList.size();
	System.out.println("The list size is: " + size);
	
	boolean result = gm.isElementPresent("name", "id");
	System.out.println(result);
	
	boolean result2 = gm.isElementPresent("name-not-presentwgwrtvrt", "id");
	System.out.println(result2);
			
	
}
	
	
		
	}

