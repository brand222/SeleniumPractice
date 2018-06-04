package page.classes;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class searchPageFactory {
	
	WebDriver driver;

	@FindBy(name = "originAirport")
	WebElement txtDepart;

	@FindBy(id = "air-city-arrival")
	WebElement txtArrive;

	@FindBy(id = "air-date-departure")
	WebElement txtDepartDt;

	@FindBy(id = "air-date-return")
	WebElement txtReturnDt;

	@FindBy(id = "air-pax-count-adults")
	@CacheLookup
	WebElement btnAdults;

	@FindBy(id = "air-pax-count-seniors")
	WebElement btnSeniors;

	@FindBy(id = "jb-booking-form-submit-button")
	WebElement btnSearch;

	@FindBy(id = "trip-type-one-way")
	WebElement rbtnOneway;

	// here we are creating a constructor that initiates the instance of the
	// webdriver class
	public searchPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickFlightButton() {
		btnSearch.click();
	}

	public void enterFlightInfo(String dept, String arrival) {
		txtDepart.sendKeys(dept);
		txtArrive.sendKeys(arrival);
		txtDepartDt.sendKeys("07/11/2018");
		txtReturnDt.sendKeys("07/29/2018");
	}
}
