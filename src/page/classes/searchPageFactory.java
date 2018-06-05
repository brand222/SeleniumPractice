package page.classes;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class searchPageFactory {
	
	static WebDriver driver;

	@FindBy(name = "originAirport")
	static WebElement txtDepart;

	@FindBy(id = "air-city-arrival")
	static WebElement txtArrive;

	@FindBy(id = "air-date-departure")
	static WebElement txtDepartDt;

	@FindBy(id = "air-date-return")
	static WebElement txtReturnDt;

	@FindBy(id = "air-pax-count-adults")
	@CacheLookup
	static WebElement btnAdults;

	@FindBy(id = "air-pax-count-seniors")
	static WebElement btnSeniors;

	@FindBy(id = "jb-booking-form-submit-button")
	static WebElement btnSearch;

	@FindBy(id = "trip-type-one-way")
	static WebElement rbtnOneway;

	// here we are creating a constructor that initiates the instance of the
	// webdriver class
	public searchPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickFlightButton() {
		btnSearch.click();
	}

	public void enterFlightInfo(String dept, String arrival) throws InterruptedException  {
		txtDepart.sendKeys(dept);
		Thread.sleep(500);
		txtArrive.sendKeys(arrival);
		Thread.sleep(500);
		txtDepartDt.clear();
		txtDepartDt.sendKeys("07/11/2018");
		Thread.sleep(500);
		txtReturnDt.clear();
		txtReturnDt.sendKeys("07/29/2018");
	}
}
