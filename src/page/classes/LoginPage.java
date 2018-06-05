package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	public WebDriver driver;
	
	@FindBy(xpath = "//*[@id='navbar']/div/div/div/ul/li[2]/a")
	public WebElement btnLogin;
	
	@FindBy(xpath = "//*[@id='user_email']")
	public WebElement txt_UserName;
	
	@FindBy(xpath = "//*[@id='user_password']")
	public WebElement txt_password;
	
	@FindBy(xpath = "//*[@id='new_user']/div[3]/input")
	public WebElement btnSubmit;
	
	@FindBy(xpath = "/html/body/div/div/div/div/div/div/div[1]/div/div")
	public WebElement invalidLoginMsg;
	
	public void LogIn(WebDriver driver, String username, String password) {
		txt_UserName.sendKeys(username);
		txt_password.sendKeys(password);
		btnSubmit.click();
	}
	
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
