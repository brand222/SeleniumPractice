package linksFromPage;

import static org.junit.Assert.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.TemporaryFilesystem;

import com.sun.jndi.toolkit.url.Uri;

import page.classes.LoginPage;
import page.classes.MainPage;

public class linksFromAPage {
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
	public void test() {
		loginPage = new LoginPage(driver);
		mainPage = new MainPage(driver);
		//here we will be getting all of the links in the page
		loginPage.btnLogin.click();
		
		List<WebElement> linkslist = clickableLinks(driver);
		for(WebElement link : linkslist) {
			String href = link.getAttribute("href");
			try {
				System.out.println("URL:  " + href + " returned" + linkStatus(new URL(href)));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static List<WebElement> clickableLinks(WebDriver driver ) {
		List<WebElement> linksToClick = new ArrayList<WebElement>();
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		elements.addAll(driver.findElements(By.tagName("img")));
		//for each element in the element list
		for (WebElement e : elements) {
			//if the element in the list has a href, then we add it to the links to click list
			if (e.getAttribute("href") != null) {
				linksToClick.add(e);
			}
		}
		return linksToClick;
	}
	
	public static String linkStatus(URL url) {
		try {
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.connect();
			String responseMessage = http.getResponseMessage();
			http.disconnect();
			return responseMessage;
		}
		catch (Exception e) {
			return e.getMessage();
		}
	}

}
