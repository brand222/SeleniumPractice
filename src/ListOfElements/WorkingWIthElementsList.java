package ListOfElements;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class WorkingWIthElementsList {
	WebDriver driver;
	
	String driverName, baseURL, driverPath;

	@Before
	public void setUp() throws Exception {
		baseURL = "https://learn.letskodeit.com/p/practice";
		driverName = "webdriver.chrome.driver";
		driverPath = "src\\chromedriver.exe";
		System.setProperty(driverName, driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
	}
	//here we are creating a list of radio buttons and printing out the attribute values
	@Test
	public void testListOfElements() throws InterruptedException {
		boolean isChecked = false;
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[contains(@type, 'radio') and contains(@name, 'cars')]"));
		//this for loop gets the attribute value for each radio button
		//then this loop checks whether each radio button is selected or not
		for (WebElement element : radioButtons) {
			System.out.println(element.getAttribute("value"));
			isChecked = element.isSelected();
			System.out.println(isChecked);
			
			if (!isChecked){
				element.click();
				Thread.sleep(2000);
				
			}
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	

}
