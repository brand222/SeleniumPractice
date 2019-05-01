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

	/* Here is the constructor for the WebDriver interface */
	public Base(WebDriver driver) {
		this.driver = driver;
	}

	/* Go to a web url */
	public void goTo(String url) {
		driver.get(url);
	}

	/* Find an element by it's locator */
	public WebElement find(By locator) {
		return driver.findElement(locator);
	}

	/* Click an element by it's locator */
	public void click(By locator) {
		try {
			waitFor(ExpectedConditions.elementToBeClickable(locator), 10);
			find(locator).click();
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}

	}

	
	/*Scroll a WebElement into view (a webElement)*/
	public void scrollElementIntoView(WebElement element) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
	}

	
	/*Scroll an element into view by it's locator*/
	public void scrollElementIntoView(By locator) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", find(locator));
		Thread.sleep(500);
	}

	
	/* Return the text value of an element by it's locator */
	public String getText(By locator) {
		String textValue;
		textValue = find(locator).getText().trim();
		return textValue;
	}

	/* Return the text value of a Web Element */
	public String getText(WebElement element) {
		String textValue;
		textValue = element.getText().trim();
		return textValue;
	}

	/* Convert a String to an Integer */
	public int stringToInt(String string) {
		return Integer.parseInt(string);
	}

	/* Convert a String to a Double */
	public double stringToDouble(String string) {
		return Double.parseDouble(string);
	}

	/* Convert an Integer to a String */
	public String intToString(int number) {
		return Integer.toString(number);
	}

	/* Convert a Double to a String */
	public String doubleToString(double number) {
		return Double.toString(number);
	}

	/* Get the attribute value of a webelement by it's locator */
	public String getAttributeOfElement(By locator, String attribute) {
		return find(locator).getAttribute(attribute);
	}

	/* Get the attribute value of a Web Element */
	public String getAttributeOfElement(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	/* Enter a value into a textfield by it's locator */
	public void type(String inputText, By locator) {
		checkIfElementEnabled(locator);
		find(locator).sendKeys(inputText);
	}

	/* Enter a value into a textfield Web Element */
	public void type(String inputText, WebElement element) {
		checkIfElementEnabled(element);
		element.sendKeys(inputText);
	}

	/* Clear the value of a textfield by it's locator */
	public void clear(By locator) {
		find(locator).clear();
	}

	/*
	 * Determine if an element is displayed by Explicitly waiting for the element to
	 * become visible on the screen within a time-out period
	 */
	public boolean isDisplayed(By locator, int maxWaitTime) {
		waitFor(ExpectedConditions.visibilityOfElementLocated(locator), maxWaitTime);
			return isElementPresent(locator);
			}

	/*Determine if a WebElement is displayed by explicitly waiting for the element
	 * to become visible on the screen within a time-out period.*/
	public boolean isDisplayed(WebElement element, int maxWaitTime) {
		try {
			waitFor(ExpectedConditions.visibilityOf(element), maxWaitTime);
		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println(e);
			return false;
		} catch (org.openqa.selenium.NoSuchElementException exception) {
			System.out.println(exception);
			return false;
		}
		return true;
	}

	/*
	 * Determine if an element is present on the screen by trying to find it by it's
	 * locator
	 */
	public boolean isElementPresent(By locator) {
		try {
			find(locator);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println(e);
			return false;
		}
	}

	
	/*Verify whether a WebElement is present on the screen*/
	public boolean isElementPresent(WebElement element) {
		return element.isDisplayed();
	}

	// *Wait until an element is no longer visible on the screen (NOTE: This is
	// specific to locators only)*/
	public void waitUntilElementIsInvisible(By locator, int timeOut) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

	}

	/* Determine if an element by it's locator is enabled */
	public boolean checkIfElementEnabled(By locator) {
		return find(locator).isEnabled();
	}

	/* Determine if a Web Element is enabled */
	public boolean checkIfElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	/*parse a string value of an element and return a new string based on regex that you pass*/
	public String getRegexStringMatch(By locator, String regex) {
		String elementText = getText(locator);
		Pattern r = Pattern.compile(regex);
		//create matcher object
		Matcher m = r.matcher(elementText);
		m.find();
		return m.group().trim();
	}
	
	/*verify whether a javascript alert is displayed on the screen or not*/
	public boolean isAlertDisplayed() {
		try {
			Alert alert = driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	/*Get the  text of the javascript alert that has popped up*/
	public String getAlertText() {
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		return alertText;
	}

	/*Accept the javascript alert (click "OK" on the alert)*/
	public void acceptAlert() {
		// driver.switchTo().activeElement().sendKeys(Keys.ENTER);
		driver.switchTo().alert().accept();
	}

	/*Simply make the Javascript alert go away (click "Cancel" on the alert)*/
	public void dismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	
	/*Verify whether the browser is closed or not*/
	public boolean isBrowserClosed() {
		if (driver.toString().contains(null)) {
			System.out.println("All browser windows are closed");
			return true;
		} else {
			System.out.println("Browser failed to close");
			return false;
		}
	}

	/*
	 * Determine if an element's text value (by locator) matches what you are
	 * looking for
	 */
	public boolean checkElementText(By locator, String expectedText) {
		if (isDisplayed(locator, 5)) {
			return find(locator).getText().trim().equalsIgnoreCase(expectedText);
		}
		return false;
	}

	/* Get an element's text value and return it's integer-converted value */
	public int getIntValue(By locator) {
		Integer number;
		isDisplayed(locator, 5);
		String text = getText(locator);
		number = Integer.parseInt(text);
		return number;
	}

	/* Wait until a specific condition on a Web Element has occurred */
	public void waitFor(ExpectedCondition<WebElement> condition, Integer timeOut) {
		timeOut = timeOut != null ? timeOut : 5;
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(condition);
	}

	
	/*get the child elements of an element by tagname*/
	public List<WebElement> getChildElementsByTagName(By locator, String tagName) {
		List<WebElement> elements = find(locator).findElements(By.tagName(tagName));
		return elements;
	}

	
	/* Get the child elements of a Web Element by tagname */
	public List<WebElement> getChildElementsByTagName(WebElement element, String tagName) {
		List<WebElement> elements = element.findElements(By.tagName(tagName));
		return elements;
	}

	
	// get the child elements from a parent element
	public List<WebElement> getChildElementsByClass(By locator, String className) {
		List<WebElement> elements = find(locator).findElements(By.className(className));
		return elements;
	}

	
	/*Get the child elements of a WebElement by classname*/
	public List<WebElement> getChildElementsByClass(WebElement element, String className) {
		List<WebElement> elements = element.findElements(By.className(className));
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

	/* get child items of WebElement and click on desired element*/
	public void clickListItem(WebElement element, String text, String tagName) {

		try {
			List<WebElement> items = element.findElements(By.tagName(tagName));
			if (items.size() > 0) {
				for (WebElement i : items) {
					if (i.getText().trim().contains(text)) {
						i.click();
						break;
					} else {
						System.out.println(i.getText() + " is not a match");
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/*
	 * Get the children of a Web Element by it's locator and check to see if a
	 * specified element is selected
	 */
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

	/*
	 * Get the children of a Web Element by it's locator and check to see if a
	 * specified element is selected
	 */
	public boolean isListItemSelected(WebElement element, String text, String tagName) {
		boolean isSelected;
		List<WebElement> items = element.findElements(By.tagName(tagName));
		for (WebElement i : items) {
			if (i.getText().trim().equalsIgnoreCase(text)) {
				isSelected = i.isSelected();
				return isSelected;
			}
		}
		return false;
	}
	
	/* Get the file count of a particlar folder*/
	public int getFileCount(String dirPath) {
		File f = new File(dirPath);
		File[] files = f.listFiles();
		int count = files.length;
		return count;
	}
}

