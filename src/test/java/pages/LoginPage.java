package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;
import io.reactivex.rxjava3.functions.Action;

public class LoginPage extends MenuPage{
	
	private By oUsernameText = By.id("username");
	private By oPasswordText = By.id("password");
	private By oSignInBtn = By.xpath("//button[text()='Sign In']");
	private By oForgotLink = By.xpath("//*[text()='Forgot Your Password?']");
	private By oRegisterLink = By.xpath("//*[text()='Register For Account']");
	private By oLoginFailedInnerText = By.xpath("//div[contains(text(),'login failed')]");
	private By oAgreePrivacyPolicy = By.xpath("//button[contains(text(),'I agree to the Privacy Policy')]");
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean verifyElement() {
		if(driver.findElement(oUsernameText).isDisplayed() &&
				driver.findElement(oPasswordText).isDisplayed()&&
				driver.findElement(oSignInBtn).isDisplayed()&&
				driver.findElement(oForgotLink).isDisplayed()&&
				driver.findElement(oRegisterLink).isDisplayed()) {
				return true;
		}else {
			return false;
		}
	}
	
	public LoginPage enterUserName(String uName) {
		driver.findElement(oUsernameText).clear();
		driver.findElement(oUsernameText).sendKeys(uName);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		driver.findElement(oPasswordText).clear();
		driver.findElement(oPasswordText).sendKeys(password);
		return this;
	}
	
	public LoginPage clickOnSignInButton() throws Exception {
		WebDriverWait oWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		oWait.until(ExpectedConditions.elementToBeClickable(oSignInBtn));
		Thread.sleep(2000);
		Actions oAction = new Actions(driver);
		oAction.moveToElement(driver.findElement(oSignInBtn)).perform();
		Thread.sleep(2000);
		driver.findElement(oSignInBtn).click();;
		return this;
	}
	
	public LoginPage clickOnIAgreePolicyWithInvalid() {
		WebDriverWait oWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		oWait.until(ExpectedConditions.elementToBeClickable(oAgreePrivacyPolicy));
		driver.findElement(oAgreePrivacyPolicy).click();
		return this;
	}
	
	public boolean validateLoginFailedText() {
		
		boolean result = driver.findElement(oLoginFailedInnerText).isDisplayed();
		return result;
	}
	
	public RegistrationPage clickOnRegistrationLink() {
		driver.findElement(oRegisterLink).click();
		return new RegistrationPage(driver);
	}
	
	public HomePage clickOnIAgreePolicy() throws Exception {
		Thread.sleep(2000);
		WebDriverWait oWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		oWait.until(ExpectedConditions.elementToBeClickable(oAgreePrivacyPolicy));
		driver.findElement(oAgreePrivacyPolicy).click();;
		return new HomePage(driver);
	}


}
