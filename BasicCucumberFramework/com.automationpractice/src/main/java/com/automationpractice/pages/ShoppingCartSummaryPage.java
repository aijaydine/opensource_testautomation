package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartSummaryPage extends BasePage{
	
	@FindBy(xpath = "//*[@id='3_13_0_0']/i")
	private WebElement removeItem1FromCartElement;
	
	@FindBy(xpath = "//*[@id='4_16_0_0']/i")
	private WebElement removeItem2FromCartElement;

	public ShoppingCartSummaryPage(WebDriver driver) {
		super(driver);
		
	}

	public boolean validateMessage(String totalAmount) {
		boolean result = false;
		try{
			logger.info("validateMessage started execution");
			result = driver.getPageSource().contains(totalAmount);
			logger.info("validateMessage finished execution");
			}catch(Throwable t){
				logger.error("validateMessage encountered error  " + t);
				camera.takeShot("validateMessage");
		}
		return result;
	}

	public ShoppingCartSummaryPage removeItemsFromShoppingCart() {
		try{
			logger.info("removeItemsFromShoppingCart started execution");
			removeItem1FromCartElement.click();
			logger.info("Item 1 has been removed");
			removeItem2FromCartElement.click();
			logger.info("Item 2 has been removed");
		}catch(Throwable t){
			logger.info("removeItemsFromShoppingCart encountered error " + t);
			camera.takeShot("removeItemsFromShoppingCart");
		}
		return PageFactory.initElements(driver, ShoppingCartSummaryPage.class);
		
		
	}
	

}
