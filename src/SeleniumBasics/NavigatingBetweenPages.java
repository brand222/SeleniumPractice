package SeleniumBasics;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class NavigatingBetweenPages {
	WebDriver driver;
	String baseURL, driverName, driverPath;
	
	// opening the browser, maximizing window, setting up driver object
	@Before
	public void setUp() throws Exception {
		driverName = "webdriver.chrome.driver";
		driverPath = "src\\chromedriver.exe";
		System.setProperty(driverName, driverPath);
		driver = new ChromeDriver();
		baseURL = "http://letskodeit.teachable.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);
		
		String title = driver.getTitle();
		System.out.println("the title is: " + title);
		String currentURL = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currentURL);
		
		String urlToNavigate = "https://www.google.com";
		driver.navigate().to(urlToNavigate);
		
		currentURL = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currentURL);
		Thread.sleep(2000);
		//this will go to the previous page (back)
		driver.navigate().back();
		System.out.println("Navigate back");
		currentURL = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currentURL);
		Thread.sleep(2000);
		//this will take you forward to the next page
		driver.navigate().forward();
		System.out.println("navigate forward");
		currentURL = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currentURL);
		
		driver.navigate().refresh();
		System.out.println("navigate refresh");
		driver.get(baseURL);
		
		String pageSource = driver.getPageSource();
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
