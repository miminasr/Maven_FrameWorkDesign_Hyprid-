package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinalCheckOutPagee {
	public WebDriver driver;
	@FindBy(xpath="//h4[@class= 'panel-title'][text()= 'Step 1: Checkout Options']")
	private  WebElement finalCheckoutPageStatus;
	@FindBy(xpath="//input[@name= 'payment_address'][@value= 'existing']")
	private WebElement existingAddressButton;
	@FindBy(xpath="//input[@id= 'button-payment-address']")
	private WebElement continueButtonPaymentAddress;
	@FindBy(xpath="//input[@id= 'button-shipping-address']")
	private WebElement shippingAddressContinueButton;
	@FindBy(xpath="//input[@id= 'button-shipping-method']")
	private WebElement methodShippingButton;
	@FindBy(xpath="//input[@name= 'agree']")
	private WebElement agreeButtonOnFinalCheckoutPage;
	@FindBy(xpath="//input[@id= 'button-payment-method']")
	private WebElement paymentFinalButtoncontinue;
	@FindBy(xpath="//input[@id= 'button-confirm']")
	private WebElement finalConfirmButton;
	
	public FinalCheckOutPagee (WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
			}
	public boolean verifyFinalCheckoutPageStatusDisplayed() {
		boolean checkTitleStatus=  finalCheckoutPageStatus.isDisplayed();
		return checkTitleStatus;
		
	}
	public void pressOnExistingAddress() {
		existingAddressButton.click();
	}
	public void pressOnContinuePaymentAddress() {
		continueButtonPaymentAddress.click();
	}
	public void pressOnShippingAddressContinue() {
		shippingAddressContinueButton.click();
	}
	public void pressOnMethodshippingButton() {
		methodShippingButton.click();
	}

	public void pressOnAgreeButtonOnFinalCheckoutPage() {
		agreeButtonOnFinalCheckoutPage.click();
	}
	
	public void pressOnFinalpaymentButtonOnFinalCheckoutPage() {
		paymentFinalButtoncontinue.click();
	}
	
	public void pressOnFinalConfirmButtonOnFinalCheckoutPage() {
		finalConfirmButton.click();
	}
}
