package Waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import usefulMethods.GenericMethods;

public class implicitWaits {

	public static void main(String[] args) {
		
		// create a webdriver object
		WebDriver driver;
		// set your driver name, driver path, and base URL
		String chromeDriverName, chromeDriverPath, baseURL;
		// NOTE: need to pass the 'http://' with the URL
		baseURL = "http://learn.letskodeit.com";
		chromeDriverName = "webdriver.chrome.driver";
		chromeDriverPath = "src\\chromedriver.exe";
		// set the system property so selenium can work with the chromedriver
		System.setProperty(chromeDriverName, chromeDriverPath);
		// set the driver object equal to the chromedriver
		driver = new ChromeDriver();
		
		// maximize the window
		driver.manage().window().maximize();
		
		
		
		/*
		 * Here is the creation of an implicit wait. This wait will apply to all statements.
		 * We implicitly know that it will wait for 2 seconds between each statement before throwing
		 * and exception.
		 */
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// open the browser and go to the site
		driver.get(baseURL);
		
		WebElement loginLink = driver.findElement(By.linkText("Login"));
		loginLink.click();
		
		driver.findElement(By.xpath("//*[@id='user_email']")).sendKeys("Test");
	}
}
