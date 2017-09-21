package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage{

	public SearchPage(WebDriver driver) {
		super(driver);
		
	}

	public boolean validatePageTitle(String pageTitle) {
		boolean result = false;
		try{
			logger.info("validatePageTitle started execution");
			result = driver.getTitle().contains(pageTitle);
			logger.info("validatePageTitle finished execution");
		}catch(Throwable t){
			logger.error("validatePageTitle encountered error" + t);
			camera.takeShot("validatePageTitle");
		}
		return result;
	}

	
	public boolean validatePageUrl(String pageUrl) {
		boolean result = false;
		try{
			logger.info("validatePageUrl started execution");
			result = driver.getCurrentUrl().contains(pageUrl);
			logger.info("validatePageUrl finished execution");
		}catch(Throwable t){
			logger.error("validatePageUrl encountered error" + t);
			camera.takeShot("validatePageUrl");
		}
		return result;
	}
	
	public boolean validateMessage(String itemNames) {
		boolean result = false;
		try{
			logger.info("validateMessage started execution");
			result = driver.getPageSource().contains(itemNames);
			logger.info("validateMessage finished execution");
		}catch(Throwable t){
			logger.error("validateMessage encountered error" + t);
			camera.takeShot("validateMessage");
		}
		return result;
	}
}
