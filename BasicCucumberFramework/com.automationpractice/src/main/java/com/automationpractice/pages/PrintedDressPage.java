package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrintedDressPage extends BasePage{
	@FindBy(xpath = "//*[@id='add_to_cart']/button")
	private WebElement addEveningDressElement;
	
	@FindBy(xpath = "//*[@id='add_to_cart']/button")
	private WebElement addCasualDressElement;
	
	@FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span")
	private WebElement continueShoppingElement;
	
	@FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
	private WebElement proceedToCheckOutElement;
	
	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
	private WebElement goToDressesElement;
	
	@FindBy(xpath = "//*[@id='categories_block_left']/div/ul/li[2]/a")
	private WebElement goToEveningDressesElement;

	public PrintedDressPage(WebDriver driver) {
		super(driver);
		
	}

	public ShoppingCartSummaryPage addEveningDress(String eveningDresses) {
		try{
			logger.info("addEveningDress started execution");
			addEveningDressElement.click();
			logger.info("addEveningDress finished execution");
			proceedToCheckOutElement.click();
			driver.switchTo().defaultContent();
			logger.info("driver successfully switched to default content");
		}catch(Throwable t){
			logger.error("addEveningDress encountered error " + t);
			camera.takeShot("addEveningDress");
		}
		return PageFactory.initElements(driver, ShoppingCartSummaryPage.class);
		
		
	}

	public PrintedDressPage addCasualDress(){
		try{
			logger.info("addCasualDress started execution");
			addCasualDressElement.click();
			continueShoppingElement.click();
			logger.info("continueShopping button was successfully selected");
			driver.switchTo().defaultContent();
			logger.info("driver successfully switched to default content");	
			Thread.sleep(5000);
//			driver.switchTo().parentFrame().switchTo().frame(arg0); This is switch toparent frame to frame when working on frames
//			driver.switchTo().defaultContent();This is to return to the main content being tested
			logger.info("addCasualDress executed successfully");
		}catch(Throwable t){
			logger.error("addCasualDress encountered error "+ t);
			camera.takeShot("addCasualDress");
	}
	return PageFactory.initElements(driver, PrintedDressPage.class);
	}
	
	
	public EveningDressesPage selectEveningDress() {
		try{
			logger.info("selectEveningDress started execution");
			goToDressesElement.click();
			logger.info("Dresses has been selected");
			goToEveningDressesElement.click();
			logger.info("selectEveningDress executed successfully");
		}catch(Throwable t){
			logger.error("selectEveningDress encountered error " + t);
			camera.takeShot("selectEveningDress");
			
		}
		return PageFactory.initElements(driver, EveningDressesPage.class);
		
		
	}
	
	
	
}
