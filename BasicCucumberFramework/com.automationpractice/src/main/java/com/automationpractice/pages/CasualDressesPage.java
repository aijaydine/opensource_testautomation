package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CasualDressesPage extends BasePage{
	
	@FindBy(xpath= "//*[@id='center_column']/ul/li/div/div[2]/h5/a")
	private WebElement selectCasualDressElement;
	

	public CasualDressesPage(WebDriver driver) {
		super(driver);
		
	}
	

	public PrintedDressPage goToPrintedDress() {
		try{
			logger.info("goToCasualDress started execution");
			selectCasualDressElement.click();
			logger.info("goToCasualDress was selected successfully");		
		}catch(Throwable t){
			logger.error("goToCasualDress encountered error" + t );
			camera.takeShot("goToCasualDress");
		}
		return PageFactory.initElements(driver, PrintedDressPage.class);

	}
}