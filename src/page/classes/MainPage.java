package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {

	public WebDriver driver;
	
	@FindBy(xpath = "//*[@id='search-courses']")
	public WebElement txt_findCourse;
	
	@FindBy(xpath = "")
	public WebElement btnSearch;
	
	@FindBy(xpath = "//*[@id='navbar']/div/div/div/ul/li[4]/a/img")
	public WebElement menuDropdown;
	
	@FindBy(xpath = "//*[@id='navbar']/div/div/div/ul/li[4]/ul/li[5]/a")
	public WebElement btnLogout;
	
	
	public void logout(WebDriver driver) {
		menuDropdown.click();
		btnLogout.click();
	}
	
	public boolean correctTitle(WebDriver driver, String expectedTitle) {
		String actualTitle = driver.getTitle();
		if (actualTitle.toLowerCase().equals(expectedTitle.toLowerCase())) {
			return true;
		}
		else
			return false;
	}
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
