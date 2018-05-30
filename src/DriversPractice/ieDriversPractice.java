package DriversPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ieDriversPractice {
	public static void main(String[] args) {
		//pass our base URL as a string
		String baseURL = "http://www.google.com";
		//create our driver object variable
		WebDriver driver;
		//here we are mapping to the iedriver executible
		System.setProperty("webdriver.ie.driver", "C:\\Users\\Brandon Mc\\git\\SeleniumPractice\\SeleniumFramework\\libs\\IEDriverServer.exe");
		//after we set our iedriver, we set our driver variable equal to iedriver object
		driver = new InternetExplorerDriver();
		//here we maximize the window
		driver.manage().window().maximize();
		//here we get the base url
		driver.get(baseURL);
	}
}
