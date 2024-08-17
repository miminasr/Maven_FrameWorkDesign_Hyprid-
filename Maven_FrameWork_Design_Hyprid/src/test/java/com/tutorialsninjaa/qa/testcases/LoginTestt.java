package com.tutorialsninjaa.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hybridframework.pages.Utilss;
import com.tn.qa.pages.AccountPagee;
import com.tn.qa.pages.HomePagee;
import com.tn.qa.pages.LoginPagee;
import com.tutorialsninja.qa.testData.ExcelDataData;
import com.tutorialsninja.qa.testbase.TestBase;

public class LoginTestt extends TestBase {
	public LoginTestt() throws Exception {
		super();

	}

	public WebDriver driver;
	public SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		// openApplication();
		HomePagee homepagee = new HomePagee(driver);
		homepagee.clickOnMyAccountLink();
		homepagee.clickOnLoginLink();

	}

	@Test(priority = 1, dataProvider = "TN", dataProviderClass = ExcelDataData.class)
	public void verifyTutorialsLoginWithValidCredentials(String email, String password) throws Exception {
		LoginPagee loginpagee = new LoginPagee(driver);
		loginpagee.enterEmailInEmailTextBoxField(email);
		Thread.sleep(1000);
		loginpagee.enterPasswordInPasswordTextBoxField(password);
		Thread.sleep(1000);
		loginpagee.clickOnLoginButton();
		Thread.sleep(1000);
		AccountPagee accountpagee = new AccountPagee(driver);
		softassert.assertTrue(accountpagee.verifyLoginLinkIsDisplayed());
		softassert.assertAll();

	}

	@Test(priority = 2)
	public void verifyLoginTNWithInvalidCredentials() {
		LoginPagee loginpagee = new LoginPagee(driver);
		loginpagee.enterEmailInEmailTextBoxField(Utilss.emailWithDateTimestamp());
		loginpagee.enterPasswordInPasswordTextBoxField(dataProp.getProperty("invalidPassword"));
		loginpagee.clickOnLoginButton();
		softassert.assertTrue(loginpagee.verifyNoMtchEmailPasswordDisplayed());
		softassert.assertAll();

	}

	@Test(priority = 3)
	public void verifyLoginTNWithValidEmailInvalidPassword() {
		LoginPagee loginpagee = new LoginPagee(driver);
		loginpagee.enterEmailInEmailTextBoxField(prop.getProperty("validEmail"));
		loginpagee.enterPasswordInPasswordTextBoxField(dataProp.getProperty("invalidPassword"));
		loginpagee.clickOnLoginButton();
		softassert.assertTrue(loginpagee.verifyNoMtchEmailPasswordDisplayed());
		softassert.assertAll();

	}

	@Test(priority = 4)
	public void verifyLoginTNInvalidEmailvalidpassword() throws Exception {
		LoginPagee loginpagee = new LoginPagee(driver);
		loginpagee.enterEmailInEmailTextBoxField(Utilss.emailWithDateTimestamp());
		Thread.sleep(1000);
		loginpagee.enterPasswordInPasswordTextBoxField(prop.getProperty("validPassword"));
		Thread.sleep(2000);
		loginpagee.clickOnLoginButton();
		Thread.sleep(3000);
		softassert.assertTrue(loginpagee.verifyNoMtchEmailPasswordDisplayed());
		softassert.assertAll();

	}

	@Test(priority = 5)
	public void verifyLoginWithNoCredentials() {
		LoginPagee loginpagee = new LoginPagee(driver);
		loginpagee.clickOnLoginButton();
		softassert.assertTrue(loginpagee.verifyNoMtchEmailPasswordDisplayed());
		softassert.assertAll();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
