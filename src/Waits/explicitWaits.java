package Waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//we must import this for using the explicit wait
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.waitTypes;

public class explicitWaits {

	public static void main(String[] args) {
		// create a webdriver object
		WebDriver driver = null;
		// set your driver name, driver path, and base URL
		String chromeDriverName, chromeDriverPath, baseURL;
		// NOTE: need to pass the 'http://' with the URL
		baseURL = "http://learn.letskodeit.com";
		waitTypes wt = new waitTypes(driver);
		chromeDriverName = "webdriver.chrome.driver";
		chromeDriverPath = "src\\chromedriver.exe";
		// set the system property so selenium can work with the chromedriver
		System.setProperty(chromeDriverName, chromeDriverPath);
		// set the driver object equal to the chromedriver
		driver = new ChromeDriver();

		// maximize the window
		driver.manage().window().maximize();

		/*
		 * In this example, we will provide an explicit wait on the email
		 * textfield ONLY for one element.
		 */
		driver.get(baseURL);

		WebElement loginLink = driver.findElement(By.linkText("Login"));
		loginLink.click();
		 //here we are creating our explicit wait object
		 WebDriverWait wait = new WebDriverWait(driver, 3);
		// here we are creating the condition to be met for the explicit wait
		 WebElement emailField =
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));

		// the above code is used for a basic explict wait on a web element
		// however, since we imported our utilities library, we can use our
		// customized method now
		//WebElement emailField = wt.waitForElement(By.xpath("//input[@type='email']"), 15);
		//emailField.sendKeys("Test@Test.org");
		driver.findElement(By.xpath("//*[@id='user_email']")).sendKeys("Test");
		
		wt.clickWhenReady(By.name("commit"), 3);
	}
}
