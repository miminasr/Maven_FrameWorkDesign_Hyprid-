package com.tutorialsninjaa.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tn.qa.pages.CheckOutPagee;
import com.tn.qa.pages.FinalCheckOutPagee;
import com.tn.qa.pages.HomePagee;
import com.tn.qa.pages.ProductPagee;
import com.tn.qa.pages.SearchPagee;
import com.tutorialsninja.qa.testbase.TestBase;

public class SearchProductTestt extends TestBase{
	public SearchProductTestt() throws Exception {
		super();
		
	}
	public WebDriver driver;
	public 	SoftAssert softassert= new SoftAssert();

	@BeforeMethod
	 public void setUp() {
		driver= openApplication();

}
	@Test(priority= 1)
	public void searchawithValidProduct() throws Exception {
		HomePagee homepagee= new HomePagee(driver);
		homepagee.enterValidProductNameInSearchBox(dataProp.getProperty("validProduct"));
		homepagee.clickOnSearchButtonn();
		 SearchPagee searchpagee= new  SearchPagee(driver);
		  softassert.assertTrue( searchpagee.displayStatusValidproduct());
		  searchpagee.clickOnAddToCartButtonInSesrchPage();
	  
		  ProductPagee productpagee= new ProductPagee(driver);
		  productpagee.productPageClickOnAddToCartButton();
	 
         softassert.assertTrue( productpagee.verifyproductAdditionStatusIsDisplayed());
	    Thread.sleep(1000);
	    productpagee.clickOnCartTotalButton();
	
	    Thread.sleep(1000);
	    productpagee.checkoutButtonClickOnProductPage();
	
	    Thread.sleep(1000);
	    CheckOutPagee checkoutpage= new CheckOutPagee(driver);
	    checkoutpage.inputEmailOncheckout(prop.getProperty("validEmail"));

	    Thread.sleep(1000);
	    checkoutpage.inputPasswordOncheckout(prop.getProperty("validPassword"));
	
	    Thread.sleep(1000);
	    checkoutpage.pressOnLoginButtonOnCheckOutPage();
	
	    Thread.sleep(1000);
	    FinalCheckOutPagee finalcheckoutpage= new  FinalCheckOutPagee(driver);
	   softassert.assertTrue(  finalcheckoutpage.verifyFinalCheckoutPageStatusDisplayed());
	    Thread.sleep(1000);
	    finalcheckoutpage.pressOnExistingAddress();

	    Thread.sleep(1000);
	    finalcheckoutpage.pressOnContinuePaymentAddress();
	   
	    Thread.sleep(1000);
	    finalcheckoutpage.pressOnShippingAddressContinue();
	 
	    Thread.sleep(1000);
	    finalcheckoutpage.pressOnMethodshippingButton();

	    Thread.sleep(1000);
	    finalcheckoutpage.pressOnAgreeButtonOnFinalCheckoutPage();
	
	    Thread.sleep(1000);
	    finalcheckoutpage.pressOnFinalpaymentButtonOnFinalCheckoutPage();
	 
	    Thread.sleep(1000);
	    finalcheckoutpage.pressOnFinalConfirmButtonOnFinalCheckoutPage();
	  
		softassert.assertAll();
		
		}
	@Test(priority= 2)
	public void searchWithInvalidProduct() {
		HomePagee homepagee= new HomePagee(driver);
		homepagee.enterValidProductNameInSearchBox(dataProp.getProperty("invalidProduct"));
		homepagee.clickOnSearchButtonn();
		 SearchPagee searchpagee= new  SearchPagee(driver);
		softassert.assertTrue( searchpagee.invalidProductNomatchC());
		softassert.assertAll();
		
	}
	@Test(priority= 3)
	public void searchWithNoProduct() {
		HomePagee homepagee= new HomePagee(driver);
		homepagee.clickOnSearchButtonn();
		 SearchPagee searchpagee= new  SearchPagee(driver);
		 softassert.assertTrue( searchpagee.invalidProductNomatchC());
			softassert.assertAll();
			
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

}
