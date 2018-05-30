package driverPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class chromeDriver {

	
	/* Here we are doing a simple google search of my name
	 * NOTE: This is just a simple way to test the chromedriver.
	 */
	public static void main(String[] args) {
		//create a webdriver object
		WebDriver driver;
		//set your driver name, driver path, and base URL
		String chromeDriverName, chromeDriverPath, baseURL;
		//NOTE: need to pass the 'http://' with the URL
		baseURL = "http://www.google.com";
		chromeDriverName = "webdriver.chrome.driver";
		chromeDriverPath = "C:\\Users\\bmcdonald\\Desktop\\SeleniumPractice\\SeleniumPractice\\src\\chromedriver.exe";
		//set the system property so selenium can work with the chromedriver
		System.setProperty(chromeDriverName, chromeDriverPath);
		//set the driver object equal to the chromedriver
		driver = new ChromeDriver();
		//implicitly wait 5 seconds before each action
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//maximize the window
		driver.manage().window().maximize();
		//open the browser and go to the site
		driver.get(baseURL);
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Brandon McDonald");
		driver.findElement(By.xpath("//input[@title='Search']")).click();
		driver.findElement(By.xpath("//input[@value='Google Search']")).click();
		String title = driver.getTitle();
		System.out.println("The title of the page is " + title);
	}
	
	
}
