package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage {

	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[2]/a")
	private WebElement logOutElement;
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[2]/a")
	private WebElement clickOnDressesElement;
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}

	public boolean verifyMessage(String verificationMessage) {
		boolean result = false;
		try{
			logger.info("verifyMessage started execution");
			result = driver.getPageSource().contains(verificationMessage);
			logger.info("verifyMessage executed successfully with "+result);
		}catch(Throwable t){
			logger.error("verifyMessage was not successful with error "+ t);
			
		}
		return result;
		
	}

	public SignInPage logoutFromTheApplicationAfterLoggingOn() {
		try{
			logger.info("logOutFromTheApplicationAfterLoggingOn started execution");
			logOutElement.click();
			logger.info("logOutFromTheApplicationAfterLoggingOn executed successfully");	
		}catch(Throwable t){
			logger.error("logOutFromTheApplicationAfterLoggingOn encountered error" + t );
			camera.takeShot("logOutFromTheApplicationAfterLoggingOn");
		}
		return PageFactory.initElements(driver, SignInPage.class);
		
	}

	public DressesPage clickOnDresses() {
		try{
			logger.info("clickOnDresses started execution");
			clickOnDressesElement.click();
			logger.info("clickOnDresses executed successfully");
			
		}catch(Throwable t){
			logger.error("clickOnDresses encountered error" + t );
			camera.takeShot("clickOnDresses");
		}
		return PageFactory.initElements(driver, DressesPage.class);
	}
	 

	

}
