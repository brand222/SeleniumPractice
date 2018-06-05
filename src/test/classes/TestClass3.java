package test.classes;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.TemporaryFilesystem;

import page.classes.LoginPage;
import page.classes.MainPage;

public class TestClass3 {

	public static WebDriver driver;
	
	LoginPage loginPage;
	MainPage mainPage;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.navigate().to("https://letskodeit.teachable.com/");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	if (driver != null) {
		TemporaryFilesystem.getDefaultTmpFS().deleteTemporaryFiles();
		driver.close();
		driver.quit();
	}
	}

	@Test
	public void invalidLoginMessage() throws InterruptedException {
		loginPage = new LoginPage(driver);
		loginPage.btnLogin.click();
		Thread.sleep(3000);
		loginPage.LogIn(driver, "brandon@blah.com", "blah");
		Assert.assertTrue(loginPage.invalidLoginMsg.isDisplayed());
		if (loginPage.invalidLoginMsg.isDisplayed()) {
			System.out.println("It's there!");
			
		}
		else
		{
			System.out.println("NOT THERE :(");
		}
	}
	
	@Test
	public void LogIn() throws InterruptedException {
		loginPage = new LoginPage(driver);
		mainPage = new MainPage(driver);
		loginPage.btnLogin.click();
		loginPage.LogIn(driver, "Brandon_McDonald22@yahoo.com", "Passwordman123");
		Assert.assertTrue(mainPage.correctTitle(driver, "Let's Kode It"));
		mainPage.txt_findCourse.sendKeys("hell0");
	}
	
	@Test
	public void LogOut() throws InterruptedException {
		loginPage = new LoginPage(driver);
		mainPage = new MainPage(driver);
		loginPage.btnLogin.click();
		loginPage.LogIn(driver, "Brandon_McDonald22@yahoo.com", "Passwordman123");
		Assert.assertTrue(mainPage.correctTitle(driver, "Let's Kode It"));
		mainPage.selectLogout();
		
	}
	
	

}
