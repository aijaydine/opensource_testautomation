package com.automationpractice.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	
	@FindBy(linkText = "Sign in")
	private WebElement signInButton;
	
	@FindBy(id="search_query_top")
	private WebElement searchForItemElement;
	
	@FindBy(xpath = "//*[@id='searchbox']/button")
	private WebElement clickOnSearchButton;
	
	@FindBy(partialLinkText ="Contact us")
	private WebElement contactUsElement;
	
	@FindBy(xpath = "//*[@id='header']/div[3]/div/div/div[3]/div/a")
	private WebElement goToCartElement;
	
	@FindBy(xpath = "//*[@id='home-page-tabs']/li[2]/a")
	private WebElement bestSellerElement;

	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}

	public SignInPage clickOnSignIn() {
		try{
			logger.info("clickOnSignIn started execution");
			signInButton.click();
			logger.info("clickOnSignIn executed successfully");
			
		}catch(Throwable t){
			logger.error("clickOnSignIn failed execution because " + t);
			camera.takeShot("clickOnSignIn");
			
		}
		return PageFactory.initElements(driver, SignInPage.class);
	}

	public SearchPage searchForItem(String item) {
		try{
			logger.info("searchForItem started execution");
			searchForItemElement.sendKeys(item);
			logger.info(item + " was printed to be searched");
			clickOnSearchButton.click();
			logger.info("searchButton was successfully clicked");
			logger.info("searchForItem was executed successfully");
		}catch(Throwable t){
			logger.error("searchForItem encountered an error" + t);
			camera.takeShot("searchForItems");
	}
		return PageFactory.initElements(driver, SearchPage.class);
	}

	public ContactUsPage clickOnContactUs() {
		try{
			logger.info("clickOnContactUs started execution");
			contactUsElement.click();
			logger.info("clickOnContactUs executed successfully");
		}catch(Throwable t){
			logger.error("clickOnContactUs encountered error" + t);
			camera.takeShot("clickOnContactUs");
			
		}
		return PageFactory.initElements(driver, ContactUsPage.class);
		
		
	}

	public ShoppingCartSummaryPage goToCart() {
		try{
			logger.info("goToCart started execution");
			goToCartElement.click();
			logger.info("goToCart executed successfully");
		}catch(Throwable t){
			logger.error("goToCart encountered error" + t);
			camera.takeShot("goToCart");
			
		}
		return PageFactory.initElements(driver, ShoppingCartSummaryPage.class );
		
		
	}

	public boolean verifyItem(String item) {
		boolean result = false;
		try{
			logger.info("verifyItem started execution");
			result = driver.getPageSource().contains(item);
			logger.info( item + " was found and verifyItem finished execution");
		}catch(Throwable t){
			logger.error("verifyItem encountered error " + t);
			camera.takeShot("verifyItem");
			
		}
		return result;
	}

	public HomePage selectBestSeller() {
		try{
			logger.info("selectBestSeller started execution");
			bestSellerElement.click();
			logger.info("selectBestSeller was successfully selected");
		}catch(Throwable t){
			logger.error("selectBestSeller encountered error with message  " + t);
			camera.takeShot("selectBestSeller");
			
		}
		return PageFactory.initElements(driver, HomePage.class);
		
		
	}
	
}
