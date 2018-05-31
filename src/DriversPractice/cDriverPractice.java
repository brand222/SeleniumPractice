package DriversPractice;
import org.openqa.selenium.By;
//we need to import this to use the driver object
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//here we are importing our chrome driver
import org.openqa.selenium.chrome.ChromeDriver;

public class cDriverPractice {

	public static void main(String[] args) {
		//pass our base URL as a string
		String baseURL = "http://www.google.com";
		//create our driver object variable
		WebDriver driver;
		//here we are mapping to the chromedriver executible
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Brandon Mc\\git\\Selenium\\SeleniumPractice\\src\\chromedriver.exe");
		//after we set our chromedriver, we set our driver variable equal to chromedriver object
		driver = new ChromeDriver();
		//here we maximize the window
		driver.manage().window().maximize();
		//here we get the base url
		driver.get(baseURL);
		WebElement txtfield = driver.findElement(By.xpath("//*[@id='lst-ib']"));
		txtfield.sendKeys("Brandon McDonald");
		txtfield.click();
		WebElement btnSearch = driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[3]/center/input[1]"));
		btnSearch.click();
		String pageTitle = driver.getTitle();
		System.out.println("The title of the page is: " + pageTitle);
	}
}
