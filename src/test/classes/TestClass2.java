package test.classes;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import page.classes.searchPageFactory;

public class TestClass2 {
	private WebDriver driver;
	private String baseURL;
	private String chromeDriverName = "webdriver.chrome.driver";
	private String chromeDriverPath = "src\\chromedriver.exe";
	searchPageFactory searchPage;
	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty(chromeDriverName, chromeDriverPath);
		driver = new ChromeDriver();
		baseURL = "https://www.southwest.com/";

		// maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		searchPage = PageFactory.initElements(driver, searchPageFactory.class);
		
	}
	

	@Test
	public void test() throws InterruptedException {
		 searchPage.enterFlightInfo("HOU", "TIL");
		 searchPage.clickFlightButton();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
		
	}


}
