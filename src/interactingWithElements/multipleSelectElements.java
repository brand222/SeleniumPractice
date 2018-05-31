package interactingWithElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class multipleSelectElements {

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
		
		WebElement selectionBox = driver.findElement(By.xpath("//fieldset/select[@id='multiple-select-example']"));
		Select sel = new Select(selectionBox);
		
		sel.selectByValue("orange");
		sel.deselectByValue("orange");
		//selecting something 
		sel.selectByIndex(2);
		//selecting something by visible text
		sel.selectByVisibleText("Apple");
		//printing all selected options 
		List<WebElement> selectedOptions = sel.getAllSelectedOptions();
		// for each option we saved inside the list, we will print the text of that option
		for (WebElement option : selectedOptions) {
			System.out.println(option.getText());
		}
		//deselect all stuff
		sel.deselectAll();
		
	}
}
