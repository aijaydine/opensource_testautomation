package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressesPage extends BasePage {
	
	@FindBy(xpath = "//*[@id='categories_block_left']/div/ul/li[1]/a")
	private WebElement clickOnCasualDressesElement;

	public DressesPage(WebDriver driver) {
		super(driver);
		
	}

	public CasualDressesPage selectCasualDresses() {
		try{
			logger.info("selectCasualDresses started execution");
			clickOnCasualDressesElement.click();
			logger.info("selectCasualDresses executed successfully");
		}catch(Throwable t){
			logger.error("selectCasualDresses encountered error" + t );
			camera.takeShot("selectCasualDresses");
		}
		return PageFactory.initElements(driver, CasualDressesPage.class);
	
	}

}
