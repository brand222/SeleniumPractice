package screenshots;

import java.io.File;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.apache.commons.io.FileUtils; //we need to add this to the build path




public class testScreenshots {

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
		WebElement flight_origin = driver.findElement(By.xpath("//*[@id='air-city-departure']"));
		WebElement flight_destination = driver.findElement(By.xpath("//*[@id='air-city-arrival']"));
		WebElement departure_date = driver.findElement(By.xpath("//*[@id='air-date-departure']"));
		WebElement return_date = driver.findElement(By.xpath("//*[@id='air-date-return']"));
		WebElement btnSearch = driver.findElement(By.xpath("//*[@id='jb-booking-form-submit-button']"));
		
		//send data to elements
		flight_origin.sendKeys("New York");
		departure_date.sendKeys("09/03/2018");
		return_date.clear();
		return_date.sendKeys("09/10/2018");
		flight_destination.sendKeys("New York");
		btnSearch.click();

		
		//here is where we take a screenshot
		String fileName = getRandomString(10) + ".png";
		String directory = "//Users//bmcdonald//Desktop//";
		
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(sourceFile, new File(directory, fileName));
		//WE NEED TO IMPORT 
		
	}
	
	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for (int i = 0; i <= characters.length(); i++) {
			int index = (int) Math.random() * characters.length();
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}
}
