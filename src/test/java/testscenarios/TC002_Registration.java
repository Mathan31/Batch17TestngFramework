package testscenarios;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.RegistrationPage;

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
		.enterFirstName("Mathan")
		.selectTitle("Mr")
		.enterMiddleName("")
		.enterLastName("Chandrasekaran")
		.selectGender("Male")
		.enterUserName("Credo"+getRandomInteger(999, 9999))
		.enterEmail("credo"+getRandomInteger(999, 9999)+"@gmail.com")
		.enterPassword("Credo@123")
		.clickOnRegisterBtn()
		.verifyUserRegistration()
		.clickOnUILogo()
		.verifyElement();
		
		Assert.assertTrue(result);
	}
	
	//@Test(priority = 3)
	public void registerWithMandatoryAndOptionalFields() {
		
	}
	
	public static int getRandomInteger(int start,int end) {
		Random random = new Random();
		int result = random.nextInt((end - start) + 1) + 1;
		return result;
	}

}
