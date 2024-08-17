package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPagee {
	public WebDriver driver;
	@FindBy(xpath="//button[@id= 'button-cart']")
	private WebElement productPageAddToCartButton;
	@FindBy(xpath="//div[@class= 'alert alert-success alert-dismissible']")
	private WebElement productAdditionSuccessmessage;
	@FindBy(xpath="//span[@id= 'cart-total']")
	private WebElement cartTotalButtonOnProductPage;
	@FindBy(xpath="//strong[text()= 'Checkout']")
	private WebElement checkoutButtonOnProductpage;
	
	
	
	
	public   ProductPagee (WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
			}
	public void productPageClickOnAddToCartButton() {
		productPageAddToCartButton.click();
		
	}
	public boolean verifyproductAdditionStatusIsDisplayed() {
		boolean additionMessage=  productAdditionSuccessmessage.isDisplayed();
		return additionMessage ;
		
	}

    public void clickOnCartTotalButton() {
    	cartTotalButtonOnProductPage.click();

}
    public void checkoutButtonClickOnProductPage() {
    	checkoutButtonOnProductpage.click();

}
    
    
}
