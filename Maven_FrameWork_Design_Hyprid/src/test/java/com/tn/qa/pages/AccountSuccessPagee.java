package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPagee {
	public WebDriver driver;
	@FindBy(xpath="//p[text()= 'Congratulations! Your new account has been successfully created!']")
	private WebElement accountCreationSuccessMessagee;

	
	
	public  AccountSuccessPagee (WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
			}
	
	public boolean verifyAccountCreationMessageIsDisplayed() {
		boolean accountSuccess= accountCreationSuccessMessagee.isDisplayed();
		return accountSuccess;
		
	}
}
