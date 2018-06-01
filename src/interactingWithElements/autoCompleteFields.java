package interactingWithElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class autoCompleteFields {

	public static void main(String[] args) throws InterruptedException {

		// create a webdriver object
		WebDriver driver;
		// set your driver name, driver path, and base URL
		String chromeDriverName, chromeDriverPath, baseURL;
		// NOTE: need to pass the 'http://' with the URL
		baseURL = "https://www.southwest.com/";
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
		 * ************************************************** Below is the
		 * useful code... **************************************************
		 */
		String searchingText = "Newark";
		String partialText = "New York";

		// here is the textfield where we will type our search
		WebElement txtDepart = driver.findElement(By.xpath("//input[@name='originAirport']"));
		txtDepart.sendKeys(partialText);

		// here is the auto-complete results that pop up after typing text to
		// field
		WebElement autoResultsWindow = driver.findElement(By.xpath("//ul[@id='air-city-departure-menu']"));

		// here we will create a list of the results that come back from
		List<WebElement> autoResults = autoResultsWindow.findElements(By.tagName("li"));
		Thread.sleep(3000);

		// alternatively, you can use the other type of for loop for this
		// to print out autoResults
		int size = autoResults.size();
		for (int i = 0; i < size; i++) {
			System.out.println(autoResults.get(i).getText());
		}

		// here we will loop through the list of results that come back from
		// auto-complete
		// and we will make a selection
		for (WebElement result : autoResults) {
			if (result.getText().contains(searchingText)) {
				result.click();
			}
		}
		// *[@id="air-city-departure-menu-item1"]

		System.out.println("DONE __________________");
	}
}
