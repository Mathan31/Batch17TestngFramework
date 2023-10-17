package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import libraries.SeleniumWrapper;

public class EmailVerificationPage extends MenuPage {

	private By oWelcome = By.xpath("//h2[contains(text(),'Welcome To The UiBank Family!')]");
	// private By oLogin = By.linkText("Login");
	private By oUILogo = By.xpath("//a[@class='navbar-brand']");
	private WebDriver driver;
	private SeleniumWrapper oWrap;
	
	public EmailVerificationPage(WebDriver driver,ExtentTest node) {
		this.driver = driver;
		this.node = node;
		oWrap = new SeleniumWrapper(driver, node);
	}
	public EmailVerificationPage verifyUserRegistration() {
		
		boolean displayed =oWrap.verifyDisplayedwithReturn(driver.findElement(oWelcome), "Welcome Text");
		if (displayed) {
			System.out.println("User Registration is Successfull!!!");
		} else {
			System.out.println("User Registration is Not Successfull!!!");
		}
		return this;
	}

	public LoginPage clickOnUILogo() {
		oWrap.click(driver.findElement(oUILogo),"UIBank Logo");
		return new LoginPage(driver,node); 
	}
}
