package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	protected WebDriver driver;

	public Base(WebDriver driver) {
		this.driver = driver;
	}

	// navigate to a URL
	public void goTo(String url) {
		driver.get(url);
	}

	// find an element by it's locator
	public WebElement find(By locator) {
		return driver.findElement(locator);
	}

	// click an element found by it's locator
	public void click(By locator) {
		find(locator).click();
	}

	// type something into a field
	public void type(String inputText, By locator) {
		find(locator).sendKeys(inputText);
	}

	// clear something out of a field
	public void clear(By locator) {
		find(locator).clear();
	}

	// verify if something is displayed
	public boolean isDisplayed(By locator, int maxWaitTime) {
		try {
			waitFor(ExpectedConditions.visibilityOfElementLocated((By) locator), maxWaitTime);
		} catch (org.openqa.selenium.TimeoutException exception) {
			return false;
		}
		return true;
	}

	// wait until an element is no longer displayed
	public void waitUntilElementIsInvisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	// check to see if an element is enabled or not
	public boolean checkIfElementEnabled(By locator) {
		if (find(locator).isEnabled()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkElementText(By locator, String expectedText) {
		if (isDisplayed(locator, 5) == true) {
			if (find(locator).getText().trim().contains(expectedText)) {
				return true;
			}
		}
		return false;
	}

	// wait for something for a specific amount of time
	public void waitFor(ExpectedCondition<WebElement> condition, Integer timeOut) {
		timeOut = timeOut != null ? timeOut : 5;
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(condition);
	}

	// get the child elements from a parent element
	public List<WebElement> getChildElements(By locator, String tagName) {
		List<WebElement> elements = find(locator).findElements(By.tagName(tagName));
		return elements;
	}

	// get child items and click on desired element
	public void clickListItem(By locator, String text, String tagName) {
		List<WebElement> items = find(locator).findElements(By.tagName(tagName));
		for (WebElement i : items) {
			if (i.getText().trim().contains(text)) {
				i.click();
				break;
			}
		}
	}
	
	// get child items and click on desired element
	public boolean isListItemSelected(By locator, String text, String tagName) {
		boolean isSelected;
		List<WebElement> items = find(locator).findElements(By.tagName(tagName));
		for (WebElement i : items) {
			if (i.getText().trim().equalsIgnoreCase(text)) {
				isSelected = i.isSelected();
				return isSelected;
			}
		}
		return false;
	}
	
}

