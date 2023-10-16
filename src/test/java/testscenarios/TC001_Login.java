package testscenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC001_Login extends BaseClass{
	
	@BeforeTest
	public void testSetup() {
		excelFile = "TC01";
	}
	
	@Test(priority = 1)
	public void loginFieldValidation() {
		boolean result = new LoginPage(driver)
		.verifyElement();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 2,dataProvider = "TestData")
	public void loginWithValidCredentials(String uName,String password) throws Exception {
		boolean result = new LoginPage(driver)
		.enterUserName(uName)
		.enterPassword(password)
		.clickOnSignInButton()
		.clickOnIAgreePolicy()
		.validateHomePage()
		.clickonLogout()
		.verifyElement();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 3)
	public void loginWithInValidCredentials() throws Exception {
		boolean result = new LoginPage(driver)
		.enterUserName("Mathan")
		.enterPassword("Testing")
		.clickOnSignInButton()
		.clickOnIAgreePolicyWithInvalid()
		.validateLoginFailedText();
		
		Assert.assertTrue(result);
	}

}
