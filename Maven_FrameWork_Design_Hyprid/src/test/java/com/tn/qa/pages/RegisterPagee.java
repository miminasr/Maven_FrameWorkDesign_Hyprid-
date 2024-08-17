package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPagee {
	public WebDriver driver;
	@FindBy(xpath="//input[@id= 'input-firstname']")
	private WebElement firstNameTextBoxField;
	@FindBy(xpath="//input[@id= 'input-lastname']")
	private WebElement lastNameTextBoxField;
	@FindBy(xpath="//input[@id= 'input-email']")
	private WebElement emailRegisterTextBoxFiled;
	@FindBy(xpath="//input[@id= 'input-telephone']")
	private WebElement telephoneRegisterTextBoxFiled;
	@FindBy(xpath="//input[@id= 'input-password']")
	private WebElement passwordRegisterTextBoxFiled;
	@FindBy(xpath="//input[@id= 'input-confirm']")
	private WebElement confirmPasswordRegisterTextBoxFiled;
	@FindBy(xpath="//input[@class= 'btn btn-primary']/preceding-sibling::input[1]")
	private WebElement privacyPolicyCheckBoxInRegister;
	@FindBy(xpath="//input[@class= 'btn btn-primary']")
	private WebElement continueButtonInRegister;
	@FindBy(xpath="//input[@name= 'newsletter'][@value= '1']")
	private WebElement newsletterRadioButton;
	@FindBy(xpath="//div[@class= 'alert alert-danger alert-dismissible']")
	private WebElement duplicateEmailMessagee;
	@FindBy(xpath="//div[@class= 'alert alert-danger alert-dismissible']")
	private WebElement privacyPolicywarningMessagee;
	@FindBy(xpath="//input[@id= 'input-firstname']/following-sibling::div")
	private WebElement firstNamewarningMessagee;
	@FindBy(xpath="//input[@id= 'input-lastname']/following-sibling::div")
	private WebElement LastNamewarningMessagee;
	@FindBy(xpath="//input[@id= 'input-email']/following-sibling::div")
	private WebElement emailwarningMessageee;
	@FindBy(xpath="//input[@id= 'input-telephone']/following-sibling::div")
	private WebElement telephonewarningMessageee;
	@FindBy(xpath="//input[@id= 'input-password']/following-sibling::div")
	private WebElement passwordwarningMessageee;
	
	public RegisterPagee  (WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
			}
	
	public void enterFirstNameInTextBoxField(String firstNameText) {
		firstNameTextBoxField.sendKeys(firstNameText);
		}
	public void enterLastNameInTextBoxField(String LastNameText) {
		lastNameTextBoxField.sendKeys(LastNameText);
		}
	public void enterEmailInTextBoxFieldInRegister(String emailRegisterText) {
		emailRegisterTextBoxFiled.sendKeys(emailRegisterText);
		}
	public void enterTelephoneInTextBoxFieldInRegister(String telephoneRegisterText) {
		 telephoneRegisterTextBoxFiled.sendKeys(telephoneRegisterText);
		}
	public void enterpasswordInTextBoxFieldInRegister(String passwordRegisterText) {
		 passwordRegisterTextBoxFiled.sendKeys(passwordRegisterText);
		}
	public void enterConfirmPasswordInTextBoxFieldInRegister(String confirmPasswordRegisterText) {
		confirmPasswordRegisterTextBoxFiled.sendKeys(confirmPasswordRegisterText);
		}
	public void clickOnPrivacyButtonInRegister() {
		privacyPolicyCheckBoxInRegister.click();
		
	}
	public void clickOnContinueButtonInRegister() {
		continueButtonInRegister.click();
		
	}
	public void clickOnNewsLetterButtonInRegister() {
		newsletterRadioButton.click();
		
	}
	public String retrieveDuplicateEmailMessage() {
		String duplicatemessage= duplicateEmailMessagee.getText();
		return duplicatemessage;
	}
	
	public String retrievePrivacyPolicyWarningMessage() {
		String privacymessage= privacyPolicywarningMessagee.getText();
		return privacymessage;
	}
	public String retrieveFirstNameWarningMessage() {
		String firstnamemessage= firstNamewarningMessagee.getText();
		return firstnamemessage;
	}
	public String retrieveLastNameWarningMessage() {
		String lastnamemessage= LastNamewarningMessagee.getText();
		return lastnamemessage ;
	}
	public String retrieveEmailWarningMessage() {
		String emaillmessage= emailwarningMessageee.getText();
		return emaillmessage ;
	}
	public String retrievetelephoneWarningMessage() {
		String telephoneemessage= telephonewarningMessageee.getText();
		return telephoneemessage ;
	}
	public String retrievePasswordWarningMessage() {
		String passworddmessage= passwordwarningMessageee.getText();
		return passworddmessage ;
	}
	
}
