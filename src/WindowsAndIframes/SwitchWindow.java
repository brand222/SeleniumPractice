package WindowsAndIframes;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindow {

	private WebDriver driver;
	private String baseUrl;
	private String chromeDriverName = "webdriver.chrome.driver";
	private String chromeDriverPath = "src\\chromedriver.exe";

	@Before
	public void setUp() throws Exception {
		System.setProperty(chromeDriverName, chromeDriverPath);
		driver = new ChromeDriver();
		baseUrl = "http://letskodeit.teachable.com/p/practice";

		// maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws InterruptedException {
		
		
		//WebElement txtField = driver.findElement(By.id("search-courses"));
		//txtField.sendKeys("python");
		
		// get the handle (the window) that the current focus is on
		//in this case, it will be the main page
		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent Handle is: " + parentHandle);
		WebElement openWindow = driver.findElement(By.id("openwindow"));
		openWindow.click();

		// get all handles once we open all windows we want to work with
		Set<String> handles = driver.getWindowHandles();
		// switch between handles by looping through the set list
		for (String handle : handles) {
			System.out.println(handle);
			//if the handle does NOT equal the parent handle
			if (!handle.equals(parentHandle)) {
				//switch to the handle
				driver.switchTo().window(handle);
				Thread.sleep(2000);
				//then click the element inside that new handle we switched to
				WebElement txtField = driver.findElement(By.id("search-courses"));
				txtField.sendKeys("python");
				Thread.sleep(2000);
				//now we are closing the window with the current focus
				driver.close();
				//now break out of the loop
				break;
			}
		}
		// switch back to parent window
		driver.switchTo().window(parentHandle);
		WebElement txtBox1 = driver.findElement(By.id("name"));
		txtBox1.sendKeys("test successful");
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
