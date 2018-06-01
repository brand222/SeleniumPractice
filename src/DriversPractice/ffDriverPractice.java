package DriversPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ffDriverPractice {
 
	public static void main(String[] args) throws InterruptedException {
		//pass our base URL as a string
				String baseURL = "http://www.google.com";
				//create our driver object variable
				WebDriver driver;
				//here we are mapping to the chromedriver executible
				System.setProperty("webdriver.gecko.driver", "src//geckodriver.exe");
				//after we set our chromedriver, we set our driver variable equal to chromedriver object
				driver = new FirefoxDriver();
				//here we maximize the window
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				//here we get the base url
				driver.get(baseURL);
				WebElement txtfield = driver.findElement(By.xpath("//*[@id='lst-ib']"));
				txtfield.sendKeys("Brandon McDonald");
				txtfield.click();
				WebElement btnSearch = driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[3]/center/input[1]"));
				btnSearch.sendKeys(Keys.ENTER);
				String pageTitle = driver.getTitle();
				System.out.println("The title of the page is: " + pageTitle);
			}
	}
