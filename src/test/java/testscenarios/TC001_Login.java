package testscenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC001_Login extends BaseClass{
	
	@Test(priority = 1)
	public void loginFieldValidation() {
		boolean result = new LoginPage()
		.verifyElement();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 2)
	public void loginWithValidCredentials() {
		boolean result = new LoginPage()
		.enterUserName("Mathan")
		.enterPassword("Testing123")
		.clickOnSignInButton()
		.validateHomePage()
		.clickonLogout()
		.verifyElement();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 3)
	public void loginWithInValidCredentials() {
		boolean result = new LoginPage()
		.enterUserName("Mathan")
		.enterPassword("Testing")
		.clickOnSignInButtonWithInvalid()
		.validateLoginFailedText();
		
		Assert.assertTrue(result);
	}

}
