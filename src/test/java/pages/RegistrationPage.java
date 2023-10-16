package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends MenuPage{
	
	private By oFirstName = By.id("firstName");
	private By oMiddleName = By.id("middleName"); 
	private By oLastName = By.id("lastName");
	private By oUserName = By.id("username");
	private By oEmail = By.id("email");
	private By oPassword = By.id("password");
	private By oRegister = By.xpath("//button[text()='Register']");
	private By oTitle = By.id("title");
	private By oGender = By.id("sex");
	private By oAgree = By.xpath("//input[@id='agreeCheckbox']");
	
	
	private WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean verifyAllTheRegistrationFields() {
		if(driver.findElement(oUserName).isDisplayed() && driver.findElement(oPassword).isDisplayed()
				&& driver.findElement(oEmail).isDisplayed()&& driver.findElement(oRegister).isDisplayed()) {
			return true;		
		}else {
			return false;
		} 
	}
	
	public RegistrationPage enterFirstName(String fName) {
		driver.findElement(oFirstName).sendKeys(fName);
		return this;
	}
	
	public RegistrationPage selectTitle(String title) {
		Select oSelect = new Select(driver.findElement(oTitle));
		oSelect.selectByVisibleText(title);
		return this;
	}
	
	public RegistrationPage enterMiddleName(String mName) {
		driver.findElement(oMiddleName).sendKeys(mName);
		return this;
	}
	
	public RegistrationPage enterLastName(String lName) {
		driver.findElement(oLastName).sendKeys(lName);
		return this;
	}
	
	public RegistrationPage selectGender(String gender) {
		Select oSelect = new Select(driver.findElement(oGender));
		oSelect.selectByVisibleText(gender);
		return this;
	}
	
	public RegistrationPage enterUserName(String uName) {
		driver.findElement(oUserName).sendKeys(uName);
		return this;
	}
	
	public RegistrationPage enterEmail(String email) {
		driver.findElement(oEmail).sendKeys(email);
		return this;
	}
	
	public RegistrationPage enterPassword(String password) {
		driver.findElement(oPassword).sendKeys(password);
		return this;
	}
	
	public RegistrationPage clickOnAgree() {
		driver.findElement(oAgree).click();
		return this;
	}
	
	public EmailVerificationPage clickOnRegisterBtn() {
		driver.findElement(oRegister).click();
		return new EmailVerificationPage(driver);
	}

	public LoginPage clickOnUILogo() {
		driver.findElement(oUILogo).click();
		return new LoginPage(driver);
	}
}
