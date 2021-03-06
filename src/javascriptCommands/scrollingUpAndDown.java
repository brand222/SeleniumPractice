package javascriptCommands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scrollingUpAndDown {

	public static void main(String[] args) throws InterruptedException {
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
		// here we are casting our driver to javascript executor
		js = (JavascriptExecutor) driver;
		// implicitly wait 5 seconds before each action
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// maximize the window
		driver.manage().window().maximize();
		// open the browser and go to the site
		// notice the difference in the way we open the url
		// driver.get(baseURL);
		js.executeScript("window.location = 'https://learn.letskodeit.com/p/practice';");
		/*
		 * ************************************************** Below is the
		 * useful code... **************************************************
		 */
		
		Thread.sleep(2000);
		
		//scroll down: scrollBy(horizontal, vertical)
		js.executeScript("window.scrollBy(0, 1900); ");
		Thread.sleep(2000);
		
		//scroll up
		js.executeScript("window.scrollBy(0, -1900); ");
		Thread.sleep(2000);
		
		//Scroll element into view
		WebElement element = driver.findElement(By.id("mousehover"));
		//here we provide empty argument that we 'scroll into view' by passing in the 'element' as an argument
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -190);");
		
	}
}
