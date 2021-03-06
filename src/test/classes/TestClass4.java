package test.classes;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.classes.subPOM;

public class TestClass4 {
	private static WebDriver driver;
	 subPOM pom;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String baseURL = "http://www.google.com/";
		driver.get(baseURL);
	}

	@Test
	public void login_goToAccountPage() throws InterruptedException {
		pom = new subPOM(driver);
		//login
		pom.LogIn();
		//assert that we are on the main page
		Assert.assertTrue(pom.onMainPage());
		//open account page
		pom.enterProfilePage();
		//assert we are on the profile page
		Assert.assertTrue(pom.onAccountPage());
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

}
