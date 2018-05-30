package usefulMethods;

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
			System.out.println("Element found with id: " + locator);
			return this.driver.findElement(By.id(locator));
		} else if (type.equals("xpath")) {
			System.out.println("Element found with xpath: " + locator);
			return this.driver.findElement(By.xpath(locator));
		} else if (type.equals("cssSelector")) {
			System.out.println("Element found with cssSelector " + locator);
			return this.driver.findElement(By.cssSelector(locator));
		} else if (type.equals("linkText")) {
			System.out.println("Element found with linkText " + locator);
			return this.driver.findElement(By.linkText(locator));
		} else {
			System.out.println("Locator type not supported");
			return null;
		}
	}
	
	public List<WebElement> getElementList(String locator, String type) {
		type = type.toLowerCase();
		if (type.equals("id")) {
			System.out.println("Element found with id: " + locator);
			return this.driver.findElements(By.id(locator));
		}
		else if (type.equals("xpath")) {
			System.out.println("Element found with xpath: " + locator);
			return this.driver.findElements(By.xpath(locator));
		}
		else if (type.equals("cssSelector")) {
			System.out.println("Element found with cssSelector " + locator); 
			return this.driver.findElements(By.cssSelector(locator));
		}
	else if (type.equals("linkText")) {
		System.out.println("Element found with linkText " + locator); 
		return this.driver.findElements(By.linkText(locator));
	}
		else 
		{
			System.out.println("Locator type not supported");
			return null;
		}
	}

}
