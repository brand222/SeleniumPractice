package usefulMethods;
import usefulMethods.GenericMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenericMethodsDemo {
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
	chromeDriverPath = "src\\chromedriver.exe";
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
	WebElement element = gm.getElement("name", "id");
	element.sendKeys("test");
}
	
	
		
	}

