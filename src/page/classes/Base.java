package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	private WebDriver driver;

	// constructor
	public Base(WebDriver driver) {
		this.driver = driver;
	}

	public void goTo(String url) {
		driver.get(url);
	}

	public WebElement find(By locator) {
		return driver.findElement(locator);
	}

	public void click(By locator) {
		find(locator).click();
	}

	public void type(String inputText, By locator) {
		find(locator).sendKeys(inputText);
	}

	public boolean isDisplayed(By locator, int maxWaitTime) {
		try {
			waitFor(ExpectedConditions.visibilityOfElementLocated(locator), maxWaitTime);
		} catch (org.openqa.selenium.TimeoutException exception) {
			return false;
		}
		return true;
	}

	public void waitFor(ExpectedCondition<WebElement> condition, Integer timeOut) {
		timeOut = timeOut != null ? timeOut : 5;
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(condition);
	}

}
