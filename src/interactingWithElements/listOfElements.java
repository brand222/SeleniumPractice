package interactingWithElements;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class listOfElements {

	public static void main(String[] args) throws InterruptedException {
		// create a webdriver object
		WebDriver driver;
		// set your driver name, driver path, and base URL
		String chromeDriverName, chromeDriverPath, baseURL;
		// NOTE: need to pass the 'http://' with the URL
		baseURL = "http://learn.letskodeit.com/p/practice";
		chromeDriverName = "webdriver.chrome.driver";
		chromeDriverPath = "C:\\Users\\bmcdonald\\Desktop\\SeleniumPractice\\SeleniumPractice\\src\\chromedriver.exe";
		// set the system property so selenium can work with the chromedriver
		System.setProperty(chromeDriverName, chromeDriverPath);
		// set the driver object equal to the chromedriver
		driver = new ChromeDriver();
		// implicitly wait 5 seconds before each action
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// maximize the window
		driver.manage().window().maximize();
		// open the browser and go to the site
		driver.get(baseURL);
		//here we create a list of webelements (in this case radio buttons)
		//we will use an enhanced for loop to 
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[contains(@type,'radio')and contains(@name,'cars')]"));
		
		for (WebElement element : radioButtons) {
			System.out.println("It is " + element.isEnabled() + " that the element is enabled");
			System.out.println(element.getAttribute("value"));
			

				Thread.sleep(1000);
				element.click();
			}
		}
	}

