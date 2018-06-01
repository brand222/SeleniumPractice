package interactingWithElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendarSelections {

	public static void main(String[] args) {
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
		//click depart field
		WebElement txtDepartDate = driver.findElement(By.xpath("//*[@id='booking-form--flight-panel']/div[2]/div[2]/div[1]/a/span[1]"));
		txtDepartDate.click();
		//here we are hard-coding a date to pick (with a customized xpath)
		WebElement dateFROMSelect = driver.findElement(By.xpath("//*[@id='calendar-june-14']"));
		dateFROMSelect.click();
		//here we are selecting a date by creating a list (based on the tag type in the calendar)
		//and then looping through that list and clicking the item that we specify
		WebElement dateTOSelect = driver.findElement(By.xpath("//*[@id='booking-form--flight-panel']/div[2]/div[2]/div[2]/a/span[1]"));
		dateTOSelect.click();
		//here we are identifying the calendar month we want to work with
		WebElement calMonth = driver.findElement(By.xpath("//*[@id='calendar-descendant']/div[2]/div[2]/div"));
		//from the calendar month element, we create a list of child elements (representing the dates)
		List<WebElement> allValidDates = calMonth.findElements(By.tagName("td"));
		//for each web element within the list, if the date is 27, click it. then break out of loop
		for (WebElement date : allValidDates) {
			if (date.getText().equals("27")) {
				date.click();
				break;
			}
		}
		System.out.println("Done");
		
		
		
	}
}
