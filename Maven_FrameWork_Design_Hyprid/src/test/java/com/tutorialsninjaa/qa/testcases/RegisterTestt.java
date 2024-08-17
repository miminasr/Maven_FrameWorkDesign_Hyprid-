package com.tutorialsninjaa.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hybridframework.pages.Utilss;
import com.tn.qa.pages.AccountSuccessPagee;
import com.tn.qa.pages.HomePagee;
import com.tn.qa.pages.RegisterPagee;
import com.tutorialsninja.qa.testbase.TestBase;


	public class RegisterTestt extends TestBase {
		public RegisterTestt() throws Exception {
			super();
			
		}
		public WebDriver driver;
		public 	SoftAssert softassert= new SoftAssert();

		@BeforeMethod
		 public void setUp() {
			
			driver= openApplication();
			HomePagee homepagee= new HomePagee(driver);
			homepagee.clickOnMyAccountLink();
	         homepagee.clickOnRegisterLink();
			
			
		}
		@Test(priority= 1)
		public void registerAccountWithMandatoryFields() {
			RegisterPagee registerpagee= new RegisterPagee(driver);
			registerpagee.enterFirstNameInTextBoxField(dataProp.getProperty("firstName"));
	        registerpagee.enterLastNameInTextBoxField(dataProp.getProperty("lastName"));
			registerpagee.enterEmailInTextBoxFieldInRegister(Utilss.emailWithDateTimestamp());
	        registerpagee.enterTelephoneInTextBoxFieldInRegister(dataProp.getProperty("telephone"));
			registerpagee.enterpasswordInTextBoxFieldInRegister(prop.getProperty("validPassword"));
			registerpagee.enterConfirmPasswordInTextBoxFieldInRegister(prop.getProperty("validPassword"));
	        registerpagee.clickOnPrivacyButtonInRegister();
	       registerpagee.clickOnContinueButtonInRegister();
	       AccountSuccessPagee accountsucces= new AccountSuccessPagee(driver);
	       softassert.assertTrue(accountsucces.verifyAccountCreationMessageIsDisplayed());
			softassert.assertAll();
			}
		@Test(priority= 2)
		public void registerAccountWithExistingEmail() {
			RegisterPagee registerpagee= new RegisterPagee(driver);
			registerpagee.enterFirstNameInTextBoxField(dataProp.getProperty("firstName"));
	        registerpagee.enterLastNameInTextBoxField(dataProp.getProperty("lastName"));
	        registerpagee.enterEmailInTextBoxFieldInRegister(prop.getProperty("validEmail"));
			 registerpagee.enterTelephoneInTextBoxFieldInRegister(dataProp.getProperty("telephone"));
	      		registerpagee.enterpasswordInTextBoxFieldInRegister(prop.getProperty("validPassword"));
	      		registerpagee.enterConfirmPasswordInTextBoxFieldInRegister(prop.getProperty("validPassword"));
	          registerpagee.clickOnNewsLetterButtonInRegister();
	          registerpagee.clickOnPrivacyButtonInRegister();
	      	 registerpagee.clickOnContinueButtonInRegister();
			String actualWarningmessage= registerpagee.retrieveDuplicateEmailMessage();
			String expectedWarningmessage= dataProp.getProperty("duplicateEmailWarningMessage");
			softassert.assertTrue(actualWarningmessage.contains(expectedWarningmessage));
			softassert.assertAll(); 
			
		}
		@Test(priority= 3)
		public void registerAccountWithallFields() {
			RegisterPagee registerpagee= new RegisterPagee(driver);
			registerpagee.enterFirstNameInTextBoxField(dataProp.getProperty("firstName"));
	        registerpagee.enterLastNameInTextBoxField(dataProp.getProperty("lastName"));
			registerpagee.enterEmailInTextBoxFieldInRegister(Utilss.emailWithDateTimestamp());
	        registerpagee.enterTelephoneInTextBoxFieldInRegister(dataProp.getProperty("telephone"));
			registerpagee.enterpasswordInTextBoxFieldInRegister(prop.getProperty("validPassword"));
			registerpagee.enterConfirmPasswordInTextBoxFieldInRegister(prop.getProperty("validPassword"));
			registerpagee.clickOnNewsLetterButtonInRegister();
	        registerpagee.clickOnPrivacyButtonInRegister();
		    registerpagee.clickOnContinueButtonInRegister();
		    AccountSuccessPagee accountsucces= new AccountSuccessPagee(driver);
		       softassert.assertTrue(accountsucces.verifyAccountCreationMessageIsDisplayed());
				softassert.assertAll();
		}
		@Test(priority= 4)
		public void registerAccountWithNoFields() {
			RegisterPagee registerpagee= new RegisterPagee(driver);
			   registerpagee.clickOnContinueButtonInRegister();
			
			String actualprivacyPolicyWarningMessage= registerpagee.retrievePrivacyPolicyWarningMessage();
			String expectedprivacyPolicyWarningMessage= dataProp.getProperty("privacyPolicyWarningMessage");
			softassert.assertTrue(actualprivacyPolicyWarningMessage.contains(expectedprivacyPolicyWarningMessage));
			
			String actualFirstnameWarningmessage= registerpagee.retrieveFirstNameWarningMessage();
			String expectedFirstnameWarningmessage= dataProp.getProperty("firstNameWarningMessage");
			softassert.assertEquals(actualFirstnameWarningmessage, expectedFirstnameWarningmessage);
			
			String actualLastnameWarningmessage= registerpagee.retrieveLastNameWarningMessage();
			String expectedLastnameWarningmessage= dataProp.getProperty("lastNameWarningmessage");
			softassert.assertEquals(actualLastnameWarningmessage, expectedLastnameWarningmessage);
			

			String actualEmailWarningmessage= registerpagee.retrieveEmailWarningMessage();
			String expectedEmailWarningmessage= dataProp.getProperty("emailWarningMessage");
			softassert.assertEquals(actualEmailWarningmessage, expectedEmailWarningmessage);
			

			String actualTelephoneWarningmessage= registerpagee.retrievetelephoneWarningMessage();
			String expectedTelephoneWarningmessage= dataProp.getProperty("telephoneWarningMessage");
			softassert.assertEquals(actualTelephoneWarningmessage, expectedTelephoneWarningmessage);
			
			String actualPasswordWarningmessage= registerpagee.retrievePasswordWarningMessage();
			String expectedPasswordWarningmessage= dataProp.getProperty("passwordWarningMessage");
			softassert.assertEquals(actualPasswordWarningmessage, expectedPasswordWarningmessage);
			
			softassert.assertAll();
			
			
			
			
		}
		@AfterMethod
		public void tearDown() {
			driver.quit();
			
		}

	}

