package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

	public static WebElement element = null;
	
	/**
	 * Returns the flight origin text box element
	 * @param driver
	 * @return
	 */
	
	public static WebElement txtOrigin(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='air-city-departure']"));
		return element;
	}
	
	public static WebElement txtDestination(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='air-city-arrival']"));
		return element;
	}
	
	public static WebElement txtDepartureDt(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='air-date-departure']"));
		return element;
	}
	
	public static WebElement txtReturnDt(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='air-date-return']"));
		return element;
	}
	
	public static WebElement btnSearch(WebDriver driver) {
		element = driver.findElement(By.id("jb-booking-form-submit-button"));
		return element;
	}
	
	/**
	 * Enter search data
	 * @param driver
	 * @return
	 * @throws InterruptedException 
	 */
	
	
	public static void enterSearchData(WebDriver driver, String origin, String dest) throws InterruptedException{
		fillOriginField(driver, origin);
		Thread.sleep(500);
		fillDestinationField(driver, dest);
		Thread.sleep(500);
		fillDepartDtField(driver, "07/01/2018");
		Thread.sleep(500);
		fillArriveDtField(driver, "07/14/2018");
	}
	
	public static void fillOriginField(WebDriver driver, String text) {
		txtOrigin(driver).sendKeys(text);
	}
	
	public static void fillDestinationField(WebDriver driver, String text) {
		txtDestination(driver).sendKeys(text);
	}
	
	public static void fillDepartDtField(WebDriver driver, String text) {
		txtDepartureDt(driver).clear();
		txtDepartureDt(driver).sendKeys(text);
	}
	
	public static void fillArriveDtField(WebDriver driver, String text) {
		txtReturnDt(driver).clear();
		txtReturnDt(driver).sendKeys(text);
	}
	
	/**
	 * Click on search button
	 * @param driver
	 * @return
	 */
	public static void clickOnSearchButton(WebDriver driver) {
		element = btnSearch(driver);
		element.click();
	}
	
	
}
