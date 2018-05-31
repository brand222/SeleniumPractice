package interactingWithElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class hiddenElements {

	public static void main(String[] args) throws InterruptedException {
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
		Thread.sleep(3000);
		WebElement textBox = driver.findElement(By.xpath("//*[@id='displayed-text']"));
		WebElement btnHide = driver.findElement(By.xpath("//*[@id='hide-textbox']"));
		WebElement btnShow = driver.findElement(By.xpath("//*[@id='show-textbox']"));
		System.out.println("Textbox Displayed: " + textBox.isDisplayed());
		//here we hid the textbox
		btnHide.click();
		Thread.sleep(1000);
		System.out.println("After hiding the textbox");
		System.out.println("Textbox displayed: " + textBox.isDisplayed());
		//here we show the textbox
		btnShow.click();
		Thread.sleep(1000);
		System.out.println("After re-showing the textbox");
		//here we verify if it is displayed
		System.out.println("Textbox displayed: " + textBox.isDisplayed());
		
	}
}
