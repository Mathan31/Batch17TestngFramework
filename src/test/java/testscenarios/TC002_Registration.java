package testscenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.RegistrationPage;
import utilities.FakerDataFactory;

public class TC002_Registration extends BaseClass{
	
	@BeforeTest
	public void testSetup() {
		authors = "Jessi";
		category = "Smoke";
		testName = "Registration Test";
		testDescription = "Registration Test Validation";
		module = "Registration";
	}
	
	@Test(priority = 1)
	public void registerFieldValidation() {
		boolean regResult = new LoginPage(driver,node)
		.clickOnRegistrationLink()
		.verifyAllTheRegistrationFields();
		
		boolean loginResult = new RegistrationPage(driver,node)
		.clickOnUILogo()
		.verifyElement();
		
		Assert.assertTrue(regResult);
		Assert.assertTrue(loginResult);
	}
	
	@Test(priority = 2)
	public void registerWithMandatoryFields() {
		boolean result = new LoginPage(driver,node)
		.clickOnRegistrationLink()
		.enterFirstName(FakerDataFactory.getFirstName())
		.selectTitle(FakerDataFactory.getTitle())
		.enterMiddleName("")
		.enterLastName(FakerDataFactory.getLastName())
		.selectGender(FakerDataFactory.getGender())
		.enterUserName(FakerDataFactory.getUserName())
		.enterEmail(FakerDataFactory.getEmailAddress())
		.enterPassword(FakerDataFactory.getPassword())
		.clickOnAgree()
		.clickOnRegisterBtn()
		.verifyUserRegistration()
		.clickOnUILogo()
		.verifyElement();
		
		Assert.assertTrue(result);
	}
	
	//@Test(priority = 3)
	public void registerWithMandatoryAndOptionalFields() {
		
	}
	
}
