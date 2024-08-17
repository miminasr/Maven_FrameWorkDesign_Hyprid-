package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPagee {
	public WebDriver driver;
	@FindBy(linkText="HP LP3065")
	private  WebElement validproductStatus;
	@FindBy(xpath="//span[@class= 'hidden-xs hidden-sm hidden-md'][text()= 'Add to Cart']")
	private WebElement addToCartInSearchPage;
	@FindBy(xpath="//p[text()= 'There is no product that matches the search criteria.']")
	private WebElement noProductMatchCriteriaMessage;
	
	public SearchPagee (WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
			}
	public boolean displayStatusValidproduct() {
		boolean validDisplay= validproductStatus.isDisplayed();
		return validDisplay;
		
	}
	public void clickOnAddToCartButtonInSesrchPage() {
		addToCartInSearchPage.click();
	}
	public boolean invalidProductNomatchC() {
		boolean invalidDisplay= noProductMatchCriteriaMessage.isDisplayed();
		return invalidDisplay;
		
	}
}
