package testscenarios;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.RegistrationPage;
import utilities.FakerDataFactory;

public class TC002_Registration extends BaseClass{
	
	@Test(priority = 1)
	public void registerFieldValidation() {
		boolean regResult = new LoginPage()
		.clickOnRegistrationLink()
		.verifyAllTheRegistrationFields();
		
		boolean loginResult = new RegistrationPage()
		.clickOnUILogo()
		.verifyElement();
		
		Assert.assertTrue(regResult);
		Assert.assertTrue(loginResult);
	}
	
	@Test(priority = 2)
	public void registerWithMandatoryFields() {
		boolean result = new LoginPage()
		.clickOnRegistrationLink()
		.enterFirstName(FakerDataFactory.getFirstName())
		.selectTitle(FakerDataFactory.getTitle())
		.enterMiddleName("")
		.enterLastName(FakerDataFactory.getLastName())
		.selectGender(FakerDataFactory.getGender())
		.enterUserName(FakerDataFactory.getUserName())
		.enterEmail(FakerDataFactory.getEmailAddress())
		.enterPassword(FakerDataFactory.getPassword())
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
