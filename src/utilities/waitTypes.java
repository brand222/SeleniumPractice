package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitTypes {
	WebDriver driver;

	public waitTypes(WebDriver driver) {
		this.driver = driver;
	}
	//here we created an explict wait method
	public WebElement waitForElement(By locator, int timeOut) {
		WebElement element = null;
		try {
			System.out.println("Waiting for max: " + timeOut + " seconds for element to be available");
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			element = wait.until(
					ExpectedConditions.visibilityOfElementLocated(locator));
			System.out.println("Element appeared on the web page");
		} catch (Exception e) {
			System.out.println("Element not appeared on the web page");
		}
		return element;
	}
	public WebElement clickWhenReady(By locator, int timeOut) {
		WebElement element = null;
		try {
			System.out.println("Waiting for max: " + timeOut + " seconds for element to be clickable");
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			element = wait.until(
					ExpectedConditions.elementToBeClickable(locator));
			element.click();
			System.out.println("Element clicked on the web page");
		} catch (Exception e) {
			System.out.println("Element not clicked on the web page");
		}
		return element;

	}
}
