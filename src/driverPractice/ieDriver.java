package driverPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ieDriver {
	
	public static void main(String[] args) {
		//create a webdriver object
		WebDriver driver;
		//set your driver name, driver path, and base URL
		String ieDriverName, ieDriverPath, baseURL;
		//NOTE: need to pass the 'http://' with the URL
		baseURL = "http://www.google.com";
		ieDriverName = "webdriver.ie.driver";
		ieDriverPath = "C:\\Users\\bmcdonald\\Desktop\\SeleniumPractice\\SeleniumPractice\\src\\IEDriverServer.exe";
		//set the system property so selenium can work with the iedriver
		System.setProperty(ieDriverName, ieDriverPath);
		//set the driver object equal to the iedriver
		driver = new InternetExplorerDriver();
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
	
