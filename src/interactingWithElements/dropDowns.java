package interactingWithElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//here we are working with the 'select' class
import org.openqa.selenium.support.ui.Select;

public class dropDowns {

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
		// implicitly wait 5 seconds before each action
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// maximize the window
		driver.manage().window().maximize();
		// open the browser and go to the site
		driver.get(baseURL);
		/*
		 * **************************************************
		 * Below is the useful code...
		 * **************************************************
		 */
		
		Select dropdownMenuOptions = new Select(driver.findElement(By.xpath("//select[@id='carselect']")));
		//selecting by the visible text
		dropdownMenuOptions.selectByVisibleText("Benz");
		//selecting by the index position
		dropdownMenuOptions.selectByIndex(2);
		//here we will create a list and print out all the options
		List<WebElement> dropdown = dropdownMenuOptions.getOptions();
		
		for (WebElement element: dropdown) {
			System.out.println(element.getText());
		}
		
	}
}
