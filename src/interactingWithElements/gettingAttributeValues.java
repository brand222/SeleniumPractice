package interactingWithElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class gettingAttributeValues {

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
		WebElement btnShow = driver.findElement(By.xpath("//*[@id='show-textbox']"));
		WebElement btnHide = driver.findElement(By.xpath("//*[@id='hide-textbox']"));
		WebElement element = driver.findElement(By.xpath("//*[@id='displayed-text']"));
		
		//here we are getting the attribute value for the field
		//to assert whether the field is displayed or not
		btnShow.click();
		isDisplayed(element);
		Thread.sleep(1000);
		btnHide.click();
		isDisplayed(element);
		
		
		
	}
	//created simple function for checking the element is dislayed or not
	//NOTE: we are asserting on the attrribute value 
	public static boolean isDisplayed(WebElement element) {
		//here is our attribute value we are creating a a variable
		String attributeValue = element.getAttribute("style");
		//if the value equals block, then its displayed, otherwise it isn't
		if (attributeValue.equals("display: block;")){
			System.out.println("Textfield is displayed");
			return true;
		}
		else
		{
			System.out.println("Textfield is not displayed");
			return false;
		}
	}

}