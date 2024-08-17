package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagee {
	public WebDriver driver;
	@FindBy(xpath="//input[@id= 'input-email']")
   private WebElement emailTextBoxField;
	@FindBy(xpath="//input[@id= 'input-password']")
	private WebElement passwordTextBoxField;
	@FindBy(css="input.btn.btn-primary")
	private WebElement clickOnLoginButton;
	@FindBy(xpath="//div[@class= 'alert alert-danger alert-dismissible']")
	private WebElement noMatchEmailPasswordMessage;
	
	
	
	
	public   LoginPagee(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
			}
	public void enterEmailInEmailTextBoxField(String emailText) {
		emailTextBoxField.sendKeys(emailText);
		}
	public void enterPasswordInPasswordTextBoxField(String passwordText) {
		passwordTextBoxField.sendKeys(passwordText);
		}
	public void clickOnLoginButton() {
		clickOnLoginButton.click();
		
	}
	public boolean verifyNoMtchEmailPasswordDisplayed() {
		boolean noMatchMessage=  noMatchEmailPasswordMessage.isDisplayed();
		return noMatchMessage;
		
	}
	
}
