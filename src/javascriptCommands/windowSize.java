package javascriptCommands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowSize {

	public static void main(String[] args) {
		// create a webdriver object
		WebDriver driver;
		
		JavascriptExecutor js;
		
		// set your driver name, driver path, and base URL
		String chromeDriverName, chromeDriverPath, baseURL;
		// NOTE: need to pass the 'http://' with the URL
		baseURL = "https://learn.letskodeit.com/p/practice";
		chromeDriverName = "webdriver.chrome.driver";
		chromeDriverPath = "src\\chromedriver.exe";
		
		
		// set the system property so selenium can work with the chromedriver
		System.setProperty(chromeDriverName, chromeDriverPath);
		// set the driver object equal to the chromedriver
		driver = new ChromeDriver();
		//here we are casting our driver to javascript executor
		js = (JavascriptExecutor) driver;
		// implicitly wait 5 seconds before each action
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// maximize the window
		driver.manage().window().maximize();
		// open the browser and go to the site
		//notice the difference in the way we open the url
		//driver.get(baseURL);
		js.executeScript("window.location = 'https://learn.letskodeit.com/p/practice';");
		/*
		 * ************************************************** Below is the
		 * useful code... **************************************************
		 */
		long height = (Long) js.executeScript("return window.innerHeight;");
		long width = (Long) js.executeScript("return window.innerWidth;");
		
		System.out.println("The height of the window is: " + height);
		System.out.println("The width of the window is : " + width);
	}
}
