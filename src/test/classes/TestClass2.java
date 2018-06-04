package test.classes;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import page.classes.SearchPage;
import page.classes.searchPageFactory;

public class TestClass2 {
	private WebDriver driver;
	private String baseURL;
	private String chromeDriverName = "webdriver.chrome.driver";
	private String chromeDriverPath = "src\\chromedriver.exe";
	searchPageFactory searchPage;
	//here we create an object of type searchPageFactory
	@BeforeClass
	public void setUp() throws Exception {
		System.setProperty(chromeDriverName, chromeDriverPath);
		searchPage = new searchPageFactory(driver);
		driver = new ChromeDriver();
		baseURL = "https://www.southwest.com/";
		// maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		
	}
	

	@Test
	public void test() throws InterruptedException {
		searchPage.enterFlightInfo("HOU", "LIT");
		searchPage.clickFlightButton();
	}
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
		
	}


}
