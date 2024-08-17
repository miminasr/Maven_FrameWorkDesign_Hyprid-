package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagee {
	public WebDriver driver;
	@FindBy(linkText="My Account")
	private WebElement MyAccountLink;
	@FindBy(linkText="Login")
	private WebElement loginOption;
	@FindBy(linkText="Register")
	private WebElement registerOption;
	@FindBy(name="search")
	private WebElement searchTextbox;
	@FindBy(css="button.btn.btn-default.btn-lg")
	private WebElement searchButton;
	
	public  HomePagee(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
			}
	public void clickOnMyAccountLink() {
		MyAccountLink.click();
		
	}
	public void clickOnLoginLink() {
		 loginOption.click();
		
	}
	public void clickOnRegisterLink() {
		registerOption.click();
		
	}
	public void enterValidProductNameInSearchBox(String validProductText) {
		searchTextbox.sendKeys(validProductText);
		
	}
	public void clickOnSearchButtonn() {
		searchButton.click();
		
	}
	
	
}
