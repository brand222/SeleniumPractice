package DriversPractice;
//we need to import this to use the driver object
import org.openqa.selenium.WebDriver;
//here we are importing our chrome driver
import org.openqa.selenium.chrome.ChromeDriver;

public class cDriverPractice {

	public static void main(String[] args) {
		//pass our base URL as a string
		String baseURL = "http://www.google.com";
		//create our driver object variable
		WebDriver driver;
		//here we are mapping to the chromedriver executible
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Brandon Mc\\git\\SeleniumPractice\\SeleniumFramework\\libs\\chromedriver.exe");
		//after we set our chromedriver, we set our driver variable equal to chromedriver object
		driver = new ChromeDriver();
		//here we maximize the window
		driver.manage().window().maximize();
		//here we get the base url
		driver.get(baseURL);
	}
}
