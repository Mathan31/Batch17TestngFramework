package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import io.reactivex.rxjava3.functions.Action;
import libraries.SeleniumWrapper;

public class LoginPage extends MenuPage{
	
	private By oUsernameText = By.id("username");
	private By oPasswordText = By.id("password");
	private By oSignInBtn = By.xpath("//button[text()='Sign In']");
	private By oForgotLink = By.xpath("//*[text()='Forgot Your Password?']");
	private By oRegisterLink = By.xpath("//small[text()='Register For Account']");
	private By oLoginFailedInnerText = By.xpath("//div[contains(text(),'login failed')]");
	private By oAgreePrivacyPolicy = By.xpath("//button[contains(text(),'I agree to the Privacy Policy')]");
	private SeleniumWrapper oWrap;
	private WebDriver driver;
	
	public LoginPage(WebDriver driver,ExtentTest node) {
		this.driver = driver;
		this.node = node;
		oWrap = new SeleniumWrapper(driver, node);
	}
	
	public boolean verifyElement() {
		
		if( oWrap.verifyDisplayedwithReturn(driver.findElement(oUsernameText), "User Name") &&
				oWrap.verifyDisplayedwithReturn(driver.findElement(oPasswordText), "Password") &&
				oWrap.verifyDisplayedwithReturn(driver.findElement(oSignInBtn), "Sign In") &&
				oWrap.verifyDisplayedwithReturn(driver.findElement(oForgotLink), "Forgot Link") &&
				oWrap.verifyDisplayedwithReturn(driver.findElement(oRegisterLink), "Register Link"))
		{
				return true;
		}else {
			return false;
		}
	}
	
	public LoginPage enterUserName(String uName) {
		oWrap.type(driver.findElement(oUsernameText), uName);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		oWrap.type(driver.findElement(oPasswordText), password);
		return this;
	}
	
	public LoginPage clickOnSignInButton() throws Exception {
		oWrap.click(driver.findElement(oSignInBtn), "Sign In Button");
		return this;
	}
	
	public LoginPage clickOnIAgreePolicyWithInvalid() {
		oWrap.click(driver.findElement(oAgreePrivacyPolicy), "Agree Privacy Policy");
		return this;
	}
	
	public boolean validateLoginFailedText() {
		boolean result = oWrap.verifyDisplayedwithReturn(driver.findElement(oLoginFailedInnerText));
		return result;
	}
	
	public RegistrationPage clickOnRegistrationLink() {
		oWrap.click(driver.findElement(oRegisterLink));
		return new RegistrationPage(driver,node);
	}
	
	public HomePage clickOnIAgreePolicy() throws Exception {
		oWrap.click(driver.findElement(oAgreePrivacyPolicy), "Agree Privacy Policy");
		return new HomePage(driver,node);
	}


}
