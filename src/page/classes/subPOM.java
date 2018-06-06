package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.sun.org.apache.bcel.internal.classfile.Visitor;

public class subPOM extends Base {
	
	
	public subPOM(WebDriver driver) {
		super(driver);
	}
	String baseURL = "http://www.google.com/";
	
	//page elements
	By btnLoginLocator = By.id("gb_70");
	
	By txtUsernameLocator = By.id("identifierId");
	
	By btnNext1Locator = By.xpath("//*[@id='identifierNext']/content/span");
	
	By txtPasswordLocator = By.name("password");
	
	By btnNext2Locator = By.id("passwordNext");
	
	By txtSearchLocator = By.id("lst-ib");
	
	By lnkUserProfile = By.className("gb_b gb_ib gb_R");
	
	By btnMyAccount = By.xpath("//div/a[text()='My Account']");
	
	By headerSignInSecurity = By.id("i3");
	
	//login method
	public void LogIn() throws InterruptedException {
		goTo(baseURL);
		click(btnLoginLocator);
		type("b.mcdonald2323", txtUsernameLocator);
		click(btnNext1Locator);
		isDisplayed(txtPasswordLocator, 5);
		type("11007633Alphard123", txtPasswordLocator);
		Thread.sleep(2000);
		enterKeys(Keys.ENTER, btnNext2Locator);
	}
	//verify we are on the main page
	public boolean onMainPage() {
		boolean isPresent = isDisplayed(txtSearchLocator, 10);
		if (isPresent) {
			return true;
		}
		else
		{
			return false;
		}
		
	}
	//enter account screen from main page
	public void enterProfilePage() {
		click(lnkUserProfile);
		click(btnMyAccount);
	}
	
	//verify we are on the account page
	public boolean onAccountPage() {
		boolean isPresent = isDisplayed(headerSignInSecurity, 10);
		if (isPresent) {
			return true;
		}
		else
		{
			return false;
		}
		
	}


}
