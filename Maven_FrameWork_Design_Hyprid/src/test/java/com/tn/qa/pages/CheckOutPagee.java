package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPagee {
	public WebDriver driver;
	@FindBy(xpath="//input[@id= 'input-email']")
	private WebElement inputEmailInCheckOutPageText;
	@FindBy(xpath="//input[@id= 'input-password']")
	private WebElement inputPasswordInCheckOutPageText;
	@FindBy(xpath="//input[@id= 'button-login']")
	private WebElement pressLoginInCheckoutpage;
	
	public CheckOutPagee  (WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
			}
	public void inputEmailOncheckout(String inputEmailText) {
		inputEmailInCheckOutPageText.sendKeys(inputEmailText);
		}
	public void inputPasswordOncheckout(String inputPasswordText) {
		inputPasswordInCheckOutPageText.sendKeys(inputPasswordText);
		}
	
	public void pressOnLoginButtonOnCheckOutPage() {
		pressLoginInCheckoutpage.click();
		
	}
}
