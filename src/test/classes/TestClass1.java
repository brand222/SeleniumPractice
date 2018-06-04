package test.classes;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.classes.SearchPage;

public class TestClass1 {
	private WebDriver driver;
	private String baseURL;
	private String chromeDriverName = "webdriver.chrome.driver";
	private String chromeDriverPath = "src\\chromedriver.exe";
	@Before
	public void setUp() throws Exception {
		System.setProperty(chromeDriverName, chromeDriverPath);
		driver = new ChromeDriver();
		baseURL = "https://www.southwest.com/";

		// maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		
	}
	

	@Test
	public void test() throws InterruptedException {
		SearchPage.enterSearchData(driver, "HOU", "LIT");
		SearchPage.clickOnSearchButton(driver);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
		
	}


}
