package usefulMethods;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericMethods {

	WebDriver driver;

	public GenericMethods(WebDriver driver) {
		// here we are referencing our WebDriver variable outside the
		// constructor
		this.driver = driver;
	}

	// here we are simplifying our process of getting our selector
	public WebElement getElement(String locator, String type) {
		type = type.toLowerCase();
		if (type.equals("id")) {
			System.out.println("Using id: " + locator);
			return this.driver.findElement(By.id(locator));
		} else if (type.equals("xpath")) {
			System.out.println("Using xpath: " + locator);
			return this.driver.findElement(By.xpath(locator));
		} else if (type.equals("cssSelector")) {
			System.out.println("Using cssSelector: " + locator);
			return this.driver.findElement(By.cssSelector(locator));
		} else if (type.equals("linkText")) {
			System.out.println("Using linkText: " + locator);
			return this.driver.findElement(By.linkText(locator));
		} else {
			System.out.println("Locator type not supported");
			return null;
		}
	}

	public List<WebElement> getElementList(String locator, String type) {
		type = type.toLowerCase();
		List<WebElement> elementList = new ArrayList<WebElement>();
		if (type.equals("id")) {
			System.out.println("Using id: " + locator);
			elementList = this.driver.findElements(By.id(locator));
		} else if (type.equals("xpath")) {
			System.out.println("Using xpath: " + locator);
			elementList = this.driver.findElements(By.xpath(locator));
		} else if (type.equals("cssSelector")) {
			System.out.println("Using cssSelector: " + locator);
			elementList = this.driver.findElements(By.cssSelector(locator));
		} else if (type.equals("linkText")) {
			System.out.println("Using linkText: " + locator);
			elementList = this.driver.findElements(By.linkText(locator));
		} else {
			System.out.println("Locator type not supported");
		}
		
		if (elementList.isEmpty()) {
			System.out.println("Element not found with " + type + ": " + locator);
		}
		else {
			System.out.println("Element found with " + type + ": " + locator);
		}
		return elementList;
	}

	public boolean isElementPresent(String locator, String type) {

		List<WebElement> elementList = getElementList(locator, type);

		int size = elementList.size();

		if (size > 0) {
			System.out.println("ELEMENT PRESENT!");
			return true;
		} else {
			System.out.println("ELEMENT NOT PRESENT!");
			return false;
		}
	}

}
