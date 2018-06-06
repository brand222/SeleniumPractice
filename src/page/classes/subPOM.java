package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sun.org.apache.bcel.internal.classfile.Visitor;

public class subPOM extends Base {
	
	
	public subPOM(WebDriver driver) {
		super(driver);
	}
	
	
	//page elements
	By btnLoginLocator = By.id("gb_70");
	
	By txtUsernameLocator = By.id("identifierId");
	
	By btnNext1Locator = By.xpath("//*[@id='identifierNext']/div[2]");
	
	By txtPasswordLocator = By.name("password");
	
	By btnNext2Locator = By.xpath("//*[@id='passwordNext']/div[2]");
	
	By txtSearchLocator = By.id("lst-ib");
	
	//login method
	public void LogIn() throws InterruptedException {
		//isDisplayed(btnLoginLocator, 10);
		click(btnLoginLocator);
		type("b.mcdonald2323", txtUsernameLocator);
		click(btnNext1Locator);
		type("11007633Alphard123", txtPasswordLocator);
		click(btnNext2Locator);
	}
	
	public boolean onMainPage() {
		boolean isPresent = isDisplayed(txtSearchLocator, 5);
		if (isPresent) {
			return true;
		}
		else
		{
			return false;
		}
		
	}


}
