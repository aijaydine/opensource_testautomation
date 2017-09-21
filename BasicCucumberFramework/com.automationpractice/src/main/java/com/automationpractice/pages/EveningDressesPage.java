package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EveningDressesPage extends BasePage{
	@FindBy(xpath = "//*[@id='center_column']/ul/li/div/div[2]/h5/a")
	private WebElement goToPrintedDressElement;

	public EveningDressesPage(WebDriver driver) {
		super(driver);
	}

	public PrintedDressPage goToPrintedEveningDress() {
		try{
			logger.info("goToPrintedEveningDress started execution");
			goToPrintedDressElement.click();
			logger.info("goToPrintedEveningDress finished execution");
		}catch(Throwable t){
			logger.error("goToPrintedEveningDress encountered error " + t);
		}
		return PageFactory.initElements(driver, PrintedDressPage.class);
		
		
	}
}