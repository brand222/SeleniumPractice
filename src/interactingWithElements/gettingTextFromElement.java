package interactingWithElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class gettingTextFromElement {

	public static void main(String[] args) throws InterruptedException {
		// create a webdriver object
		WebDriver driver;
		// set your driver name, driver path, and base URL
		String chromeDriverName, chromeDriverPath, baseURL;
		// NOTE: need to pass the 'http://' with the URL
		baseURL = "http://learn.letskodeit.com/p/practice";
		chromeDriverName = "webdriver.chrome.driver";
		chromeDriverPath = "C:\\Users\\bmcdonald\\Desktop\\SeleniumPractice\\SeleniumPractice\\src\\chromedriver.exe";
		// set the system property so selenium can work with the chromedriver
		System.setProperty(chromeDriverName, chromeDriverPath);
		// set the driver object equal to the chromedriver
		driver = new ChromeDriver();
		// implicitly wait 5 seconds before each action
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// maximize the window
		driver.manage().window().maximize();
		// open the browser and go to the site
		driver.get(baseURL);
		
		/*
		 * **************************************************
		 * Below is the useful code...
		 * **************************************************
		 */
		
		WebElement button = driver.findElement(By.xpath("//button[@id='openwindow']"));
		//.getText() returns a string value of what text is contained inside the element tag
		String buttonText = button.getText();
		System.out.println(buttonText);
	}
}
